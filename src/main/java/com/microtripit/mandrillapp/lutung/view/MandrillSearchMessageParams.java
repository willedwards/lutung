/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import com.google.api.client.util.DateTime;

/**
 * <p>Search parameters for message searching.</p>
 * @author rschreijer
 * @since Mar 16, 2013
 */
public class MandrillSearchMessageParams {
	private String query;
	private DateTime date_from, date_to;
	private String[] tags, senders, api_keys;
	private Integer limit;
	
	/**
	 * @return The search terms to find matching messages for.
	 */
	public String getQuery() {
		return query;
	}
	/**
	 * @param query The search terms to find matching messages for.
	 */
	public void setQuery(final String query) {
		this.query = query;
	}
	/**
	 * @return The start date.
	 */
	public DateTime getDateFrom() {
		return date_from;
	}
	/**
	 * @param dateFrom The start date.
	 */
	public void setDateFrom(final DateTime dateFrom) {
		this.date_from = dateFrom;
	}
	/**
	 * @return The end date.
	 */
	public DateTime getDateTo() {
		return date_to;
	}
	/**
	 * @param dateTo The end date.
	 */
	public void setDateTo(final DateTime dateTo) {
		this.date_to = dateTo;
	}
	/**
	 * @return An array of tag names to narrow the 
	 * search to, will return messages that contain 
	 * ANY of the tags.
	 */
	public String[] getTags() {
		return tags;
	}
	/**
	 * @param tags An array of tag names to narrow the 
	 * search to, will return messages that contain 
	 * ANY of the tags.
	 */
	public void setTags(final String[] tags) {
		this.tags = tags;
	}
	/**
	 * @return An array of sender addresses to narrow 
	 * the search to, will return messages sent by 
	 * ANY of the senders.
	 */
	public String[] getSenders() {
		return senders;
	}
	/**
	 * @param senders An array of sender addresses to narrow 
	 * the search to, will return messages sent by 
	 * ANY of the senders.
	 */
	public void setSenders(final String[] senders) {
		this.senders = senders;
	}
	/**
	 * @return An array of API keys to narrow the search to, 
	 * will return messages sent by ANY of the keys.
	 */
	public String[] getApiKeys() {
		return api_keys;
	}
	/**
	 * @param api_keys An array of API keys to narrow the search to, 
	 * will return messages sent by ANY of the keys.
	 */
	public void setApiKeys(final String[] api_keys) {
		this.api_keys = api_keys;
	}
	/**
	 * @return The maximum number of results to return, 
	 * defaults to 100, 1000 is the maximum.
	 */
	public Integer getLimit() {
		return limit;
	}
	/**
	 * @param limit The maximum number of results to return, 
	 * defaults to 100, 1000 is the maximum.
	 */
	public void setLimit(final Integer limit) {
		this.limit = limit;
	}
}
