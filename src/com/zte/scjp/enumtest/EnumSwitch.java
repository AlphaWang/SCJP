/**
 * <p>�ļ�����: EnumSwitch.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-18</p>
 * <p>������ڣ�2010-6-18</p>
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
package com.zte.scjp.enumtest;
import static java.lang.System.out;


public class EnumSwitch {
	public static void main(String [] args)
	{
		Student student1 = new Student("Alvin",20);
		Student student2 = new Student("Alpha",22);
		student1.assignGrade(Grade.A);
		student2.assignGrade(Grade.B);
		StringBuffer output = new StringBuffer();
		
		out.println(student2.getGrade());
		switch(student2.getGrade())
		{
			case A : output.append("GOOD");
					break;
			case B : output.append("FINE");
					break;
			case C : output.append("OK");
					break;
			case D : output.append("BAD");
					break;
			//case �����治�ܽ�������Grade.����
			//case Grade.INCOMPLETE : 
			default : output.append("NO PASS");
		}
		out.println(output);
		
	}
}
