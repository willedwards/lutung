/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import com.google.api.client.util.Key;

/**
 * <p>A mailbox route.</p>
 * @author rschreijer
 * @since Mar 19, 2013
 */
public class MandrillMailboxRoute {
	@Key
	private String pattern;
	@Key
	private String url;

	/**
	 * @return The search pattern that the mailbox 
	 * name should match.
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * @return The webhook URL where inbound messages 
	 * will be published.
	 */
	public String getUrl() {
		return url;
	}

}
