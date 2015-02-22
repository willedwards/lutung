/**
 * 
 */
package com.microtripit.mandrillapp.lutung.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Information on a message to send.</p>
 * @author rschreijer
 * @since Mar 16, 2013
 */
public class MandrillMessage {
	private String subject, html, text, fromEmail, fromName;
	private List<Recipient> to;
	private Map<String,String> headers;
	private Boolean important, trackOpens, trackClicks, autoText, autoHtml, 
			inlineCss, urlStripQs, preserveRecipients, viewContentLink;
	private String bccAddress, trackingDomain, signingDomain, 
			returnPathDomain;
	private Boolean merge;
	private List<MergeVar> globalMergeVars;
	private List<MergeVarBucket> mergeVars;
	private List<String> tags;
	private String subaccount;
	private List<String> googleAnalyticsDomains;
	private String googleAnalyticsCampaign;
	private Map<String,String> metadata;
	private List<RecipientMetadata> recipientMetadata;
	private List<MessageContent> attachments;
	private List<MessageContent> images;
	// following params are send-only
	
	
	/**
	 * @return The message subject.
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject The message subject.
	 */
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	/**
	 * @return The full HTML content.
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @param html The full HTML content.
	 */
	public void setHtml(final String html) {
		this.html = html;
	}

	/**
	 * @return Optional full text content.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text Optional full text content.
	 */
	public void setText(final String text) {
		this.text = text;
	}

	/**
	 * @return The sender email address.
	 */
	public String getFromEmail() {
		return fromEmail;
	}

	/**
	 * @param email The sender email address.
	 */
	public void setFromEmail(final String email) {
		this.fromEmail = email;
	}

	/**
	 * @return Optional from name.
	 */
	public String getFromName() {
		return fromName;
	}

	/**
	 * @param name Optional from name.
	 */
	public void setFromName(final String name) {
		this.fromName = name;
	}

	/**
	 * @return The list of recipients.
	 */
	public List<Recipient> getTo() {
		return to;
	}

	/**
	 * @param to The list of recipients.
	 */
	public void setTo(final List<Recipient> to) {
		this.to = to;
	}
	
	/**
	 * @return Optional extra headers to add to the 
	 * message (currently only Reply-To and X-* headers 
	 * are allowed).
	 */
	public Map<String,String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers Optional extra headers to add to the 
	 * message (currently only Reply-To and X-* headers 
	 * are allowed)
	 */
	public void setHeaders(final Map<String,String> headers) {
		this.headers = headers;
	}

	/**
	 * @return An array of supported attachments.
	 */
	public List<MessageContent> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments An array of supported attachments.
	 */
	public void setAttachments(final List<MessageContent> attachments) {
		this.attachments = attachments;
	}

	/**
	 * @return An array of embedded images.
	 */
	public List<MessageContent> getImages() {
		return images;
	}

	/**
	 * @param images An array of embedded images.
	 */
	public void setImages(final List<MessageContent> images) {
		this.images = images;
	}
	
	/**
	 * @return Whether or not this message is important, and should be 
	 * delivered ahead of non-important messages.
	 */
	public Boolean getImportant() {
		return important;
	}
	
	/**
	 * @param important Set whether or not this message is important, and 
	 * should be delivered ahead of non-important messages
	 */
	public void setImportant(final Boolean important) {
		this.important = important;
	}

	/**
	 * @return Whether or not to turn on open tracking 
	 * for the message.
	 */
	public Boolean getTrackOpens() {
		return trackOpens;
	}

	/**
	 * @param trackOpens Whether or not to turn on open 
	 * tracking for the message.
	 */
	public void setTrackOpens(final Boolean trackOpens) {
		this.trackOpens = trackOpens;
	}

	/**
	* @return Whether or not to turn on click tracking 
	* for the message.
	*/
	public Boolean getTrackClicks() {
		return trackClicks;
	}

	/**
	 * @param trackClicks Whether or not to turn on click tracking 
	* for the message.
	 */
	public void setTrackClicks(final Boolean trackClicks) {
		this.trackClicks = trackClicks;
	}

	/**
	 * @return Whether or not to automatically generate a 
	 * text part for messages that are not given text.
	 */
	public Boolean getAutoText() {
		return autoText;
	}

	/**
	 * @param autoText Whether or not to automatically generate a 
	 * text part for messages that are not given text.
	 */
	public void setAutoText(final Boolean autoText) {
		this.autoText = autoText;
	}

	/**
	 * @return Whether or not to automatically generate an 
	 * HTML part for messages that are not given HTML.
	 */
	public Boolean getAutoHtml() {
		return autoHtml;
	}

