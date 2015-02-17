/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import com.google.api.client.util.Key;
import com.microtripit.mandrillapp.lutung.view.StatsBucket.Stats;

/**
 * <p>A URL and its statistics.</p>
 * @author rschreijer
 * @since Mar 18, 2013
 */
public class MandrillUrl extends Stats {
	@Key
	private String url;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

}
