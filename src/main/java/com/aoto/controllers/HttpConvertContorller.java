package com.aoto.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aoto.pojo.Device;

/**
 * spring mvc 消息转换器测试
 * 
 * @author Administrator
 *
 */

@Controller
public class HttpConvertContorller {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HttpConvertContorller.class);
	

	@RequestMapping(value = "/services/devices/{deviceId}.xml", method = RequestMethod.PUT, consumes = "application/xml", produces = "application/xml")
	@ResponseBody
	public Device editDevice(@RequestBody Device device, HttpServletRequest request) {

		logger.info("进入了我的测试方法，打印映射的对象：{}",device);
		
		
		
		
		System.out.println(device);
		
		
		
		
		
		return device;

	}

}
