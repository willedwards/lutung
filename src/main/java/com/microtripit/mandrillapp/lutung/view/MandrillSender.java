/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

import com.google.api.client.util.Key;
import com.microtripit.mandrillapp.lutung.view.StatsBucket.Stats;

/**
 * <p>Information on a sending address in the account.</p>
 * @author rschreijer
 * @since Mar 16, 2013
 */
public class MandrillSender extends Stats {
	@Key
	private String address;
	@Key
	private Date created_at;
	@Key
	private StatsBucket stats;
	
	/**
	 * @return The sender's email address.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return The time that the sender was first seen by Mandrill, in UTC.
	 */
	public Date getCreatedAt() {
		return created_at;
	}
	/**
	 * @return An aggregate summary of the sender's sending stats.
	 */
	public StatsBucket getStats() {
		return stats;
	}

}
