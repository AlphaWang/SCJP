/**
 * <p>�ļ�����: Ch3_2_����ֵ.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-11-22</p>
 * <p>������ڣ�2010-11-22</p>
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

public class Ch3_2_Literal 
{

	
	public static void main(String[] args)
	{
		int ten = 123;
		//�˽��ƣ������21λ���֣�������ǰ��0
		int oct = 0123;
		int hex = 0x123;
		/**
		 * 0. �˽��ơ�ʮ���ơ�ʮ�����Ƶ���������ֵ����Ĭ�϶���Ϊint��
		 *    Ҳ����ͨ����׺L������Ϊlong�͡�
		 */
		long l = 0x123L;	
		System.out.println("�˽���0123:"  + oct);
		System.out.println("ʮ������0x123:"  + hex);
		System.out.println("ʮ������0x123:"  + 0x123);//��ʾ����ʮ����
		
		//����ֵ27����Ϊint���¾䱻�������Զ�ǿ��ת��
		byte b0 = 27;
		byte b1 = (byte)27;
		//������ֵ����byte��Χ������Ҫ�ֹ�ǿ��ת����
		byte b2 = (byte)128;
		/*
		 * ����byte�������㣬�õ�һ��int������
		 * ������ֱ�Ӹ���byte��������Ҫǿ��ת����
		 */
		//// byte b3 = b0 + b1;
		byte b4 = (byte)(b0 + b1);
		     b4 += 128;// +=��-=��*=��/=���㣬������ǿ��ת��
		System.out.println("(byte)27:" +b1);
		System.out.println("(byte)128:" +b2);
		
		/**
		 * 1. ��������ֵĬ�϶���Ϊdouble��(64λ)
		 *    ����ͨ����׺F������Ϊfloat��(32λ)
		 */
		double d = 123456.789;
		//// float  f0 = 123456.789; //Type mismatch: cannot convert from double to float
		float  f1 = 123456.789F;//�������Ӻ�׺F�����������ʾ���Ͳ�ƥ�䣬��Ϊ����ʧ����
		float  f3 = (float)123456.789; //����ǿ��ת��

		
		
		/**
		 *  2. �ַ�����ֵ
		 *     �ַ�ʵ������һ��16λ�޷������� --> Ҳ����˵�����Ը��ַ�������������ֵ��ֻҪ<65535(0xFFFF)
		 */
		char a = 'a';
		char b = 0xFFFF;
		char e = 0;
		//�����������ֵ����[0,65535]������Ҫǿ������ת��
		char c1 = (char)65536;
		//// char c2 = 65536; //������Χ	Type mismatch: cannot convert from int to char
		char d1 = (char)-98;
		//// char d2= -98;
		
		System.out.println("(char)65536:"+c1);
		System.out.println("(char)-98:"+d1);
		
		/**
		 * 3. �ַ�������ֵ  |  ��������ֵ		
		 * 
		 *  �ַ��������鲻�ǻ������ͣ�Ҳ������ֵ
		 */
		String s = "string";
		
		int[] arrays = {1,2};
		
		String s2 = "string";
		System.out.println(s == s2); //true
	}

}
