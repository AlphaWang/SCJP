/**
 * <p>文件名称: Ch1_1_构造器内多态方法.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-12</p>
 * <p>完成日期：2011-12-12</p>
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

public class Ch1_1_构造器内多态方法 {
	String name;
	void draw(){
		System.out.println("父类draw()");
	}
	Ch1_1_构造器内多态方法(){
		
		/*
		 * Cannot refer to an instance field name while explicitly invoking a constructor
		 */
		//// this(name);
		
		System.out.println("父类构造器，draw()之前");
		/**
		 * 构造器中调用多态方法：可能被子类重写，执行结果很难预料
		 * 
		 * 构造方法准则：用尽可能简单的方法使对象进入正常状态
		 * ！构造器中尽可能避免调用其他方法；————除了final(private)方法；因为他们是前期绑定，不能被重写
		 */
		draw();
		
		System.out.println("父类构造器，draw()之后)");
	}
	
	Ch1_1_构造器内多态方法(String s){
		this();
	}

}
