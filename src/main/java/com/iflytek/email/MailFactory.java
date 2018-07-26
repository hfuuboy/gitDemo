package com.iflytek.email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class MailFactory {
	

	/**
	 * 
	 * <p>
	 * <code>MailType</code>发送邮件四种类型.
	 * </p>
	 *
	 * @author <a href="mailto:wqwu@iflytek.com">cheney</a>
	 * @since 1.0
	 * @version 1.0
	 */
	public enum MailType {
		Simple, MultiPart, Html, ImageHtml
	}

	/**
	 * <p>
	 * <code>getEmail</code>获取不同类型的邮件发送方式.
	 * </p>
	 * 
	 * @param type
	 *            MailType
	 * @return Email
	 */
	public static Email getEmail(MailType type) {
		Email email = null;
		switch (type) {
		case Simple:
			email = new SimpleEmail();
			break;
		case MultiPart:
			email = new MultiPartEmail();
			break;
		case Html:
			email = new HtmlEmail();
			break;
		case ImageHtml:
			email = new ImageHtmlEmail();
			break;
		default:
			break;
		}
		if (null == email) {
			throw new NullPointerException("初始化Mail失败.");
		}
		return init(email);
	}

	/**
	 * <p>
	 * <code>init</code>初始化发送邮件需要的参数配置等信息.
	 * </p>
	 * 
	 * @param email
	 *            Email
	 * @return Email
	 */
	private static Email init(Email email) {
		email.setHostName(MailConfig.HOST);
		email.setCharset(MailConfig.DEFAULT_ENCODING);
		email.setAuthentication(MailConfig.USER_NAME, MailConfig.PASSWORD);
		return email;
	}

}
