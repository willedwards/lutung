/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

import com.google.api.client.util.Key;

/**
 * <p>Info about an inbound domain.</p>
 * @author rschreijer
 * @since Mar 18, 2013
 */
public class MandrillInboundDomain {
	@Key
	private String domain;
	@Key
	private Date created_at;
	@Key
	private Boolean valid_mx;
	
	/**
	 * @return The domain name that is accepting mail.
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @return The date and time that the inbound domain 
	 * was added, UTC.
	 */
	public Date getCreatedAt() {
		return created_at;
	}
	/**
	 * @return <code>True</code> if this inbound domain has successfully set 
	 * up an MX record to deliver mail to the Mandrill servers.
	 */
	public Boolean getValidMx() {
		return valid_mx;
	}

}
