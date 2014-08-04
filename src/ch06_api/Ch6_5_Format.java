/**
 * <p>文件名称: Ch6_5_Format.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-2-15</p>
 * <p>完成日期：2011-2-15</p>
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

import java.util.Formatter;

class Animal3{
	private String name;
	private Formatter f;
	int weight;
	public Animal3(String name, Formatter f){
		this.name = name;
		this.f = f;
	}
	public Animal3(){	}
	public void move(int x, int y){
		/**
		 * format()和printf()是等价的
		 */
		f.format("%s is at ( %d, %d). \n", name, x, y);
	}
}


public class Ch6_5_Format {

	public static void main(String[] args) {
		/**
		 * printf(	Locale l,
  					String format,
  					Object... args)
		 * 
		 * 参数format包含格式化数据，格式化数据总是以%开头:
		 * 
		 * 
		 * 	%[arg_index$] [flags] [width] [.precision] conversion_char
		 * 
		 *  [arg_index$]: 整数$,指定输出哪个变元
		 *  [flags]		: - 左对齐
		 *  			  + 包含正负号
		 *  			  0 用0填充变元
		 *  			  , 千位分隔
		 *  			  ( 将负数包含在括号内       //这样就不显示正负号了
		 *  [width]		: 要输出的最少字符数
		 *  [precision] : 精度，浮点数时需要
		 *  conversion_char: 如果转换字符 与 实际变元 类型不匹配，
		 *                   则会得到运行时异常：java.util.IllegalFormatConversionException:
		 */
		System.out.printf("%2$+(d & %1$+,d \n", 1234, -456);   //(456) & +1,234 
		//java.util.IllegalFormatConversionException:
		//// System.out.printf("%d", 12.33);
		
	    
		System.out.printf("%2$+0(20.1f & %1$+,d \n", 1234, -456.21);    //(0000000000000456.2) & +1,234 
		//java.util.IllegalFormatPrecisionException: 1
		//// System.out.printf("%2$+0(20.1d & %1$+,d \n", 1234, -456.21);
		
		/**
		 * String.format()
		 * 内部调用return new Formatter().format(format, args).toString();
		 */
		System.out.println(String.format("%2$+0(20.1f & %1$+,d \n", 1234, -456.21));    //(0000000000000456.2) & +1,234 
		
		Animal3 a = new Animal3("Tommy", new Formatter(System.out));
		Animal3 b = new Animal3("Jerry", new Formatter(System.err));
		
		a.move(1, 4); //Tommy is at ( 1, 4).
		b.move(5, 6);
		
		
		

	}

}
