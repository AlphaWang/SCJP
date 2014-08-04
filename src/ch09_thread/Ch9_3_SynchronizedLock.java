/**
 * <p>文件名称: Ch9_3_SynchronizedLock.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-24</p>
 * <p>完成日期：2011-3-24</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author WangZhongXing192063
 */
package ch09_thread;

public class Ch9_3_SynchronizedLock {
	
	public static void main(String[] args) {
		DealResource r = new DealResource();
		Thread thread1= new Thread(r,"thread1");
		Thread thread2= new Thread(r,"thread2");
		/**
		 *  当两个线程被阻塞，彼此都在等待对方的锁时，就会发生死锁
		 *  
		 *  解决方法之一：规定始终按照预定义的顺序获取锁
		 *
		 */
		thread1.start();
		thread2.start();

	}

}


class DealResource implements Runnable{
	public Resource resourceA = new Resource();
	public Resource resourceB = new Resource();
	public int read(){
		/*
		 * 1.thread1在此处获取resourceA的锁
		 */
		synchronized (resourceA) { //这里可能死锁
			/*
			 * 2.thread1在此处等待resourceB的锁
			 */
			synchronized (resourceB) {
				return resourceB.value + resourceA.value;
			}
		}
	}
	public int write(int a, int b){
		/*
		 * 1.thread2在此处获取resourceB的锁
		 */
		synchronized (resourceB) { //这里可能死锁
			/*
			 * 2. thread2在此处等待resourceA的锁
			 */
			synchronized (resourceA) {
				resourceA.value = a;
				resourceB.value = b;
			}
		}
		return a+b;
	}

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println(Thread.currentThread().getName() +" read():"
					+ read());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			System.out.println(Thread.currentThread().getName() +" write(40,50):" 
					+ write(40,50));
		}
		
	}
	
}


class Resource {
	int value;
}
