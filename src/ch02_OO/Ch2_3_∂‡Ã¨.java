/**
 * <p>文件名称: Ch2_3_多态.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-19</p>
 * <p>完成日期：2010-9-19</p>
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

public class Ch2_3_多态 {
	static Object oc 		= new Child();
	static Parent pc 		= new Child();
	static Animatable ac 	= new Child();
	static Child cc 		= new Child();
	public static void main(String[] args){
		/**
		 * 1. 方法调用 只基于引用声明的类型，与对象类型无关。
		 *    当使用了父类的引用，就只能调用父类中的方法
		 */
		//// oc.paint();
		((Child) oc).paint();
		
		pc.paint();   //Child paint
		//pc.animate()
		
		//ac.paint();
		ac.animate(); //Child animate
		
		cc.paint();   //Child animate
		cc.animate(); //Child animate
		
		System.out.println("----域的继承");
		System.out.println("cc.getField1()=" + cc.getField1());   	//Parent Field1————！
		System.out.println("cc.field1="+cc.field1);                 //Child Field1(override)
		System.out.println("pc.field1="+pc.field1); //域不可多态！       //Parent Field1
		
		System.out.println("cc.field2="+cc.field2);  //域可继承！         //Parent Field2
		System.out.println("pc.field2="+pc.field2);                 //Parent Field2
		
	}
}

class Parent {
	public String field1 = "Parent Field1";
	public String field2 = "Parent Field2";
	public void paint(){
		System.out.println("parent paint");
		//new Float(8).equals(8);
	}
	public String getField1(){
		//System.out.println(field1);
		return field1;
	}
}

interface Animatable{
	public void animate();
}

class Child extends Parent implements Animatable{
	
	public String field1 = "Child Field1(override)";

	@Override
	public void animate() {
		System.out.println("Child animate");
	}
	@Override
	public void paint(){
		System.out.println("Child paint");
	}
	
}
