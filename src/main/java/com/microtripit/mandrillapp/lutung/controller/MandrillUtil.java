/**
 * 
 */
package com.microtripit.mandrillapp.lutung.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.goebl.david.Request;
import com.goebl.david.Webb;
import com.goebl.david.WebbException;
import com.microtripit.mandrillapp.lutung.logging.Logger;
import com.microtripit.mandrillapp.lutung.logging.LoggerFactory;
import com.microtripit.mandrillapp.lutung.model.JsonNodeConverter;
import com.microtripit.mandrillapp.lutung.model.MandrillApiError;

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
			mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
			//FIXME: could we write an appropriate strategy so fields in the dtos don't have to be renamed to remove underscores?
			//PropertyNamingStrategyBase p;
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

			Request request = webb.post(url);
	        for (String key : params.keySet()) {
	        	if (params.get(key)!=null){
	        		request.param(key, params.get(key));
	        	}	
			}
	        JsonNode jsonNode;
	        if (responseType == String.class) {
	        	String result = request.ensureSuccess().asString().getBody();
	        	//remove the enclosing commas
	        	result = result.substring(1, result.length()-1);
	        	return (OUT)result;
	        }
	        else if (responseType.isArray()) {
    			JSONArray jsonArray = request.ensureSuccess().asJsonArray().getBody();
    			jsonNode = JsonNodeConverter.convertJsonFormat(jsonArray);
    		} else {
    	        JSONObject jsonObject = request.ensureSuccess().asJsonObject().getBody();
    	        jsonNode = JsonNodeConverter.convertJsonFormat(jsonObject);
    		}
			
			OUT resultAsPOJO = mapper.readValue(new TreeTraversingParser(jsonNode), responseType);
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
    }
}