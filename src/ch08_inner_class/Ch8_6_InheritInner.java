/**
 * <p>文件名称: Ch8_6_InheritInner.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-27</p>
 * <p>完成日期：2011-12-27</p>
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

class OuterSuper{
	class Inner{
		void innerMethod(){
			System.out.println("原始innerMethod(): by outer "+OuterSuper.this.getClass().getSimpleName());
		}
		Inner(String name ){
			System.out.println("OuterSuper.Inner():" + name);
		}
		Inner(){
			System.out.println("OuterSuper.Inner()" );
		}
	}
	
	OuterSuper(String name){
		System.out.println("OuterSuper():" + name);
		Inner inner = new Inner(name); //————不会被重载！
		inner.innerMethod();
	}

}

/**
 * 内部类的继承
 *
 */
class InheritInner extends OuterSuper.Inner{

	/**
	 * 1. 如果不写构造方法、或者用默认构造方法：
	 * No enclosing instance of type Outer is available due to some intermediate constructor invocation
	 */
	//// InheritInner(){ }
	
	/**
	 * 2. 构造方法中，调用父类的构造方法 ————Inner的！
	 */
	InheritInner(OuterSuper outer){
		outer.super();
	}
	InheritInner(OuterSuper outer, String name){
		outer.super(name); 
	}
	
	//Type mismatch: cannot convert from Outer.Inner to OuterSuper
//	InheritInner(Outer.Inner inner){
//		inner.super();
//	}
}

/**
 * 
 * 内部类的覆盖（重载）
 *
 * InheritOuter.Inner与OuterSuper.Inner是完全独立的两个实体，并非重载
 */
class InheritOuter1 extends OuterSuper{
	class Inner{ 
		void innerMethod(){
			System.out.println("InheritOuter.innerMethod(): by outer "+InheritOuter1.this.getClass().getSimpleName());
		}
		Inner(String name ){
			System.out.println("InheritOuter.Inner():" + name);
		}
		Inner(){
			System.out.println("InheritOuter.Inner()" );
		}
	}

	InheritOuter1(String name) {
		//会调用OuterSuper构造方法，！！其中调用的Inner是OuterSuper.Inner————没有重载
		super(name); 
		
		//这里调用的Inner是InheritOuter.Inner 
		Inner inner = new Inner(name);
		inner.innerMethod();
	}
}
/**
 * OuterSuper.Inner可以被继承下来！！！
 *
 */
class InheritOuter2 extends OuterSuper{
	InheritOuter2(String name) {
		super(name);
		Inner inner = new Inner(name); 
		inner.innerMethod();
	}
}

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////


/**
 * 
 *
 */
class InheritOuter11 extends OuterSuper{
	class Inner extends OuterSuper.Inner{ 
		void innerMethod(){
			System.out.println("InheritOuter3.innerMethod(): by outer "+InheritOuter11.this.getClass().getSimpleName());
		}
		Inner(String name ){//会自动调用super()
			System.out.println("InheritOuter3.Inner():" + name);
		}
		Inner(){
			System.out.println("InheritOuter3.Inner()" );
		}
	}
	InheritOuter11(String name) {
		super(name);
		Inner inner = new Inner(name); 
		inner.innerMethod();
	}
}

public class Ch8_6_InheritInner {
	public static void main(String[] args){
		System.out.println("=================new OuterSuper()" );
		OuterSuper outer = new OuterSuper(" outer ");
		
		System.out.println("=================new InheritInner()" );
		InheritInner inheritInner = new InheritInner(outer, "inheritInner");
		
		System.out.println("=================new InheritOuter()1" );
		InheritOuter1 inheritOuter = new InheritOuter1("inheritOuter");
		
		System.out.println("=================new InheritOuter2()" );
		InheritOuter2 inheritOuter2 = new InheritOuter2("inheritOuter2");
		
		System.out.println("=================new InheritOuter11()" );
		InheritOuter11 inheritOuter3 = new InheritOuter11("inheritOuter2");
		
	}
	
}