	/**
	 * @param autoHtml Whether or not to automatically generate an 
	 * HTML part for messages that are not given HTML.
	 */
	public void setAutoHtml(final Boolean autoHtml) {
		this.autoHtml = autoHtml;
	}

	/**
	 * @return Whether or not to automatically inline all CSS styles 
	 * provided in the message HTML &ndash; only for HTML documents less 
	 * than 256KB in size.
	 */
	public Boolean getInlineCss() {
		return inlineCss;
	}

	/**
	 * @param inlineCss Whether or not to automatically inline all CSS 
	 * styles provided in the message HTML &ndash; only for HTML 
	 * documents less than 256KB in size.
	 */
	public void setInlineCss(final Boolean inlineCss) {
		this.inlineCss = inlineCss;
	}

	/**
	 * @return Whether or not to strip the query string 
	 * from URLs when aggregating tracked URL data.
	 */
	public Boolean getUrlStripQs() {
		return urlStripQs;
	}

	/**
	 * @param urlStripQs Whether or not to strip the query string 
	 * from URLs when aggregating tracked URL data.
	 */
	public void setUrlStripQs(final Boolean urlStripQs) {
		this.urlStripQs = urlStripQs;
	}

	/**
	 * @return Whether or not to expose all recipients in 
	 * to "To" header for each email.
	 */
	public Boolean getPreserveRecipients() {
		return preserveRecipients;
	}

	/**
	 * @param preserveRecipients Whether or not to expose all 
	 * recipients in the "To" header for each email.
	 */
	public void setPreserveRecipients(final Boolean preserveRecipients) {
		this.preserveRecipients = preserveRecipients;
	}
	
	/**
	 * @return False if you want to remove content logging for 
	 * sensitive emails.
	 */
	public Boolean getViewContentLink() {
		return viewContentLink;
	}
	
	/**
	 * @param view_content_link Set to false to remove content logging for 
	 * sensitive emails.
	 */
	public void setViewContentLink(final Boolean view_content_link) {
		this.viewContentLink = view_content_link;
	}

	/**
	 * @return An optional address to receive an exact copy of 
	 * each recipient's email.
	 */
	public String getBcc() {
		return bccAddress;
	}

	/**
	 * @param email An optional address to receive an 
	 * exact copy of each recipient's email.
	 */
	public void setBcc(final String email) {
		this.bccAddress = email;
	}

	/**
	 * @return A custom domain to use for tracking opens 
	 * and clicks instead of mandrillapp.com.
	 */
	public String getTrackingDomain() {
		return trackingDomain;
	}

	/**
	 * @param trackingDomain The custom domain to use for tracking 
	 * opens and clicks instead of mandrillapp.com.
	 */
	public void setTrackingDomain(final String trackingDomain) {
		this.trackingDomain = trackingDomain;
	}

	/**
	 * @return A custom domain to use for SPF/DKIM signing instead of 
	 * mandrill (for "via" or "on behalf of" in email clients).
	 */
	public String getSigningDomain() {
		return signingDomain;
	}

	/**
	 * @param signingDomain The custom domain to use for SPF/DKIM 
	 * signing instead of mandrill (for "via" or "on behalf of" 
	 * in email clients).
	 */
	public void setSigningDomain(final String signingDomain) {
		this.signingDomain = signingDomain;
	}
	
	/**
	 * @return The custom domain to use for the messages's return-path.
	 */
	public String getReturnPathDomain() {
		return returnPathDomain;
	}
	
	/**
	 * @param return_path_domain A custom domain to use for the 
	 * messages's return-path.
	 */
	public void setReturnPathDomain(final String return_path_domain) {
		this.returnPathDomain = return_path_domain;
	}

	/**
	 * @return Whether to evaluate merge tags in the message. Will 
	 * automatically be set to true if either 
	 * {@link #setMerge_vars(MergeVarBucket)} or 
	 * {@link #setGlobal_merge_vars(MergeVar[])} are provided.
	 */
	public Boolean getMerge() {
		return merge;
	}

	/**
	 * @param merge Whether to evaluate merge tags in the message. Will 
	 * automatically be set to true if either 
	 * {@link #setMerge_vars(MergeVarBucket)} or 
	 * {@link #setGlobal_merge_vars(MergeVar[])} are provided.
	 */
	public void setMerge(final Boolean merge) {
		this.merge = merge;
	}

	/**
	 * @return The global merge variables to use for all recipients. 
	 * You can override these per recipient.
	 */
	public List<MergeVar> getGlobalMergeVars() {
		return globalMergeVars;
	}

	/**
	 * @param globalMergeVars The global merge variables to use for 
	 * all recipients. You can override these per recipient.
	 */
	public void setGlobalMergeVars(final List<MergeVar> globalMergeVars) {
		this.globalMergeVars = globalMergeVars;
	}

