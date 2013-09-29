/**
 * <p>文件名称: Ch9_1_Def.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-21</p>
 * <p>完成日期：2011-3-21</p>
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

public class Ch9_1_ThreadDef {

	public static void main(String[] args)
	{
		/**
		 * 0. 每个调用栈都有一个线程
		 *    每个线程都有一个调用栈
		 *    
		 *    main()方法是主调用栈的栈底方法
		 *    创建一个新线程后，新线程调用的方法都运行在一个新调用栈中
		 */
		
		/**
		 * 2. 实例化并运行线程
		 * 
		 * 	  方法一、实例化Thread子类
		 */
		MyThread myThread = new MyThread();
		myThread.start(); //调用myThread的run方法
		System.out.println("myThread.getName():" + myThread.getName());
		/*
		 * 可以直接调用Thread.run()，不过就不会启动新线程了
		 */
		myThread.run();
		
		
		/**
		 * 2. 实例化并运行线程
		 * 
		 * 	  方法二、实例化Runnable实现类
		 * 
		 * Thread 	：工人
		 * Runnable	：任务
		 * 
		 *  调用start()之后发生的事情：
		 *  a)启动新的执行线程（具有新的调用栈）
		 *  b)线程从new状态 转到 runnable状态
		 *  c)当线程获得执行机会，执行它的run()方法
		 */
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		t1.start();//调用myRunnable的run方法，而不是t1的！
		//!!理论上，不能保证myThread.run()和myRunnable.run()哪个先执行
		
		
		System.out.println("t1.getName():" + t1.getName());
		
		
		Thread t2 = new Thread(myRunnable);//可以让多个工人完成相同的任务		
		Thread t3 = new Thread(myThread);//Thread也实现了Runnable，所以可以传递进Thread构造方法。但是没有意义
		
		System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
		
		/**
		 * 3. 同时启动多个线程
		 * 
		 * 每个线程内的操作顺序可以预见
		 * 但不同线程的操作是混杂在一起的
		 * 
		 * 按某个顺序启动了一系列线程，并不意味着它们按照同样顺序执行
		 * 
		 * 有一种启动线程的方法，指定它在另外某个线程结束前 不要运行。 join():等待某个线程结束后再运行
		 */
		
		
		/**
		 * 4. 线程执行结束后（即run()方法终了）
		 * 
		 * 线程栈会解散，称为死线程
		 * 仍然可以调用Thread对象上的方法，但不能再次启动线程start()
		 * 
		 */
		//运行时异常：java.lang.IllegalThreadStateException
		//t1.start();
		

		

	}

}
/**
 * 1. 定义线程
 * 
 *  方法一、扩展Thread类
 *  局限：就不能扩展其他类了
 *
 */
class MyThread extends Thread
{
	@Override
	public void run() {
		System.out.println("运行MyThread.run()，线程名:" + this.getName());
	}
}
/**
 * 1. 定义线程
 * 
 *  方法二、实现Runnable接口
 *
 */
class MyRunnable implements Runnable
{
	String test = "";

	@Override
	public void run() {
		synchronized (test) {
			
		}
		System.out.println("运行MyRunnable.run()，线程名:" + Thread.currentThread().getName());
		
	}
	
}
