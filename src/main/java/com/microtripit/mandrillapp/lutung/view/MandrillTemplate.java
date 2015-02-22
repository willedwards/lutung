/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

/**
 * <p>Information about a template.</p>
 * @author rschreijer
 * @since Mar 18, 2013
 */
public class MandrillTemplate {
	private String name, slug, code, subject, fromEmail, fromName, text, 
			publishName, publishCode, publishSubject, publishFromEmail,
			publishFromName, publishText;
	private Date publishedAt, createdAt, updatedAt;
	
	/**
	 * @return The name of the template.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return The immutable unique code name of the template.
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * @return The full HTML code of the template, with mc:edit 
	 * attributes marking the editable elements - draft version.
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @return The subject line of the template, if provided 
	 * &ndash; draft version.
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @return The default sender address for the template, 
	 * if provided &ndash; draft version
	 */
	public String getFromEmail() {
		return fromEmail;
	}
	/**
	 * @return The default sender from name for the template, 
	 * if provided &ndash; draft version
	 */
	public String getFromName() {
		return fromName;
	}
	/**
	 * @return The default text part of messages sent with the 
	 * template, if provided &ndash; draft version
	 */
	public String getText() {
		return text;
	}
	/**
	 * @return The same as the template name &ndash; 
	 * kept as a separate field for backwards compatibility
	 */
	public String getPublishName() {
		return publishName;
	}
	/**
	 * @return The full HTML code of the template, with 
	 * mc:edit attributes marking the editable elements 
	 * that are available as published, if it has been 
	 * published.
	 */
	public String getPublishCode() {
		return publishCode;
	}
	/**
	 * @return The subject line of the template, if provided.
	 */
	public String getPublishSubject() {
		return publishSubject;
	}
	/**
	 * @return The default sender address for the template, if provided.
	 */
	public String getPublishFromEmail() {
		return publishFromEmail;
	}
	/**
	 * @return The default sender from name for the template, if provided.
	 */
	public String getPublishFromName() {
		return publishFromName;
	}
	/**
	 * @return The default text part of messages sent with the 
	 * template, if provided. 
	 */
	public String getPublishText() {
		return publishText;
	}
	
	/**
	 * @return The date and time of when this template was 
	 * published, UTC; <code>null</code> if it has not 
	 * been published.
	 */
	public Date getPublishedAt() {
		return publishedAt;
	}
	/**
	 * @return The date and time of when this template was 
	 * created, UTC.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @return The date and time of when this template was 
	 * last modified, UTC.
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
}
