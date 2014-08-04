/**
 * <p>�ļ�����: TestPrintf.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-21</p>
 * <p>������ڣ�2010-6-21</p>
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
package com.zte.scjp.format;
import static java.lang.System.out;

public class FormatDouble {
	public static void main(String[] args)
	{
		double posNum = 356879.443;
		double negNum = -635632.656;
		//��ʽ�� %[argument][flags][width][.precision] type
		out.println("posNum:"+posNum);
		out.println("negNum:"+negNum);
		out.printf("%%f :%f\n", negNum);
		out.printf("%%.2f :%.2f\n", negNum);
		out.printf("%%#.2f :%#.2f\n", posNum);
		out.printf("%%12.2f :%12.2f\n", negNum);
		out.println("ǧλ���ŷָ����������ţ�");
		out.printf("%%,12.2f :%,12.2f\n", negNum);
		out.printf("%%(,12.2f :%(,12.2f\n", negNum);
		out.println("�Ǹ�ֵ�ո��룺");
		out.printf("%% .2f :% .2f\n", posNum);
		out.printf("%% .2f :% .2f\n", negNum);
		out.println("������룺");
		out.printf("%%-12.2f :%-12.2f\n", negNum);
		out.printf("%%-12.2f :%-12.2f\n", posNum);
		out.println("��ʾ�����ţ�");
		out.printf("%%+.2f :%+.2f\n", negNum);
		out.printf("%%+.2f :%+.2f\n", posNum);
		out.println("ָ����ʾ��");
		out.printf("%%e :%e\n", negNum);
		out.printf("%%e :%e%n", posNum);
		out.println("ʹ��ǰһ��������");
		out.printf("posNum: %f, also: %<,f\n", posNum, negNum);
		out.println("ֵ��hashcode(HEX)��");
		out.printf("%%h :%h\n", posNum);
	}

}
