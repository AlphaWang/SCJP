/**
 * <p>�ļ�����: Ch1_1_��ʼ������.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-7</p>
 * <p>������ڣ�2011-12-7</p>
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

public class Ch1_1_��ʼ������ extends Ch1_1_��ʼ��{
	/**
	 * �������������������ܱ��̳�?? �������½�����publicVar
	 * 
	 * ���ܼ̳С����ܶ�̬��
	 */
	public String publicVar = "����publicVar"; 
	
	
	{
		publicVar = "����publicVar!";
		System.out.println("�����Ա��ʼ����");
	}
	
	
	Ch1_1_��ʼ������(){
		super("alpha");
		System.out.println("���๹�췽��()");
	}
	Ch1_1_��ʼ������(String name){
		//���б��Զ����super()
		System.out.println("���๹�췽��(String name)");
		/*
		 * ���ɷ��ʸ���private����
		 * ..The field Ch1_1_��ʼ��.name is not visible
		 */
		//// this.name = name;
		//// super.name = name;
		setName(name);
	}
	
	@Override
	void print(){
		System.out.println("����print() " + getName());		
	}
	
	//���ܸ���private����
	//// @Override
	void privateMethod(){
		System.out.println("����privateMethod()��" );
	}
	
	public static void main(String[] args){
		Ch1_1_��ʼ������ sub1 = new Ch1_1_��ʼ������();
		sub1.print();
		sub1.callPrint1();
		
		System.out.println("----------");
		Ch1_1_��ʼ�� sub2 = new Ch1_1_��ʼ������("beta");//��̬
		sub2.print();
		System.out.println("----------");
		sub2.callPrint1(); //���̳к󣬵��������print()
		
		/**
		 * ������ļ̳С���̬
		 * 
		 * ����ʵ���ϰ���������ΪpublicVar����һ�����Լ��ģ�һ���ǴӸ���õ���
		 */
		System.out.println("----------");
		System.out.println(sub1.publicVar); //����publicVar
		System.out.println(sub1.publicVar2);//����publicVar2   --������ܱ��̳У���Ӧ����                           --���ܼ̳�
		System.out.println(sub2.publicVar); //����publicVar���� --����ܱ��̳У���Ӧ�������publicVar --���ܶ�̬
		System.out.println(sub2.publicVar2);//����publicVar2
		
		sub1.privateMethod();
		//The method privateMethod() from the type Ch1_1_��ʼ�� is not visible
		//// sub2.privateMethod();
		
	}

}
