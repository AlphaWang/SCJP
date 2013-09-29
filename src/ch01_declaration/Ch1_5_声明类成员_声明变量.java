/**
 * <p>�ļ�����: Ch1_5_�������Ա_��������.java </p>
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

public class Ch1_5_�������Ա_�������� {
	/**
	 * 0. transient��ֻ������ʵ����������ʾ�����л��ñ���
	 *               �����������һ��������transient�ģ���Ҫ�������ж϶���Ĺ�ϣ��������
	 *               
	 *    volatile:  ֻ������ʵ����������ʾ���ʸñ������̱߳���ʹ�Լ��Ըñ�����˽�и������ڴ��е�������һ��
	 *    			volatile �������Ա�������һ�� ���̶Ƚ���� synchronized����
	 *              ��һ����synchronized����֤�������̰߳�ȫ�ģ�
	 */
	volatile int z;
	transient int w;
	
	final String finalVar = "finalString";
	private String privateVar = "privateString";
	final void finalMethod()
	{
		System.out.println("finalMethod");
	}
	
	public void method()
	{
		/**
		 * 1.�ֲ�����û��Ĭ��ֵ��ʹ��ǰ������ʽ��ʼ��
		 */
		int i;
		//// System.out.println(i);
		
		/**
		 * 2.����������Ƕ��еĶ��󣬼�����Ԫ���ǻ�������
		 */
		int[] j;
		int[] k[];//��ά����
		
		/**
		 * 3. �������� ���������С�����Ϸ���
		 */
		//// int[5] x;
		int[] y = new int[5];
		int[] z = {1,2};
		int[] z1 = new int[]{1,2};
		//Cannot define dimension expressions when an array initializer is provided
		//// int[] z2 = new int[2]{1,2};
		
		/**
		 * 4. final�Ļ������ͣ�һ����ʽ��ʼ�����Ͳ��������¸�ֵ
		 *    final�Ķ������ͣ���Զ�������¸�ֵ�������������󣬵��ǿ����޸Ķ���������ݡ�
		 *                    (û��final����ֻ��final����)
		 *                    
		 *   �ڹ��캯�����ǰ��final���������ʼ���������������������ڳ�Ա��ʼ���顢���캯���и�ֵ��                 
		 */
		final int y2;
		y2 = 1;
		/*
		 * The final local variable y2 may already have been assigned
		 */		
		//// y2 = 2;
		
		final Date d;
		d = new Date();
		d.setYear(78);		
		//// d = new Date();
	}
	public static void main(String[] args){
		new SubClass4().test();
	}
	/**
	 * ** 5. �ڲ����еķ����ͱ�����������static
	 *       ���ǣ�1)���ڲ���Ҳ��static;
	 *            2)�ڲ����Աʹ�� static final
	 */
	class Inner{
		/*
		 * The field j cannot be declared static; 
		 * static fields can only be declared in static or top level types
		 */		
		//// static int j = 1;
		
		static final  int i =1;
	}
}

class SubClass4 extends Ch1_5_�������Ա_��������
{
	/**
	 * 6.����� final�������ɱ���д
	 *         final���������ظ�ֵ
	 */	
	//// void finalMethod(){	}
	//// final void finalMethod(){}
	
	void test(){
		Ch1_5_�������Ա_�������� parent = new Ch1_5_�������Ա_��������();
		//// finalVar = "new";  //final���������ظ�ֵ
		//// this.privateVar;   //private�������ɼ̳�
		
		System.out.println(       finalVar);
		System.out.println( super.finalVar);
		System.out.println(parent.finalVar);
		System.out.println(  this.finalVar);
		
		this.finalMethod();		
		super.finalMethod();
		parent.finalMethod();
		
		/*
		 * ���ܷ��ʸ����е�private��Ա
		 */
		//// parent.privateVar; 
	}
	
	
}
