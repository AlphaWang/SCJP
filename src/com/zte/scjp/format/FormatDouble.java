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

public class FormatDouble {
	public static void main(String[] args)
	{
		double posNum = 356879.443;
		double negNum = -635632.656;
		//格式： %[argument][flags][width][.precision] type
		out.println("posNum:"+posNum);
		out.println("negNum:"+negNum);
		out.printf("%%f :%f\n", negNum);
		out.printf("%%.2f :%.2f\n", negNum);
		out.printf("%%#.2f :%#.2f\n", posNum);
		out.printf("%%12.2f :%12.2f\n", negNum);
		out.println("千位逗号分隔、负数括号：");
		out.printf("%%,12.2f :%,12.2f\n", negNum);
		out.printf("%%(,12.2f :%(,12.2f\n", negNum);
		out.println("非负值空格补齐：");
		out.printf("%% .2f :% .2f\n", posNum);
		out.printf("%% .2f :% .2f\n", negNum);
		out.println("向左对齐：");
		out.printf("%%-12.2f :%-12.2f\n", negNum);
		out.printf("%%-12.2f :%-12.2f\n", posNum);
		out.println("显示正负号：");
		out.printf("%%+.2f :%+.2f\n", negNum);
		out.printf("%%+.2f :%+.2f\n", posNum);
		out.println("指数表示：");
		out.printf("%%e :%e\n", negNum);
		out.printf("%%e :%e%n", posNum);
		out.println("使用前一个参数：");
		out.printf("posNum: %f, also: %<,f\n", posNum, negNum);
		out.println("值的hashcode(HEX)：");
		out.printf("%%h :%h\n", posNum);
	}

}
