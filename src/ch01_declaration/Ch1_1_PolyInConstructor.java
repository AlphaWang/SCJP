/**
 * <p>�ļ�����: Ch1_1_�������ڶ�̬����.java </p>
 * <p>�������ڣ�2011-12-12</p>
 * @version 1.0
 * @author WangZhongXing192063
 */
package ch01_declaration;

public class Ch1_1_PolyInConstructor {
	String name;
	void draw(){
		System.out.println("����draw()");
	}
	Ch1_1_PolyInConstructor(){
		
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
	
	Ch1_1_PolyInConstructor(String s){
		this();
	}

}
