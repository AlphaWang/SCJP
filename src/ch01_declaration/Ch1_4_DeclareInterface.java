/**
 * <p>文件名称: Ch1_4_声明接口.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-10</p>
 * <p>完成日期：2010-9-10</p>
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

    /**
     * 0. 接口可以extends自其它接口，但不能implements
     * 0. 接口声明中隐含 abstract————
     * 0. 接口可以扩展自多个其他接口
     */
public interface Ch1_4_DeclareInterface extends Runnable,Bounceable{
	/**
	 ******* 1. 接口中声明的“方法”，默认都是public abstract的	
	 *          所以不能修饰为final、static
	 */
	                void method1();
	public abstract void method2();
	
	/*
	 * Illegal modifier for the interface method staticMethod; only public & abstract are permitted
	 */
	//// static void staticMethod();
	//// final  void finalMethod();
	//// private void privateMethod();
	/**
	 ******* 2. 接口中声明的“变量”，默认都是public static final
	 */
	                    int var2 = 2;
	public static final int var1 = 1;
	//// private int privateVar = 0 ;
	
	
	/**
	 * 3. 接口中声明的方法，一定不能是static / final / strictfp / native的, 
	 *                     final和abstract互斥
	 *                     static和abstract互斥，不能被重写	           
	 *                     ————也就是仅能为public abstract
	 *                     
	 *    所谓static方法不能被重写：
	 *    ——多态时调用静态方法，始终调用的是父类中的，子类有方法覆盖也调用父类中的。
	 *    ——static 告诉编译器 这个方法不被覆写，就像private。 子类里 看似覆写 实则是新加
	 */
	//// static void method3();
	//// final void method4();
	
	/**
	 * 4. 接口中的方法，只能为抽象方法————与抽象类的区别！
	 */
	//// public void test(){	}
}


    /**
     * 5. 接口声明中隐含 abstract
     */
abstract interface Bounceable{
	void bounce();
}

/**
 * 抽象类
 * 
 * ！抽象类有构造函数
 * ！接口没有构造函数
 *
 */
abstract class AbstractClass2{
	//没有abstract，不能以分号结尾
	void method() {		
	}
	
	//static方法，在接口中不能出现
    static void method1(){		
	}
    
    // abstract和static互斥
	//// abstract static void method2();
    
    public abstract  void method4();
	
}
