/**
 * <p>文件名称: Ch1_1初始化.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-7</p>
 * <p>完成日期：2011-12-7</p>
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
