/**
 * 
 */
package com.microtripit.mandrillapp.lutung.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.goebl.david.Request;
import com.goebl.david.Webb;
import com.goebl.david.WebbException;
import com.goebl.david.WebbUtils;
import com.microtripit.mandrillapp.lutung.logging.Logger;
import com.microtripit.mandrillapp.lutung.logging.LoggerFactory;
import com.microtripit.mandrillapp.lutung.model.MandrillApiError;
import com.microtripit.mandrillapp.lutung.util.AllowingStartingWithUnderscoreStrategy;
import com.microtripit.mandrillapp.lutung.util.JsonNodeConverter;

/**
 * @author rschreijer
 * @since Mar 19, 2013
 */
final class MandrillUtil {
	protected static final String rootUrl = "https://mandrillapp.com/api/1.0/";

	private static final Logger log = LoggerFactory.getLogger(MandrillUtil.class);

	/**
	 * @param key
	 * @return
	 */
	protected static final HashMap<String,Object> paramsWithKey(final String key) {
		final HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("key",key);
		return params;

	}
	
	/**
	 * @param url
	 * @param params
	 * @param responseType
	 * @return
	 * @throws MandrillApiError
	 * @throws IOException
	 */
	protected static final <OUT> OUT query(final String url, 
                                            final Map<String,Object> params,
                                            Class<OUT> responseType) throws MandrillApiError, IOException
    {
        return davidWebbQuery(url,params,responseType);
	}
	
	//TODO: move ths method to an utility class
	private static JSONObject convertCustomObject(ObjectMapper mapper, Object customObject) throws JsonProcessingException{
		String valueAsJSONString = mapper.writeValueAsString(customObject);
		JSONObject valueAsJO = WebbUtils.toJsonObject(valueAsJSONString.getBytes());
		return valueAsJO;
	}
	//TODO: move ths method to an utility class
	private static JSONArray convertIterableObject(ObjectMapper mapper, Iterable iterableObject) throws JsonProcessingException{
		JSONArray jsonArray = new JSONArray();
		for (Object value : iterableObject) {
			if (value != null) {
        		if (value instanceof Boolean || value instanceof Double || value instanceof Integer || 
            			value instanceof String || value instanceof Long || value instanceof JSONArray || 
            			value instanceof JSONObject)
            	{
        			jsonArray.put(value);
            	} else if (value instanceof Iterable) {
            		JSONArray innerJsonArray = convertIterableObject(mapper, (Iterable)value);  
            		jsonArray.put(innerJsonArray);
            	} else {
            		JSONObject jso = convertCustomObject(mapper, value);
            		jsonArray.put(jso);
            	}
			}
		}
		return jsonArray;
	}
	//TODO: move ths method to an utility class
    private static JSONObject convertParams(ObjectMapper mapper, Map<String,Object> params) throws JSONException, JsonProcessingException{
		JSONObject jsonPayload = new JSONObject();
		Object value;
        for (String key : params.keySet()) {
        	value = params.get(key);
        	if (value!=null){
        		if (value instanceof Boolean || value instanceof Double || value instanceof Integer || 
        			value instanceof String || value instanceof Long || value instanceof JSONArray || 
        			value instanceof JSONObject)
        		{
        			jsonPayload.put(key, value);
        		} else if (value instanceof Date) {
        			//FIXME: optimize this, we can reuse the formatters        			
        			String dateAsString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
        			jsonPayload.put(key, dateAsString);
        		} else if (value instanceof Iterable){
        			JSONArray jsonArray = convertIterableObject(mapper, (Iterable)value);
        			jsonPayload.put(key, jsonArray);	
        		} else{
        			JSONObject jsonObject = convertCustomObject(mapper, value); 
        			jsonPayload.put(key, jsonObject);	
        		}
        	}	
		}		
    	return jsonPayload;
    }
	
    @SuppressWarnings("unchecked")
	private static final <OUT> OUT davidWebbQuery(final String url,
                                               final Map<String,Object> params,
                                               Class<OUT> responseType) throws MandrillApiError, IOException
    {
    	Webb webb = Webb.create();
		webb.setBaseUri(rootUrl);
		webb.setDefaultHeader(Webb.HDR_USER_AGENT, Webb.DEFAULT_USER_AGENT);
		
        try
        {
	        //FIXME: could this be reused between calls?
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.setPropertyNamingStrategy(new AllowingStartingWithUnderscoreStrategy());
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			
			mapper.setSerializationInclusion(Include.NON_NULL);

			Request request = webb.post(url);

			JSONObject jsonRequest = convertParams(mapper, params);
	        request.body(jsonRequest);

	        JsonNode jsonNodeResult;
	        if (responseType == String.class) {
	        	String result = request.ensureSuccess().asString().getBody();
	        	//remove the enclosing commas
	        	result = result.substring(1, result.length()-1);
	        	return (OUT)result;
	        } else if (responseType.isArray()) {
    			JSONArray jsonArray = request.ensureSuccess().asJsonArray().getBody();
    			jsonNodeResult = JsonNodeConverter.convertJsonFormat(jsonArray);
    		} else {
    	        JSONObject jsonObject = request.ensureSuccess().asJsonObject().getBody();
    	        jsonNodeResult = JsonNodeConverter.convertJsonFormat(jsonObject);
    		}

			OUT resultAsPOJO = mapper.readValue(new TreeTraversingParser(jsonNodeResult), responseType);
			return (OUT) resultAsPOJO;
        }
        catch (WebbException we) //response code not 200
        {
            log.error(we.getMessage());
            throw new MandrillApiError("problem", we);
        }
        catch (JsonParseException jpe)
        {
            log.error(jpe.getMessage());
            throw new MandrillApiError("internal error occurred", jpe);
        }
        catch (JsonMappingException jme)
        {
            log.error(jme.getMessage());
            throw new MandrillApiError("internal error occurred", jme);
        }
        catch (JSONException je)
        {
            log.error(je.getMessage());
            throw new MandrillApiError("internal error occurred", je);
        }
    }
}