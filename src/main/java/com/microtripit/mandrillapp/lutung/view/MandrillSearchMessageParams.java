/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

/**
 * <p>Search parameters for message searching.</p>
 * @author rschreijer
 * @since Mar 16, 2013
 */
public class MandrillSearchMessageParams {
	private String query;
	private Date dateFrom, dateTo;
	private String[] tags, senders, apiKeys;
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
	public Date getDateFrom() {
		return dateFrom;
	}
	/**
	 * @param dateFrom The start date.
	 */
	public void setDateFrom(final Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	/**
	 * @return The end date.
	 */
	public Date getDateTo() {
		return dateTo;
	}
	/**
	 * @param dateTo The end date.
	 */
	public void setDateTo(final Date dateTo) {
		this.dateTo = dateTo;
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
		return apiKeys;
	}
	/**
	 * @param api_keys An array of API keys to narrow the search to, 
	 * will return messages sent by ANY of the keys.
	 */
	public void setApiKeys(final String[] api_keys) {
		this.apiKeys = api_keys;
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
