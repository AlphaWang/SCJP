/**
 * <p>�ļ�����: Ch8_1_Declare.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-14</p>
 * <p>������ڣ�2011-3-14</p>
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
/**
 * Ϊʲô��Ҫ�ڲ��ࣿ
 *  ��������һ�㣬�ڲ����̳�ĳ���ࡢ��ʵ��ĳ���ӿ�
 *  
 *  1. �ڲ���ʹ�ö��ؼ̳еĽ��������������� �������ö���ڲ���̳�ĳ�ࡢʵ��ĳ�ӿ�
 *                                         ���ڲ���Ҳӵ����Χ�ࡢ��Χ�ุ�� �����з���
 *  
 *  2. �հ���ص� ��������?? ��Callbacks.java
 *     TIJ P205
 *  
 *  3. ���ƿ�ܣ��ڲ������ڱ仯���������ο�����
 *     TIJ P207
 *  
 */

/**
 * �����ڲ���: �����ڲ������� 
 *  0. Ϊ�˴����ڲ���ʵ����������һ������ڲ�����ص��ⲿ��ʵ����
 *
 */

class Outer 
{
	private int x = 1;
	/**
	 * 1. ���ⲿ�� �����ڲ������
	 * 
	 *    makeInner()���Ǿ�̬��������������һ��Outerʵ����
	 */
	public void makeInner()
	{
		Inner inner = new Inner();		
		inner.changeOuter();
		//�ⲿ�����ͨ���ڲ�����󣬷����ڲ����е�private����
		int i = inner.privateVar;
		//// int j = inner.privateStaticVar;
		int l = Inner.privateStaticFinalVar;
	}
	private void outerMethod(){
		
	}
	
	class Inner
	{
		private int privateVar = 2;
		/**
		 * The field privateStaticVar cannot be declared static; 
		 * static fields can only be declared in static or top level types
		 * �Ǿ�̬�ڲ����У������о�̬��������������̬��������
		 */
		//// private static int privateStaticVar = 3;
		private static final int privateStaticFinalVar = 4;
		
		
		public void changeOuter(){
			/**
			 * �ڲ�����Է����ⲿ���е�private����������
			 */
			x = 8;
			outerMethod();
			/**
			 * 3. �ڲ����е�this����
			 * 
			 * ��ʾ��ǰ�ڲ���ʵ��:     Innerֱ��ʹ��this
			 * ��ʾ��������ⲿ��ʵ��: Innerʹ��Outer.this: 
			 */
			System.out.println("�ڲ������this:\t" + this);
			System.out.println("�ڲ������Outer.this:\t" + Outer.this);
		}
		
		/**
		 * Outer.this: �����ڲ����Ӧ���ⲿ��ʵ��
		 * 
		 * �ڲ��������ʽ�ذ���һ��ָ���ⲿ���������ã�����
		 */
		public Outer getOuter(){
			return Outer.this;
		}
	}
	
	
	Inner getInner(){
		return new Inner();
	}
}

public class Ch8_1_Normal_InnerClass {

	public static void main(String[] args) 
	{
		/**
		 * 2. ���ⲿ�����֮�� �����ڲ������
		 */
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		
		Outer.Inner inner2 = new Outer().new Inner();
		Outer.Inner inner3 = outer.getInner();
		//// outer.Inner inner4 = new Outer().new Inner();
		
		inner.changeOuter();
		
		
		
		/**
		 * !!!!!!��������ľ�̬������ ʵ�����ڲ��ࣺ������������Ҫ���ⲿ��ʵ����
		 * 
		 * �Ա�Ch8_4_Static_NastedClassss��
		 * Nest2 nest2 = new Nest2();
		 */
		/*
		 * No enclosing instance of type Ch8_1_Declare is accessible. 
		 * Must qualify the allocation with an enclosing instance of type Ch8_1_Declare 
		 * (e.g. x.new A() where x is an instance of Ch8_1_Declare).
		 */
		
		  //// MyInner myInner = new MyInner();
		  MyInner myInner2 = new Ch8_1_Normal_InnerClass().new MyInner();
	}
	class MyInner
	{
		
	}

}

