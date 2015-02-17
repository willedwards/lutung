/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

import com.google.api.client.util.Key;

/**
 * <p>Information about a whitelist entry.</p>
 * @author rschreijer
 *
 */
public class MandrillWhitelistEntry {
	@Key
	private String email;
	@Key
	private String detail;
	@Key
	private Date created_at;
	
	/**
	 * @return The email that is whitelisted.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return A description of why the email was whitelisted.
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @return When the email was added to the whitelist.
	 */
	public Date getCreated_at() {
		return created_at;
	}

}
