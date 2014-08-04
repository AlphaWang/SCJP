/**
 * <p>文件名称: Ch9_4_ThreadInteractive.java </p>
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

/**
 * 0. 线程间的交互，使用wait() / notify() / notifyAll()
 * 
 *    ————每个对象o有一个锁，同时还有一个线程列表，他们等待来自对象o的信号
 *        线程调用对象o.wait()之后，就进入等待列表，然后线程不会执行任何其他指令，
 *        直到调用了对象o.notify()，选择一个 等待列表中的线程 开始执行
 *        
 *        或者调用了对象o.notifyAll(),所有等待线程得到通知 开始竞争锁

 * 
 *   这三个方法 必须在"同步方法"内调用！
 *   ————为了调用wait()/notify()，线程必须拥有那个对象的锁！
 *       否则抛出IllegalMonitorStateException
 *
 */



/**
 * 7. Thread相关方法：
 * 
 * wait()	：非静态	：InterruptedException
 * notify()	：非静态	：无异常
 * notifyAll()：同上~
 * 
 * join()	：非静态	：InterruptedException
 * sleep()	：静态	：InterruptedException
 * yield()	：静态	：无异常
 */
public class Ch9_4_ThreadInteractive {
	public static void main(String[] args)
	{
		ThreadB b = new ThreadB();
		b.setName("thread-B");
		b.start();
		/**
		 * 1.如果不wait(), 可能在b线程执行一半时打印total
		 */
		System.out.println(Thread.currentThread().getName()+" 总和：" + b.total);
		
		/**
		 * 2.？也可以用b.join()，等b线程执行完后, 打印total		 * 
		 * ————不过不必等待b完全结束
		 */
		
//		try {
//			b.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName()+" join()之后总和：" + b.total);
		
		
		/**
		 * 3.用b.wait(), 释放锁、当其他地方执行了b.notify()后，打印total
		 * 
		 * ————!!!!!!一般用while循环 包围着wait()
		 *     以免wait时，已经notify过了，导致一直等待
		 * 
		 */
		//————wait()必须位于同步方法内
		//如果执行b.wait()的线程 不拥有b的锁，会抛出IllegalMonitorStateException
		synchronized (b) {
			try {
				System.out.println(Thread.currentThread().getName()+" waiting for b to complete...");
				//****调用wait()之后，当前线程会立即释放锁！！！！————sleep()不释放锁
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" wait()之后总和：" + b.total);
		}
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("==测试notifyAll()==");
		
		/**
		 * 
		 * 5.测试notifyAll()
		 * 
		 */
		Calculator cal = new Calculator();
		//三个线程 等待计算结果
		Reader t1 = new Reader(cal);
		Reader t2 = new Reader(cal);
		Reader t3 = new Reader(cal);
		t1.start();
		t2.start();
		t3.start();
		
		//计算器线程
		cal.start();
		
		/**
		 * 
		 * 6. 如果运行wait()时，notify()已经运行过了，怎么办？
		 * 
		 * ————在      while   循环中使用wait(), 该循环检查某个条件表达式，只有当正在等待的事情还未发生时 才wait()
		 *     例如计算未完成
		 * ————双重检查    
		 * 
		 */
	}

}

class ThreadB extends Thread{
	 int total;
	 @Override
	public void run()
	 {
		synchronized (this)
		{
			for(int i=0; i<100; i++){
				
				total += i;
								
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			System.out.println(this.getName()+" 实际总和：" + total);
			/**
			 * 4. notify()	：通知当前在this对象上等待的线程
			 */
			//******调用notify()之后，当前线程并不一定立即释放锁。需要等到同步代码块结束
			notify();
			
			//this.notify();
			
		}
		//notify()必须位于同步方法内！
		//如果执行notify()的线程 不拥有b的锁，会抛出IllegalMonitorStateException
		
		//// notify();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName()+" 后续操作..." );
		
	 }
}
/**
 * 
 * 5.测试notifyAll()
 * 
 */
class Reader extends Thread
{
	Calculator c ;
	
	public Reader(Calculator c){
		this.c = c;
	}
	
	@Override
	public void run(){
		synchronized (c) {
			
			try {
				System.out.println(this.getName()+" Waiting for calculation...");
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName()+" wait()之后Total = "+c.total);
			
		}
	}
}
class Calculator extends Thread{
	 int total;
	 @Override
	public void run()
	 {
		synchronized (this)
		{
			for(int i=0; i<100; i++){
				total += i;
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(this.getName()+" 实际Total：" + total);
			/**
			 *5. notifyAll()	：通知当前在this对象上等待的线程
			 * 
			 * 所有等待线程进入runnable状态，竞争锁
			 */
			
			notifyAll();
			/*
			Thread-2 Waiting for calculation...
			Thread-3 Waiting for calculation...
			Thread-4 Waiting for calculation...
			Thread-1 实际Total：4950
			Thread-4 wait()之后Total = 4950
			Thread-3 wait()之后Total = 4950
			Thread-2 wait()之后Total = 4950
			*/
			
			
			/**
			 * 使用notify()究竟有何区别？
			 * 某一个等待线程进入runnable状态。
			        其他线程wait??！！！
			 */
			
			notify();
			/*
			Thread-2 Waiting for calculation...
			Thread-3 Waiting for calculation...
			Thread-1 实际Total：4950
			Thread-2 wait()之后Total = 4950
			Thread-3 wait()之后Total = 4950
			Thread-4 Waiting for calculation...
			*/
			
		}
	 }
}