/**
 * <p>文件名称: Ch1_1_构造器内多态方法.java </p>
 * <p>创建日期：2011-12-12</p>
 * @version 1.0
 * @author WangZhongXing192063
 */
package ch01_declaration;

public class Ch1_1_PolyInConstructor {
	String name;
	void draw(){
		System.out.println("父类draw()");
	}
	Ch1_1_PolyInConstructor(){
		
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
	
	Ch1_1_PolyInConstructor(String s){
		this();
	}

}
