/**
 * <p>文件名称: Ch11_NewException.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2012-1-17</p>
 * <p>完成日期：2012-1-17</p>
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
package ch11_exception;

/**
 * 	捕获异常后，如果重新抛出，则该异常的堆栈信息并未改变。即printStackTrace结果不变
 * 
 *  如果要更新堆栈信息，可重新抛出e.fillInStackTrace()，返回一个Throwable对象，把当前调用栈信息填入原来那个异常对象而得
 *
 */
public class Ch11_1_NewException {
	
	public static void f() throws Exception{
		System.out.println("f()抛出异常");
		throw new Exception("test exception");
	}
	
	public static void g() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("g()捕获异常: ");
			e.printStackTrace(System.out);
			System.out.println("g()重新抛出e");
			throw e;
		}
	}
	
	public static void h() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("h()捕获异常: ");
			e.printStackTrace(System.out);
			System.out.println("h()重新抛出 e.fillInStackTrace()");
			throw (Exception) e.fillInStackTrace(); //重新构造堆栈；不会追踪到f()
		}
	}
	
	public static void main(String[] args){
		try{
			f();
		}catch(Exception e){
			System.out.println("main()捕获f异常: ");
			e.printStackTrace(System.out);
		}
		/*
		f()抛出异常
		main()捕获f异常: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:60)
		*/	
		
		
		/**
		 * g()中打印的堆栈，与main()中打印的堆栈  一样！！
		 */
		System.out.println("====================");
		try{
			g();
		}catch(Exception e){
			System.out.println("main()捕获g异常: ");
			e.printStackTrace(System.out);
		}
		/*
		f()抛出异常
		g()捕获异常: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.g(Ch11_1_NewException.java:38)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:71)
		g()重新抛出e
		main()捕获g异常: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.g(Ch11_1_NewException.java:38)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:71)
		*/	
		
		/**
		 * h()中打印的堆栈，与main()中打印的堆栈  不一样！！main()打印的堆栈缺少f()信息
		 */
		System.out.println("====================");
		try{
			h();
		}catch(Exception e){
			System.out.println("main()捕获h异常: ");
			e.printStackTrace(System.out);
		}
		/*
		f()抛出异常
		h()捕获异常: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.h(Ch11_1_NewException.java:49)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:83)
		h()重新抛出 e.fillInStackTrace()
		main()捕获h异常: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.h(Ch11_1_NewException.java:54)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:83)
		*/	
	}
}


