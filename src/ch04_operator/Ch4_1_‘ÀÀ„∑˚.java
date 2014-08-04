/**
 * <p>�ļ�����: Ch4_1_�����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-12</p>
 * <p>������ڣ�2011-1-12</p>
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
package ch04_operator;

import static java.lang.System.out;

public class Ch4_1_�����
{
	
	public static void main(String[] args)
	{
		/**
		 * 1. ��ֵ�����
		 */
		
		
		/**
		 * 2. ��ϵ�����
		 * 	�ַ� �������κ���ֵ ���бȽ�����
		 */
		out.println("'a': "+'a' );
		out.println("'a' < 50: "+('a' < 50));//�Ƚ�Unicodeֵ
		
		/*
		 * ע�ⲻҪ�� == ��дΪ =(��ֵ���ʽ)
		 * �κθ�ֵ���ʽ�Ľ�������Ǹ�ֵ��ı���ֵ��
		 */
		boolean b = true;
		int i;
		out.println("b = false :"+(b = false));
		out.println("i = 123: "+(i = 123));
		//�޷����룺
		//// if(i = 234);
		
		/**
		 * ö�ٵ������ : ==��equals���ؽ����ͬ
		 */
		Color c1 = Color.BULE;
		Color c2 = Color.BULE;
		out.println("ö��==��"+(c1 == c2));//true
		out.println("ö��equals��"+c1.equals(c2));//true
		
		/**
		 * 3. instanceof�Ƚ�
		 * instanceof�����ڿ粻ͬ���μ����
		 */
		/*
		 * null���õ�instanceof����
		 * 
		 * null instanceof XXX ����false
		 * XXX instanceof null �������
		 */
		String s = "1";
		out.println("null instanceof String:"+(null instanceof String));
		//// out.println("String instanceof null:"   +(s instanceof null));
		
		/*
		 * instanceof�����ڿ粻ͬ���μ����
		 * �����������
		 */
		class C{}
		class D{}
		D d = new D();
		//// out.println(d instanceof String);
		//// out.println(d instanceof C);
		
		/**
		 * 4. ���������
		 * 
		 */
		/*
		 * �ַ������������
		 */
		out.println(5 + 1 + "s");//6s
		out.println("s" + 5 + 1 );//s51
		/*
		 * �����ݼ������
		 */
		int x = 2; int y = 3;
		if((y == x++) | (x < ++y)){
			out.println("x = "+x+", y = "+y);
		}
		//����ע�ⲻ����final�����ϵ����ݼ���
		final int num = 5;
		//// int i2 = num ++;
		
		/**
		 * 5. ���������
		 */
		int count = 5;
		String status = (count < 4) ? "less" : "more";
		
		/**
		 * 6. �߼������
		 */
		// ��·�߼��������&&  ||
		// ������������������ļ������˷�ʱ��
		
		// �Ƕ�·�߼�������� &  |
		
		// �߼������ ���^
		out.println((2<3) ^ (3<4)); // true ^ true == false
		
		
		float f = 3.4F;
		float[] fs = {4f,2.3f};
		Long x2 = 3L;
		
		//���ԱȽ� ��ͬ�Ļ�������
		if(f == x2)
			out.println("f == x2");
		
		//���ܱȽ� �������� vs ����
		//// if(f == fs)  out.println("f == x2");
		out.println("------out range");
		int test = 24 * 60 * 60 * 1000 * 1000 * 100000000 * 100000000;
		out.println(test);
		long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000; //����ȷ
        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        out.println(MICROS_PER_DAY + "/" + MILLIS_PER_DAY + " = " + MICROS_PER_DAY / MILLIS_PER_DAY);
        
        
        out.println("----mix-type computation");
        out.println(0xcafebabe); //-889275714
        out.println(0xcafebabeL); //3405691582
        out.println(0xffffffffcafebabeL); //-889275714
        out.println(Long.toHexString(0x100000000L + 0xcafebabe)); //cafebabe
        out.println(Long.toHexString(0x100000000L + 0xcafebabeL)); //1cafebabe
        
        out.println("----infinity");
        out.println(1.0 / 0.0); // Infinity
        out.println((1.0 / 0.0) == Double.POSITIVE_INFINITY);
        
        out.println(0.0 / 0.0); // NaN
        out.println((0.0 / 0.0) == Double.NaN); // Nan != Nan
        out.println(1 / 0); // java.lang.ArithmeticException: / by zero
	}

}
enum Color{
	RED,BULE
}
