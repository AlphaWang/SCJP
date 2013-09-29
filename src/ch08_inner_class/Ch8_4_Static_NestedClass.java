/**
 * <p>文件名称: Ch8_4_Static_InnerClass.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-15</p>
 * <p>完成日期：2011-3-15</p>
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
package ch08_inner_class;

import ch08_inner_class.Outer.Inner;

/**
 *  静态嵌套类
 *  
 *  ————并不是内部类，因为它和外部类实例没有关系
 *  
 *  普通内部类对象，隐式地保存了一个指向外部类的引用
 *  静态内部类对象，没有！
 *
 */

class Outer4
{
	static String outerStaticVar = "outerStaticVar";
	String outerVar = "outerVar";
	
	static class Nest
	{
		void doStuff(){
			System.out.println("Outer4.Nest 静态嵌套类内的方法");
			System.out.println("==访问Outer静态变量："+outerStaticVar);
			/*
			 * 静态嵌套类内部 ，不能访问实例变量、实例方法
			 * Cannot make a static reference to the non-static field outerVar
			 */
			//// System.out.println("==访问Outer实例变量："+outerVar);
		}
		//可以有静态方法
		static void staticMethod(){
			
		}
	}
}
public class Ch8_4_Static_NestedClass 
{
	static class Nest2
	{
		void doStuff(){
			System.out.println("Ch8_4_Static_NastedClassss.Nest2 静态嵌套类内的方法");
		}
	}
	public static void main(String[] args)
	{
		/**
		 * 创建本类中的静态嵌套类，同一般类创建方法
		 */
		Nest2 nest2 = new Nest2();
		/**
		 * 创建其他类中的静态嵌套类, 无需外部类实例！
		 */		
		Outer4.Nest nest = new Outer4.Nest();
		
		//与非静态内部类的区别：
		//Illegal enclosing instance specification for type Outer4.Nest
		
		//// Outer4.Nest nest3 = new Outer4().new Nest();
			 Outer.Inner inner2 = new Outer().new Inner();
		
		nest2.doStuff();
		nest.doStuff();
	}

}
