/**
 * <p>�ļ�����: Ch2_3_��̬.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-19</p>
 * <p>������ڣ�2010-9-19</p>
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
package ch02_OO;

public class Ch2_3_��̬ {
	static Object oc 		= new Child();
	static Parent pc 		= new Child();
	static Animatable ac 	= new Child();
	static Child cc 		= new Child();
	public static void main(String[] args){
		/**
		 * 1. �������� ֻ�����������������ͣ�����������޹ء�
		 *    ��ʹ���˸�������ã���ֻ�ܵ��ø����еķ���
		 */
		//// oc.paint();
		((Child) oc).paint();
		
		pc.paint();   //Child paint
		//pc.animate()
		
		//ac.paint();
		ac.animate(); //Child animate
		
		cc.paint();   //Child animate
		cc.animate(); //Child animate
		
		System.out.println("----��ļ̳�");
		System.out.println("cc.getField1()=" + cc.getField1());   	//Parent Field1����������
		System.out.println("cc.field1="+cc.field1);                 //Child Field1(override)
		System.out.println("pc.field1="+pc.field1); //�򲻿ɶ�̬��       //Parent Field1
		
		System.out.println("cc.field2="+cc.field2);  //��ɼ̳У�         //Parent Field2
		System.out.println("pc.field2="+pc.field2);                 //Parent Field2
		
	}
}

class Parent {
	public String field1 = "Parent Field1";
	public String field2 = "Parent Field2";
	public void paint(){
		System.out.println("parent paint");
		//new Float(8).equals(8);
	}
	public String getField1(){
		//System.out.println(field1);
		return field1;
	}
}

interface Animatable{
	public void animate();
}

class Child extends Parent implements Animatable{
	
	public String field1 = "Child Field1(override)";

	@Override
	public void animate() {
		System.out.println("Child animate");
	}
	@Override
	public void paint(){
		System.out.println("Child paint");
	}
	
}
