/**
 * <p>文件名称: Ch2_3_Inherit.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2012-1-18</p>
 * <p>完成日期：2012-1-18</p>
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
package ch11_exception;


/**
 *  如果父类、接口中包含同样的方法？？
 *
 */
class MyException1 extends Exception{}
class MyException2 extends Exception{}

class P {
	public P() throws MyException1{}
	public P(String s) throws MyException1{}
	public void event()  { System.out.println("P.event()");}
	public void event2() { System.out.println("P.event2()");}
	public void event3() throws MyException1{	System.out.println("P.event3()");	}
	
}

interface I {
	void event ();
	void event2 ();
	/**
	 * 要与P中的同名方法保持一致，包括抛出的异常
	 */
	//// void event3 () throws MyException2;
}

class C extends P implements I {
	/**
	 * 异常限制对构造器不起作用。子类构造器可以抛出新异常
	 * 
	 * 但是由于基类构造器会被调用，所以C()的异常说明中 必须包含P()的异常MyException1
	 */
	public C() throws MyException1,MyException2 {
		super();
		//throw new MyException2();
	}
	/**
	 * 不可在子类构造器中 捕获基类构造器的异常 
	 */
	public C(String s)throws MyException1{
		//Constructor call must be the first statement in a constructor 
		//// try{
				super(s);
		//// }finally{}
	}

	public void event (){
		
	}
	/**
	 * 打印this，会调用其toString()方法，产生递归调用！
	 * 
	 * 应该用super.toString()
	 */
	public String toString(){
		//// return "C :" + this;
		return "C :" + super.toString();
	}
}

public class Ch11_4_Inherit {
	public static void main(String[] args) {
		P c;
		try {
			c = (P) new C();
			c.event();
			c.event2();
		} catch (MyException1 e) {
			e.printStackTrace();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
		
		
		try {
			c = new C();
			
			//java.lang.StackOverflowError 因为递归调用
			System.out.println(c);
		} catch (MyException1 e) {
			e.printStackTrace();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
