/**
 * <p>文件名称: Ch3_6_重载.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-4</p>
 * <p>完成日期：2011-1-4</p>
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

public class Ch3_6_重载 {
	// >>>>Ch2_4_重载.java
	public static void main(String[] args) 
	{
		/**
		 * 1.考虑以下因素对重载的影响：
		 * 1）加宽
		 * 2）装箱
		 * 3）var-arg
		 */
		
		/**
		 * 当找不到精确的方法匹配时，JVM会使用一个方法，它 带有比参数更宽的最小变元
		 * ————加宽
		 */
		byte b = 127; 
		go(b);  //go(double)
		long l = 5;
		go(l);  //go(double)

		/**
		 * 加宽--装箱，JVM会选择加宽！
		 * ————装箱时java5新增的，它不应影响老代码的行为
		 */
		int i = 127;
		go(i);    //go(Integer)
		          //go(double)！！
		/**
		 * 加宽--vararg，JVM会选择加宽！
		 * ————vararg是Java5新增的，它不应影响老代码的行为
		 */
		byte b2 = 5;
		go(b2,b2);//go(byte...)
		          //go(int, int)！！
		/**
		 *  装箱--var-arg ?????，JVM会选择装箱！
		 *  ————var-arg比装箱更宽松，它能处理任意个数的参数。类似于异常处理 捕获所有
		 */
		
		
		
		
		/**
		 * 
		 * 2. 加宽引用变量
		 * ————引用加宽 依赖于继承
		 * ————包装器 不能加宽。因为包装器之间是平等的。
		 */
		/**
		 * 参数Byte，不能加宽到Long
		 */
		Byte b3 = new Byte("2");
		//// test(b3);  //Byte不会加宽到Long   //The method test(Long) in the type Ch3_6_重载 is not applicable for the arguments (Byte)
		
		
		
		
		
		/**
		 * ！！不能"先加宽、后装箱"
		 * 参数byte，不能"先加宽、后装箱"到Long
		 * byte => long => Long (NNN)
		 */
		byte b4 = 2;
		//// test(b4);
		//The method test(Long) in the type Ch3_6_重载 is not applicable for the arguments (byte)
		/**
		 * ！！可以"先装箱，后加宽"
		 * 参数byte，可以"先装箱，后加宽"到Object
		 * byte => Byte => Object (YYY)
		 */
		BoxAndWiden(b4);
		
		
	}
	/*static void go(int x){
		System.out.println("go(int)");
	}*/
	static void go(Integer i){
		System.out.println("go(Integer)");
	}
	
	static void go(double d){
		System.out.println("go(double)");
	}
	
	static void go(int i, int j){
		System.out.println("go(int, int)");
	}
	static void go(byte... x){
		System.out.println("go(byte...)");
	}
	
	/////////////////////
	static void test(Long i){
		System.out.println("test(Long)");
	}
	////////////////////
	static void BoxAndWiden(Object o){
		System.out.println("test(Object)");
	}
	

}