	/**
	 * @return The per-recipient merge variables, which override 
	 * global merge variables with the same name.
	 */
	public List<MergeVarBucket> getMergeVars() {
		return mergeVars;
	}

	/**
	 * @param mergeVars The per-recipient merge variables, which override 
	 * global merge variables with the same name.
	 */
	public void setMergeVars(final List<MergeVarBucket> mergeVars) {
		this.mergeVars = mergeVars;
	}

	/**
	 * @return An array of string to tag the message with. Stats 
	 * are accumulated using tags, though we only store the first 
	 * 100 we see, so this should not be unique or change frequently. 
	 * Tags should be 50 characters or less. Any tags starting with 
	 * an underscore are reserved for internal use and will cause 
	 * errors.
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags An array of string to tag the message with. Stats 
	 * are accumulated using tags, though we only store the first 
	 * 100 we see, so this should not be unique or change frequently. 
	 * Tags should be 50 characters or less. Any tags starting with 
	 * an underscore are reserved for internal use and will cause 
	 * errors.
	 */
	public void setTags(final List<String> tags) {
		this.tags = tags;
	}
	
	/**
	 * @param tags Strings to tag the message with. Stats 
	 * are accumulated using tags, though we only store the first 
	 * 100 we see, so this should not be unique or change frequently. 
	 * Tags should be 50 characters or less. Any tags starting with 
	 * an underscore are reserved for internal use and will cause 
	 * errors.
	 */
	public void setTags(final String... tags) {
		final ArrayList<String> ts = new ArrayList<String>();
		for(String tag : tags) {
			ts.add(tag);
		}
		if(!ts.isEmpty()) {
			this.tags = ts;
		} else {
			this.tags = null;
		}
	}
	
	/**
	 * @return The unique id of a subaccount for this message 
	 * &ndash; must already exist or will fail with an error.
	 */
	public String getSubaccount() {
		return subaccount;
	}
	
	/**
	 * @param subaccount The unique id of a subaccount for this message 
	 * &ndash; must already exist or will fail with an error.
	 */
	public void setSubaccount(final String subaccount) {
		this.subaccount = subaccount;
	}

	/**
	 * @return An array of strings indicating which matching URLs will 
	 * automatically have Google Analytics parameters appended to their 
	 * query string.
	 */
	public List<String> getGoogleAnalyticsDomains() {
		return googleAnalyticsDomains;
	}

	/**
	 * @param googleAnalyticsDomains An array of strings indicating which 
	 * matching URLs will automatically have Google Analytics parameters 
	 * appended to their query string.
	 */
	public void setGoogleAnalyticsDomains(
			final List<String> googleAnalyticsDomains) {
		
		this.googleAnalyticsDomains = googleAnalyticsDomains;
	}

	/**
	 * @return Optional string indicating the value to set 
	 * for the utm_campaign tracking parameter. If this isn't 
	 * provided the email's from address will be used instead.
	 */
	public String getGoogleAnalyticsCampaign() {
		return googleAnalyticsCampaign;
	}

	/**
	 * @param googleAnalyticsCampaign Optional string indicating the 
	 * value to set for the utm_campaign tracking parameter. If this isn't 
	 * provided the email's from address will be used instead.
	 */
	public void setGoogleAnalyticsCampaign(
			final String googleAnalyticsCampaign) {
		
		this.googleAnalyticsCampaign = googleAnalyticsCampaign;
	}

