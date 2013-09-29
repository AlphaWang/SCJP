/**
 * <p>文件名称: Callbacks.java </p>
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


/**
 * 闭包：闭包是一个可调用的对象，它记录了一些来自 创建它的作用域 的信息
 *
 */



interface Incrementable{
	void increment();
}
//Callee1： 常规实现
class Callee1 implements Incrementable{
	private int i = 0;
	public void increment() {
		i++;
		System.out.println(i);
	}

}

//Callee2：内部类实现
class MyIncrement {
	public void increment(){
		System.out.println("MyIncrement.increment()");
	}
	static void method(MyIncrement mi){
		mi.increment();
	}
}
class Callee2 extends MyIncrement {
	private int i = 0;
	@Override
	public void increment(){//继承自父类
		super.increment();
		i++;
		System.out.println(i);
	}	
	//内部类：闭包	
	private class Closure implements Incrementable{
		public void increment() {
			Callee2.this.increment();
		}
	}
	//钩子？
	Incrementable getCallbackRef(){
		return new Closure();
	}
	
}








class Caller{
	private Incrementable callbackRef;
	Caller(Incrementable cb){
		callbackRef = cb;
	}
	void go(){
		callbackRef.increment();
	}
}

public class Callbacks {
	public static void main(String[] args){
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.method(c2);
		
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackRef());
		
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}
