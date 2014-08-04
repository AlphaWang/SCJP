//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2014
//             A G F A - G E V A E R T  G R O U P
//                    All Rights Reserved
/////////////////////////////////////////////////////////////////
//
//       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                    Agfa-Gevaert Group
//      The copyright notice above does not evidence any
//     actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//
//
package ch02_OO;

public class Ch2_3_StaticDispatch {
	
	static abstract class Human {
		void say() {
			System.out.println("I am a Human");
		}
	}
	static class Man extends Human {
		@Override
		void say() {
			System.out.println("I am a man");
		}
	}
	static class Woman extends Human {
		@Override
		void say() {
			System.out.println("I am a women");
		}
	}
	
	public void sayHello (Human h) {
		System.out.println("Hello, guy!");
	}
	
	public void sayHello (Man h) {
		System.out.println("Hello, man!");
	}
	
	public void sayHello (Woman h) {
		System.out.println("Hello, lady!");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Human man = new Man();
		Human woman = new Woman();
		
		Ch2_3_StaticDispatch  dispath = new Ch2_3_StaticDispatch ();
		/**
		 * Overload - 静态分派
		 * 编译器在重载时，是通过参数的静态类型来选择；而不是实际类型！
		 */
		dispath.sayHello(man); // Hello, guy!
		dispath.sayHello(woman); // Hello, guy!
		
		/**
		 * Override - 动态分派
		 * 根据实际类型！
		 */
		man.say(); // I am a man
		woman.say(); // I am a women
	}

}
