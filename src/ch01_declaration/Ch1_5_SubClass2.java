/**
 * <p>文件名称: SubClass2.java </p>
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


/**
 *  继承 默认类中的public方法
 *  如果在其他包中 继承该类，则编译失败！！
 */
//不可缩小父类的 可见性??
class Test1  extends Ch1_5_声明类成员_访问修饰符{
	
}

public  class Ch1_5_SubClass2 extends Ch1_5_声明类成员_访问修饰符{
	public void newMethod()
	{
		Ch1_5_声明类成员_访问修饰符 parent = new Ch1_5_声明类成员_访问修饰符();
		parent.defaultMethod();			    //调用父类中的default方法
		       defaultMethod();			    //继承父类中的default方法
		  this.defaultMethod();
		
		parent.protectedMethod();			//调用父类中的protected方法
		       protectedMethod();           //继承父类中的protected方法		       
		  this.protectedMethod();
		  
		parent.finalMethod();
		       finalMethod();
		  this.finalMethod();
		
		int i1 = parent.protectedVar;        //调用父类中的protected变量
		int i2 = this.protectedVar;          //继承父类中的protected变量
				
		/**
		 * 不可调用父类private成员
		 * 不可继承父类private成员
		 */
		//// int j = parent.privateVar;
		//// int k = privateVar;
		
		
	}
	//// 不可缩小父类方法的 可见性
	//// Cannot reduce the visibility of the inherited method from Ch1_5_声明类成员_访问修饰符
	/*
	private void defaultMethod()
	{
		System.out.println("子类重写default方法");
	}
	public void protectedMethod()
	{
		System.out.println("子类重写protected方法");
	}
	*/
	
	
	public static void main(String[] args){
		Ch1_5_SubClass2 subClass2 = new Ch1_5_SubClass2();
		subClass2.newMethod();
		
		int i = subClass2.protectedVar;
		
		//he field Ch1_5_声明类成员_访问修饰符.privateVar is not visible
		//// int j = subClass2.privateVar;
		
		
	}
	
}