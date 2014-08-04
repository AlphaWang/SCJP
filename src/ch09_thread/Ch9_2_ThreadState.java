/**
 * <p>�ļ�����: Ch9_2_ThreadState.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-22</p>
 * <p>������ڣ�2011-3-22</p>
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

public class Ch9_2_ThreadState
{
	/**
	 * 1. �߳�״̬�仯
	 *     start()                   yield()<
	 * [new] ---------> [runnable] <----------> [running] ------> [death]
	 *                   ��               | join()/wait()/sleep()/�ȴ�ͬ������
	 *                    |     ��
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
		 * Threadʵ������֮���̼߳�����new״̬����ʱ�̲߳��ǻ��
		 * 
		 */
			
		
		thread1.start();
		thread2.start();
		thread3.start();
		/**
		 * 2)runnable:
		 * ����start()֮���߳̽���runnable״̬�����
		 * 
		 * �������������ַ�ʽ����ʹ�߳̽���runnable״̬:start\�ȴ����ɹ�\sleep���\yield\join���
		 */
		
		
		/**
		 * 3)running:
		 * �̵߳������ӿ����г��� ѡ��һ���߳���Ϊ��ǰִ�е��̣߳����̼߳�����running״̬��
		 * 
		 * ��������ֻ��һ�ַ�ʽ����ʹ�߳̽���running״̬
		 */
		
		/**
		 * 4) wait:
		 * �̵߳����д��� �����̵߳ȴ�
		 * 
		 * 4) sleep:
		 * �̵߳����д��� ֪ͨ���߳�˯��һ��ʱ�䡪���������ͷ�����wait()�ͷ���
		 * Thread.sleep()���������̶߳��л������е���Ѱ취
		 * 
		 * 4) blocked:
		 * �̵߳ȴ�һ����Դ��IO����������ʱ�����ܱ�����
		 * 
		 */
		
		
		/**
		 * 3. Thread.yield()
		 * 
		 * �õ�ǰ�����е��̻߳ص�runnable״̬��(running -> runnable)
		 * ����ѡһ����ͬ���ȼ��������У���������ѡ��ԭ�����Ǹ��߳�
		 * 
		 * �þ�����ͬ���ȼ����߳�֮���ܷ��ʵ�����ת
		 */
		thread1.setPriority(Thread.MAX_PRIORITY);
		Thread.yield();
		
		/**
		 * 4. A.join() �Ǿ�̬
		 * 
		 * �õ�ǰ�߳�B���뵽��һ���߳�A��β��:�ȴ�A����
		 * ������A death֮�󣬵�ǰ�߳�B ����runnable
		 */
		try {
			thread1.join();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName());
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
			System.out.println("����MyRunnable.run()���߳���: " + Thread.currentThread().getName());
			try {
				/**
				 * 2. Thread.sleep()
				 * 
				 * Thread.sleep()���������̶߳��л������е���Ѱ취
				 * ���� �߳��ڽ���˯��֮ǰ�����ܿ϶�����ʵ�����ж೤ʱ��
				 * sleep���ں� �����runnable״̬�������ܱ�֤�����Ͼ��������У����Բ�������sleep����ȷ��ʱ��
				 *
				 * sleep()�Ǿ�̬������sleep()����"��ǰ���е��߳�"˯��
				 * ��Ҫ����Ϊһ���߳��ܹ�ʹ��һ���߳�˯��
				 *
				 */
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
