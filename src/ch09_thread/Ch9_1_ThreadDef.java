/**
 * <p>�ļ�����: Ch9_1_Def.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-21</p>
 * <p>������ڣ�2011-3-21</p>
 * <p>�޸ļ�¼1: // �޸���ʷ��¼�������޸����ڡ��޸��߼��޸�����</p>
 * <pre>
 *    �޸����ڣ�
 *    �� �� �ţ�
 *    �� �� �ˣ�
 *    �޸����ݣ�
 * </pre>
 * <p>�޸ļ�¼2����</p>
 * @version 1.0
 * @author WangZhongXing192063
 */
package ch09_thread;

public class Ch9_1_ThreadDef {

	public static void main(String[] args)
	{
		/**
		 * 0. ÿ������ջ����һ���߳�
		 *    ÿ���̶߳���һ������ջ
		 *    
		 *    main()������������ջ��ջ�׷���
		 *    ����һ�����̺߳����̵߳��õķ�����������һ���µ���ջ��
		 */
		
		/**
		 * 2. ʵ�����������߳�
		 * 
		 * 	  ����һ��ʵ����Thread����
		 */
		MyThread myThread = new MyThread();
		myThread.start(); //����myThread��run����
		System.out.println("myThread.getName():" + myThread.getName());
		/*
		 * ����ֱ�ӵ���Thread.run()�������Ͳ����������߳���
		 */
		myThread.run();
		
		
		/**
		 * 2. ʵ�����������߳�
		 * 
		 * 	  ��������ʵ����Runnableʵ����
		 * 
		 * Thread 	������
		 * Runnable	������
		 * 
		 *  ����start()֮���������飺
		 *  a)�����µ�ִ���̣߳������µĵ���ջ��
		 *  b)�̴߳�new״̬ ת�� runnable״̬
		 *  c)���̻߳��ִ�л��ᣬִ������run()����
		 */
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		t1.start();//����myRunnable��run������������t1�ģ�
		//!!�����ϣ����ܱ�֤myThread.run()��myRunnable.run()�ĸ���ִ��
		
		
		System.out.println("t1.getName():" + t1.getName());
		
		
		Thread t2 = new Thread(myRunnable);//�����ö�����������ͬ������		
		Thread t3 = new Thread(myThread);//ThreadҲʵ����Runnable�����Կ��Դ��ݽ�Thread���췽��������û������
		
		System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
		
		/**
		 * 3. ͬʱ��������߳�
		 * 
		 * ÿ���߳��ڵĲ���˳�����Ԥ��
		 * ����ͬ�̵߳Ĳ����ǻ�����һ���
		 * 
		 * ��ĳ��˳��������һϵ���̣߳�������ζ�����ǰ���ͬ��˳��ִ��
		 * 
		 * ��һ�������̵߳ķ�����ָ����������ĳ���߳̽���ǰ ��Ҫ���С� join():�ȴ�ĳ���߳̽�����������
		 */
		
		
		/**
		 * 4. �߳�ִ�н����󣨼�run()�������ˣ�
		 * 
		 * �߳�ջ���ɢ����Ϊ���߳�
		 * ��Ȼ���Ե���Thread�����ϵķ������������ٴ������߳�start()
		 * 
		 */
		//����ʱ�쳣��java.lang.IllegalThreadStateException
		//t1.start();
		

		

	}

}
/**
 * 1. �����߳�
 * 
 *  ����һ����չThread��
 *  ���ޣ��Ͳ�����չ��������
 *
 */
class MyThread extends Thread
{
	@Override
	public void run() {
		System.out.println("����MyThread.run()���߳���:" + this.getName());
	}
}
/**
 * 1. �����߳�
 * 
 *  ��������ʵ��Runnable�ӿ�
 *
 */
class MyRunnable implements Runnable
{
	String test = "";

	@Override
	public void run() {
		synchronized (test) {
			
		}
		System.out.println("����MyRunnable.run()���߳���:" + Thread.currentThread().getName());
		
	}
	
}
