/**
 * <p>�ļ�����: Ch1_1_�������ڶ�̬����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-12</p>
 * <p>������ڣ�2011-12-12</p>
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

public class Ch1_1_�������ڶ�̬���� {
	String name;
	void draw(){
		System.out.println("����draw()");
	}
	Ch1_1_�������ڶ�̬����(){
		
		/*
		 * Cannot refer to an instance field name while explicitly invoking a constructor
		 */
		//// this(name);
		
		System.out.println("���๹������draw()֮ǰ");
		/**
		 * �������е��ö�̬���������ܱ�������д��ִ�н������Ԥ��
		 * 
		 * ���췽��׼���þ����ܼ򵥵ķ���ʹ�����������״̬
		 * ���������о����ܱ����������������������������final(private)��������Ϊ������ǰ�ڰ󶨣����ܱ���д
		 */
		draw();
		
		System.out.println("���๹������draw()֮��)");
	}
	
	Ch1_1_�������ڶ�̬����(String s){
		this();
	}

}
