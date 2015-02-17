/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

import com.google.api.client.util.Key;

/**
 * <p>Info on a scheduled email.</p>
 * @author rschreijer
 *
 */
public class MandrillScheduledMessageInfo {
	@Key
	private String _id;
	@Key
	private String from_email;
	@Key
	private String to;
	@Key
	private String subject;
	@Key
	private Date created_at;
	@Key
	private Date send_at;
	
	/**
	 * @return The scheduled message id.
	 */
	public String getId() {
		return _id;
	}
	/**
	 * @return The email's sender address.
	 */
	public String getFromEmail() {
		return from_email;
	}
	/**
	 * @return The email's recipient.
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @return The email's subject.
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @return The time when the message was created.
	 */
	public Date getCreated_at() {
		return created_at;
	}
	/**
	 * @return The time when the message will be sent.
	 */
	public Date getSend_at() {
		return send_at;
	}

}
