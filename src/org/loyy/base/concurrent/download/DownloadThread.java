package org.loyy.base.concurrent.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread extends Thread {
	private URL url;
	private int length;
	private int offset;
	private OutputStream bos;
	private String filePath;

	public void run() {
		Main.SINGAL++;
		System.out.println("线程" + this.getId() + "开始下载");
		try {
			System.out.println("length:" + length);
			System.out.println("off:" + offset);
			HttpURLConnection httpConnection = (HttpURLConnection) url
					.openConnection();
			httpConnection.setRequestProperty("RANGE", "bytes=" + offset + "-");
			InputStream ins = httpConnection.getInputStream();
			bos = new FileOutputStream(new File(filePath), false);
			byte[] buffer = new byte[1024];
			int bytesRead;
			int size = 0;
			while ((bytesRead = ins.read(buffer)) != -1) {
				size += bytesRead;
				if (size > length) {
					bytesRead = bytesRead - (size - length);
				}
				bos.write(buffer, 0, bytesRead);
				System.out.println("线程" + this.getId() + "下载了" + bytesRead
						+ "字节");
				if (size > length) {
					break;
				}
			}
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		System.out.println("线程" + this.getId() + "已经完成");
		Main.SINGAL--;
	}

	public DownloadThread(URL url, int length, int offset, String filePath) {
		super();
		this.url = url;
		this.length = length;
		this.offset = offset;
		this.filePath = filePath;
	}

	public OutputStream getBos() {
		return bos;
	}

	public void setBos(OutputStream bos) {
		this.bos = bos;
	}
}