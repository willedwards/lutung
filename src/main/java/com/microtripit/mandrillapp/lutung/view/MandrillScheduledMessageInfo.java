/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

/**
 * <p>Info on a scheduled email.</p>
 * @author rschreijer
 *
 */
public class MandrillScheduledMessageInfo {
	private String _id, fromEmail, to, subject;
	private Date createdAt, sendAt;
	
	/**
	 * @return The scheduled message id.
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @return The email's sender address.
	 */
	public String getFromEmail() {
		return fromEmail;
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
		return createdAt;
	}
	/**
	 * @return The time when the message will be sent.
	 */
	public Date getSend_at() {
		return sendAt;
	}

}
