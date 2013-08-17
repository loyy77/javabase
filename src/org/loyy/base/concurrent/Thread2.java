/**
 * 
 */
package org.loyy.base.concurrent;

/**
 * @author LiShixi 轮流"卖票" <br/>
 *         yield()方法的使用
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
							+ "说：“我卖出去一张票！”（ 还剩票数" + count-- + ")");
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
