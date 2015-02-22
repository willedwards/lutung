/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

/**
 * @author rschreijer
 *
 */
public class MandrillExportJobInfo {
	private String id, type, state, resultUrl;
	private Date createdAt, finishedAt;
	
	/**
	 * @return The unique identifier for this Export. Use 
	 * this identifier when checking the export job's status.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return The type of the export job: 
	 * 'activity', 'reject', or 'whitelist'.
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return The export job's state: 'waiting', 
	 * 'working', 'complete', 'error', or 'expired'.
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return The url for the export job's results, 
	 * if the job is complete.
	 */
	public String getResultUrl() {
		return resultUrl;
	}
	/**
	 * @return The date and time that the export job was created.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @return The date and time that the export job was finished.
	 */
	public Date getFinishedAt() {
		return finishedAt;
	}

	
	
}
