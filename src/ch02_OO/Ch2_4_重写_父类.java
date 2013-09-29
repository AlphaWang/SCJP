/**
 * <p>文件名称: Ch2_3_重写_父类.java </p>
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ch2_4_重写_父类 {
	//父类静态变量
	public static String staticVar = "pStaticVar";
	//测试重载
	public void eat(){
		System.out.println("父类eat()");
	}
	
	public void eat(String arg){
		System.out.println("父类eat(String)"+arg);
	}
	
	
	
	public void eat(HashMap map){
		
	}
	public void eat2(Map map){
		
	}
	//测试返回类型
	public Ch2_4_重写_父类 getInstance()
	{
		return new Ch2_4_重写_父类();
	}
	//父类private方法
	private void privateMethod()
	{
		System.out.println("父类private方法");
	}
	//父类final方法
	public final void finalMethod()
	{
		System.out.println("父类final方法");
	}
	//父类static方法
	public static void staticMethod()
	{
		System.out.println("父类static方法");
	}
	//父类方法可以声明抛出异常
	public void ioExceptionMethod() throws IOException
	{
		System.out.println("父类中的IOException方法");
	}
	//父类方法可以声明抛出异常
	public void classCastExceptionMethod() throws ClassCastException
	{
		System.out.println("父类中的ClassCastException方法");
	}

}
