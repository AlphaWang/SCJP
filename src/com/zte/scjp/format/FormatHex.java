/**
 * <p>�ļ�����: FormatHex.java </p>
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

public class FormatHex {
	public static void main(String[] args) 
	{
		int num = 656898;
		long longNum = 653857658;
		out.printf("%%x :%x\n", num);
		out.printf("%%#x :%#x\n", num);
		out.printf("%%o :%o\n", longNum);
		out.printf("%%#o :%#o\n", longNum);

	}

}
