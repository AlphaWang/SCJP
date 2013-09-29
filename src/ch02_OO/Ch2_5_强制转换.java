/**
 * <p>文件名称: Ch2_5_强制转换.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-10-21</p>
 * <p>完成日期：2010-10-21</p>
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

public class Ch2_5_强制转换 {

	public static void main(String[] args)
	{
		Parent2 p = new Child2();
		/**
		 * 1. 父类引用，如果需要调用子类的方法，必须向下强制转换
		 *    强制转换之前，要进行instanceof检查！！！否则ClassCastException
		 */
		  //// p.methodC();
		  if(p instanceof Child2){
			  //// p.methodC();
			  ((Child2) p).methodC(); //子类方法
		  }
		  /**
		   * 1. 运行时异常java.lang.ClassCastException: 
		   *             ch02_OO.Parent2 cannot be cast to ch02_OO.Child2
		   */
		  //// Child2 child = (Child2)new Parent2();
		  
		  /**
		   * 2. 向上转换，无需强制进行
		   */
		  Child2 c = new Child2();
		  Parent2 p2 = c;
		  Parent2 p3 = (Parent2)c;
		  
		  p2.methodP(); //子类重写父类方法
		  p3.methodP(); //子类重写父类方法
		  
		  
	}
	
}

class Parent2
{
	void methodP(){
		System.out.println("父类方法");
	}
}
class Child2 extends Parent2
{
	void methodP(){
		System.out.println("子类重写父类方法");
	}
	void methodC(){
		System.out.println("子类方法");
	}
}


