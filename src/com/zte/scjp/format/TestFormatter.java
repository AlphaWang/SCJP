/**
 * <p>文件名称: TestPrintf.java </p>
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

import java.util.Formatter;

public class TestFormatter {
	public static void main(String[] args)
	{
		double posNum = 356879.443;
		double negNum = -635632.656;
		//格式： %[argument][flags][width][.precision] type
		
		/*
		 * 方法一：Formatter(StringBuilder)
		 */
		StringBuilder sb = new StringBuilder();
		StringBuffer sb2 = new StringBuffer();
		Formatter formatter = new Formatter(sb);
		Formatter formatter2 = new Formatter(sb2);
		formatter.format("Formatter(StringBuilder)：%%.2f :%.2f", negNum);
		formatter2.format("Formatter(StringBuffer)：%%.2f :%.2f", posNum);
		System.out.println(sb);
		System.out.println(sb2);
		
		/*
		 * 方法二：String.format()
		 */
		String s = String.format("String.format():%%.2f :%.2f", negNum);
		System.out.println(s);
		/*
		 * 方法三：System.out.format()
		 */
		System.out.format("System.out.formate()：%%.2f :%.2f", posNum);
		System.out.println();
		/*
		 * 方法四：System.out.printf()
		 */
		System.out.printf("System.out.printf()：%%.2f :%.2f", posNum);
		System.out.println();
		
	}

}
