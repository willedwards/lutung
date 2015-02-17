/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

import com.google.api.client.util.Key;
import com.microtripit.mandrillapp.lutung.view.StatsBucket.Stats;

/**
 * <p>A time series holds stats for a single hour.</p>
 * @author rschreijer
 * @since Mar 16, 2013
 */
public class MandrillTimeSeries extends Stats {
	@Key
	private Date time;

	/**
	 * @return The hour for this time series.
	 */
	public Date getTime() {
		return time;
	}

}
