/**
 * <p>文件名称: Ch9_3_Synchronized.java </p>
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

public class Ch9_3_Synchronized implements Runnable
{
	/**
	 * 0.问题来源：多线程取款，如何保证账户不透支？
	 * 
	 * ————将查询、取款 作为一个"原子操作"！
	 */
	private Account acct = new Account();
	public static void main(String[] args)
	{
		Ch9_3_Synchronized o = new Ch9_3_Synchronized();
		Thread thread1 = new Thread(o);
		Thread thread2 = new Thread(o);
		thread1.setName("Fred");
		thread2.setName("Lucy");
		
		thread1.start();
		thread2.start();
	}

	@Override
	public void run() 
	{
		for(int i = 0; i<5; i++){
			makeWithdrawal(10);
			//要求保证账户不透支
			if(acct.getBalance() < 0){
				System.out.println(Thread.currentThread().getName()+"账户已透支！ERROR！");
			}
		}

	}
	/**
	 * 1. 同步方法
	 * 
	 * 取款操作：
	 * 余款足够，则取款、
	 * 余款不足，不取款
	 * 
	 * -->将查询、取款作为一个原子操作，可保证不透支！
	 * 
	 * 每次只有一个线程可以执行 该对象的  所有  同步方法！
	 * ————因为每个对象有一个锁，线程进入同步方法 即获得该对象的锁；
	 *     其他线程无法得到该对象的锁，也就无法执行该对象的"所有"同步方法
	 * 
	 */
	
	//public void makeWithdrawal(int amount)
	public synchronized void makeWithdrawal(int amount)
	{
		if(acct.getBalance() >= amount){
			System.out.println(Thread.currentThread().getName()+"查询余额: "+acct.getBalance()+"(-"+amount+")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			acct.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+"取款成功：= "+acct.getBalance());
			
		}else{
			System.out.println(Thread.currentThread().getName()+"查询余额: 不足！(不取款)");
		}
	}
	
	/**
	 * 2. 同步代码块
	 * 
	 * 可以用包含同步代码块的 非同步方法，来替代同步方法
	 * ————同步会损害并发性，同步代码块可以减少同步部分
	 * 
	 */
	public void withdraw2()
	{
		System.out.println("非同步代码块部分");
		/*
		 * 同步代码块 需要指定希望使用哪个对象的锁
		 * ————在不同对象上同步的线程，将不会彼此阻塞
		 */
		synchronized (this) {
			System.out.println("同步代码块部分");
		}
	}
	/**
	 * 3. 静态方法也可以同步	
	 *    静态方法中 也可以有同步代码块
	 *    ————其他线程不能调用该"类"的所有同步方法？？？？
	 *        //错！静态同步方法、非静态同步方法 永远不会彼此阻塞！
	 *        
	 *        
	 *    ————静态方法应该只访问静态字段；非静态方法 应该只访问非静态字段。否则同步时会很复杂	       
	 *        例如，nonStaticMethod() staticMethod()都访问一个staticVar，调用这两个方法的不同线程 却可以并发操作
	 *        //如果一个方法中同时需要处理静态、非静态字段，怎么办？--超出范围...
	 *    
	 * 
	 */
	public static synchronized void staticMethod(){
		System.out.println("static同步方法");
	}
	
	public static void staticMethod2(){
		System.out.println("static非同步代码块");
		/*
		 * 或者用
		 * Class c = Class.forName("Ch9_3_Synchronized")
		 * synchronized (c) {}
		 */
		synchronized (Ch9_3_Synchronized.class) 
		{
			System.out.println("static同步代码块");
		}
	}
	
	
	/**
	 * 
	 * 4. 何时需要同步？
	 * 
	 * 为了使类是"线程安全"的，要求访问 可交换字段的方法 是同步的
	 * 
	 * ————所谓线程安全的类，是指其"每个"方法都是同步的
	 *     //注意，在aMethod()中连续调用线程安全类的两个方法，不能保证aMethod()是线程安全！
	 */
	

}

class Account
{
	private int balance = 50;
	public int getBalance(){
		return balance;
	}
	public void withdraw(int amount){
		balance = balance - amount;
	}
}
