/**              dev branch 2
 * <p>文件名称: Ch1_1初始化.java </p>
 * <p>创建日期：2011-12-7</p>
 * @version 1.0
 * @author WangZhongXing192063
 */
package ch01_declaration;

import java.util.Arrays;

/**
 * 
 * 非内部类的修饰符 不能为private！！：
 * only public, abstract & final are permitted
 *
 * Illegal modifier for the class privateClass; only public, abstract & final are permitted
 */
//// private class privateClass{}
//// private enum privateEnum{}
enum DefaultEnum{
	SMALL,BIG,LARGE;
	DefaultEnum(){
		System.out.println("Enum构造函数，不可直接调用");
	}
}

public class Ch1_1_Initialize {
	
	private String name;
	public String publicVar = "父类publicVar";
	public String publicVar2 = "父类publicVar2";
	
	
	{
		publicVar = "父类publicVar!";
		System.out.println("父类成员初始化块");
		//// blankFinalVar = 0;       //空白final，不可多次赋值
	}
	
	
	private final int blankFinalVar;
	
	Ch1_1_Initialize(){
		blankFinalVar = 1;
		System.out.println("父类构造方法()");
	}
	Ch1_1_Initialize(String name){
		blankFinalVar = 2;          //空白final，必须在构造器之前对其赋值;
		//// blankFinalVar = 3;      //空白final，不可多次赋值
		System.out.println("父类构造方法(String)");
		this.name = name;
	}
	
	
	void print(){
		System.out.println("父类print()：" + name);
	}
	/**
	 * 被继承后，调用子类的print()
	 */
	void callPrint1(){
		print();
	}
	
	
	
	/**
	 * final方法参数
	 */
	void setName(final String n){
		this.name = n;
		name = "b";
		
		// final参数，不可更改引用
		///// n = "";
	}
	String getName(){
		return this.name;
	}
	/**
	 * private方法，不可被继承
	 */
	private void privateMethod(){
		System.out.println("父类privateMethod()：" );
		//可用values()遍历枚举元素
		DefaultEnum[] eItems = DefaultEnum.values();
		System.out.println(Arrays.asList(eItems));
		
		//Enum构造函数，不可直接调用
		//// DefaultEnum e1 = new DefaultEnum();
		DefaultEnum e2 = DefaultEnum.BIG;
	}
	
	public static void main(String[] args){
		new Ch1_1_Initialize().privateMethod();
	}
	
	

}
