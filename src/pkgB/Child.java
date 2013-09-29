/**
 * <p>文件名称: Child.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-31</p>
 * <p>完成日期：2011-3-31</p>
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
package pkgB;
import pkgA.*;

public class Child extends Parent{
	public static void main(String[] args){
		Child c2 = new Child();
		c2.testAuth();
		
	}
	public void testAuth()
	{
		Parent p = new Parent();
		Child c = new Child();
		System.out.println(p.publicVar);
		System.out.println(c.publicVar);
		
		System.out.println(p.defaultVar);
		System.out.println(c.defaultVar);
		
		System.out.println(p.protectedVar);//不能通过父类引用访问其protected方法！
		System.out.println(super.protectedVar);//??
		System.out.println(c.protectedVar);
		
		System.out.println(p.privateVar);			
		System.out.println(c.privateVar);
	}

}
