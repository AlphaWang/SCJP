/**
 * <p>�ļ�����: Ch3_2_��ֵ�����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-11-30</p>
 * <p>������ڣ�2010-11-30</p>
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

import java.awt.Dimension;

public class Ch3_2_AssignOperator 
{
	char instanceChar = '\u0000';
	public static void main(String[] args)
	{
		System.out.println("instanceChar:"+new Ch3_2_AssignOperator().instanceChar);
		
	/**
	 * 1. ��������ֵĬ�϶���Ϊdouble��(64λ)��
	 *    Ϊ�˽���������ֵ ��ֵ ��float����������ǿ��ת������+F
	 *    
	 */
	double d = 23.5;	
	//Type mismatch: cannot convert from double to float
	//// float  f2= 23.5;
	float  f1 = 123.5F;	
	float  f3 = (float)23.5; //ǿ��ת�����ᶪʧ��ߵ�����λ(��λ)
	System.out.println("123.5F: "+f1);
	System.out.println("(float)23.5: "+f3);
	/**
	 * 2. ǿ��ת��������ʾ��
	 */
	byte b3 = (byte)128;
	System.out.println("(byte)128: "+b3);
	/*
	 * 128 =                                     10 00 00 00
	 *     = 00 00 00 00 00 00 00 00 00 00 00 00 10 00 00 00
	 * ת����ȡ���8λ
	 *     = 10 00 00 00
	 * ��Ϊbyte���з��ŵģ�����
	 *     = -128
	 */
	/**
	 * ���� 3.  +=��-=��*=��/=���㣬������ǿ��ת��
	 */
	byte b4 = (byte)(0 + 128);//�������ֹ�ǿ��ת��
    b4 += 128;                //�� +=�Զ�ǿ��ת��
    
    /**
     * 4. �������� ��ֵ ����һ����������
     */
    int i = 10;
    int j = i; //j��i���õ��ڴ�λ�ò�ͬ��
    j = 21;
    System.out.println("i:"+i+" -- j:"+j);
    /**
     * 5. ���ñ��� ��ֵ ����һ�����ñ���
     */
    Dimension d1 = new Dimension(5,10);
    Dimension d2 = d1; 
    d2.width = 4;//d1��d2������ͬ�Ķ���    
    System.out.println("d1:"+d1+" -- d2:"+d2);
    /**
     *   ���ñ��������⣺String    
     */
    String s1 = "Test";
    String s2 = s1;
    s2.toUpperCase();//��û�иı�s2��ֵ����������һ�����ַ���"TEST"��Ȼ���ֱ�����
    System.out.println("s1:"+s1+" -- s2:"+s2);
    
	}

}
