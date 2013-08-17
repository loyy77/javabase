package org.loyy.base.concurrent.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MergeFile extends Thread {

	private int threadNumber;
	private String fileName;
	private String downLoadPath;

	public MergeFile(int threadNumber, String downLoadPath, String fileName) {
		super();
		this.threadNumber = threadNumber;
		this.downLoadPath = downLoadPath;
		this.fileName = fileName;
	}

	public void run() {
		while (!(Main.SINGAL == 0 && Main.START_DOWNLOAD)) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}
		try {
			System.out.println("�ļ���ʼ�ϲ�");
			OutputStream bos = new FileOutputStream(new File(downLoadPath
					+ fileName), false);
			for (int i = 0; i < threadNumber; i++) {
				File file = new File(downLoadPath + fileName + ".part" + i);
				InputStream is = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = is.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				is.close();
				file.delete();
			}
			bos.close();
			System.out.println("�ļ��ϲ����");
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		Main.START_DOWNLOAD = false;
	}

	public int getThreadNumber() {
		return threadNumber;
	}

	public void setThreadNumber(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownLoadPath() {
		return downLoadPath;
	}

	public void setDownLoadPath(String downLoadPath) {
		this.downLoadPath = downLoadPath;
	}

}