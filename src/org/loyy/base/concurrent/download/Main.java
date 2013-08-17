package org.loyy.base.concurrent.download;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
	public static int SINGAL = 0;
	public static boolean START_DOWNLOAD = false;
	private int threadNumber;
	private String fileName;
	private String downLoadPath;
	private URL url;

	public Main(URL url) {
		super();
		this.url = url;
		this.threadNumber = 5;
		this.downLoadPath = "c:/download/";
		try {
			this.fileName = java.net.URLDecoder.decode(
					url.getFile().substring(url.getFile().lastIndexOf("/") + 1,
							url.getFile().length()), "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	public Main(int threadNumber, String fileName, String downLoadPath, URL url) {
		super();
		this.threadNumber = threadNumber;
		this.fileName = fileName;
		this.downLoadPath = downLoadPath;
		this.url = url;
	}

	public void download() throws Exception {
		System.out.println("文件开始下载");
		START_DOWNLOAD = true;
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();
		int contentLength = httpURLConnection.getContentLength();

		int partLength = contentLength / threadNumber + 1;
		for (int i = 0; i < threadNumber; i++) {
			int length = partLength;
			if (i == threadNumber - 1) {
				length = contentLength - i * partLength;
			}
			DownloadThread dt = new DownloadThread(url, length, i * partLength,
					downLoadPath + fileName + ".part" + i);
			dt.start();
		}
	}

	public int getThreadNumber() {
		return threadNumber;
	}

	public void setThreadNumber(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	public String getDownLoadPath() {
		return downLoadPath;
	}

	public void setDownLoadPath(String downLoadPath) {
		this.downLoadPath = downLoadPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public static void main(String[] args) throws Exception {
		String urlAddress = "http://www.cnblogs.com/codestiny/articles/1269388.html";

		URL url = new URL(urlAddress);
		int threadNumber = 5;
		String fileName = "test.mp3";
		String downLoadPath = "c:/download/";
		new File(downLoadPath).mkdir();
		// 下载

		Main m = new Main(url);
		m.setThreadNumber(threadNumber);
		m.download();

		// 合并文件

		fileName = m.getFileName();
		Thread mergeFile = new MergeFile(threadNumber, downLoadPath, fileName);
		mergeFile.start();

	}
}