/**
 * <p>�ļ�����: Ch6_4_DateNum.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-2-11</p>
 * <p>������ڣ�2011-2-11</p>
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
package ch06_api;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.lang.System.out;
public class Ch6_4_DateNum {

	public static void main(String[] args) {

		/**
		 * 1. Date��
		 *    Date�Ķ��������ѹ�ʱ����Ϊ���ܺܺ�Ӧ�Թ��ʻ������ػ�
		 *    
		 *    1) ����setTime()��getTime()
		 *    2) ������ʹ��DateFormat���ʽ��Calendar�������ʱ����
		 */
		out.println("\n==Date==");
		Date d1  = new Date(10000000000000000L);
		Date now = new Date();
		out.println("new Date()\t:"+now);
		now.setTime(now.getTime() + 3600000);//����3600000����
		out.println("setTime()֮��\t:"+now);
		
		
		/**
		 * 2. Calendar ������ <- GregorianCalendar
		 * 
		 */
		out.println("\n==Calendar==");
		Calendar cal = Calendar.getInstance();
		out.println("Calendar.getInstance()\t:"+cal);
		out.println("Calendar.getInstance().getTime()\t:"+cal.getTime());//cal.getTime()����Date
		
		cal.setTime(now);
		out.println("cal.setTime(Date)\t:"+cal.getTime());
		
		if(Calendar.SUNDAY == cal.getFirstDayOfWeek())
			out.println("���ڼ� �����տ�ʼ����");
		int week = cal.get(Calendar.DAY_OF_WEEK);
		out.println("cal.get(Calendar.DAY_OF_WEEK)\t:"+week);//�����տ�ʼ����
		
		cal.add(Calendar.MONTH, 13);
		out.println("cal.add(Calendar.MONTH, 13)\t:"+cal.getTime());
		//roll��add���ƣ����ǲ�������ݼ�Date����Ĳ���
		//������ֻ�����·ݣ���ݲ���Ӱ��
		cal.roll(Calendar.MONTH, 13);
		out.println("cal.roll(Calendar.MONTH, 13)\t:"+cal.getTime());
		
		
		/**
		 * 3. DateFormat ������ <- SimpleDateFormat
		 *    format()
		 *    parse() >����Date
		 *    
		 */
		//fomat()����
		out.println("\n==DateFormat==");
		DateFormat df1 = DateFormat.getInstance();
		String ds1 = df1.format(now);
		
		DateFormat df2 = DateFormat.getDateInstance();//Ĭ��ͬDateFormat.MEDIUM
		String ds2= df2.format(now);
		
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.SHORT);
		String ds3 = df3.format(now);
		
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String ds4 = df4.format(now);
		
		DateFormat df5 = DateFormat.getDateInstance(DateFormat.LONG);
		String ds5 = df5.format(now);
		
		DateFormat df6 = DateFormat.getDateInstance(DateFormat.FULL);
		String ds6 = df6.format(now);
		
		out.println("DateFormat.getInstance()\t:"+ ds1);
		out.println("DateFormat.getDateInstance()\t:"+ ds2);
		out.println("DateFormat.getInstance(DateFormat.SHORT)\t:"+ ds3);
		out.println("DateFormat.getInstance(DateFormat.MEDIUM)\t:"+ ds4);
		out.println("DateFormat.getInstance(DateFormat.LONG)\t:"+ ds5);
		out.println("DateFormat.getInstance(DateFormat.FULL)\t:"+ ds6);
			
		//parse()����
		try {
			//// String s = "2011��2��11�� ������";//java.text.ParseException:
			String s = "2012-12-20";
			Date d = df4.parse(s);//df4:DateFormat.MEDIUM
			out.println("df4.parse(\"2012-12-20\")\t:"+d);
			
		} catch (ParseException e) {e.printStackTrace();}
		
		
		/**
		 * 4. Locale��
		 *    Locale(String language)
		 *    Locale(String language, String country)
		 *    
		 *    ���ڣ�      DateFormat.getDateInstance(DateFormat.FULL, Locale );
		 *   		NumberFormat.getInstance(Locale);
		 *                Locale.getDisplayLanguage(Locale));
		 *    
		 */
		out.println("\n==Locale==");
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2012, 12, 20);
		//Date�����ã�����Calendar��DateFormat������
		Date date2 = cal2.getTime(); 
		
		Locale locIT = new Locale("it");
		Locale locIT2 = new Locale("it","ZH");//��ʿ �������
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locIT2);
		String ds = df.format(date2);
		out.println("DateFormat.getDateInstance(DateFormat.FULL,locIT)\t:"+ds);
		
		out.println("locIT2.getDisplayName()\t:"	+locIT2.getDisplayName());
		out.println("locIT2.getDisplayLanguage()\t:"+locIT2.getDisplayLanguage());
		out.println("locIT2.getDisplayLanguage(locIT2)\t:"+locIT2.getDisplayLanguage(locIT2));
		
		out.println("locIT2.getDisplayCountry()\t:"	+locIT2.getDisplayCountry());
		out.println("locIT2.getDisplayCountry(locIT2)\t:"	+locIT2.getDisplayCountry(locIT2));
		out.println("locIT2.getCountry()\t:"		+locIT2.getCountry());
		out.println("locIT2.getLanguage()\t:"		+locIT2.getLanguage());
		
		
		/**
		 * 5. NumberFormat������
		 *    format()
		 *    parse() >����Number
		 */
		out.println("\n==NumberFormat==");
		float f = 123.87654321F;
		NumberFormat nf1 = NumberFormat.getInstance();
		NumberFormat nf2 = NumberFormat.getInstance(locIT);
		NumberFormat nf3 = NumberFormat.getCurrencyInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(locIT);
		
		out.println("NumberFormat.getInstance()\t:"+nf1.format(f)); //Ĭ�������λС��
		out.println("NumberFormat.getInstance(locIT)\t:"+nf2.format(f));
		out.println("NumberFormat.getCurrencyInstance()\t:"+nf3.format(f));
		out.println("NumberFormat.getCurrencyInstance(locIT)\t:"+nf4.format(f));
		
		nf1.setMaximumFractionDigits(6);//�������С��λ
		//!!!! setMaximumFractionDigitsֻ�Ը�ʽ�������ã� ����ʱ ʹ��ԭʼС��λ��
		out.println("NumberFormat.getInstance()\t:"+nf1.format(f));
		
		//parse()
		try {
			out.println("nf1.parse()\t:"+nf1.parse("1234.12347F"));
			nf1.setParseIntegerOnly(true);
			out.println("nf1.setParseIntegerOnly(true)\t:"+nf1.parse("1234.12347F"));
			
		} catch (ParseException e) {e.printStackTrace();}
	}

}
