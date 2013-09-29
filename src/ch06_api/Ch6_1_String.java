/**
 * <p>文件名称: Ch6_1_String.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-25</p>
 * <p>完成日期：2011-1-25</p>
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
package ch06_api;
import static java.lang.System.out;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Ch6_1_String {

	public static void main(String[] args) {
		/**
		 * 1. String：具有不可变性。
		 */
		String s = "abc";
		s.concat("def");
		s.replace('a','x');
		out.println(s); //abc
		
		/*
		 * String与内存：
		 * JVM留出一块特殊的内存区域“String常量池”，
		 * 遇到String字面值时 首先检查池内是否已存在相同的字面值，若找到，则直接提供额外引用
		 * 
		 * ————String的不可变性的原因。
		 * ————String不会被继承重写，因为是final类
		 */
		String s1 = "abc";//存入String常量池
		String s2 = new String("abc");//存入常规内存！！
		
		/**
		 * 2. StringBuffer、StringBuilder
		 *    当需要对字符串做大量修改时 适用
		 *    ——StringBuilder不是线程安全的，StringBuffer类中的方法 不是同步的
		 *    ——StringBuilder中的方法更快
		 */
		StringBuilder sb = new StringBuilder("0123456789");
		sb.insert(4, "---");//偏移量从0开始计算，插入到第四个位置。
		out.println(sb);    //0123---456789
		
		out.println(sb.substring(1, 3));//12
										//第一个偏移量 从 0 开始计算
		                                //第二个从 1 开始计算
		
		
		/**
		 * ? 每次Writer都会覆盖原来的内容？
		 */
		File file2 = new File("test.txt");
		//createNewFile()：如果文件不存在，则创建
		try {
			//boolean newFile = file2.createNewFile();
			//out.println("再次创建不包装.txt："+newFile);
			PrintWriter pw4 = new PrintWriter(new FileWriter(file2));
			pw4.println("new line");
			pw4.flush();
			pw4.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
