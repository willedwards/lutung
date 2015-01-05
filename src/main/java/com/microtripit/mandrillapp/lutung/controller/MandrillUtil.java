/**
 * 
 */
package com.microtripit.mandrillapp.lutung.controller;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.microtripit.mandrillapp.lutung.logging.Logger;
import com.microtripit.mandrillapp.lutung.logging.LoggerFactory;
import com.microtripit.mandrillapp.lutung.model.*;
import com.nando.googleHttpJavaClientPoc.HttpRequestHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		
        //return googleQuery(url,params,responseType);
        return apacheQuery(url,params,responseType);

	}

    private static final <OUT> OUT apacheQuery(final String url,
                                               final Map<String,Object> params,
                                               Class<OUT> responseType) throws MandrillApiError, IOException
    {
		final MandrillRequest<OUT> requestModel =  new MandrillRequest<OUT>(url, params, responseType);
		return MandrillRequestDispatcher.execute(requestModel, null);

    }

    private static final <OUT> OUT googleQuery(final String url,
                                               final Map<String,Object> params,
                                               Class<OUT> responseType) throws MandrillApiError, IOException
    {

        GenericUrl genericUrl = new GenericUrl(url);
        HttpRequest request = HttpRequestHelper.buildRequestWithParams(genericUrl, params);

        try
        {


            HttpResponse response = request.execute();
            if (200 == response.getStatusCode())
            {
                Object lutung = null;
                try
                {
                    lutung = MandrillGoogleHttpRequest.handleResponse(response.getContent(), responseType);
                }
                catch (HandleResponseException e)
                {
                    log.error(e.getMessage());
                    throw new MandrillApiError("something went wrong", e);
                }

                OUT r = (OUT) lutung;

                //r = response.parseAs(responseType);


                return r;

            }
            else
            {
                throw new MandrillApiError("problem");
            }
        }
        catch (HttpResponseException e)
        {
            log.error(e.getMessage());
            throw new MandrillApiError("internal error occurred", e);

        }
    }
}
