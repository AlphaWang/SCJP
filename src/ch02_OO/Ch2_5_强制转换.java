/**
 * <p>�ļ�����: Ch2_5_ǿ��ת��.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-10-21</p>
 * <p>������ڣ�2010-10-21</p>
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
package ch02_OO;

public class Ch2_5_ǿ��ת�� {

	public static void main(String[] args)
	{
		Parent2 p = new Child2();
		/**
		 * 1. �������ã������Ҫ��������ķ�������������ǿ��ת��
		 *    ǿ��ת��֮ǰ��Ҫ����instanceof��飡��������ClassCastException
		 */
		  //// p.methodC();
		  if(p instanceof Child2){
			  //// p.methodC();
			  ((Child2) p).methodC(); //���෽��
		  }
		  /**
		   * 1. ����ʱ�쳣java.lang.ClassCastException: 
		   *             ch02_OO.Parent2 cannot be cast to ch02_OO.Child2
		   */
		  //// Child2 child = (Child2)new Parent2();
		  
		  /**
		   * 2. ����ת��������ǿ�ƽ���
		   */
		  Child2 c = new Child2();
		  Parent2 p2 = c;
		  Parent2 p3 = (Parent2)c;
		  
		  p2.methodP(); //������д���෽��
		  p3.methodP(); //������д���෽��
		  
		  
	}
	
}

class Parent2
{
	void methodP(){
		System.out.println("���෽��");
	}
}
class Child2 extends Parent2
{
	void methodP(){
		System.out.println("������д���෽��");
	}
	void methodC(){
		System.out.println("���෽��");
	}
}


