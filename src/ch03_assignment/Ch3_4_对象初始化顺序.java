/**
 * <p>�ļ�����: Ch3_4_�����ʼ��˳��.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-12-29</p>
 * <p>������ڣ�2010-12-29</p>
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
package ch03_assignment;

public class Ch3_4_�����ʼ��˳�� {
	/**
	 * 
1��  ���ྲ̬��Ա�;�̬��ʼ���� �����ڴ����г��ֵ�˳������ִ�� 

2��  ���ྲ̬��Ա�;�̬��ʼ���� �����ڴ����г��ֵ�˳������ִ�� 

3��  ����ʵ����Ա��ʵ����ʼ���� �����ڴ����г��ֵ�˳������ִ�� 
4��  ���๹�췽�� super()

5��  ����ʵ����Ա��ʵ����ʼ���� �����ڴ����г��ֵ�˳������ִ�� 
6��  ���๹�췽�� 
	 */
	public static void main(String[] args)
	{
		new SubClass();
	}

}

class Parent {    
    // ��̬����    
    public static String p_StaticField = "����--��̬����";    
    // ����    
    public String p_Field = "����--����";    
   
    // ��̬��ʼ����    
    static {    
        System.out.println(p_StaticField);    
        System.out.println("����--��̬��ʼ����");    
        System.out.println(); 
    }    
   
    // ��ʼ����    
    {    
        System.out.println(p_Field);    
        System.out.println("����--ʵ����ʼ����");  
        System.out.println(); 
    }    
   
    // ������    
    public Parent() {    
        System.out.println("����--������Parent()");   
        System.out.println(); 
    }    
}    
   
class SubClass extends Parent {    
    // ��̬����    
    public static String s_StaticField = "����--��̬����";    
    // ����    
    public String s_Field = "����--����";    
    // ��̬��ʼ����    
    static {    
        System.out.println(s_StaticField);    
        System.out.println("����--��̬��ʼ����");  
        System.out.println(); 
    }    
    // ��ʼ����    
    {    
        System.out.println(s_Field);    
        System.out.println("����--ʵ����ʼ����");  
        System.out.println(); 
    }    
   
    // ������    
    public SubClass() {    
        System.out.println("����--������SubClass()");  
        System.out.println(); 
    }    

}   
