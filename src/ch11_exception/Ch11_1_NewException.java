/**
 * <p>�ļ�����: Ch11_NewException.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2012-1-17</p>
 * <p>������ڣ�2012-1-17</p>
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
package ch11_exception;

import java.util.Date;

/**
 * 	�����쳣����������׳�������쳣�Ķ�ջ��Ϣ��δ�ı䡣��printStackTrace�������
 * 
 *  ���Ҫ���¶�ջ��Ϣ���������׳�e.fillInStackTrace()������һ��Throwable���󣬰ѵ�ǰ����ջ��Ϣ����ԭ���Ǹ��쳣�������
 *
 */
public class Ch11_1_NewException {
	
	public static void f() throws Exception{
		System.out.println("f()�׳��쳣");
		throw new Exception("test exception");
	}
	
	public static void g() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("g()�����쳣: ");
			e.printStackTrace(System.out);
			System.out.println("g()�����׳�e");
			throw e;
		}
	}
	
	public static void h() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("h()�����쳣: ");
			e.printStackTrace(System.out);
			System.out.println("h()�����׳� e.fillInStackTrace()");
			throw (Exception) e.fillInStackTrace(); //���¹����ջ������׷�ٵ�f()
		}
	}
	
	public static Date getDate() {
		Date date = null;
		try {
			date = new Date();
			throw new Exception();
//			return date;			
		} catch (Exception e) {
			return date;
		} finally {
			date.setYear(99); //��ĵ�����ֵ��
		}		
	}
	
	public static int getInt() {
		int i = 0;
		try {
			i = 1;
			throw new Exception();
//			return date;			
		} catch (Exception e) {
			i = 2;
			return i;
		} finally {
			i = 3; //����ĵ�����ֵ��
		}		
	}
	
	public static void main(String[] args){
		try{
			f();
		}catch(Exception e){
			System.out.println("main()����f�쳣: ");
			e.printStackTrace(System.out);
		}
		/*
		f()�׳��쳣
		main()����f�쳣: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:60)
		*/	
		
		
		/**
		 * g()�д�ӡ�Ķ�ջ����main()�д�ӡ�Ķ�ջ  һ������
		 */
		System.out.println("====================");
		try{
			g();
		}catch(Exception e){
			System.out.println("main()����g�쳣: ");
			e.printStackTrace(System.out);
		}
		/*
		f()�׳��쳣
		g()�����쳣: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.g(Ch11_1_NewException.java:38)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:71)
		g()�����׳�e
		main()����g�쳣: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.g(Ch11_1_NewException.java:38)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:71)
		*/	
		
		/**
		 * h()�д�ӡ�Ķ�ջ����main()�д�ӡ�Ķ�ջ  ��һ������main()��ӡ�Ķ�ջȱ��f()��Ϣ
		 */
		System.out.println("====================");
		try{
			h();
		}catch(Exception e){
			System.out.println("main()����h�쳣: ");
			e.printStackTrace(System.out);
		}
		/*
		f()�׳��쳣
		h()�����쳣: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.f(Ch11_1_NewException.java:33)
			at ch11_exception.Ch11_1_NewException.h(Ch11_1_NewException.java:49)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:83)
		h()�����׳� e.fillInStackTrace()
		main()����h�쳣: 
		java.lang.Exception: test exception
			at ch11_exception.Ch11_1_NewException.h(Ch11_1_NewException.java:54)
			at ch11_exception.Ch11_1_NewException.main(Ch11_1_NewException.java:83)
		*/	
		
		
		System.out.println(getDate());
		System.out.println(getInt());
	}
}


