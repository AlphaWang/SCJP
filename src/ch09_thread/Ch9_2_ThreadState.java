/**
 * <p>文件名称: Ch9_2_ThreadState.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-22</p>
 * <p>完成日期：2011-3-22</p>
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

public class Ch9_2_ThreadState
{
	/**
	 * 1. 线程状态变化
	 *     start()                   yield()<
	 * [new] ---------> [runnable] <----------> [running] ------> [death]
	 *                   ∧               | join()/wait()/sleep()/等待同步方法
	 *                    |     ∨
	 *               [wait/block/sleep]
	 * 
	 */
	public static void main(String[] args)
	{
		MyRunnable2 myRunnable = new MyRunnable2();
		Thread thread1 = new Thread(myRunnable,"thread 1");
		Thread thread2 = new Thread(myRunnable,"thread 2");
		Thread thread3 = new Thread(myRunnable,"thread 3");
		/**
		 * 1)new:
		 * Thread实例创建之后，线程即进入new状态，此时线程不是活的
		 * 
		 */
			
		
		thread1.start();
		thread2.start();
		thread3.start();
		/**
		 * 2)runnable:
		 * 调用start()之后，线程进入runnable状态，活的
		 * 
		 * ————有三种方式可以使线程进入runnable状态:start\等待锁成功\sleep完成\yield\join完成
		 */
		
		
		/**
		 * 3)running:
		 * 线程调度器从可运行池中 选择一个线程作为当前执行的线程，该线程即进入running状态。
		 * 
		 * ————只有一种方式可以使线程进入running状态
		 */
		
		/**
		 * 4) wait:
		 * 线程的运行代码 导致线程等待
		 * 
		 * 4) sleep:
		 * 线程的运行代码 通知该线程睡眠一段时间————不释放锁！wait()释放锁
		 * Thread.sleep()是让所有线程都有机会运行的最佳办法
		 * 
		 * 4) blocked:
		 * 线程等待一种资源（IO、对象锁）时，可能被阻塞
		 * 
		 */
		
		
		/**
		 * 3. Thread.yield()
		 * 
		 * 让当前运行中的线程回到runnable状态，(running -> runnable)
		 * 重新选一个相同优先级的来运行，但可能又选到原来的那个线程
		 * 
		 * 让具有相同优先级的线程之间能否适当地轮转
		 */
		thread1.setPriority(Thread.MAX_PRIORITY);
		Thread.yield();
		
		/**
		 * 4. A.join() 非静态
		 * 
		 * 让当前线程B加入到另一个线程A的尾部:等待A结束
		 * 必须在A death之后，当前线程B 才能runnable
		 */
		try {
			thread1.join();
			System.out.println("当前线程："+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

}
class MyRunnable2 implements Runnable
{

	@Override
	public void run() {
		for(int i = 0; i < 4 ; i++)
		{
			System.out.println("运行MyRunnable.run()，线程名: " + Thread.currentThread().getName());
			try {
				/**
				 * 2. Thread.sleep()
				 * 
				 * Thread.sleep()是让所有线程都有机会运行的最佳办法
				 * 但是 线程在进入睡眠之前，不能肯定它会实际运行多长时间
				 * sleep到期后 会进入runnable状态，并不能保证它马上就重新运行，所以不能依赖sleep做精确定时器
				 *
				 * sleep()是静态方法！sleep()会让"当前运行的线程"睡眠
				 * 不要误以为一个线程能够使另一个线程睡眠
				 *
				 */
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
