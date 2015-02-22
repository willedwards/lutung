/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

import com.microtripit.mandrillapp.lutung.view.StatsBucket.Stats;

/**
 * @author rschreijer
 *
 */
public class MandrillSubaccountInfo {
	private String id, name, notes;
	private Integer customQuota;
	private String status;
	private Integer reputation;
	private Date createdAt, firstSentAt;
	private Integer sentWeekly, sentMonthly, sentTotal, sentHourly;
	private Integer hourlyQuota;
	private Stats last30Days;
	
	
	/**
	 * @return A unique indentifier for the subaccount.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return An optional display name for the subaccount.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return Optional extra text to associate with the subaccount.
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @return An optional manual hourly quota for the 
	 * subaccount. If not specified, the hourly quota 
	 * will be managed based on reputation.
	 */
	public Integer getCustomQuota() {
		return customQuota;
	}
	/**
	 * @return The current sending status of the subaccount, 
	 * one of 'active' or 'paused'.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return The subaccount's current reputation on a 
	 * scale from 0 to 100.
	 */
	public Integer getReputation() {
		return reputation;
	}
	/**
	 * @return The date and time that the subaccount was created.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @return The date and time that the subaccount first sent.
	 */
	public Date getFirstSentAt() {
		return firstSentAt;
	}
	/**
	 * @return The number of emails the subaccount has sent 
	 * so far this week (weeks start on midnight Monday, UTC).
	 */
	public Integer getSentWeekly() {
		return sentWeekly;
	}
	/**
	 * @return The number of emails the subaccount has sent 
	 * so far this month (months start on midnight of the 1st, UTC).
	 */
	public Integer getSentMonthly() {
		return sentMonthly;
	}
	/**
	 * @return The number of emails the subaccount has sent 
	 * since it was created. 
	 */
	public Integer getSentTotal() {
		return sentTotal;
	}
	/**
	 * @return The number of emails the subaccount has sent 
	 * in the last hour. 
	 */
	public Integer getSentHourly() {
		return sentHourly;
	}
	/**
	 * @return The current hourly quota for the subaccount, 
	 * either manual or reputation-based.
	 */
	public Integer getHourlyQuota() {
		return hourlyQuota;
	}
	/**
	 * @return Stats for this subaccount in the last 30 days.
	 */
	public Stats getLast30Days() {
		return last30Days;
	}
	
}
