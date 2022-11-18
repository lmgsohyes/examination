/**
 * EncryptUtil.java
 * <p>(一句话描述功能):
 * <p>@author: guoy
 * <p>@date: 2019年4月4日
 */
package com.aoto.util;

import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptUtil {

	private static String KEY = "abcdef0123456789";

	private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

	/*static {
		Properties properties = PropertiesManager.getInstance().loadProperties("security.properties");
		KEY = properties.getProperty("user.encrypt.key", "abcdef0123456789");
	}*/

	public static String base64Encode(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

	public static byte[] base64Decode(String base64Code) {
		return Base64.decodeBase64(base64Code);
	}

	public static byte[] aesEncrytToBytes(String content, String encryptKey) throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(128);
		Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

		return cipher.doFinal(content.getBytes("utf-8"));
	}

	/**
	 *  加密方法
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String aesEncryptToString(String content) throws Exception {
		return base64Encode(aesEncrytToBytes(content, KEY));
	}


	public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(128);
		Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
		byte[] decryptBytes = cipher.doFinal(encryptBytes);

		return new String(decryptBytes, "utf-8");
	}

	/**
	 * 解密方法
	 * @param encryptCode
	 * @return
	 * @throws Exception
	 */
	public static String aesDecryptByString(String encryptCode) throws Exception {
		return aesDecryptByBytes(base64Decode(encryptCode), KEY);
	}


	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		}
		hexStr = hexStr.toUpperCase();
		int length = hexStr.length() / 2;
		char[] hexChar = hexStr.toCharArray();
		byte[] bs = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			bs[i] = (byte) (char2Byte(hexChar[pos]) << 4 | char2Byte(hexChar[pos + 1]));
		}
		return bs;
	}


	public static String parseByte2HexStr(byte[] bytes) {
		if (bytes.length < 1) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			int v = bytes[i] & 0xff;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				sb.append("0");
			}
			sb.append(hv);
		}
		return sb.toString();
	}

	public static byte char2Byte(char ch) {
		return (byte) "0123456789ABCDEF".indexOf(ch);
	}
	public static void main(String[] args) {
		try {
			String s = EncryptUtil.aesEncryptToString("supadmin");
			System.out.println("加密内容："+s);

			String d = EncryptUtil.aesDecryptByString(s);

			System.out.println("解密内容："+d);


			System.out.println("只是加密："+aesEncrytToBytes("supadmin", KEY));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
