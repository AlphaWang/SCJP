/**
 * <p>文件名称: FormatDate.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-21</p>
 * <p>完成日期：2010-6-21</p>
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
		
		out.printf("%%tY(年，四位数) :%tY\n", date);
		out.printf("%%ty(年，两位数) :%ty\n", date);
		out.printf("%%TB(月，全称) :%TB\n", date);
		out.printf("%%Tb(月，简写) :%Tb\n", date);
		out.printf("%%Th(月，简写) :%Th\n", date);
		out.printf("%%tm(月，两位数) :%tm\n", date);
		out.printf("%%Te(日，无前置0) :%Te\n", date);
		out.printf("%%Td(日) :%Td\n", date);
		out.printf("%%TH(时，24) :%TH\n", date);
		out.printf("%%tI(时，12) :%tI\n", date);
		out.printf("%%tk(时，24) :%tk\n", date);
		out.printf("%%tM(分，两位数) :%tM\n", date);	
		out.printf("%%tS(秒，两位数) :%tS\n", date);
		
		out.printf("%%tA(星期，全称) :%tA\n", date);
		out.printf("%%ta(星期，简写) :%ta\n", date);
		
		out.printf("%%tp(上下午) :%tp\n", date);		
		out.printf("%%tR(时分，24) :%tR\n", date);
		out.printf("%%tT(时分秒，24) :%tT\n", date);
		out.printf("%%tr(时分秒上下午，12) :%tr\n", date);
		
		out.printf("%%TC(世纪) :%TC\n", date);
		out.printf("%%Tc(完整时间日期) :%Tc\n", date);
		out.printf("%%TD(短日期) :%TD\n", date);
		out.printf("%%TF(ISO8601日期) :%TF\n", date);
		
		//out.printf("%%tE(毫秒) :%tE\n", date);
		
		out.printf("%%tj(三位数的日期?) :%tj\n", date);
		out.printf("%%tL(三位数的毫秒?) :%tL\n", date);
		
		out.printf("%%tN(奈秒?) :%tN\n", date);
		out.printf("%%ts(秒数) :%ts\n", date);
		
		out.printf("%%tZ(时区，简写) :%tZ\n", date);
		out.printf("%%tz(与GMT的时差) :%tz\n", date);

	}

}
