/**
 * <p>�ļ�����: Ch9_4_ThreadInteractive.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-24</p>
 * <p>������ڣ�2011-3-24</p>
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

/**
 * 0. �̼߳�Ľ�����ʹ��wait() / notify() / notifyAll()
 * 
 *    ��������ÿ������o��һ������ͬʱ����һ���߳��б����ǵȴ����Զ���o���ź�
 *        �̵߳��ö���o.wait()֮�󣬾ͽ���ȴ��б�Ȼ���̲߳���ִ���κ�����ָ�
 *        ֱ�������˶���o.notify()��ѡ��һ�� �ȴ��б��е��߳� ��ʼִ��
 *        
 *        ���ߵ����˶���o.notifyAll(),���еȴ��̵߳õ�֪ͨ ��ʼ������

 * 
 *   ���������� ������"ͬ������"�ڵ��ã�
 *   ��������Ϊ�˵���wait()/notify()���̱߳���ӵ���Ǹ����������
 *       �����׳�IllegalMonitorStateException
 *
 */



/**
 * 7. Thread��ط�����
 * 
 * wait()	���Ǿ�̬	��InterruptedException
 * notify()	���Ǿ�̬	�����쳣
 * notifyAll()��ͬ��~
 * 
 * join()	���Ǿ�̬	��InterruptedException
 * sleep()	����̬	��InterruptedException
 * yield()	����̬	�����쳣
 */
public class Ch9_4_ThreadInteractive {
	public static void main(String[] args)
	{
		ThreadB b = new ThreadB();
		b.setName("thread-B");
		b.start();
		/**
		 * 1.�����wait(), ������b�߳�ִ��һ��ʱ��ӡtotal
		 */
		System.out.println(Thread.currentThread().getName()+" �ܺͣ�" + b.total);
		
		/**
		 * 2.��Ҳ������b.join()����b�߳�ִ�����, ��ӡtotal		 * 
		 * ���������������صȴ�b��ȫ����
		 */
		
//		try {
//			b.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName()+" join()֮���ܺͣ�" + b.total);
		
		
		/**
		 * 3.��b.wait(), �ͷ������������ط�ִ����b.notify()�󣬴�ӡtotal
		 * 
		 * ��������!!!!!!һ����whileѭ�� ��Χ��wait()
		 *     ����waitʱ���Ѿ�notify���ˣ�����һֱ�ȴ�
		 * 
		 */
		//��������wait()����λ��ͬ��������
		//���ִ��b.wait()���߳� ��ӵ��b���������׳�IllegalMonitorStateException
		synchronized (b) {
			try {
				System.out.println(Thread.currentThread().getName()+" waiting for b to complete...");
				//****����wait()֮�󣬵�ǰ�̻߳������ͷ�������������������sleep()���ͷ���
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" wait()֮���ܺͣ�" + b.total);
		}
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("==����notifyAll()==");
		
		/**
		 * 
		 * 5.����notifyAll()
		 * 
		 */
		Calculator cal = new Calculator();
		//�����߳� �ȴ�������
		Reader t1 = new Reader(cal);
		Reader t2 = new Reader(cal);
		Reader t3 = new Reader(cal);
		t1.start();
		t2.start();
		t3.start();
		
		//�������߳�
		cal.start();
		
		/**
		 * 
		 * 6. �������wait()ʱ��notify()�Ѿ����й��ˣ���ô�죿
		 * 
		 * ����������      while   ѭ����ʹ��wait(), ��ѭ�����ĳ���������ʽ��ֻ�е����ڵȴ������黹δ����ʱ ��wait()
		 *     �������δ���
		 * ��������˫�ؼ��    
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
			System.out.println(this.getName()+" ʵ���ܺͣ�" + total);
			/**
			 * 4. notify()	��֪ͨ��ǰ��this�����ϵȴ����߳�
			 */
			//******����notify()֮�󣬵�ǰ�̲߳���һ�������ͷ�������Ҫ�ȵ�ͬ����������
			notify();
			
			//this.notify();
			
		}
		//notify()����λ��ͬ�������ڣ�
		//���ִ��notify()���߳� ��ӵ��b���������׳�IllegalMonitorStateException
		
		//// notify();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName()+" ��������..." );
		
	 }
}
/**
 * 
 * 5.����notifyAll()
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
			System.out.println(this.getName()+" wait()֮��Total = "+c.total);
			
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
			System.out.println(this.getName()+" ʵ��Total��" + total);
			/**
			 *5. notifyAll()	��֪ͨ��ǰ��this�����ϵȴ����߳�
			 * 
			 * ���еȴ��߳̽���runnable״̬��������
			 */
			
			notifyAll();
			/*
			Thread-2 Waiting for calculation...
			Thread-3 Waiting for calculation...
			Thread-4 Waiting for calculation...
			Thread-1 ʵ��Total��4950
			Thread-4 wait()֮��Total = 4950
			Thread-3 wait()֮��Total = 4950
			Thread-2 wait()֮��Total = 4950
			*/
			
			
			/**
			 * ʹ��notify()�����к�����
			 * ĳһ���ȴ��߳̽���runnable״̬��
			        �����߳�wait??������
			 */
			
			notify();
			/*
			Thread-2 Waiting for calculation...
			Thread-3 Waiting for calculation...
			Thread-1 ʵ��Total��4950
			Thread-2 wait()֮��Total = 4950
			Thread-3 wait()֮��Total = 4950
			Thread-4 Waiting for calculation...
			*/
			
		}
	 }
}