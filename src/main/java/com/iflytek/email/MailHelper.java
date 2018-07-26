package com.iflytek.email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class MailHelper {
	
	/**
	 * <p>
	 * <code>MailHelper</code>封装了常用的邮件发送方法，使用默认的发送者.
	 * </p>
	 * 
	 * @param to
	 *            接受者
	 * @param subject
	 *            主题
	 * @param body
	 *            内容
	 * @throws org.apache.commons.mail.EmailException
	 *             发送失败异常
	 */
	public static void sendMail(String to, String subject, String body)
			throws EmailException {
		sendMail(MailConfig.FROM, to, subject, body);
	}

	/**
	 * <p>
	 * <code>sendMail</code>封装了常用的邮件发送方法.
	 * </p>
	 *
	 * @param from
	 *            发送者
	 * @param to
	 *            接受者
	 * @param subject
	 *            主题
	 * @param body
	 *            内容
	 * @throws org.apache.commons.mail.EmailException
	 *             发送失败异常
	 */
	public static void sendMail(String from, String to, String subject,
			String body) throws EmailException {
		Email email = MailFactory.getEmail(MailFactory.MailType.Simple);
		email.setFrom(from);
		email.addTo(to);
		email.setSubject(subject);
		email.setMsg(body);
		email.send();
	}
	/**
	 * <p>
	 * <code>MailHelper</code>封装了常用的邮件发送方法，使用默认的发送者.
	 * </p>
	 *
	 * @param to
	 *            接受者
	 * @param subject
	 *            主题
	 * @param body
	 *            内容
	 * @throws org.apache.commons.mail.EmailException
	 *             发送失败异常
	 */
	public static void sendMail(String[] to, String subject, String body)
			throws EmailException {
		sendMail(MailConfig.FROM, to, subject, body);
	}
	/**
	 * <p>
	 * <code>sendMail</code>封装了常用的邮件发送方法.
	 * </p>
	 *
	 * @param from
	 *            发送者
	 * @param to
	 *            接受者
	 * @param subject
	 *            主题
	 * @param body
	 *            内容
	 * @throws org.apache.commons.mail.EmailException
	 *             发送失败异常
	 */
	public static void sendMail(String from, String[] to, String subject,
								String body) throws EmailException {
		Email email = MailFactory.getEmail(MailFactory.MailType.Simple);
		email.setFrom(from);
		email.addTo(to);
		email.setSubject(subject);
		email.setMsg(body);
		email.send();
	}
	
}
