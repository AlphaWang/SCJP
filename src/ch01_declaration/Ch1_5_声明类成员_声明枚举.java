/**
 * <p>文件名称: Ch1_5_声明类成员_声明枚举.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-17</p>
 * <p>完成日期：2010-9-17</p>
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

public class Ch1_5_声明类成员_声明枚举 {

	public static void main(String[] args)
	{
		Coffee coffee = new Coffee();
		/**
		 * 创建一个其他类内部定义 的枚举
		 * 1. =Coffee.Grade.GOOD;
		 * 2. =Grade.GOOD; 同时import ch01_declaration.Coffee.Grade;
		 */
		coffee.size = CoffeeSize.BIG;//size 是一个CoffeSize类的实例
		coffee.grade = Coffee.Grade.GOOD;
		
		coffee.size2 = CoffeeSize2.HUGE;
		System.out.println("coffee.size:" + coffee.size );
		System.out.println("coffee.size2:"+ coffee.size2 );
		
		/**
		 * ！！！永远不能直接调用enum的构造函数！
		 */
		//// coffee.size2  = new CoffeeSize2(10);
		
		/**
		 * enum的values方法可以遍历枚举值
		 */
		CoffeeSize2[] allSize = CoffeeSize2.values();
		for(CoffeeSize2 size : allSize){
			System.out.println(size + ":"+size.getOunces());
		}
		
	}
}

//1.枚举可以定义为独立的类
enum CoffeeSize{
	BIG,
	HUGE,
	OVERWHELMING
}
/**
 * 枚举声明中，可以包含构造函数、实例变量、方法
 */
enum CoffeeSize2{
	BIG(8),//类似public static final CoffeeSize2 BIG = new CoffeeSize2(8);
	HUGE(10),
	/**
	 * enum内部可以定义 "常量特定类体" constant specific class body，
	 * 可以在其中重写ENUM定义的方法
	 */
	OVERWHELMING(20){
		public int getOunces(){
			return 100;
		}
	};//******** <- 枚举常量值声明以分号结束
	
	
	private int ounces;
	CoffeeSize2(int ounces){
		this.ounces = ounces;
	}
	public int getOunces(){
		return ounces;
	}
	
	
}
class Coffee{
	CoffeeSize size; 
	CoffeeSize2 size2;
	Grade grade;
	
	/**
	 * 2.枚举可以定义为类成员
	 *
	 */
	enum Grade{
		NORMAL, 
		//类似public static final Grade NORMAL2;
		GOOD
	}; //****** <-可以有分号
	public void getCoffee()
	{
		/**
		 * 3.枚举不可以定义在方法内部，即:不可定义为局部变量
		 */
		/*enum Test{
			ENUM1,
			ENUM@
		}*/
	}
}