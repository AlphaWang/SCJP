/**
 * <p>�ļ�����: Ch8_4_Static_InnerClass.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-15</p>
 * <p>������ڣ�2011-3-15</p>
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
package ch08_inner_class;

import ch08_inner_class.Outer.Inner;

/**
 *  ��̬Ƕ����
 *  
 *  ���������������ڲ��࣬��Ϊ�����ⲿ��ʵ��û�й�ϵ
 *  
 *  ��ͨ�ڲ��������ʽ�ر�����һ��ָ���ⲿ�������
 *  ��̬�ڲ������û�У�
 *
 */

class Outer4
{
	static String outerStaticVar = "outerStaticVar";
	String outerVar = "outerVar";
	
	static class Nest
	{
		void doStuff(){
			System.out.println("Outer4.Nest ��̬Ƕ�����ڵķ���");
			System.out.println("==����Outer��̬������"+outerStaticVar);
			/*
			 * ��̬Ƕ�����ڲ� �����ܷ���ʵ��������ʵ������
			 * Cannot make a static reference to the non-static field outerVar
			 */
			//// System.out.println("==����Outerʵ��������"+outerVar);
		}
		//�����о�̬����
		static void staticMethod(){
			
		}
	}
}
public class Ch8_4_Static_NestedClass 
{
	static class Nest2
	{
		void doStuff(){
			System.out.println("Ch8_4_Static_NastedClassss.Nest2 ��̬Ƕ�����ڵķ���");
		}
	}
	public static void main(String[] args)
	{
		/**
		 * ���������еľ�̬Ƕ���࣬ͬһ���ഴ������
		 */
		Nest2 nest2 = new Nest2();
		/**
		 * �����������еľ�̬Ƕ����, �����ⲿ��ʵ����
		 */		
		Outer4.Nest nest = new Outer4.Nest();
		
		//��Ǿ�̬�ڲ��������
		//Illegal enclosing instance specification for type Outer4.Nest
		
		//// Outer4.Nest nest3 = new Outer4().new Nest();
			 Outer.Inner inner2 = new Outer().new Inner();
		
		nest2.doStuff();
		nest.doStuff();
	}

}
