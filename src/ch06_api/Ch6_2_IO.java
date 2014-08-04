/**
 * <p>文件名称: Ch6_2_IO.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-28</p>
 * <p>完成日期：2011-1-28</p>
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

public class Ch6_2_IO {

	public static void main(String[] args) {
		/**
		 * 1. File
		 *    不是用于实际读写数据；是文件或目录路径名的抽象表示
		 *    
		 *    创建File类，不会新增一个文件
		 */
		//创建File类，不会新增一个文件
		File file1 = new File("不包装.txt");
		out.println("file.exists() : "+file1.exists());
		try {
			//createNewFile()：如果文件不存在，则创建
			boolean newFile = file1.createNewFile();
			out.println("file.createNewFile() : "+newFile);
		} catch (IOException e) {e.printStackTrace();}
		out.println("file.exists() : "+file1.exists());
		
		
		/**
		 * 2. 包装
		 *    FileReader一般由更高级的对象包装 >> BufferedReader
		 *    FileWriter一般由更高级的对象包装 >> BufferedWriter / PrintWriter
		 *    ——以便提高性能、提供更高级更灵活的读写方法
		 */
		/*
		 * 1) 不包装
		 */
		out.println("=========不包装：" );
		try {
			FileWriter fw = new FileWriter(file1);
			fw.write("FileWriter写入第一行\nFileWriter写入第二行\n");//缺点：需要手工输入换行
			
			//flush(): 强行将缓冲区中的内容输出，否则直到缓冲区满后才会一次性的将内容输出 
			//         Causes all currently buffered information to be written to the output stream
			//         ——只在写文件时需要！
			fw.flush();
			fw.close();
		} catch (IOException e) {	e.printStackTrace();}
		
		
		try {
			FileReader fr = new FileReader(file1);
			char [] in = new char[11];
			//read()读取整个文件，每次一个字符 存入char[]，返回字符数目
		    //缺点：如果char[]设置的不够大，则会截取文件的一部分
			int size = fr.read(in);
			out.println("file size:" + size);
			out.println("file content:" );
			for (char c : in){
				out.println(c);
			}
			fr.close();
		} catch (FileNotFoundException e) {	e.printStackTrace();} 
		  catch (IOException e) {e.printStackTrace();}
		  
		  
		  /*
		   * 2) 包装
		   */
		  out.println("=========包装：" );
		  File file = new File("包装.txt");
		  try {
			//!!!当创建一个Writer或Stream,若File不存在，会自动创建！
			FileWriter 		fw2 = new FileWriter(file);
			BufferedWriter	bw 	= new BufferedWriter(fw2);   //可以从FileWriter包装到BufferedWriter		
			
			PrintWriter 	pw 	= new PrintWriter(fw2);      //更常从FileWriter包装到PrintWriter！！			
			PrintWriter 	pw2 = new PrintWriter(file);     //Java5可以从File包装到PrintWriter
			
			pw.println();
			pw.print("PrintWriter.print()写入第2行");
			pw.print(", append");
			pw.append('-');
			pw.println();
			pw.println("PrintWriter.println()写入第3行");
			pw.write("PrintWriter.write()写入第4行");
			
			pw.flush();
			pw.close();
		} catch (IOException e) {e.printStackTrace();}
		
		try {
			FileReader fr2 = new FileReader(file);
			BufferedReader br = new BufferedReader(fr2);//更常从FileReader包装到BufferedReader
			
			
			String data = br.readLine();
			out.println("br.readLine():" + data);
			String data2 = br.readLine();
			out.println("br.readLine():" + data2);
			
			//测试br.read();
			char [] in = new char[6];
			out.println("br.read(char[])："+br.read(in));
			for (char c : in){
				out.println(c);
			}
			br.close();
	
		} catch (FileNotFoundException e) {e.printStackTrace();	} 
		  catch (IOException e) {e.printStackTrace();	}
		
		  
		  /**
		  *  注：第二次创建File，Writer写入之后，会把原来的内容冲掉？？
		  */
			File file2 = new File("不包装.txt");
			//createNewFile()：如果文件不存在，则创建
			try {
				boolean newFile = file2.createNewFile();
				out.println("再次创建不包装.txt："+newFile);
				
				PrintWriter pw4 = new PrintWriter(new FileWriter(file2));
				//pw4.println("new line");
				pw4.append("new line");  //也是重新写
				
				pw4.flush();
				pw4.close();
			} catch (IOException e) {e.printStackTrace();}
		  
		  /**
		   * 3. 处理文件和目录
		   */
		  /*
		   * 当创建一个Writer或Stream,若File不存在，会自动创建！
		   * 但是不会自动创建Dir
		   */
		  out.println("=========处理文件：" );
		  try {
			  File myDir = new File("myDir");
			  out.println("myDir.isDirectory():"+myDir.isDirectory()) ;
			  
			  //不会自动创建Dir, 下一句mkdir()必须要有！！！
			  myDir.mkdir();
			  File myFile = new File(myDir, "myFile.txt");
			  File myFile2 = new File(myDir, "myFile2.txt");
			  
			  //当创建一个Writer或Stream,若File不存在，会自动创建！（但dir不会自动创建！）
			  myFile.createNewFile();
			  myFile2.createNewFile();
			  
			  out.println("PrintWriter写入文件") ;
			  PrintWriter pw2 = new PrintWriter(myFile);
			  pw2.println("PrintWriter写入 myFile文件内容");
			  pw2.flush();
			  pw2.close();
			  
			 out.println("myDir.isDirectory():"+myDir.isDirectory()) ;
			 /*
			  * delete(): 当dir不为空，则无法delete()
			  */
			 out.println("myDir.delete():"+myDir.delete());
			 
			 /*
			  * renameTo(File): 参数File要注意目录层次
			  * 如果改名后会导致重名，则不修改
			  */
			 File newFile = new File(myDir,"new file.txt");
			 myFile.renameTo(newFile);
			 
			 /*
			 * renameTo(File):即使dir不为空，也可以renameTo()
			 */
			 File newDir = new File("myNewDir");
			 myDir.renameTo(newDir);
			 
			 //myDir经过重命名renameTo()之后, 即不存在，exists()返回为F
			 out.println("myDir.isDirectory():"+myDir.isDirectory()) ;
			 out.println("myDir.exists():"+myDir.exists()) ;
			 out.println("newDir.isDirectory():"+newDir.isDirectory()) ;
			 
			 String[] files0 = myDir.list();//myDir已不存在！
			 String[] files = newDir.list();
			 out.println("myDir.list():");
			 //空指针
			 //// for(String s : files0){
			 ////  out.println(s);
			 //// }
			 out.println("newDir.list():");
			 for(String s : files){
				 out.println("--"+s);
			 }
		} catch (IOException e) {e.printStackTrace();	}
		
		
		

	}

}
