/**
 * <p>文件名称: Ch3_2_字面值.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-11-22</p>
 * <p>完成日期：2010-11-22</p>
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

public class Ch3_2_Literal 
{

	
	public static void main(String[] args)
	{
		int ten = 123;
		//八进制，最多有21位数字，不包括前导0
		int oct = 0123;
		int hex = 0x123;
		/**
		 * 0. 八进制、十进制、十六进制的整型字面值，都默认定义为int型
		 *    也可以通过后缀L，定义为long型。
		 */
		long l = 0x123L;	
		System.out.println("八进制0123:"  + oct);
		System.out.println("十六进制0x123:"  + hex);
		System.out.println("十六进制0x123:"  + 0x123);//显示的是十进制
		
		//字面值27隐含为int，下句被编译器自动强制转换
		byte b0 = 27;
		byte b1 = (byte)27;
		//若字面值超过byte范围，则需要手工强制转换。
		byte b2 = (byte)128;
		/*
		 * 两个byte进行运算，得到一个int！！！
		 * 不能再直接覆盖byte变量！需要强制转换！
		 */
		//// byte b3 = b0 + b1;
		byte b4 = (byte)(b0 + b1);
		     b4 += 128;// +=、-=、*=、/=运算，隐含了强制转换
		System.out.println("(byte)27:" +b1);
		System.out.println("(byte)128:" +b2);
		
		/**
		 * 1. 浮点字面值默认定义为double型(64位)
		 *    可以通过后缀F，定义为float型(32位)
		 */
		double d = 123456.789;
		//// float  f0 = 123456.789; //Type mismatch: cannot convert from double to float
		float  f1 = 123456.789F;//！若不加后缀F，编译错误提示类型不匹配，因为会损失精度
		float  f3 = (float)123456.789; //或者强制转换

		
		
		/**
		 *  2. 字符字面值
		 *     字符实际上是一个16位无符号整数 --> 也就是说，可以给字符赋予数字字面值，只要<65535(0xFFFF)
		 */
		char a = 'a';
		char b = 0xFFFF;
		char e = 0;
		//如果数字字面值不在[0,65535]，则需要强制类型转换
		char c1 = (char)65536;
		//// char c2 = 65536; //超出范围	Type mismatch: cannot convert from int to char
		char d1 = (char)-98;
		//// char d2= -98;
		
		System.out.println("(char)65536:"+c1);
		System.out.println("(char)-98:"+d1);
		
		/**
		 * 3. 字符串字面值  |  数组字面值		
		 * 
		 *  字符串、数组不是基本类型，也有字面值
		 */
		String s = "string";
		
		int[] arrays = {1,2};
		
		String s2 = "string";
		System.out.println(s == s2); //true
	}

}
