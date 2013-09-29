/**
 * <p>文件名称: Ch2_3_重写_子类.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-10-9</p>
 * <p>完成日期：2010-10-9</p>
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

import java.util.HashMap;
import java.util.Map;

public class Ch2_4_重写_子类 extends Ch2_4_重写_父类{
	
	public static String staticVar2 = "cStaticVar2";
	public static String staticVar = "cStaticVar：子类重新定义";
	
	//重写父类方法
	@Override	
	public void eat() {
		System.out.println("子类重写的eat()");
		super.eat("test");//用super.method()调用本方法的超类版本
		
	}
	@Override	
	public void eat(final HashMap map){
		
	}
	//重写的方法，参数必须完全一致————子类也不行！
	//// @Override	
	public void eat(Map map){
		
	}
	
	/**重载父类方法时，输入参数被缩小，不符合里氏替换原则
	 * 父类：public void eat2(Map map)
	 * 入参必须完全一致！！是子类也不行
	*/
	//// @Override	
	public void eat2(HashMap map){
		
	}
	/**
	 * 0. 重写方法的返回类型：可以是父类方法返回类型 的子类
	 */
	@Override	
	public Ch2_4_重写_子类 getInstance()
	{
		return new Ch2_4_重写_子类();
	}
	
	/**
	 *  1. 重写的方法 权限不能缩小
	 */
	 //// private void eat(String arg){}
	
	
	/**
	 *  2. 父类中的private方法不可被重写
	 */
	//// @Override
	private void privateMethod()
	{
		System.out.println("子类中新增的private方法");
	}
	/**
	 *  3. 父类中的final方法不可被重写
	 *     注意，若父类final方法是private的，则子类可以重新定义
	 *     
	 *     //用super.method()调用本方法的超类版本
	 */
	/*
	public final void finalMethod()
	{
		System.out.println("子类中不能重写final方法");
	}
	*/
	/**
	 *  4. 父类中的static方法不可被重写。但是子类可以新增！！
	 */
	//// @Override
	public static void staticMethod()
	{
		System.out.println("子类中新增的static方法");
	}
	/**
	 *  5. 子类重写的方法抛出的异常，不可比原方法更宽、或更多
	 *  例外：可以抛出父类中没有的 RuntimeException
	 */
	
	/*
	@Override
	public void classCastExceptionMethod() throws IOException 
	{
		System.out.println("子类重写的ClassCastException方法");
	}
	*/
	
	/**
	 * ??? 父类方法抛出ClassCastException，子类重写 不可抛IOException
	 *     父类方法抛出IOException，       子类重写 可抛ClassCastException
	 *
	 */
	@Override
	public void ioExceptionMethod() throws ClassCastException
	{
		System.out.println("子类重写的ioExceptionMethod() throws ClassCastException");
	}
	
	
	
	//子类新增方法
	public void childMethod()
	{
		System.out.println("子类新增的方法childMethod()");
	}
	
	

	public static void main(String[] args)
	{
		Ch2_4_重写_父类 pp = new Ch2_4_重写_父类();
		Ch2_4_重写_父类 pc = new Ch2_4_重写_子类();
		Ch2_4_重写_子类 cc = new Ch2_4_重写_子类();
		
		pp.eat();  //父类eat()
		/**
		 * 3.如果是父类的引用，则只能调用父类方法
		 */
		pc.eat();  //子类重写eat()
		//pc.childMethod();
		//父类的private方法，无权访问
		//pc.privateMethod();
		
		cc.eat();  //子类重写eat()
		cc.privateMethod();
		cc.childMethod();
		/**
		 * 4. 父类的static变量，可以继承
		 */
		String s1 = cc.staticVar;
		String s2 = cc.staticVar2;
		String s3 = Ch2_4_重写_父类.staticVar;
		System.out.println("cc.staticVar: "+s1+"\ncc.staticVar2："+s2+"\nCh2_4_重写_父类.staticVar："+s3);
		/**
		 * 5. 多态只适用于实例方法；不适用于 实例变量
		 *    此处应用的是父类变量，相当于：Ch2_4_重写_父类.staticVar
		 */
		System.out.println("pc.staticVar: "+pc.staticVar);
	}

}
