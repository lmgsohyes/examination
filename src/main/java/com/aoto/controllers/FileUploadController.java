package com.aoto.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.pojo.Device;

/**
 * 测试文件上传
 * @author Administrator
 *
 */
@Controller
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public ModelAndView intryFileUpload() {
		
		ModelAndView mav = new ModelAndView("file/list");
		
		logger.info("进入文件上传页面");
		
		
		return mav;

	}
	
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> fileUploadProc() {
		
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		
		
		return resultMap;

	}
	
}
