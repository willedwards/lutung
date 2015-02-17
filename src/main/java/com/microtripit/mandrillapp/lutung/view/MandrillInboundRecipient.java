package com.microtripit.mandrillapp.lutung.view;

import com.google.api.client.util.Key;

/**
 * <p>Recipient information.</p>
 * @author rschreijer
 * @since Mar 19, 2013
 */
public class MandrillInboundRecipient {
	@Key
	private String email;
	@Key
	private String pattern;
	@Key
	private String url;

	/**
	 * @return The email address of the matching recipient.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return The mailbox route pattern that the recipient matched.
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * @return The webhook URL that the message was posted to.
	 */
	public String getUrl() {
		return url;
	}

}
