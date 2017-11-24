package com.hujao.schedule;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

public class TokenWorkerProcess {
	private static final Logger logger = Logger.getLogger(TokenWorkerProcess.class);

	public static void RefreshToken() {
		try {
			String url = "https://api.weixin.qq.com/cgi-bin/token";
			//任务开始时间
			logger.info("start task:" + new Date().toString());
			logger.info("http request:" + url);
			Thread.sleep(5000);
			logger.info("get token:" + UUID.randomUUID());	
			
			//任务结束时间
			logger.info("end task:" + new Date().toString());
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
}
