package com.aoto.controllers;

import com.aoto.pojo.Device;
import com.aoto.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * spring mvc  测试请求转发
 * 
 * @author Administrator
 *
 */

@Controller
public class MyContorller {

	private static final Logger logger = LoggerFactory.getLogger(MyContorller.class);

	@RequestMapping(value = "/mydispatch",method = RequestMethod.GET)
	public void testRed(HttpServletResponse response) throws Exception{

		String username = "supadmin";
		String pwd = "Aoto12345";


		String encryptUname = EncryptUtil.aesEncryptToString(username); //使用工具类对用户名进行加密
		String encryptPwd = EncryptUtil.aesEncryptToString(pwd);   //使用工具类对密码进行加密

		String encryptUnameUrl = URLEncoder.encode(encryptUname,"UTF-8");   //使用URLENcoder对密码进行编码
		String encryptPwdUrl = URLEncoder.encode(encryptPwd,"UTF-8"); //使用URLENcoder对密码进行编码

		String url = "http://172.16.210.181:8080/mips/single/sign?username="+encryptUnameUrl+"&pwd="+encryptPwdUrl;
		System.out.println("转发地址"+url);
		response.sendRedirect(url);  //将请求重定向到智能设备管理系统中

		System.out.println("这是一个多余的测试代码");

	}

}
