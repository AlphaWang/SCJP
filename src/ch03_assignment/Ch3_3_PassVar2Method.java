/**
 * <p>文件名称: Ch3_3_向方法传递变量.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-12-28</p>
 * <p>完成日期：2010-12-28</p>
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
package ch03_assignment;

public class Ch3_3_PassVar2Method 
{
	/**
	 * 1. 传递对象引用：
	 *    传递的是对象引用的一个副本，而非实际的对象引用，更非实际的对象
	 *    
	 *    因为引用、引用副本都指向同一个对象，所以对“引用副本的状态”修改 会影响到“引用的状态”
	 */
	
	
	void changeIt(Bar bar){
		bar.size = 99;
		System.out.println("changeIt()执行中："+bar.size);
	}
	public static void main(String[] args)
	{
		Ch3_3_PassVar2Method obj = new Ch3_3_PassVar2Method();
		Bar bar= new Bar();
		System.out.println("初始状态："+bar.size);
		obj.changeIt(bar);
		System.out.println("结束状态："+bar.size);
	}
	
	/**
	 * 2.传递基本变量
	 *   传递的是基本变量的位副本，——按值传递
	 *   
	 */
}
class Bar{
	int size = 28;
}