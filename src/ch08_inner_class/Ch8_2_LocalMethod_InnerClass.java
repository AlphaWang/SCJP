package ch08_inner_class;

/**
 *  局部方法内部类：在方法内部定义类
 *
 *  使用场景：————为何不用匿名内部类
 *  当需要一个已命名的构造器，或者需要重载构造器时。
 */
class Outer2
{
	private String outerVar = "outerVar";
	
	public void doStufff(final String var)
	{
		String methodLocalVar = "methodLocalVar";
		final String methodLocalVar_Final = "methodLocalVar_Final";
		/**
		 * 1. 可以在方法内定义内部类
		 *
		 */
		//定义局部方法内部类之后，才能实例化！！！！
		//// Inner2 inner = new Inner2();
		
		class Inner2
		{
			public void seeOuter()
			{
				System.out.println("访问外部类私有变量："+outerVar);
				/**
				 * 2. 内部类对象 不能使用它所在方法的局部变量，除非局部变量标识为final	
				 *    ————因为有可能局部变量已经死亡，但内部类对象还存活
				 *    
				 *    Cannot refer to a non-final variable methodLocalVar inside an inner class defined in a different method
				 * 
				 */
			    //// System.out.println("访问方法的局部变量："+methodLocalVar);
				System.out.println("访问方法的局部final变量："+methodLocalVar_Final);
				
				/**
				 * 内部类中使用一个在其外部定义的对象，则要求必须是final的！
				 */
				System.out.println("访问final方法参数：" + var);
			}
			/**
			 * 内部类可以有构造函数
			 */
			Inner2(){
				System.out.println("Inner2()");
			}
		}
		/**
		 * 3. 局部方法内部类 只能在方法内实例化		 * 
		 *    在方法外部，不能访问该内部类Inner2！！
		 */
		Inner2 inner2 = new Inner2();
		inner2.seeOuter();
	}//end of doStufff()
	
	
}
public class Ch8_2_LocalMethod_InnerClass {

	public static void main(String[] args) 
	{
		Outer2 outer2 = new Outer2();
		outer2.doStufff("param");

	}

}
