/**
 * <p>�ļ�����: Ch1_5_�������Ա_�Ƿ������η�.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-15</p>
 * <p>������ڣ�2010-9-15</p>
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
package ch01_declaration;

import java.util.Date;

public class Ch1_5_Modifier_NoAccess {
	Date d;
	/**
	 * final���������Ա��̳У����ɱ���д��
	 */
	public final void finalMethod()
	{
		System.out.println("Ch1_5_�������Ա_�Ƿ������η�.finalMethod()");
	}

	public void finalParaMethod(final Date date)
	{
		d = date;
		System.out.println(d);
		System.out.println(date);
		d.setMonth(78);				
		System.out.println(d);
		System.out.println(date); //dateͬʱ���޸�
		
		date.setMonth(87);        //final������Ϊ�ο����޸ģ���--> �޸���ָ���¸�ֵ
		System.out.println(d);
		System.out.println(date);
		/**
		 * 1. final���������޸ģ����ɱ����¸�ֵ��
		 *   ��������������final����ֻ����final����
		 */
		//// date = new Date();
	}
	/**
	 * 2. �ǳ������У������г��󷽷�
	 *    ���ǳ������� ����û�г��󷽷�
	 */
	//// public abstract void sample();
	
	/**
	 * 3. ͬ����������ʾ����һ��ֻ�ܱ�һ���̷߳���
	 *    ��������synchronized���η�ֻ�����ڷ��������������ࡢ��������
	 */
	public synchronized void synchronizedMethod()
	{
	}
	
	/**
	 * 4.native������Java�޷�ֱ�ӷ��ʵ�����ϵͳ�ײ㣨��ϵͳӲ����)��Ϊ��Javaʹ��native��������չJava����Ĺ��ܡ� 
	 *   ���Խ�native��������Java����ͬ�ó���Ľӿ�
	 *   ��������native���η�ֻ�����ڷ��������������ࡢ��������native�����ԷֺŽ���
	 */
	public native void nativeMethod();
	
	/**
	 * 5. strictfp��ֻ�����ڷ������࣬�������ڱ�������
	 */
	public strictfp void stictfpMethod()
	{
	}
	
	public static void main(String[] args)
	{
		Ch1_5_Modifier_NoAccess obj = new Ch1_5_Modifier_NoAccess();
		Date today = new Date();
		obj.finalParaMethod(today);
		
		new SubClass3().finalMethod(); //final�����ɱ�����̳�
		
		
		/**
		 * PackageClass���췽����private�����Բ��ܴ��������ʵ��
		 * ���ǿ��Է��ʸ����public ��̬������
		 */			
		int i = PackageClass.staticVar;
		//// PackageClass p1 = new PackageClass();			
		     PackageClass p2 = new PackageClass("public constructor");
	}
}

class SubClass3 extends Ch1_5_Modifier_NoAccess{
	/**
	 * 3. final�������ɱ���д��
	 *         �ᱻ�̳С�
	 *         Cannot override the final method from Ch1_5_�������Ա_�Ƿ������η�
	 */
	
//	public void  finalMethod(){
//		System.out.println("��дfinalMethod");
//	}
	
}
abstract class AbstractClass3{
	/**
	 * 4. abstract��final��private��static����
	 */
	//// abstract final void method1();
	//// private abstract void method2();
	//// abstract static void method3();
	
}
