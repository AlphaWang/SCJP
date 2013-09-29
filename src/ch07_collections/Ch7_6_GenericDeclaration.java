/**
 * <p>文件名称: Ch7_6_GenericDeclaration.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-9</p>
 * <p>完成日期：2011-3-9</p>
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
package ch07_collections;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;

public class Ch7_6_GenericDeclaration {

	public static void main(String[] args) 
	{
		List<Car> carList = new ArrayList<Car>();
		Car car1 = new Car();
		Car car2 = new Car();
		carList.add(car1);
		carList.add(car2);
		
		Rental<Car> rental = new Rental<Car>(carList, 10);
		
		Car rentCar = rental.getRental();
		
		//doStuff
		
		rental.returnRental(rentCar);
		
		/*String path = "conf"+File.separator+"conf\\app\\";
		System.out.println(path);*/

	}

}
/**
 * 1. 创建自己的泛型类  ————声明一个类，在实例化时 要求传递泛型
 * 
 * <E> ,也可为其他标识符  ————然后在整个类代码中，就可以使用“E占位符”了
 * <E extends Animal>,为参数类型 指定范围  ————区分：在声明List/方法只读参数时，用<? extends Animal>
 * 
 * E ：Element, 约定用于集合类
 * T ：Type，   约定用于非集合类
 * 
 */

/*
 * 不可使用<?> <? extends Number>
 * 
 * Syntax error on token "?", invalid TypeParameter
 */

//class Err<? extends Number>{  }


class Rental<T>
{
	private List<T> rentalPool;
	private int maxnum;
	
	public Rental(List<T> list, int num){
		this.rentalPool = list;
		this.maxnum = num;
		
	}
	
	public T getRental(){
		return rentalPool.get(0);
	}
	
	public void returnRental(T returnedThing){
		rentalPool.add(returnedThing);
	}
}
class Car{		
}
//<E extends Animal>,为参数类型 指定范围  
class MyList<E extends Number, T>
{
	E newElemE;
	T newElemT; //合法，但 泛型一般只用于集合
	E[] allElems;
	void add(E elem){
		
	}
	
}

class CreateList
{
	/**
	 * 2. 创建泛型方法 ————在非泛型类中 要使用泛型方法时
	 * 
	 * 在返回类型前  必须声明类型变量<T>
	 * ————而不是在方法参数中声明！！！
	 * 
	 */
	public <T> List<T> makeList(T t){
		List<T> list = new ArrayList<T>();
		list.add(t);
		return list;
	}
	//可用<E extends Animal>,为参数类型 指定范围  
	public <T extends Number> void makeList2(T t){
		
	}
	
	public <T,E> void makeList3(T t,E e){
		
	}
	/*
	 * 也可以在定义构造方法时使用 泛型。
	 * ————因为没有返回类型，看起来很怪，但是合法的！
	 */
	public <X> CreateList(X x){
		
	}
}

