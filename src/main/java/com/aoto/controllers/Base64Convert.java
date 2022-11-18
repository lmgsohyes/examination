package com.aoto.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;


/**
 * base64文件转换
 * 
 * @author Administrator
 *
 */
public class Base64Convert {

	public static void main(String[] args) {
		// 将文件转换成字节数组，并转成字符串
//		String strImg = GetImageStr();
//		System.out.println(strImg);
		// 对字节数组字符串进行Base64解码并生成图片
		//GenerateImage(strImg);
		
		String str = readFile();
		
		
		decodeStr(str);
		
	}

	public static String GetImageStr() {
		String imgFile = "d:\\convert\\20200331090323225";// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Base64 base64 = new Base64();
		String baseStr = base64.encodeAsString(data);
		
//		System.out.println("解密开始-----------------");
//		decodeStr(baseStr);
//		System.out.println("解密完成-----------------");
		
		return baseStr;// 返回Base64编码过的字节数组字符串
	}
	
	
	public static String readFile(){
		String str = "";
				
		String file = "d:\\convert\\20200331093100651_1.txt";// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(file);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		str = new String(data);
		System.out.println("读取到的base64字符串："+str);
		return str;
	}
	

	/**
     * 
     * 创建日期2011-4-25上午10:15:11
     * 修改日期
     * 作者：dh     *TODO 使用Base64加密
     *return
     */
    public static String decodeStr(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("d:\\convert\\bas.txt"));
			fos.write(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
