/**
 * <p>文件名称: Ch_3_7_垃圾收集.java </p>
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

import static java.lang.System.out;
import java.util.Date;


public class Ch3_7_垃圾收集 {

	public static void main(String[] args) 
	{
		/**
		 * 0. 请求JVM进行垃圾收集
		 */
		Runtime rt = Runtime.getRuntime();
		out.println("总内存："+rt.totalMemory());
		out.println("闲内存："+rt.freeMemory());
		Date d  = null;
		for (int i = 0;i<1000; i++){
			d = new Date();
			d = null;
		}
		out.println("程序运行后闲内存："+rt.freeMemory());
		rt.gc();
		out.println("gc()后闲内存："+rt.freeMemory());
		
		
		/**
		 * 1. 对象在何时开始符合垃圾收集条件？
		 * 
		 * 每个线程有其自己的小执行栈，每个线程有其自己的生命周期
		 * 当没有线程能够访问对象时，该对象即符合垃圾收集条件
		 * 
		 * ————如果程序中有一个"引用变量"引用对象，并且该"引用变量" 可用于一个活线程，则该对象是可到达的
		 * ————垃圾收集只针对非String对象
		 */
		//怎样使对象符合垃圾收集条件：
		/**
		 * 1) 空引用
		 */
		Date d1 = new Date();
		out.println(d1);
		d1 = null; //此时满足垃圾收集条件
		
		/**
		 * 2) 为引用变量重新赋值
		 */
		Date d2 = new Date();
		Date d3 = new Date();
		d2 = d3; //此时原来d2引用的老对象，满足垃圾收集条件
		
		/**
		 * 3) 隔离引用
		 */
		Island i1 = new Island();
		Island i2 = new Island();
		i1.i = i2;
		i2.i = i1;
		i1 = null;
		i2 = null;
		//此时，i1、i2都具有有效引用，但是是被互相引用的
		//满足垃圾收集条件
		
	}
	/**
	 * 4) 方法内创建的对象
	 * ————例外：方法返回的对象
	 */
	public Date getDate(){
		StringBuffer sb = new StringBuffer("局部变量");
		Date d = new Date();		
		return d;
		//方法结束后，sb满足垃圾收集条件
		//           而d不满足！
	}
}
class Island{
	public Island i;

	/**
	 * 2. 对象被垃圾回收之前，会运行finalize()方法。
	 * 但是不能保证对象总是被回收，故finalize()方法不能保证总是被执行
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
}
