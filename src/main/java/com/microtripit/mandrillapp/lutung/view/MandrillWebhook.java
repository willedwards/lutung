/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

/**
 * <p>Info about a webhook.</p>
 * @author rschreijer
 * @since Mar 18, 2013
 */
public class MandrillWebhook {
	public static final String SEND = "send";
	public static final String HARD_BOUNCE = "hard_bounce";
	public static final String SOFT_BOUNCE = "soft_bounce";
	public static final String OPEN = "open";
	public static final String CLICK = "click";
	public static final String SPAM = "spam";
	public static final String UNSUB = "unsub";
	public static final String REJECT = "reject";
	
	private Integer id, batchesSent, eventsSent;
	private String url, description, authKey, last_error;
	private String[] events;
	private Date createdAt, lastSentAt;
	
	/**
	 * @return The unique integer indentifier for the webhook.
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return The number of event batches that have 
	 * ever been sent to this webhook.
	 */
	public Integer getBatchesSent() {
		return batchesSent;
	}
	/**
	 * @return The total number of events that have ever 
	 * been sent to this webhook. 
	 */
	public Integer getEventsSent() {
		return eventsSent;
	}
	/**
	 * @return The URL that the event data will be posted to.
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @return A description of the webhook.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return The key used to requests for this webhook.
	 */
	public String getAuthKey() {
		return authKey;
	}
	/**
	 * @return If we've ever gotten an error trying to post 
	 * to this webhook, the last error that we've seen.
	 */
	public String getLastError() {
		return last_error;
	}
	/**
	 * @return The date and time that the webhook was created, UTC.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @return The date and time that the webhook last successfully 
	 * received events, UTC.
	 */
	public Date getLastSentAt() {
		return lastSentAt;
	}
	/**
	 * @return The message events that will be posted to the hook.
	 * Those are the string literals that Mandrill understands: send, 
	 * hard_bounce, soft_bounce, open, click, spam, unsub, or reject.
	 * @see {@link #SEND}, {@link #HARD_BOUNCE}, {@link #SOFT_BOUNCE}, 
	 * {@link #OPEN}, {@link #CLICK}, {@link #SPAM}, {@link #UNSUB}, 
	 * {@link #REJECT}
	 */
	public String[] getEvents() {
		return events;
	}
}
