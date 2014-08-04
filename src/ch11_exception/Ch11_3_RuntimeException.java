/**
 * <p>文件名称: Ch11_3_RuntimeException.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2012-1-18</p>
 * <p>完成日期：2012-1-18</p>
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
 * RuntimeException及其子类 是“不受检查异常”，可以不捕获。
 * 如果RuntimeException未被捕获而直达main(), 那么在程序退出前将调用printStackTrace()
 *
 */
public class Ch11_3_RuntimeException {

	static void f(){
		System.out.println("执行f()，抛出RuntimeException");
		throw new RuntimeException();
	}
	static void g(){
		System.out.println("执行g()，调用f()");
		f();
	}
	static void h(){
		System.out.println("执行h()，抛出RuntimeException");
		throw new RuntimeException();
	}
	public static void main(String[] args) {
		
		try{
			h();
		}catch(RuntimeException e){
			System.out.println("main()捕获RuntimeException");
		}
		
		g();
		
	}

}
