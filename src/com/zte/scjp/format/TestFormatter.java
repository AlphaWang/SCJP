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

import java.util.Formatter;

public class TestFormatter {
	public static void main(String[] args)
	{
		double posNum = 356879.443;
		double negNum = -635632.656;
		//��ʽ�� %[argument][flags][width][.precision] type
		
		/*
		 * ����һ��Formatter(StringBuilder)
		 */
		StringBuilder sb = new StringBuilder();
		StringBuffer sb2 = new StringBuffer();
		Formatter formatter = new Formatter(sb);
		Formatter formatter2 = new Formatter(sb2);
		formatter.format("Formatter(StringBuilder)��%%.2f :%.2f", negNum);
		formatter2.format("Formatter(StringBuffer)��%%.2f :%.2f", posNum);
		System.out.println(sb);
		System.out.println(sb2);
		
		/*
		 * ��������String.format()
		 */
		String s = String.format("String.format():%%.2f :%.2f", negNum);
		System.out.println(s);
		/*
		 * ��������System.out.format()
		 */
		System.out.format("System.out.formate()��%%.2f :%.2f", posNum);
		System.out.println();
		/*
		 * �����ģ�System.out.printf()
		 */
		System.out.printf("System.out.printf()��%%.2f :%.2f", posNum);
		System.out.println();
		
	}

}
