/**
 * <p>文件名称: Ch5_3_Exception.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-18</p>
 * <p>完成日期：2011-1-18</p>
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
package ch05_flowControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.naming.NamingException;

public class Ch5_3_Exception 
{
	static String s = "-";
	public static void main(String[] args)
	{
		/**
		 * 1. catch子句：最具体的异常 必须放在更一般的异常处理程序上面，否则无法编译
		 */
		//如果IOException在前
		//Unreachable catch block for FileNotFoundException. 
		//It is already handled by the catch block for IOException
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("test.txt", "r");
			byte[] b = new byte[1000];
			raf.readFully(b,0,1000);
		} catch (FileNotFoundException e1) {
		} catch (IOException e) {
		}
		System.out.println("try-catch-finally结束1");
		
		
		
		/**
		 * 2. finally子句：总是会执行,除非try catch中调用了System.exit()
		 *    常用于对资源进行清理
		 * 
		 * try后要么有catch，要么有finally，要么二者都有。不能二者都省略！
		 * ————为什么可以只有try和finally？不需要处理异常？——RuntimeException
		 */
		
		try{
			//// int x = 5/0;
		}finally{
			System.out.println("finally -by 0");
		}
		System.out.println("try-catch-finally结束2");
		
		try{
			throw new Exception();
		}catch(Exception e){
			try{
				try{
					throw new Exception();
				}catch(Exception ex){
					s += "catch1 ";
				}finally{
					s += "finally1 ";
				}
				throw new Exception();
			}catch (Exception x ){
				s += "catch2 ";
			}finally{
				s += "finally2 ";
			}
			s += "catch3 ";
		}finally{
			s += "finally3";
		}
		System.out.println(s);
		System.out.println("try-catch-finally结束3");
		
		
		try {
			Thread.sleep(100);
			System.out.println("try");
			/**
			 * 有return,也会执行finally
			 */
			return;
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("catch");
		}
		finally {
			System.out.println("finally！");
			
		}
		System.out.println("try-catch-finally结束4");
		
		
		//test2();
	}
	/**
	 * 3. 异常声明
	 * a) 任何可能抛出的异常，都必须声明，除非是RuntimeException的子类
	 * b) 被声明的异常，不一定会被抛出
	 * c)
	 */
	void test() throws IOException, NamingException 
	{
		throw new NamingException();
	}
	/**
	 * 抛出RuntimeException的子类，无需声明！
	 */
	static void test2()
	{
		test2();
		System.out.println("s2");
		throw new ArrayIndexOutOfBoundsException();
		
	}
	
	void test3() 
	{
		try {
			throw new NamingException();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void test4() 
	{
		test3();
	}
	/**
	 * 抛出Error及其子类，无需声明！
	 */
	void test5()
	{
		throw new Error();
	}
	void test6()
	{
		throw new OutOfMemoryError();
	}
	
	/**
	 * 重抛同一个异常
	 * ————catch子句中抛出的非RuntimException异常，也必须声明！
	 */
	void test7() throws NamingException, IOException
	{
		try {
			boolean isIO = false;
			if(isIO){
				throw new IOException();
			}else{
				throw new NamingException();
			}			
		} catch (IOException e){
			throw e;
		}catch (NamingException e) {
			throw e;//重抛同一个异常
		}
	}

}
