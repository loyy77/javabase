/**
 * 
 */
package org.loyy.base.concurrent;

/**
 * @author LiShixi ����"��Ʊ" <br/>
 *         yield()������ʹ��
 */
public class Thread2 implements Runnable {

	static int count = 10;// 10 ticket
	boolean flag = true;

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (count > 0) {
			synchronized (this) {

					System.out.println(Thread.currentThread().getName()
							+ "˵����������ȥһ��Ʊ������ ��ʣƱ��" + count-- + ")");
				Thread.currentThread().yield();


				

			}



		}


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread2 t1 = new Thread2();
		Thread2 t2 = new Thread2();
		System.out.println();
		Thread tt1 = new Thread(t1);
		System.out.println(tt1.isAlive());
		tt1.start();
		System.out.println(tt1.isAlive());
		new Thread(t2).start();
	}


}
