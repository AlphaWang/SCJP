/**
 * <p>文件名称: Ch8_1_Declare.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-14</p>
 * <p>完成日期：2011-3-14</p>
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
/**
 * 为什么需要内部类？
 *  ————一般，内部类会继承某个类、或实现某个接口
 *  
 *  1. 内部类使得多重继承的解决方案变得完整： ！可以让多个内部类继承某类、实现某接口
 *                                         ！内部类也拥有外围类、外围类父类 的所有方法
 *  
 *  2. 闭包与回调 ————?? 见Callbacks.java
 *     TIJ P205
 *  
 *  3. 控制框架：内部类适于变化向量（二次开发）
 *     TIJ P207
 *  
 */

/**
 * 常规内部类: 在类内部定义类 
 *  0. 为了创建内部类实例，必须有一个与该内部类相关的外部类实例！
 *
 */

class Outer 
{
	private int x = 1;
	/**
	 * 1. 在外部类 创建内部类对象
	 * 
	 *    makeInner()不是静态方法，所以属于一个Outer实例！
	 */
	public void makeInner()
	{
		Inner inner = new Inner();		
		inner.changeOuter();
		//外部类可以通过内部类对象，访问内部类中的private变量
		int i = inner.privateVar;
		//// int j = inner.privateStaticVar;
		int l = Inner.privateStaticFinalVar;
	}
	private void outerMethod(){
		
	}
	
	class Inner
	{
		private int privateVar = 2;
		/**
		 * The field privateStaticVar cannot be declared static; 
		 * static fields can only be declared in static or top level types
		 * 非静态内部类中，不能有静态变量————静态常量除外
		 */
		//// private static int privateStaticVar = 3;
		private static final int privateStaticFinalVar = 4;
		
		
		public void changeOuter(){
			/**
			 * 内部类可以访问外部类中的private变量、方法
			 */
			x = 8;
			outerMethod();
			/**
			 * 3. 内部类中的this引用
			 * 
			 * 表示当前内部类实例:     Inner直接使用this
			 * 表示相关联的外部类实例: Inner使用Outer.this: 
			 */
			System.out.println("内部类调用this:\t" + this);
			System.out.println("内部类调用Outer.this:\t" + Outer.this);
		}
		
		/**
		 * Outer.this: 返回内部类对应的外部类实例
		 * 
		 * 内部类对象隐式地包含一个指向外部类对象的引用！！！
		 */
		public Outer getOuter(){
			return Outer.this;
		}
	}
	
	
	Inner getInner(){
		return new Inner();
	}
}

public class Ch8_1_Normal_InnerClass {

	public static void main(String[] args) 
	{
		/**
		 * 2. 在外部类代码之外 创建内部类对象
		 */
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		
		Outer.Inner inner2 = new Outer().new Inner();
		Outer.Inner inner3 = outer.getInner();
		//// outer.Inner inner4 = new Outer().new Inner();
		
		inner.changeOuter();
		
		
		
		/**
		 * !!!!!!在其他类的静态方法中 实例化内部类：————必须要有外部类实例！
		 * 
		 * 对比Ch8_4_Static_NastedClassss：
		 * Nest2 nest2 = new Nest2();
		 */
		/*
		 * No enclosing instance of type Ch8_1_Declare is accessible. 
		 * Must qualify the allocation with an enclosing instance of type Ch8_1_Declare 
		 * (e.g. x.new A() where x is an instance of Ch8_1_Declare).
		 */
		
		  //// MyInner myInner = new MyInner();
		  MyInner myInner2 = new Ch8_1_Normal_InnerClass().new MyInner();
	}
	class MyInner
	{
		
	}

}

