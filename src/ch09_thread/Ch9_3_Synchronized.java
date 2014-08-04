/**
 * <p>�ļ�����: Ch9_3_Synchronized.java </p>
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

public class Ch9_3_Synchronized implements Runnable
{
	/**
	 * 0.������Դ�����߳�ȡ���α�֤�˻���͸֧��
	 * 
	 * ������������ѯ��ȡ�� ��Ϊһ��"ԭ�Ӳ���"��
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
			//Ҫ��֤�˻���͸֧
			if(acct.getBalance() < 0){
				System.out.println(Thread.currentThread().getName()+"�˻���͸֧��ERROR��");
			}
		}

	}
	/**
	 * 1. ͬ������
	 * 
	 * ȡ�������
	 * ����㹻����ȡ�
	 * ���㣬��ȡ��
	 * 
	 * -->����ѯ��ȡ����Ϊһ��ԭ�Ӳ������ɱ�֤��͸֧��
	 * 
	 * ÿ��ֻ��һ���߳̿���ִ�� �ö����  ����  ͬ��������
	 * ����������Ϊÿ��������һ�������߳̽���ͬ������ ����øö��������
	 *     �����߳��޷��õ��ö��������Ҳ���޷�ִ�иö����"����"ͬ������
	 * 
	 */
	
	//public void makeWithdrawal(int amount)
	public synchronized void makeWithdrawal(int amount)
	{
		if(acct.getBalance() >= amount){
			System.out.println(Thread.currentThread().getName()+"��ѯ���: "+acct.getBalance()+"(-"+amount+")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			acct.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+"ȡ��ɹ���= "+acct.getBalance());
			
		}else{
			System.out.println(Thread.currentThread().getName()+"��ѯ���: ���㣡(��ȡ��)");
		}
	}
	
	/**
	 * 2. ͬ�������
	 * 
	 * �����ð���ͬ�������� ��ͬ�������������ͬ������
	 * ��������ͬ�����𺦲����ԣ�ͬ���������Լ���ͬ������
	 * 
	 */
	public void withdraw2()
	{
		System.out.println("��ͬ������鲿��");
		/*
		 * ͬ������� ��Ҫָ��ϣ��ʹ���ĸ��������
		 * ���������ڲ�ͬ������ͬ�����̣߳�������˴�����
		 */
		synchronized (this) {
			System.out.println("ͬ������鲿��");
		}
	}
	/**
	 * 3. ��̬����Ҳ����ͬ��	
	 *    ��̬������ Ҳ������ͬ�������
	 *    �������������̲߳��ܵ��ø�"��"������ͬ��������������
	 *        //����̬ͬ���������Ǿ�̬ͬ������ ��Զ����˴�������
	 *        
	 *        
	 *    ����������̬����Ӧ��ֻ���ʾ�̬�ֶΣ��Ǿ�̬���� Ӧ��ֻ���ʷǾ�̬�ֶΡ�����ͬ��ʱ��ܸ���	       
	 *        ���磬nonStaticMethod() staticMethod()������һ��staticVar�����������������Ĳ�ͬ�߳� ȴ���Բ�������
	 *        //���һ��������ͬʱ��Ҫ����̬���Ǿ�̬�ֶΣ���ô�죿--������Χ...
	 *    
	 * 
	 */
	public static synchronized void staticMethod(){
		System.out.println("staticͬ������");
	}
	
	public static void staticMethod2(){
		System.out.println("static��ͬ�������");
		/*
		 * ������
		 * Class c = Class.forName("Ch9_3_Synchronized")
		 * synchronized (c) {}
		 */
		synchronized (Ch9_3_Synchronized.class) 
		{
			System.out.println("staticͬ�������");
		}
	}
	
	
	/**
	 * 
	 * 4. ��ʱ��Ҫͬ����
	 * 
	 * Ϊ��ʹ����"�̰߳�ȫ"�ģ�Ҫ����� �ɽ����ֶεķ��� ��ͬ����
	 * 
	 * ����������ν�̰߳�ȫ���࣬��ָ��"ÿ��"��������ͬ����
	 *     //ע�⣬��aMethod()�����������̰߳�ȫ����������������ܱ�֤aMethod()���̰߳�ȫ��
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
