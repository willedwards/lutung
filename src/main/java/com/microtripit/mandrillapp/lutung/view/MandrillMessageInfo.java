/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.List;

import com.google.api.client.util.Key;

/**
 * <p>Basic information for a message.</p>
 * @author rschreijer
 * @since Mar 16, 2013
 */
public class MandrillMessageInfo {
	@Key
	private Long ts;
	@Key
	private Integer opens;
	@Key
	private Integer clicks;
	@Key
	private String _id;
	@Key
	private String sender;
	@Key
	private String template;
	@Key
	private String subject;
	@Key
	private String email;
	@Key
	private String state;
	@Key
	private List<String> tags;
	@Key
	private List<UserActionDetail> opens_detail;
	@Key
	private List<UserActionDetail> clicks_detail;
	@Key
	private List<SMTPEvent> smtp_events;
//	private Map<String,String> metadata;
	
	/**
	 * @return The Unix timestamp from when this message was sent.
	 */
	public Long getTs() {
		return ts;
	}
	/**
	 * @return How many times has this message been opened.
	 */
	public Integer getOpens() {
		return opens;
	}
	/**
	 * @return How many times has a link been clicked in this message.
	 */
	public Integer getClicks() {
		return clicks;
	}
	/**
	 * @return The message's unique id.
	 */
	public String getId() {
		return _id;
	}
	/**
	 * @return The email address of the sender.
	 */
	public String getSender() {
		return sender;
	}
	/**
	 * @return The unique name of the template used, if any.
	 */
	public String getTemplate() {
		return template;
	}
	/**
	 * @return The message's subject link.
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @return The recipient email address.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return The sending status of this message: sent, bounced, rejected.
	 */
	public String getState() {
		return state;
	}
	/**
	 * @return List of tags on this message.
	 */
	public List<String> getTags() {
		return tags;
	}
	/**
	 * @return A list of individual opens for the message.
	 */
	public List<UserActionDetail> getOpensDetail() {
		return opens_detail;
	}
	/**
	 * @return A list of individual clicks for the message.
	 */
	public List<UserActionDetail> getClicksDetail() {
		return clicks_detail;
	}
	public List<SMTPEvent> getSmtpEvents() {
		return smtp_events;
	}
//	/**
//	 * @return Any custom metadata provided when the message was sent.
//	 */
//	public Map<String,String> getMetadata() {
//		return metadata;
//	}
	
	public static class UserActionDetail {
		@Key
		private Integer ts;
		@Key
		private String url;
		@Key
		private String ip;
		@Key
		private String location;
		@Key
		private String ua;
		
		/**
		 * @return The unix timestamp from when the action occured.
		 */
		public final Integer getTs() {
			return ts;
		}
		/**
		 * @return The URL that was clicked on (clicks only, duh!).
		 */
		public final String getUrl() {
			return url;
		}
		/**
		 * @return The IP address that generated the action.
		 */
		public final String getIp() {
			return ip;
		}
		/**
		 * @return The approximate region and country that the 
		 * acting IP is located.
		 */
		public final String getLocation() {
			return location;
		}
		/**
		 * @return The email client or browser data of the action.
		 */
		public final String getUa() {
			return ua;
		}
	}
	
	public static class SMTPEvent {
		@Key
		private Integer ts;
		@Key
		private String type;
		@Key
		private String diag;
		
		/**
		 * @return The Unix timestamp when the event occured.
		 */
		public final Integer getTs() {
			return ts;
		}
		/**
		 * @return The message's state as a result of this event.
		 */
		public final String getType() {
			return type;
		}
		/**
		 * @return The SMTP response from the recipient's server. 
		 */
		public final String getDiag() {
			return diag;
		}
		
		
	}

}
