package com.iflytek.email;

import org.apache.commons.mail.EmailException;

public class MailTest {
	
	public static void main(String[] args) throws EmailException {
		String to ="***@qq.com";
		String subject ="老母鸡";
		String body ="晚上有饭嘛";
		MailHelper.sendMail(to, subject, body);
		System.out.println("发送成功");
	}

}
