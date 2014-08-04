/**
 * <p>文件名称: 合法.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-8</p>
 * <p>完成日期：2010-9-8</p>
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
import static java.lang.System.out;


/**
 * 1. 合法标识符必须仅由Unicode字符、数字、货币符号、连字符组成
 * 2. 不能以数字开头
 *
 */
public class Ch1_2_Identifier {
	int _a;
	int $a;
	//// int e/;
	//// int e#;
	//// int \n;
	//// int e.;
	//// int 2b;
	int e$;
	
	/**
	 * 汉字也是Unicode字符！
	 */
	int 变量 = 420;
	int 数字2 = 2;
	//// int 数字3； = 3;
	//// int 数字4—— = 4;
	
	public static void main (String[] args)
	{
		Ch1_2_Identifier obj = new Ch1_2_Identifier();
		out.println(obj.变量);  //420
		out.println(obj.数字2);   //2
		obj.打印();
	}
	public void 打印()
	{
		out.println("方法中文名()");
	}
	/**
	 * 内部类的访问修饰符，可以不为public、默认 
	 *
	 */
	protected class InnerClass1{}
	private class InnerClass2{}
	/*
	 * 扩展：
	 * protected内部类，默认的构造方法也是protected，
	 * 所以在外部类子类中，就不能调用 new InnerClass1()
	 */

}
/**
 * 外部类的访问修饰符，只能为public、默认 
 *
 */

//// protected class Class1{}
//// private class Class2{}

