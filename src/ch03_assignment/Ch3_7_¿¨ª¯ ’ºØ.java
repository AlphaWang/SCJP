/**
 * <p>�ļ�����: Ch_3_7_�����ռ�.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-4</p>
 * <p>������ڣ�2011-1-4</p>
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
package ch03_assignment;

import static java.lang.System.out;
import java.util.Date;


public class Ch3_7_�����ռ� {

	public static void main(String[] args) 
	{
		/**
		 * 0. ����JVM���������ռ�
		 */
		Runtime rt = Runtime.getRuntime();
		out.println("���ڴ棺"+rt.totalMemory());
		out.println("���ڴ棺"+rt.freeMemory());
		Date d  = null;
		for (int i = 0;i<1000; i++){
			d = new Date();
			d = null;
		}
		out.println("�������к����ڴ棺"+rt.freeMemory());
		rt.gc();
		out.println("gc()�����ڴ棺"+rt.freeMemory());
		
		
		/**
		 * 1. �����ں�ʱ��ʼ���������ռ�������
		 * 
		 * ÿ���߳������Լ���Сִ��ջ��ÿ���߳������Լ�����������
		 * ��û���߳��ܹ����ʶ���ʱ���ö��󼴷��������ռ�����
		 * 
		 * �������������������һ��"���ñ���"���ö��󣬲��Ҹ�"���ñ���" ������һ�����̣߳���ö����ǿɵ����
		 * �������������ռ�ֻ��Է�String����
		 */
		//����ʹ������������ռ�������
		/**
		 * 1) ������
		 */
		Date d1 = new Date();
		out.println(d1);
		d1 = null; //��ʱ���������ռ�����
		
		/**
		 * 2) Ϊ���ñ������¸�ֵ
		 */
		Date d2 = new Date();
		Date d3 = new Date();
		d2 = d3; //��ʱԭ��d2���õ��϶������������ռ�����
		
		/**
		 * 3) ��������
		 */
		Island i1 = new Island();
		Island i2 = new Island();
		i1.i = i2;
		i2.i = i1;
		i1 = null;
		i2 = null;
		//��ʱ��i1��i2��������Ч���ã������Ǳ��������õ�
		//���������ռ�����
		
	}
	/**
	 * 4) �����ڴ����Ķ���
	 * �����������⣺�������صĶ���
	 */
	public Date getDate(){
		StringBuffer sb = new StringBuffer("�ֲ�����");
		Date d = new Date();		
		return d;
		//����������sb���������ռ�����
		//           ��d�����㣡
	}
}
class Island{
	public Island i;

	/**
	 * 2. ������������֮ǰ��������finalize()������
	 * ���ǲ��ܱ�֤�������Ǳ����գ���finalize()�������ܱ�֤���Ǳ�ִ��
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
}
