/**
 * <p>文件名称: EnumSwitch.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-18</p>
 * <p>完成日期：2010-6-18</p>
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
			//case 语句后面不能接完整的Grade.＊＊
			//case Grade.INCOMPLETE : 
			default : output.append("NO PASS");
		}
		out.println(output);
		
	}
}
