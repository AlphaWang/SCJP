/**
 * <p>�ļ�����: Ch1_1��ʼ��.java </p>
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

import java.util.Arrays;

/**
 * 
 * ���ڲ�������η� ����Ϊprivate������
 * only public, abstract & final are permitted
 *
 * Illegal modifier for the class privateClass; only public, abstract & final are permitted
 */
//// private class privateClass{}
//// private enum privateEnum{}
enum DefaultEnum{
	SMALL,BIG,LARGE;
	DefaultEnum(){
		System.out.println("Enum���캯��������ֱ�ӵ���");
	}
}

public class Ch1_1_Initialize {
	
	private String name;
	public String publicVar = "����publicVar";
	public String publicVar2 = "����publicVar2";
	
	
	{
		publicVar = "����publicVar!";
		System.out.println("�����Ա��ʼ����");
		//// blankFinalVar = 0;       //�հ�final�����ɶ�θ�ֵ
	}
	
	
	private final int blankFinalVar;
	
	Ch1_1_Initialize(){
		blankFinalVar = 1;
		System.out.println("���๹�췽��()");
	}
	Ch1_1_Initialize(String name){
		blankFinalVar = 2;          //�հ�final�������ڹ�����֮ǰ���丳ֵ;
		//// blankFinalVar = 3;      //�հ�final�����ɶ�θ�ֵ
		System.out.println("���๹�췽��(String)");
		this.name = name;
	}
	
	
	void print(){
		System.out.println("����print()��" + name);
	}
	/**
	 * ���̳к󣬵��������print()
	 */
	void callPrint1(){
		print();
	}
	
	
	
	/**
	 * final��������
	 */
	void setName(final String n){
		this.name = n;
		name = "b";
		
		// final���������ɸ�������
		///// n = "";
	}
	String getName(){
		return this.name;
	}
	/**
	 * private���������ɱ��̳�
	 */
	private void privateMethod(){
		System.out.println("����privateMethod()��" );
		//����values()����ö��Ԫ��
		DefaultEnum[] eItems = DefaultEnum.values();
		System.out.println(Arrays.asList(eItems));
		
		//Enum���캯��������ֱ�ӵ���
		//// DefaultEnum e1 = new DefaultEnum();
		DefaultEnum e2 = DefaultEnum.BIG;
	}
	
	public static void main(String[] args){
		new Ch1_1_Initialize().privateMethod();
	}
	
	

}
