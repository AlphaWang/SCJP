/**
 * <p>�ļ�����: Ch6_2_IO.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-28</p>
 * <p>������ڣ�2011-1-28</p>
 * <p>�޸ļ�¼1: // �޸���ʷ��¼�������޸����ڡ��޸��߼��޸�����</p>
 * <pre>
 *    �޸����ڣ�
 *    �� �� �ţ�
 *    �� �� �ˣ�
 *    �޸����ݣ�
 * </pre>
 * <p>�޸ļ�¼2����</p>
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
		 *    ��������ʵ�ʶ�д���ݣ����ļ���Ŀ¼·�����ĳ����ʾ
		 *    
		 *    ����File�࣬��������һ���ļ�
		 */
		//����File�࣬��������һ���ļ�
		File file1 = new File("����װ.txt");
		out.println("file.exists() : "+file1.exists());
		try {
			//createNewFile()������ļ������ڣ��򴴽�
			boolean newFile = file1.createNewFile();
			out.println("file.createNewFile() : "+newFile);
		} catch (IOException e) {e.printStackTrace();}
		out.println("file.exists() : "+file1.exists());
		
		
		/**
		 * 2. ��װ
		 *    FileReaderһ���ɸ��߼��Ķ����װ >> BufferedReader
		 *    FileWriterһ���ɸ��߼��Ķ����װ >> BufferedWriter / PrintWriter
		 *    �����Ա�������ܡ��ṩ���߼������Ķ�д����
		 */
		/*
		 * 1) ����װ
		 */
		out.println("=========����װ��" );
		try {
			FileWriter fw = new FileWriter(file1);
			fw.write("FileWriterд���һ��\nFileWriterд��ڶ���\n");//ȱ�㣺��Ҫ�ֹ����뻻��
			
			//flush(): ǿ�н��������е��������������ֱ������������Ż�һ���ԵĽ�������� 
			//         Causes all currently buffered information to be written to the output stream
			//         ����ֻ��д�ļ�ʱ��Ҫ��
			fw.flush();
			fw.close();
		} catch (IOException e) {	e.printStackTrace();}
		
		
		try {
			FileReader fr = new FileReader(file1);
			char [] in = new char[11];
			//read()��ȡ�����ļ���ÿ��һ���ַ� ����char[]�������ַ���Ŀ
		    //ȱ�㣺���char[]���õĲ���������ȡ�ļ���һ����
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
		   * 2) ��װ
		   */
		  out.println("=========��װ��" );
		  File file = new File("��װ.txt");
		  try {
			//!!!������һ��Writer��Stream,��File�����ڣ����Զ�������
			FileWriter 		fw2 = new FileWriter(file);
			BufferedWriter	bw 	= new BufferedWriter(fw2);   //���Դ�FileWriter��װ��BufferedWriter		
			
			PrintWriter 	pw 	= new PrintWriter(fw2);      //������FileWriter��װ��PrintWriter����			
			PrintWriter 	pw2 = new PrintWriter(file);     //Java5���Դ�File��װ��PrintWriter
			
			pw.println();
			pw.print("PrintWriter.print()д���2��");
			pw.print(", append");
			pw.append('-');
			pw.println();
			pw.println("PrintWriter.println()д���3��");
			pw.write("PrintWriter.write()д���4��");
			
			pw.flush();
			pw.close();
		} catch (IOException e) {e.printStackTrace();}
		
		try {
			FileReader fr2 = new FileReader(file);
			BufferedReader br = new BufferedReader(fr2);//������FileReader��װ��BufferedReader
			
			
			String data = br.readLine();
			out.println("br.readLine():" + data);
			String data2 = br.readLine();
			out.println("br.readLine():" + data2);
			
			//����br.read();
			char [] in = new char[6];
			out.println("br.read(char[])��"+br.read(in));
			for (char c : in){
				out.println(c);
			}
			br.close();
	
		} catch (FileNotFoundException e) {e.printStackTrace();	} 
		  catch (IOException e) {e.printStackTrace();	}
		
		  
		  /**
		  *  ע���ڶ��δ���File��Writerд��֮�󣬻��ԭ�������ݳ������
		  */
			File file2 = new File("����װ.txt");
			//createNewFile()������ļ������ڣ��򴴽�
			try {
				boolean newFile = file2.createNewFile();
				out.println("�ٴδ�������װ.txt��"+newFile);
				
				PrintWriter pw4 = new PrintWriter(new FileWriter(file2));
				//pw4.println("new line");
				pw4.append("new line");  //Ҳ������д
				
				pw4.flush();
				pw4.close();
			} catch (IOException e) {e.printStackTrace();}
		  
		  /**
		   * 3. �����ļ���Ŀ¼
		   */
		  /*
		   * ������һ��Writer��Stream,��File�����ڣ����Զ�������
		   * ���ǲ����Զ�����Dir
		   */
		  out.println("=========�����ļ���" );
		  try {
			  File myDir = new File("myDir");
			  out.println("myDir.isDirectory():"+myDir.isDirectory()) ;
			  
			  //�����Զ�����Dir, ��һ��mkdir()����Ҫ�У�����
			  myDir.mkdir();
			  File myFile = new File(myDir, "myFile.txt");
			  File myFile2 = new File(myDir, "myFile2.txt");
			  
			  //������һ��Writer��Stream,��File�����ڣ����Զ�����������dir�����Զ���������
			  myFile.createNewFile();
			  myFile2.createNewFile();
			  
			  out.println("PrintWriterд���ļ�") ;
			  PrintWriter pw2 = new PrintWriter(myFile);
			  pw2.println("PrintWriterд�� myFile�ļ�����");
			  pw2.flush();
			  pw2.close();
			  
			 out.println("myDir.isDirectory():"+myDir.isDirectory()) ;
			 /*
			  * delete(): ��dir��Ϊ�գ����޷�delete()
			  */
			 out.println("myDir.delete():"+myDir.delete());
			 
			 /*
			  * renameTo(File): ����FileҪע��Ŀ¼���
			  * ���������ᵼ�����������޸�
			  */
			 File newFile = new File(myDir,"new file.txt");
			 myFile.renameTo(newFile);
			 
			 /*
			 * renameTo(File):��ʹdir��Ϊ�գ�Ҳ����renameTo()
			 */
			 File newDir = new File("myNewDir");
			 myDir.renameTo(newDir);
			 
			 //myDir����������renameTo()֮��, �������ڣ�exists()����ΪF
			 out.println("myDir.isDirectory():"+myDir.isDirectory()) ;
			 out.println("myDir.exists():"+myDir.exists()) ;
			 out.println("newDir.isDirectory():"+newDir.isDirectory()) ;
			 
			 String[] files0 = myDir.list();//myDir�Ѳ����ڣ�
			 String[] files = newDir.list();
			 out.println("myDir.list():");
			 //��ָ��
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
