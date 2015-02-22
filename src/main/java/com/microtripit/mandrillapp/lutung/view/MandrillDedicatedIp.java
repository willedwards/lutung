/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.Date;

/**
 * <p>Info about a dedicated IP.</p>
 * @author rschreijer
 *
 */
public class MandrillDedicatedIp {
	private String ip, pool, domain;
	private Date createdAt;
	private CustomDns customDns;
	private WarmupStatus warmup;
	
	/**
	 * @return The IP address.
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @return The name of the pool that this dedicated IP belongs to.
	 */
	public String getPool() {
		return pool;
	}
	/**
	 * @return The domain name (reverse dns) of this dedicated IP.
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @return The date and time that the dedicated IP was created.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @return Information about the ip's custom dns, 
	 * if it has been configured.
	 */
	public CustomDns getCustomDns() {
		return customDns;
	}
	/**
	 * @return Information about the ip's warmup status.
	 */
	public WarmupStatus getWarmup() {
		return warmup;
	}

	/**
	 * <p>Information about an IP's custom dns.</p>
	 * @author rschreijer
	 *
	 */
	public static class CustomDns {
		private Boolean enabled, valid;
		private String error;
		
		/**
		 * @return A boolean indicating whether custom dns 
		 * has been configured for this ip.
		 */
		public Boolean getEnabled() {
			return enabled;
		}
		/**
		 * @return Whether the ip's custom dns is currently valid.
		 */
		public Boolean getValid() {
			return valid;
		}
		/**
		 * @return If the ip's custom dns is invalid, this will 
		 * include details about the error.
		 */
		public String getError() {
			return error;
		}
	}
	
	/**
	 * <p>Information about the ip's warmup status.</p>
	 * @author rschreijer
	 *
	 */
	public static class WarmupStatus {
		private Boolean warmingUp;
		private Date startAt, endAt;
		
		/**
		 * @return Whether the ip is currently in warmup mode.
		 */
		public Boolean getWarmingUp() {
			return warmingUp;
		}
		/**
		 * @return The start time for the warmup process.
		 */
		public Date getStartAt() {
			return startAt;
		}
		/**
		 * @return The end date and time for the warmup process.
		 */
		public Date getEndAt() {
			return endAt;
		}
	}
	
	/**
	 * <p>Validation results for a domain.</p>
	 * @author rschreijer
	 *
	 */
	public static class MandrillDnsCheck {
		private Boolean valid;
		private String error;
		
		/**
		 * @return Whether the domain name has a correctly-configured 
		 * A record pointing to the ip address.
		 */
		public Boolean getValid() {
			return valid;
		}
		/**
		 * @return If valid is false, this will contain details 
		 * about why the domain's A record is incorrect.
		 */
		public String getError() {
			return error;
		}
	}

}
