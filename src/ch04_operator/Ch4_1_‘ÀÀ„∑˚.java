/**
 * <p>文件名称: Ch4_1_运算符.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-12</p>
 * <p>完成日期：2011-1-12</p>
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
package ch04_operator;

import static java.lang.System.out;

public class Ch4_1_运算符
{
	
	public static void main(String[] args)
	{
		/**
		 * 1. 赋值运算符
		 */
		
		
		/**
		 * 2. 关系运算符
		 * 	字符 可以与任何数值 进行比较运算
		 */
		out.println("'a': "+'a' );
		out.println("'a' < 50: "+('a' < 50));//比较Unicode值
		
		/*
		 * 注意不要把 == 误写为 =(赋值表达式)
		 * 任何赋值表达式的结果，都是赋值后的变量值。
		 */
		boolean b = true;
		int i;
		out.println("b = false :"+(b = false));
		out.println("i = 123: "+(i = 123));
		//无法编译：
		//// if(i = 234);
		
		/**
		 * 枚举的相等性 : ==和equals返回结果相同
		 */
		Color c1 = Color.BULE;
		Color c2 = Color.BULE;
		out.println("枚举==："+(c1 == c2));//true
		out.println("枚举equals："+c1.equals(c2));//true
		
		/**
		 * 3. instanceof比较
		 * instanceof不能在跨不同类层次间测试
		 */
		/*
		 * null引用的instanceof测试
		 * 
		 * null instanceof XXX 返回false
		 * XXX instanceof null 编译错误
		 */
		String s = "1";
		out.println("null instanceof String:"+(null instanceof String));
		//// out.println("String instanceof null:"   +(s instanceof null));
		
		/*
		 * instanceof不能在跨不同类层次间测试
		 * ——编译错误
		 */
		class C{}
		class D{}
		D d = new D();
		//// out.println(d instanceof String);
		//// out.println(d instanceof C);
		
		/**
		 * 4. 算术运算符
		 * 
		 */
		/*
		 * 字符串连接运算符
		 */
		out.println(5 + 1 + "s");//6s
		out.println("s" + 5 + 1 );//s51
		/*
		 * 递增递减运算符
		 */
		int x = 2; int y = 3;
		if((y == x++) | (x < ++y)){
			out.println("x = "+x+", y = "+y);
		}
		//！！注意不能再final变量上递增递减！
		final int num = 5;
		//// int i2 = num ++;
		
		/**
		 * 5. 条件运算符
		 */
		int count = 5;
		String status = (count < 4) ? "less" : "more";
		
		/**
		 * 6. 逻辑运算符
		 */
		// 短路逻辑运算符：&&  ||
		// ————不在无意义的计算上浪费时间
		
		// 非短路逻辑运算符： &  |
		
		// 逻辑运算符 异或：^
		out.println((2<3) ^ (3<4)); // true ^ true == false
		
		
		float f = 3.4F;
		float[] fs = {4f,2.3f};
		Long x2 = 3L;
		
		//可以比较 不同的基本类型
		if(f == x2)
			out.println("f == x2");
		
		//不能比较 基本类型 vs 对象
		//// if(f == fs)  out.println("f == x2");
		out.println("------out range");
		int test = 24 * 60 * 60 * 1000 * 1000 * 100000000 * 100000000;
		out.println(test);
		long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000; //不精确
        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        out.println(MICROS_PER_DAY + "/" + MILLIS_PER_DAY + " = " + MICROS_PER_DAY / MILLIS_PER_DAY);
        
        
        out.println("----mix-type computation");
        out.println(0xcafebabe); //-889275714
        out.println(0xcafebabeL); //3405691582
        out.println(0xffffffffcafebabeL); //-889275714
        out.println(Long.toHexString(0x100000000L + 0xcafebabe)); //cafebabe
        out.println(Long.toHexString(0x100000000L + 0xcafebabeL)); //1cafebabe
        
        out.println("----infinity");
        out.println(1.0 / 0.0); // Infinity
        out.println((1.0 / 0.0) == Double.POSITIVE_INFINITY);
        
        out.println(0.0 / 0.0); // NaN
        out.println((0.0 / 0.0) == Double.NaN); // Nan != Nan
        out.println(1 / 0); // java.lang.ArithmeticException: / by zero
	}

}
enum Color{
	RED,BULE
}
