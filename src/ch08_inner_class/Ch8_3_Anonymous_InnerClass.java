/**
 * <p>文件名称: Ch8_3_Anonymous_InnerClass.java </p>
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


class Outer3
{
	/**
	 * 
	 * 1. 普通的 旧式匿名内部类，形式一
	 * 匿名内部类不会有构造函数（构造函数用实例初始化块替代）
	 * 
	 */
	
	//Outer3的实例变量innerObj1，innerObj1是ParentClass类的一个“匿名子类”对象
	ParentClass innerObj1 = new ParentClass(){
		private String name = null;
		
		/**
		 * 实例初始化块，相当于匿名内部类的构造函数
		 * 区别：不能重载，仅有一个构造函数
		 */		
		{
			name = "Initial name";
		}
		
		//重写ParentClass类的doStuff方法
		public void doStuff(){
			System.out.println("方法一：Inner 重写ParentClass.doStuff()");
		}
		//定义新方法
		public void newMethod(){
			System.out.println("方法一：Inner 定义newMethod()");
		}
	};

	/**
	 * 
	 * 2. 普通的旧式匿名内部类，形式二
	 * 
	 * ————与形式一的差别：
	 * 形式一：创建指定 类型 的匿名子类
	 * 形式二：创建指定 接口 的匿名实现类 (只能实现一个接口)
	 * 
	 * ————匿名内部类要么扩展类，要么实现接口；但是不能两者兼备！
	 */
	MyInterface innerObj2 = new MyInterface(){
		@Override
		public void interfaceMethod() {
			System.out.println("方法二：实现MyInterface.interfaceMethod()");
		}
		
	};
	
	public void outerMethod(){
		innerObj1.doStuff();
		/**
		 * 注意这种匿名内部类 适用多态！！
		 * The method newMethod() is undefined for the type Test
		 */
		//// t.newMethod();
		
		innerObj2.interfaceMethod();
	}
	
	//用于测试方法三
	public void doStuff(ParentClass arg){
		arg.doStuff();
		
	}
	
	
}
class ParentClass{
	public void doStuff(){
		System.out.println("ParentClass");
	}
	ParentClass(){
		
	}
}
interface MyInterface{
	public void interfaceMethod();
}

public class Ch8_3_Anonymous_InnerClass 
{

	public static void main(String[] args) 
	{

		//测试方法一、二
		Outer3 outer = new Outer3();
		outer.outerMethod();
		
		/**
		 * 
		 * 3. 变元内声明匿名内部类
		 * 
		 */
		
		outer.doStuff(new ParentClass(){
			//重写ParentClass类的doStuff方法
			public void doStuff(){
				System.out.println("方法三：变元内声明匿名内部类： 重写ParentClass.doStuff()");
			}
			//定义新方法
			public void newMethod(){
				System.out.println("方法三：变元内声明匿名内部类： 定义newMethod()");
			}
		});
		

	}

}
