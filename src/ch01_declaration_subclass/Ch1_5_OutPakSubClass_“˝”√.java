/**
 * <p>�ļ�����: Ch1_5_SubClass_����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-15</p>
 * <p>������ڣ�2010-9-15</p>
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
package ch01_declaration_subclass;


public class Ch1_5_OutPackSubClass_Ref {
	
	public  static void main(String[] args)
	{
		//TODO test
		Ch1_5_OutPakSubClass subclass = new Ch1_5_OutPakSubClass();
		
		/**
		 * 1. ����е����࣬ ���Լ̳�protected��Ա��	
		 *    �������еĸ�protected��Ա ���ɱ���������ʣ�
		 *    
		 *    is not visible
		 */
		int i = subclass.protectedVar;
		subclass.protectedMethod();
		
	}

}