	/**
	 * @return A map of user metadata. Mandrill will 
	 * store this metadata and make it available for retrieval. In 
	 * addition, you can select up to 10 metadata fields to index and 
	 * make searchable using the Mandrill search api.
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata A map of user metadata. Mandrill will 
	 * store this metadata and make it available for retrieval. In 
	 * addition, you can select up to 10 metadata fields to index and 
	 * make searchable using the Mandrill search api.
	 */
	public void setMetadata(final Map<String, String> metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return Per-recipient metadata that will override the 
	 * global values specified in the metadata parameter.
	 */
	public List<RecipientMetadata> getRecipientMetadata() {
		return recipientMetadata;
	}

	/**
	 * @param recipientMetadata metadata that will override the 
	 * global values specified in the metadata parameter.
	 */
	public void setRecipientMetadata(
			final List<RecipientMetadata> recipientMetadata) {
		this.recipientMetadata = recipientMetadata;
	}

	

	/**
	 * <p>A single recipient's information.</p>
	 * @author rschreijer
	 * @since Mar 16, 2013
	 */
	public static class Recipient {
		/**
		 * <p>The Recipient type (To, Cc, Bcc, ...)
		 */
		public enum Type {
			to, bcc, cc;
		}

		private String email, name;
		private Type type = Type.to;

		/**
		 * @return The type of the recipient.
		 * @see {@link Type}
		 */
		public Type getType() {
			return type;
		}

		/**
		 * @param type The type of the recipient.
		 * @see {@link Type}
		 */
		public void setType(final Type type) {
			this.type = type;
		}


		/**
		 * @return The email address of the recipient.
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email The email address of the recipient.
		 */
		public void setEmail(final String email) {
			this.email = email;
		}
		/**
		 * @return The optional display name to use for the recipient.
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name The optional display name to use for the recipient
		 */
		public void setName(final String name) {
			this.name = name;
		}


	}
	
	/**
	 * <p>A single supported content object for a message. This
	 * can be a embedded image or an attachment.</p>
	 * @author rschreijer
	 * @since Mar 16, 2013
	 */
	public static class MessageContent {
		private String name, type, content;
		private Boolean binary;
		
		/**
		 * @return The file name of the attachment.
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name The file name of the attachment.
		 */
		public void setName(final String name) {
			this.name = name;
		}
		/**
		 * @return The MIME type of the attachment.
		 */
		public String getType() {
			return type;
		}
		/**
		 * @param type The MIME type of the attachment.
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * @return The actual content, as base64-encoded string.
		 */
		public String getContent() {
			return content;
		}
		/**
		 * @param content The actual content, as base64-encoded string.
		 */
		public void setContent(final String content) {
			this.content = content;
		}
		/**
		 * @return the binary
		 */
		public Boolean isBinary() {
			if(binary == null) {
				return false;
			}
			return binary;
		}
		/**
		 * @param binary the binary to set
		 */
		public void setBinary(final Boolean binary) {
			this.binary = binary;
		}
	}
	
	/**
	 * <p>A per-recipient merge variable.</p>
	 * @author rschreijer
	 * @since Mar 16, 2013
	 */
	public static class MergeVarBucket {
		private String rcpt;
		private MergeVar[] vars;
		/**
		 * @return The email address of the recipient that 
		 * the merge variables should apply to.
		 */
		public String getRcpt() {
			return rcpt;
		}
		/**
		 * @param rcpt The email address of the recipient that 
		 * the merge variables should apply to.
		 */
		public void setRcpt(final String rcpt) {
			this.rcpt = rcpt;
		}
		/**
		 * @return The recipient's merge variables.
		 */
		public MergeVar[] getVars() {
			return vars;
		}
		/**
		 * @param vars The recipient's merge variables.
		 */
		public void setVars(final MergeVar[] vars) {
			this.vars = vars;
		}
	}
	
	/**
	 * <p>A single global merge variable.</p>
	 * @author rschreijer
	 * @since Mar 16, 2013
	 */
	public static class MergeVar {
		private String name, content;

		/**
		 * Construct a MergeVar.
		 */
		public MergeVar() {
		}

		/**
		 * Construct and assign name and content in one step.
		 * @param name The merge variable's name
		 * @param content The merge variable's content.
		 */
		public MergeVar(final String name, final String content) {
			this.name = name;
			this.content = content;
		}

		/**
		 * @return The merge variable's name. 
		 * Merge variable names are case-insensitive 
		 * and may not start with _ (underline).
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name The merge variable's name. 
		 * Merge variable names are case-insensitive 
		 * and may not start with _ (underline).
		 */
		public void setName(final String name) {
			this.name = name;
		}
		/**
		 * @return The merge variable's content.
		 */
		public String getContent() {
			return content;
		}
		/**
		 * @param content The merge variable's content.
		 */
		public void setContent(final String content) {
			this.content = content;
		}
	}
	
	/**
	 * <p>Metadata for a single recipient</p>
	 * @author rschreijer
	 * @since Mar 16, 2013
	 */
	public static class RecipientMetadata {
		private String rcpt;
		private Map<String,String> values;
		/**
		 * @return The email address of the recipient 
		 * that the metadata is associated with.
		 */
		public String getRcpt() {
			return rcpt;
		}
		/**
		 * @param rcpt The email address of the recipient 
		 * that the metadata is associated with.
		 */
		public void setRcpt(final String rcpt) {
			this.rcpt = rcpt;
		}
		/**
		 * @return A map of user metadata. Mandrill will 
		 * store this metadata and make it available for retrieval. In 
		 * addition, you can select up to 10 metadata fields to index and 
		 * make searchable using the Mandrill search api.
		 */
		public Map<String, String> getValues() {
			return values;
		}
		/**
		 * @param values A map of user metadata. Mandrill will 
		 * store this metadata and make it available for retrieval. In 
		 * addition, you can select up to 10 metadata fields to index and 
		 * make searchable using the Mandrill search api.
		 */
		public void setValues(final Map<String, String> values) {
			this.values = values;
		}
	}
}
