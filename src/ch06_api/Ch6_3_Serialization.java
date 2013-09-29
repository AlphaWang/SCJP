/**
 * <p>文件名称: Ch6_3_Serialization.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-2-10</p>
 * <p>完成日期：2011-2-10</p>
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
package ch06_api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import static java.lang.System.out;

public class Ch6_3_Serialization {

	public static void main(String[] args) {

		/**
		 *  1.序列化用于：保存这个对象 及其全部实例变量(除非transient变量)
		 *  
		 *  ObjectOutputStream <- FileOutputStream
		 */
		CatHouse house = new CatHouse(123);
		Cat c = new Cat(house, "Cat构造函数定义name");
		Cat.staticName = "Cat修改staticName1";
		c.age = 2;
		c.weight = 32;//weigth是继承来的，非序列化
		c.color = "white";
		
		
		out.println("序列化：");
		out.println("c.name:"+c.staticName);
		out.println("c.color:"+c.color);
		out.println("c.age:"+c.age);
		out.println("c.length:"+c.length);
		out.println("c.weight:"+c.weight);
		/*
		 * 序列化
		 */
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.ser"));
			oos.writeObject(c);
			oos.close();
			
		} catch (FileNotFoundException e) {	e.printStackTrace();} 
		  catch (IOException e) {e.printStackTrace();}
		
		/*
		 * 反序列化
		 * 
		 * 反序列化时，不发生任何常规初始化：不会运行构造函数、不赋予显示声明的值
		 */
		Cat c2 = null;
		Cat.staticName = "修改staticNname2";
		try {
			
			ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("cat.ser"));
			c2 = (Cat) ois.readObject();
			ois.close();
			
		} catch (FileNotFoundException e) {e.printStackTrace();} 
		  catch (IOException e) {e.printStackTrace();} 
		  catch (ClassNotFoundException e) {e.printStackTrace();}
		  
		out.println("反序列化后：");
		out.println("c2.name:"+c2.staticName);
		out.println("c2.color:"+c2.color);//null, transient变量不被序列化，赋予默认值————而不是声明变量时赋予的值
		out.println("c2.age:"+c2.age);
		out.println("c2.length:"+c2.length);
		out.println("c2.weight:"+c2.weight);//weigth是继承来的，反序列化后 赋予默认值/最初的赋值
		/**
		 * 因为house为transient，所以反序列化后 c2.house == null，此处抛出NullPointerException
		 * 如何解决？ ==> 使用writeObject()、readObject()方法，参见 3
		 */
		System.out.println("c2.house.size:"+c2.house.size );
		

	}

}

/**********************************/
class Animal{
	/*
	 * 如果有一个序列化类，但其父类是非序列化的
	 * 则反序列化后，从父类继承的实例变量都会被重置为对象原始构造期间所赋予的值
	 * 
	 * ————即父类的构造函数会被调用。父父类的构造函数也会被调用
	 */
	int weight = 45;
}
class Cat extends Animal implements Serializable{
	/**
	 * 2. 当序列化一个对象，Java序列化机制会保存对象的整个“对象图”
	 *    例如Cat包含CatHouse对象，则也会序列化CatHouse
	 */
	
	/*
	 * 如果实例变量 为对象引用CatHouse，而CatHouse又没有implements Serializable	 * 
	 * 则在序列化时，会提示java.io.NotSerializableException
	 * 
	 * 解决方法：
	 * 1. 修改CatHouse为implements Serializable
	 * 2. 新建CatHouse子类，并implements Serializable ——不能访问CatHouse源码时
	 *                                               ——缺点：可能是final类；可能包含其他非序列化对象，不可遍历
	 * 3. 使用transient
	 */
	transient CatHouse house;
	//CatHouse house;
	
	/*
	 * 序列化不适用于静态变量！
	 * 因为静态变量不属于任何对象
	 */
	static String staticName = "初始定义的staticName";
	Object[] objects;
	transient String color;
	int length;
	int age;
	public Cat(CatHouse house, String name){
		 this.house = house;
		 Cat.staticName = name;
	}
	/**
	 * 3. 解决transient对象引用 反序列化NullPointerException问题
	 * 
	 * 定义writeObject()、readObject()方法，——并非重写
	 * 在序列化/反序列化时调用这些方法
	 * 
	 * 注：何时使用writeObject()、readObject()？
	 *    ——当需要手工保存对象状态的某一部分时。
	 */
	 private void writeObject(ObjectOutputStream oos)	 {
		 try {
			oos.defaultWriteObject();
			oos.writeInt(house.size);//将一个额外的int写入创建序列化Cat的流中
			
		} catch (IOException e) {e.printStackTrace();}
		 
	 }
	 private void readObject(ObjectInputStream ois){
		 try {
			 ois.defaultReadObject();
			 house = new CatHouse(ois.readInt());//读取额外的int
			
		} catch (IOException e) {e.printStackTrace();} 
		  catch (ClassNotFoundException e) {e.printStackTrace();}
	 }
}

class CatHouse {
	int size;
	public CatHouse(int size){
		this.size = size;
	}
}
