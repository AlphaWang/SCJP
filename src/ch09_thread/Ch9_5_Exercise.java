/**
 * <p>�ļ�����: Ch9_5_Exercise.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-25</p>
 * <p>������ڣ�2011-3-25</p>
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
 * ��15��
 * @author WangZhongXing192063
 *
 */
class Dudes{
	
	static long flag = 0;
	/**
	 * ���ܣ���һ�ε��ã���ӡyo�������ӡdude
	 * @param id
	 */
	//synchronized void chat(long id){	
	void chat(long id){
		if(flag == 0) flag = id;
		for(int x = 1; x < 3; x++){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (flag == id)
				System.out.println(id + "-yo ");
			else
				System.out.println(id + "-dude");
		}
	}
	
}
public class Ch9_5_Exercise implements Runnable{

	static Dudes d;
	public static void main(String[] args) {
		new Ch9_5_Exercise().go();

	}
	void go(){
		d = new Dudes();
		new Thread(new Ch9_5_Exercise()).start();
		new Thread(new Ch9_5_Exercise()).start();
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		d.chat(Thread.currentThread().getId());
		
	}

}
