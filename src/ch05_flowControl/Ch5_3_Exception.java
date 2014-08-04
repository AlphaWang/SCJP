/**
 * <p>�ļ�����: Ch5_3_Exception.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-18</p>
 * <p>������ڣ�2011-1-18</p>
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
		 * 1. catch�Ӿ䣺�������쳣 ������ڸ�һ����쳣����������棬�����޷�����
		 */
		//���IOException��ǰ
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
		System.out.println("try-catch-finally����1");
		
		
		
		/**
		 * 2. finally�Ӿ䣺���ǻ�ִ��,����try catch�е�����System.exit()
		 *    �����ڶ���Դ��������
		 * 
		 * try��Ҫô��catch��Ҫô��finally��Ҫô���߶��С����ܶ��߶�ʡ�ԣ�
		 * ��������Ϊʲô����ֻ��try��finally������Ҫ�����쳣������RuntimeException
		 */
		
		try{
			//// int x = 5/0;
		}finally{
			System.out.println("finally -by 0");
		}
		System.out.println("try-catch-finally����2");
		
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
		System.out.println("try-catch-finally����3");
		
		
		try {
			Thread.sleep(100);
			System.out.println("try");
			/**
			 * ��return,Ҳ��ִ��finally
			 */
			return;
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("catch");
		}
		finally {
			System.out.println("finally��");
			
		}
		System.out.println("try-catch-finally����4");
		
		
		//test2();
	}
	/**
	 * 3. �쳣����
	 * a) �κο����׳����쳣��������������������RuntimeException������
	 * b) ���������쳣����һ���ᱻ�׳�
	 * c)
	 */
	void test() throws IOException, NamingException 
	{
		throw new NamingException();
	}
	/**
	 * �׳�RuntimeException�����࣬����������
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
	 * �׳�Error�������࣬����������
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
	 * ����ͬһ���쳣
	 * ��������catch�Ӿ����׳��ķ�RuntimException�쳣��Ҳ����������
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
			throw e;//����ͬһ���쳣
		}
	}

}
