/**
 * <p>�ļ�����: FormatDate.java </p>
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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormatDate {
	public static void main(String[] args) 
	{
		Date date = new Date();
		GregorianCalendar calender = new GregorianCalendar();
		out.println("date:"+date);
		out.println("calender:"+calender);
		
		out.printf("%%tY(�꣬��λ��) :%tY\n", date);
		out.printf("%%ty(�꣬��λ��) :%ty\n", date);
		out.printf("%%TB(�£�ȫ��) :%TB\n", date);
		out.printf("%%Tb(�£���д) :%Tb\n", date);
		out.printf("%%Th(�£���д) :%Th\n", date);
		out.printf("%%tm(�£���λ��) :%tm\n", date);
		out.printf("%%Te(�գ���ǰ��0) :%Te\n", date);
		out.printf("%%Td(��) :%Td\n", date);
		out.printf("%%TH(ʱ��24) :%TH\n", date);
		out.printf("%%tI(ʱ��12) :%tI\n", date);
		out.printf("%%tk(ʱ��24) :%tk\n", date);
		out.printf("%%tM(�֣���λ��) :%tM\n", date);	
		out.printf("%%tS(�룬��λ��) :%tS\n", date);
		
		out.printf("%%tA(���ڣ�ȫ��) :%tA\n", date);
		out.printf("%%ta(���ڣ���д) :%ta\n", date);
		
		out.printf("%%tp(������) :%tp\n", date);		
		out.printf("%%tR(ʱ�֣�24) :%tR\n", date);
		out.printf("%%tT(ʱ���룬24) :%tT\n", date);
		out.printf("%%tr(ʱ���������磬12) :%tr\n", date);
		
		out.printf("%%TC(����) :%TC\n", date);
		out.printf("%%Tc(����ʱ������) :%Tc\n", date);
		out.printf("%%TD(������) :%TD\n", date);
		out.printf("%%TF(ISO8601����) :%TF\n", date);
		
		//out.printf("%%tE(����) :%tE\n", date);
		
		out.printf("%%tj(��λ��������?) :%tj\n", date);
		out.printf("%%tL(��λ���ĺ���?) :%tL\n", date);
		
		out.printf("%%tN(����?) :%tN\n", date);
		out.printf("%%ts(����) :%ts\n", date);
		
		out.printf("%%tZ(ʱ������д) :%tZ\n", date);
		out.printf("%%tz(��GMT��ʱ��) :%tz\n", date);

	}

}
