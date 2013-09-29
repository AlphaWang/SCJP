/**
 * <p>文件名称: Ch1_5_SubClass.java </p>
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
package ch01_declaration_subclass;
import ch01_declaration.*;

public class Ch1_5_OutPakSubClass extends Ch1_5_声明类成员_访问修饰符{
	public int j;
	public void testProtected()
	{
		/**
		 * 
		 * 包外子类 只能通过“继承”，看到父类的protected成员		 
		 * 不能通过点运算符！！！否则就和public成员一样了
		 * 
		 * ————子类继承protectedVar，该变量对子类外的任何代码来说 都相当于private的，除非其子类
		 * 
		 */
		Ch1_5_声明类成员_访问修饰符 parent = new Ch1_5_声明类成员_访问修饰符();
		/**
		 * 1. 不可在父类的引用上 使用点运算符 来访问Protected变量
		 *    ————但可用super访问
		 */
		//// System.out.println(parent.protectedVar);
		System.out.println(protectedVar);
		System.out.println(this.protectedVar);  //与Ch1_5_SubClass_引用 对比！
		System.out.println(super.protectedVar); //??
		
		
		/**
		 * 2. 不可在父类的引用上 使用点运算符 来访问Protected方法
		 *    ————但可用super访问
		 */
	    //// parent.protectedMethod();
		this.protectedMethod();
		super.protectedMethod();//??
		
		
		
		/**
		 * 3. 不能访问父类中的final成员？？？？————因为是default方法！！
		 *    ————super也不行
		 */
		this.finalMethod();         //注：调用重写的finalMethod()
		//// super.finalMethod();
		//// parent.finalMethod();
		
		/**
		 * --4. 包外不能访问父类的default成员
		 *      is not visible
		 */
		//// this.defaultMethod();
		//// super.defaultMethod();
		//// parent.defaultMethod();
	}
	/**
	 * 3. 父类中的final成员，不可继承重写，但可重定义
	 */
    //// @Override
	final void finalMethod(){ 
		System.out.println("子类finalMethod");
	}
	
	//Duplicate method finalMethod() in type Ch1_5_OutPakSubClass
	//void finalMethod(){}
	
	final String finalVar = "";
	


	public  static void main(String[] args)
	{
		Ch1_5_OutPakSubClass subClass = new Ch1_5_OutPakSubClass();
		subClass.testProtected();
		subClass.finalMethod();		//注：调用重写的finalMethod()
		
		//default方法不能包外被继承
		//// subClass.defaultMethod();
		
		
		/**
		 * default类 在包外 不可访问！
		 * The type PackageClass is not visibles
		 */
		//// int i = PackageClass.staticVar;		
		//// PackageClass p2 = new PackageClass("public constructor");
		
	}

}
