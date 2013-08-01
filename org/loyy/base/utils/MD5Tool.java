/**
 * 
 */
package org.loyy.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author loyy
 * 
 */
public class MD5Tool {
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	protected static MessageDigest messagedigest = null;
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			// System.err.println(GetFileMD5.class.getName()+"初始化失败，MessageDigest不支持MD5Util。");
			e.printStackTrace();
		}
	}
	/**
			获得文件MD5的代码源至：
			http://blog.csdn.net/zdwzzu2006/article/details/8064947
	*/
	public static String getFileMD5String(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
				file.length());
		messagedigest.update(byteBuffer);
		return bufferToHex(messagedigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];
		char c1 = hexDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static boolean checkPassword(String password, String md5PwdStr) {
		String s = getMD5String(password);
		return s.equals(md5PwdStr);
	}

	public static String getMD5String(String s) {
		return getMD5String(s.getBytes());
	}

	public static String getMD5String(byte[] bytes) {
		messagedigest.update(bytes);
		return bufferToHex(messagedigest.digest());
	}
	
	
	
	
	
	
	
	
	

	
	//遍历目录获得每个文件的MD5值，把值和对应的文件输出到.txt文件保存。
	public static void dir(File file) throws IOException{
		if(!file.isDirectory()){
			String md5=getFileMD5String(file);
			writeOut("c:\\rst.txt", "["+md5+"] "+file.getAbsolutePath());
			
		}else{
			File[] ff=file.listFiles();
			for (int i = 0;ff!=null&& i < ff.length; i++) {
				dir(ff[i]);				
			}
		}
	}
	//输出内容到txt
	public static void writeOut(String targetDir,String str){
		
		try {
			java.io.BufferedWriter bos=new java.io.BufferedWriter(new FileWriter(new File(targetDir),true));
			bos.write(str);
			bos.newLine();
			bos.flush();
			bos.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
	
		   dir(new File("d:\\database"));
		   
		   
	}
}
