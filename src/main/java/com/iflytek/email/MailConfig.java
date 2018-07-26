package com.iflytek.email;

import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public final class MailConfig {
	
	// 主机
	public static String HOST = null;
	// 发送者
	public static String FROM = null;
	// 用户名
	public static String USER_NAME = null;
	// 密码
	public static String PASSWORD = null;
	// 默认编码方式
	public static String DEFAULT_ENCODING = null;

	static {
		try {
			Configuration config = new PropertiesConfiguration(
                    "mail.properties");
			HOST = config.getString("mail.host");
			FROM = config.getString("mail.from");
			USER_NAME = config.getString("mail.username");
			PASSWORD = config.getString("mail.password");
			DEFAULT_ENCODING = config.getString("mail.defaultEncoding");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
}
