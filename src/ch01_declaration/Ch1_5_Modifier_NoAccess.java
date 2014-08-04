/**
 * <p>文件名称: Ch1_5_声明类成员_非访问修饰符.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-15</p>
 * <p>完成日期：2010-9-15</p>
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
package ch01_declaration;

import java.util.Date;

public class Ch1_5_Modifier_NoAccess {
	Date d;
	/**
	 * final方法：可以被继承，不可被重写。
	 */
	public final void finalMethod()
	{
		System.out.println("Ch1_5_声明类成员_非访问修饰符.finalMethod()");
	}

	public void finalParaMethod(final Date date)
	{
		d = date;
		System.out.println(d);
		System.out.println(date);
		d.setMonth(78);				
		System.out.println(d);
		System.out.println(date); //date同时被修改
		
		date.setMonth(87);        //final参数，为何可以修改？！--> 修改是指重新赋值
		System.out.println(d);
		System.out.println(date);
		/**
		 * 1. final参数不可修改：不可被重新赋值！
		 *   ————不存在final对象，只存在final引用
		 */
		//// date = new Date();
	}
	/**
	 * 2. 非抽象类中，不可有抽象方法
	 *    但是抽象类中 可以没有抽象方法
	 */
	//// public abstract void sample();
	
	/**
	 * 3. 同步方法：表示方法一次只能被一个线程访问
	 *    ————synchronized修饰符只能用于方法，不能用于类、变量！！
	 */
	public synchronized void synchronizedMethod()
	{
	}
	
	/**
	 * 4.native方法：Java无法直接访问到操作系统底层（如系统硬件等)，为此Java使用native方法来扩展Java程序的功能。 
	 *   可以将native方法比作Java程序同Ｃ程序的接口
	 *   ————native修饰符只能用于方法，不能用于类、变量！！native方法以分号结束
	 */
	public native void nativeMethod();
	
	/**
	 * 5. strictfp：只可用于方法、类，不可用于变量！！
	 */
	public strictfp void stictfpMethod()
	{
	}
	
	public static void main(String[] args)
	{
		Ch1_5_Modifier_NoAccess obj = new Ch1_5_Modifier_NoAccess();
		Date today = new Date();
		obj.finalParaMethod(today);
		
		new SubClass3().finalMethod(); //final方法可被子类继承
		
		
		/**
		 * PackageClass构造方法是private，所以不能创建该类的实例
		 * 但是可以访问该类的public 静态变量。
		 */			
		int i = PackageClass.staticVar;
		//// PackageClass p1 = new PackageClass();			
		     PackageClass p2 = new PackageClass("public constructor");
	}
}

class SubClass3 extends Ch1_5_Modifier_NoAccess{
	/**
	 * 3. final方法不可被重写。
	 *         会被继承。
	 *         Cannot override the final method from Ch1_5_声明类成员_非访问修饰符
	 */
	
//	public void  finalMethod(){
//		System.out.println("重写finalMethod");
//	}
	
}
abstract class AbstractClass3{
	/**
	 * 4. abstract与final、private、static互斥
	 */
	//// abstract final void method1();
	//// private abstract void method2();
	//// abstract static void method3();
	
}
