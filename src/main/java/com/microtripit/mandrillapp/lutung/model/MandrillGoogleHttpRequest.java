/**
 *
 */
package com.microtripit.mandrillapp.lutung.model;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.microtripit.mandrillapp.lutung.logging.Logger;
import com.microtripit.mandrillapp.lutung.logging.LoggerFactory;
import com.nando.googleHttpJavaClientPoc.HttpRequestHelper;
import org.apache.commons.io.IOUtils;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


/**
 * @author rschreijer
 * @since Mar 16, 2013
 */
public final class MandrillGoogleHttpRequest<OUT>
{
    private static final Logger log = LoggerFactory.getLogger(MandrillGoogleHttpRequest.class);

    private final String url;
    private final Class<OUT> responseContentType;
    private final Map<String, ? extends Object> requestParams;

    public MandrillGoogleHttpRequest(final String url, final Map<String, ? extends Object> params, final Class<OUT> responseType)
    {
        this.url = url;
        this.requestParams = params;
        this.responseContentType = responseType;
    }

    public final String getUrl()
    {
        return url;
    }

    public final HttpRequest getRequest() throws IOException
    {
        final String paramsStr = LutungGsonUtils.getGson().toJson(requestParams, requestParams.getClass());
        log.debug("raw content for request:\n" + paramsStr);
        final StringEntity entity = new StringEntity(paramsStr, "UTF-8");
        entity.setContentType("application/json");

        GenericUrl genericUrl = new GenericUrl(url);
        return HttpRequestHelper.buildRequestWithParams(genericUrl, requestParams);

    }

//    public final boolean validateResponseStatus(final int httpResponseStatus)
//    {
//        return (httpResponseStatus == 200);
//    }

    public final OUT handleResponse(final InputStream is) throws HandleResponseException
    {

        String raw = null;
        try
        {
            raw = IOUtils.toString(is);
            log.debug("raw content from response:\n" + raw);
            return LutungGsonUtils.getGson().fromJson(raw, responseContentType);

        }
        catch (final Throwable t)
        {
            String msg = "Error handling Mandrill response " + ((raw != null) ? ": '" + raw + "'" : "");
            throw new HandleResponseException(msg, t);

        }
    }

    public static Object handleResponse(final InputStream is, Class responseContentType) throws HandleResponseException
    {

        String raw = null;
        try
        {
            raw = IOUtils.toString(is);
            log.debug("raw content from response:\n" + raw);
            return LutungGsonUtils.getGson().fromJson(raw, responseContentType);

        }
        catch (final Throwable t)
        {
            String msg = "Error handling Mandrill response " + ((raw != null) ? ": '" + raw + "'" : "");
            throw new HandleResponseException(msg, t);

        }
    }

}
