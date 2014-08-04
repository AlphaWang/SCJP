/**
 * <p>文件名称: Ch1_5_声明类成员_访问修饰符.java </p>
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

public class Ch1_5_声明类成员_访问修饰符 {
	/**
	 * 1. 方法：包访问级别；
	 *    即便类是public，在其他包中可以访问类，但不能访问类中的default方法
	 */
	void  defaultMethod(){
		System.out.println("default方法");
	}
	/**
	 * 2. 方法：protected级别；
	 *    子类可继承，即便子类在其他包中
	 *    
	 *    但是，其他包中的子类不能再父类引用上使用 点运算符 来访问protected成员——只能通过继承的方式
	 */
	protected int protectedVar = 5;
	
	protected void protectedMethod()
	{		
		/**
		 * 3.局部变量不可用 访问修饰符！
		 *           只可用 final
		 */
		//// private int privateVar;
		final int y = 10;
		System.out.println("默认类中的protected方法"+y);
	}
	/**
	 * private 变量
	 */
	private int privateVar = 6;
	
	/**
	 * 4. final：可以被继承！！！不能重写！
	 */
	final String  finalVar = "finalVar";
	final void finalMethod()
	{
		System.out.println("父类finalMethod");
	}

}
/**
 *  包访问权限的类
 */
class PackageClass
{
	/**
	 * 构造方法是private，所以不能创建该类的实例	 
	 * 但是可以访问该类的public 静态变量。
	 */
	static int staticVar;	
	private PackageClass(){
		
	}	
	
	public PackageClass(String name){
		
	}
}
