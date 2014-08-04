/**
 * <p>文件名称: Ch3_5_装箱.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-12-29</p>
 * <p>完成日期：2010-12-29</p>
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
package ch03_assignment;
import static java.lang.System.out;
public class Ch3_5_装箱 
{
	public static void main(String[] args)
	{
		/**
		 * 1. 创建包装器对象
		 *    1)包装器构造函数: 接受基本类型、String类型的参数————但Character除外，它只接受字符参数
		 *    2)valueOf()方法: 两种，可带基数
		 */
		Float f1 = new Float(21.5F);
		Float f2 = new Float("21.5F");		
		Character c1 = new Character('c');
		//// Character c2 = new Character("c");
		out.println("new Float(21.5F)\t："+f1);
		
		Integer i1 = Integer.valueOf("12B", 16);
		Integer i2 = Integer.valueOf("12");
		out.println("Integer.valueOf(\"12B\", 16)\t："+i1);
		out.println("Integer.valueOf(\"12)\t："+i2);
		
		/**
		 * 2. 转换
		 * 		1）Wrapper.xxxValue()：包装器 => 基本类型
		 * 		2）Wrapper.parseXxx(String)：String => 基本类型
		 * 		3）Wrapper.valueOf(String) ：String => 包装器
		 */
		//1）包装器 => 基本类型：：：Wrapper.xxxValue()：
		byte b = i1.byteValue();	out.println(b);//会做截取
		short s = i1.shortValue();	out.println(s);
		double d = i1.doubleValue();out.println(d);
		long l = i1.longValue();	out.println(l);
		int i = i1.intValue();		out.println(i);
		int j = i1;					out.println(j);
		
		//2）String => 基本类型：：：Wrapper.parseXxx(String)：
		//////！注意parseXxx返回的是 基本类型！
		int int1 = Integer.parseInt("123");
		int int2 = Integer.parseInt("123", 16);
		
		//3）String => 包装器：：：Wrapper.valueOf(String) ：
		///////！注意valueOf返回的是包装器类！
		Integer i3 = Integer.valueOf("12B", 16);
		
		//4）转换为String
		out.println("Integer.toString()\t:"+i1.toString());   //此处toString：非静态方法，继承自Object
		out.println("Integer.toString( , 16)\t:"+Integer.toString(i1, 16));//此处toString:静态方法
		out.println("Integer.toHexString( )\t:"+Integer.toHexString(i1));
		
		/**
		 * 3. 自动装箱
		 * 
		 */
		Integer i4 = new Integer(57);
		Integer i5 = i4;
		out.println("i4 == i5\t:"+(i4 == i5));
		//此处，实际上创建了另一个包装器对象。————包装器对象的状态是不可变的！！！！
		i4 ++;  
		out.println("i4 == i5\t:"+(i4 == i5));
		
		out.println("i4 ++\t: "+i4);
		
		/**
		 * 4. ==
		 * 
		 * 以下包装器，只要基本值相同，即==：
		 * 	Boolean
		 * 	Byte
		 * 	\u0000~\u007f的字符
		 *  -128~127的Short和Integer
		 */
		Integer i6 = 1000;
		Integer i7 = 1000;
		out.println("i6 == i7\t:"+(i6 == i7));	//不==
	
		
		Integer i8 = 127;
		Integer i9 = 127;
		out.println("i8 == i9\t:"+(i8 == i9));
		//-128~127的Short和Integer，只要基本值相同，即==。
		
		
	}

}
