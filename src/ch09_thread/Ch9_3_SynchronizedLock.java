/**
 * <p>�ļ�����: Ch9_3_SynchronizedLock.java </p>
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

public class Ch9_3_SynchronizedLock {
	
	public static void main(String[] args) {
		DealResource r = new DealResource();
		Thread thread1= new Thread(r,"thread1");
		Thread thread2= new Thread(r,"thread2");
		/**
		 *  �������̱߳��������˴˶��ڵȴ��Է�����ʱ���ͻᷢ������
		 *  
		 *  �������֮һ���涨ʼ�հ���Ԥ�����˳���ȡ��
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
		 * 1.thread1�ڴ˴���ȡresourceA����
		 */
		synchronized (resourceA) { //�����������
			/*
			 * 2.thread1�ڴ˴��ȴ�resourceB����
			 */
			synchronized (resourceB) {
				return resourceB.value + resourceA.value;
			}
		}
	}
	public int write(int a, int b){
		/*
		 * 1.thread2�ڴ˴���ȡresourceB����
		 */
		synchronized (resourceB) { //�����������
			/*
			 * 2. thread2�ڴ˴��ȴ�resourceA����
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
