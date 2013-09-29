/**
 * <p>�ļ�����: Ch1_5_SubClass.java </p>
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
package ch01_declaration_subclass;
import ch01_declaration.*;

public class Ch1_5_OutPakSubClass extends Ch1_5_�������Ա_�������η�{
	public int j;
	public void testProtected()
	{
		/**
		 * 
		 * �������� ֻ��ͨ�����̳С������������protected��Ա		 
		 * ����ͨ�������������������ͺ�public��Աһ����
		 * 
		 * ������������̳�protectedVar���ñ�������������κδ�����˵ ���൱��private�ģ�����������
		 * 
		 */
		Ch1_5_�������Ա_�������η� parent = new Ch1_5_�������Ա_�������η�();
		/**
		 * 1. �����ڸ���������� ʹ�õ������ ������Protected����
		 *    ��������������super����
		 */
		//// System.out.println(parent.protectedVar);
		System.out.println(protectedVar);
		System.out.println(this.protectedVar);  //��Ch1_5_SubClass_���� �Աȣ�
		System.out.println(super.protectedVar); //??
		
		
		/**
		 * 2. �����ڸ���������� ʹ�õ������ ������Protected����
		 *    ��������������super����
		 */
	    //// parent.protectedMethod();
		this.protectedMethod();
		super.protectedMethod();//??
		
		
		
		/**
		 * 3. ���ܷ��ʸ����е�final��Ա������������������Ϊ��default��������
		 *    ��������superҲ����
		 */
		this.finalMethod();         //ע��������д��finalMethod()
		//// super.finalMethod();
		//// parent.finalMethod();
		
		/**
		 * --4. ���ⲻ�ܷ��ʸ����default��Ա
		 *      is not visible
		 */
		//// this.defaultMethod();
		//// super.defaultMethod();
		//// parent.defaultMethod();
	}
	/**
	 * 3. �����е�final��Ա�����ɼ̳���д�������ض���
	 */
    //// @Override
	final void finalMethod(){ 
		System.out.println("����finalMethod");
	}
	
	//Duplicate method finalMethod() in type Ch1_5_OutPakSubClass
	//void finalMethod(){}
	
	final String finalVar = "";
	


	public  static void main(String[] args)
	{
		Ch1_5_OutPakSubClass subClass = new Ch1_5_OutPakSubClass();
		subClass.testProtected();
		subClass.finalMethod();		//ע��������д��finalMethod()
		
		//default�������ܰ��ⱻ�̳�
		//// subClass.defaultMethod();
		
		
		/**
		 * default�� �ڰ��� ���ɷ��ʣ�
		 * The type PackageClass is not visibles
		 */
		//// int i = PackageClass.staticVar;		
		//// PackageClass p2 = new PackageClass("public constructor");
		
	}

}
