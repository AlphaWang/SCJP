/**
 * <p>文件名称: Ch1_5_声明类成员_声明变量.java </p>
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

public class Ch1_5_声明类成员_声明变量 {
	/**
	 * 0. transient：只能用于实例变量。表示不序列化该变量
	 *               ————如果一个变量是transient的，则不要用它来判断对象的哈希码或相等性
	 *               
	 *    volatile:  只能用于实例变量。表示访问该变量的线程必须使自己对该变量的私有副本与内存中的主副本一致
	 *    			volatile 变量可以被看作是一种 “程度较轻的 synchronized”；
	 *              （一般用synchronized来保证数据是线程安全的）
	 */
	volatile int z;
	transient int w;
	
	final String finalVar = "finalString";
	private String privateVar = "privateString";
	final void finalMethod()
	{
		System.out.println("finalMethod");
	}
	
	public void method()
	{
		/**
		 * 1.局部变量没有默认值，使用前必须显式初始化
		 */
		int i;
		//// System.out.println(i);
		
		/**
		 * 2.数组变量总是堆中的对象，即便其元素是基本类型
		 */
		int[] j;
		int[] k[];//二维数组
		
		/**
		 * 3. 在声明中 包含数组大小，不合法！
		 */
		//// int[5] x;
		int[] y = new int[5];
		int[] z = {1,2};
		int[] z1 = new int[]{1,2};
		//Cannot define dimension expressions when an array initializer is provided
		//// int[] z2 = new int[2]{1,2};
		
		/**
		 * 4. final的基本类型，一旦显式初始化，就不可再重新赋值
		 *    final的对象类型，永远不能重新赋值来引用其他对象，但是可以修改对象里的数据。
		 *                    (没有final对象，只有final引用)
		 *                    
		 *   在构造函数完成前，final变量必须初始化！！！！————可在成员初始化块、构造函数中赋值！                 
		 */
		final int y2;
		y2 = 1;
		/*
		 * The final local variable y2 may already have been assigned
		 */		
		//// y2 = 2;
		
		final Date d;
		d = new Date();
		d.setYear(78);		
		//// d = new Date();
	}
	public static void main(String[] args){
		new SubClass4().test();
	}
	/**
	 * ** 5. 内部类中的方法和变量，不可用static
	 *       除非：1)该内部类也是static;
	 *            2)内部类成员使用 static final
	 */
	class Inner{
		/*
		 * The field j cannot be declared static; 
		 * static fields can only be declared in static or top level types
		 */		
		//// static int j = 1;
		
		static final  int i =1;
	}
}

class SubClass4 extends Ch1_5_声明类成员_声明变量
{
	/**
	 * 6.父类的 final方法不可被重写
	 *         final变量不可重赋值
	 */	
	//// void finalMethod(){	}
	//// final void finalMethod(){}
	
	void test(){
		Ch1_5_声明类成员_声明变量 parent = new Ch1_5_声明类成员_声明变量();
		//// finalVar = "new";  //final变量不可重赋值
		//// this.privateVar;   //private变量不可继承
		
		System.out.println(       finalVar);
		System.out.println( super.finalVar);
		System.out.println(parent.finalVar);
		System.out.println(  this.finalVar);
		
		this.finalMethod();		
		super.finalMethod();
		parent.finalMethod();
		
		/*
		 * 不能访问父类中的private成员
		 */
		//// parent.privateVar; 
	}
	
	
}
