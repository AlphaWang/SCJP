/**
 * <p>文件名称: Ch2_2_Interface.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-14</p>
 * <p>完成日期：2011-12-14</p>
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
package ch02_OO;

interface CanFly{
	void fly();
}

interface CanFight {
	void fight();
}
/**
 *  接口可以继承多个接口！
 */
interface Bird extends CanFight, CanFly{
	
}
/**
 * 菱形继承！
 */
interface SubBird extends Bird{
	
}

//////////////////////////////
interface CanFly2{
	int fly();
}
class ParentClass{
	String fly(){
		return "Flying";
	}
}
/**
 * 同时继承两个接口，但其中某个方法签名相同、返回值不同：
 * ————编译错误： The return type is incompatible with CanFly2.fly(), CanFly.fly()
 */
//// interface SubInter extends CanFly, CanFly2{ }


/**
 * 同时继承父类、实现接口，但其中某个方法签名相同、返回值不同：
 * ————编译错误：The return type is incompatible with CanFly.fly(), Parent.fly()
 */
//// class Child extends ParentClass implements CanFly{  }




///////////////////////////
class Superman{
	public void fight(){
		System.out.println("Superman.fight()");
	}
	void fly(int time){
		System.out.println("Superman.fly():"+ time);
	}
}
/**
 * 父类和接口中，同名方法的访问权限问题：
 * 
 * 如果Superman.fight()不为public，则提示
 * The inherited method Superman.fight() cannot hide the public abstract method in CanFight
 *
 */
class Jack extends Superman implements CanFight,CanFly{
	/**
	 * 父类中、接口中均有fight()时，子类中的fight()是从父类继承来的！
	 */
	//public void fight() //继承自父类
	//void fly(int time)  //继承自父类
	
	@Override
	public void fly() {
		System.out.println("Jack.fly()实现接口方法");		
	} 
}

public class Ch2_2_Interface{
	public static void main(String[] args){
		Jack jack = new Jack();
		jack.fight();
		jack.fly();
		jack.fly(110);
	}

}

