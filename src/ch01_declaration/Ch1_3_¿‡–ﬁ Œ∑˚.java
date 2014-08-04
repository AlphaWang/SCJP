/**
 * <p>文件名称: ch1_3_类修饰符.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-9</p>
 * <p>完成日期：2010-9-9</p>
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

import java.util.Date;

/**
 * 1. 看到考题有复杂逻辑时，首先要观察访问修饰符，很可能导致编译错误
 * 
 * 2. 访问修饰符：public, protected, private  | 非内部类 只可用public 或默认
 *    非访问修饰符：strictfp, final, abstract | 没有strictfp变量
 */
public class Ch1_3_类修饰符 {
	
	public static void main(String[] args){
		System.out.println("==== normal Class ====="); 
		float aFloat = 0.6710339f; 
		double aDouble = 0.04150553411984792d; 
		double sum = aFloat + aDouble; 
		float quotient = (float)(aFloat / aDouble); 
		System.out.println("float: " + aFloat); 
		System.out.println("double: " + aDouble); 
		System.out.println("sum: " + sum); 
		System.out.println("quotient: " + quotient); 
		System.out.println("==== strictfp Class ====="); 
		
		StrictfpClass o2 = new StrictfpClass();
		o2.count();
	}
	private class InnerClass{}
	protected class InnerClass2{}
}
/**
 * 3. 非内部类，不可用private/protected修饰符；
 *             只能用public 或者 默认
 */
//// private class PrivateClass{}
//// protected class ProtectedClass{}
/**
 * 4. 不能将类同时标识为final、abstract
 */
//// abstract final class AbstractClass{}

/**
 * 5. strictfp：strict float point(精确浮点)。
 *    表示类中所有方法代码在处理浮点数时，遵守IEEE754标准
 *    
 *    如果你想让你的浮点运算更加精确，而且不会因为不同的硬件平台所执行的结果不一致的话，可以用关键字strictfp
 */
strictfp class StrictfpClass{
	public void count(){
		float aFloat = 0.6710339f; 
		double aDouble = 0.04150553411984792d; 
		double sum = aFloat + aDouble; 
		float quotient = (float)(aFloat / aDouble); 
		System.out.println("float: " + aFloat); 
		System.out.println("double: " + aDouble); 
		System.out.println("sum: " + sum); 
		System.out.println("quotient: " + quotient); 
	}
}
/**
 * 6. final: 此类将不允许被扩展，可保证安全性
 *           但如果该类的某个方法有问题，则无法通过子类来修改
 */
final class FinalClass{}
//// class SubClass extends FinalClass{}
/**
 * 7. abstract：抽象类，永不能被实例化，唯一目的是用于被扩展
 * 
 *    abstract方法 以;结尾，没有{}
 */
 abstract class AbstractClass{
	private String model;//子类不能访问
	String type;
	public void setType() {}//这个不是抽象方法
	public abstract void setModel();//abstract方法 以;结尾，没有{}
	                                //类中有abstract方法，则类必为abstract
}
class SubClass extends AbstractClass{
	public void setModel() {
		super.type = "";
	}
}
