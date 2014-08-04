/**
 * <p>文件名称: Ch2_8_构造方法.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-11-2</p>
 * <p>完成日期：2010-11-2</p>
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
import java.text.DateFormat;
import java.util.*;

public class Ch2_8_Constructor 
{
	
	
	/**
	 * 0. 构造方法的两个特点：
	 *    a) 没有任何返回类型
	 *    b) 方法名与类名 完全一致
	 *    
	 * 抽象类：有构造方法————总是在实例化具体子类时才调用
	 *   接口：无构造方法————接口不是对象继承树的一部分
	 */

	public Ch2_8_Constructor(String s)
	{
		//this(3);
		System.out.println("调用String构造方法");

	}
	/**
	 * 1. 如果要在构造方法中用this()/super()，则必须放在第一句 
	 *    ————构造方法的第一行，必定为this()或super()
	 */
	public Ch2_8_Constructor(int i)
	{
		//this("");
		System.out.println("调用int构造方法");
		//// this();
		
	}
	/**
	 * 2. 调用构造函数：只能从其他"构造函数"内部进行调用
	 *    ————不可这样：
	 */
	public void aMethod(){
		//// Ch2_8_构造方法();
	}
	public static void main(String[] args)
	{
		/**
		 * 3. 注意内部类的构造方法调用：
		 */
		new Ch2_8_Constructor("s");
		new Ch2_8_Constructor(3);
		
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		
		new SubClass(2);			
	}
	
	
	
	
}
class OuterClass
{
	class InnerClass
	{
    }
}

/**
 *  4.如果父类没有默认构造方法，而子类需要无参数构造方法，则必须手工定义该无参数构造方法，
 *                                                      并显式调用super(x)
 */
class SubClass extends Ch2_8_Constructor
{
	String s;
	public SubClass()
	{
		super("");
		/**
		 * ！！5. 在父类构造方法运行之前，不可访问自身的实例方法、实例变量！（静态方法、静态变量 则可以）
		 *        ————涉及到类初始化的顺序！！！！！！！！！
		 *    
		 *    Cannot refer to an instance field s while explicitly invoking a constructor
		 */
		 //// super(s);
	}
	protected SubClass(int i)
	{
		/**
		 * 1. 如果要在构造方法中用this()/super()，则必须放在第一句 
		 *    即，不能同时用this()/super()
		 */
		super(i);
		//this();
		System.out.println("调用子类int构造方法");
	}
	
	
	/**
	 * 6. 不能重写父类的构造方法
	 */
	
	//// public Ch2_8_构造方法(int i){ }
	
}