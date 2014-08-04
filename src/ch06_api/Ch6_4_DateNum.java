/**
 * <p>文件名称: Ch6_4_DateNum.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-2-11</p>
 * <p>完成日期：2011-2-11</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
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
		 * 1. Date类
		 *    Date的多数方法已过时，因为不能很好应对国际化、本地化
		 *    
		 *    1) 可用setTime()、getTime()
		 *    2) 可用作使用DateFormat类格式化Calendar对象的临时桥梁
		 */
		out.println("\n==Date==");
		Date d1  = new Date(10000000000000000L);
		Date now = new Date();
		out.println("new Date()\t:"+now);
		now.setTime(now.getTime() + 3600000);//增加3600000毫秒
		out.println("setTime()之后\t:"+now);
		
		
		/**
		 * 2. Calendar 抽象类 <- GregorianCalendar
		 * 
		 */
		out.println("\n==Calendar==");
		Calendar cal = Calendar.getInstance();
		out.println("Calendar.getInstance()\t:"+cal);
		out.println("Calendar.getInstance().getTime()\t:"+cal.getTime());//cal.getTime()返回Date
		
		cal.setTime(now);
		out.println("cal.setTime(Date)\t:"+cal.getTime());
		
		if(Calendar.SUNDAY == cal.getFirstDayOfWeek())
			out.println("星期几 从周日开始计数");
		int week = cal.get(Calendar.DAY_OF_WEEK);
		out.println("cal.get(Calendar.DAY_OF_WEEK)\t:"+week);//以周日开始计数
		
		cal.add(Calendar.MONTH, 13);
		out.println("cal.add(Calendar.MONTH, 13)\t:"+cal.getTime());
		//roll与add类似，但是不会递增递减Date更大的部分
		//下例，只增加月份，年份不受影响
		cal.roll(Calendar.MONTH, 13);
		out.println("cal.roll(Calendar.MONTH, 13)\t:"+cal.getTime());
		
		
		/**
		 * 3. DateFormat 抽象类 <- SimpleDateFormat
		 *    format()
		 *    parse() >返回Date
		 *    
		 */
		//fomat()方法
		out.println("\n==DateFormat==");
		DateFormat df1 = DateFormat.getInstance();
		String ds1 = df1.format(now);
		
		DateFormat df2 = DateFormat.getDateInstance();//默认同DateFormat.MEDIUM
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
			
		//parse()方法
		try {
			//// String s = "2011年2月11日 星期五";//java.text.ParseException:
			String s = "2012-12-20";
			Date d = df4.parse(s);//df4:DateFormat.MEDIUM
			out.println("df4.parse(\"2012-12-20\")\t:"+d);
			
		} catch (ParseException e) {e.printStackTrace();}
		
		
		/**
		 * 4. Locale类
		 *    Locale(String language)
		 *    Locale(String language, String country)
		 *    
		 *    用于：      DateFormat.getDateInstance(DateFormat.FULL, Locale );
		 *   		NumberFormat.getInstance(Locale);
		 *                Locale.getDisplayLanguage(Locale));
		 *    
		 */
		out.println("\n==Locale==");
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2012, 12, 20);
		//Date的作用！连接Calendar与DateFormat的桥梁
		Date date2 = cal2.getTime(); 
		
		Locale locIT = new Locale("it");
		Locale locIT2 = new Locale("it","ZH");//瑞士 意大利语
		
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
		 * 5. NumberFormat抽象类
		 *    format()
		 *    parse() >返回Number
		 */
		out.println("\n==NumberFormat==");
		float f = 123.87654321F;
		NumberFormat nf1 = NumberFormat.getInstance();
		NumberFormat nf2 = NumberFormat.getInstance(locIT);
		NumberFormat nf3 = NumberFormat.getCurrencyInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(locIT);
		
		out.println("NumberFormat.getInstance()\t:"+nf1.format(f)); //默认最多三位小数
		out.println("NumberFormat.getInstance(locIT)\t:"+nf2.format(f));
		out.println("NumberFormat.getCurrencyInstance()\t:"+nf3.format(f));
		out.println("NumberFormat.getCurrencyInstance(locIT)\t:"+nf4.format(f));
		
		nf1.setMaximumFractionDigits(6);//设置最大小数位
		//!!!! setMaximumFractionDigits只对格式化起作用！ 解析时 使用原始小数位数
		out.println("NumberFormat.getInstance()\t:"+nf1.format(f));
		
		//parse()
		try {
			out.println("nf1.parse()\t:"+nf1.parse("1234.12347F"));
			nf1.setParseIntegerOnly(true);
			out.println("nf1.setParseIntegerOnly(true)\t:"+nf1.parse("1234.12347F"));
			
		} catch (ParseException e) {e.printStackTrace();}
	}

}
