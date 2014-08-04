/**
 * <p>文件名称: Ch8_5_Static_NestedClass_Interface.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-26</p>
 * <p>完成日期：2011-12-26</p>
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

public class Ch8_5_Static_NestedClass_Interface {
	public static void main(String[] args){
		Interface sub = new SubClass();
		sub.fly();
	}
}


interface Interface{
	int NUM = 56;
	void fly();
	/**
	 * 接口内部的静态嵌套类
	 * ！！StaticNested默认为public static
	 * ！！作用：可作为公共代码，可以被接口的不同实现所共用
	 * 
	 * ————接口方法都是抽象的，通过静态嵌套类 可提供非抽象方法
	 *
	 */
	class StaticNested{
		public void printClass(){
			System.out.print(this.getClass().getName());
		}
		public static void printNum(){
			//静态内部类，可以访问外部类的静态变量
			System.out.print(NUM);
		}
	}
}

class SubClass implements Interface{
	int NUM = 4; //并非继承
	@Override
	public void fly() {
		new StaticNested().printClass() ;
		System.out.print(", fly(): ");
		StaticNested.printNum();
		
	}
	
}
