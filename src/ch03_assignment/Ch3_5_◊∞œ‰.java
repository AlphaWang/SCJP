/**
 * <p>�ļ�����: Ch3_5_װ��.java </p>
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
import static java.lang.System.out;
public class Ch3_5_װ�� 
{
	public static void main(String[] args)
	{
		/**
		 * 1. ������װ������
		 *    1)��װ�����캯��: ���ܻ������͡�String���͵Ĳ�������������Character���⣬��ֻ�����ַ�����
		 *    2)valueOf()����: ���֣��ɴ�����
		 */
		Float f1 = new Float(21.5F);
		Float f2 = new Float("21.5F");		
		Character c1 = new Character('c');
		//// Character c2 = new Character("c");
		out.println("new Float(21.5F)\t��"+f1);
		
		Integer i1 = Integer.valueOf("12B", 16);
		Integer i2 = Integer.valueOf("12");
		out.println("Integer.valueOf(\"12B\", 16)\t��"+i1);
		out.println("Integer.valueOf(\"12)\t��"+i2);
		
		/**
		 * 2. ת��
		 * 		1��Wrapper.xxxValue()����װ�� => ��������
		 * 		2��Wrapper.parseXxx(String)��String => ��������
		 * 		3��Wrapper.valueOf(String) ��String => ��װ��
		 */
		//1����װ�� => �������ͣ�����Wrapper.xxxValue()��
		byte b = i1.byteValue();	out.println(b);//������ȡ
		short s = i1.shortValue();	out.println(s);
		double d = i1.doubleValue();out.println(d);
		long l = i1.longValue();	out.println(l);
		int i = i1.intValue();		out.println(i);
		int j = i1;					out.println(j);
		
		//2��String => �������ͣ�����Wrapper.parseXxx(String)��
		//////��ע��parseXxx���ص��� �������ͣ�
		int int1 = Integer.parseInt("123");
		int int2 = Integer.parseInt("123", 16);
		
		//3��String => ��װ��������Wrapper.valueOf(String) ��
		///////��ע��valueOf���ص��ǰ�װ���࣡
		Integer i3 = Integer.valueOf("12B", 16);
		
		//4��ת��ΪString
		out.println("Integer.toString()\t:"+i1.toString());   //�˴�toString���Ǿ�̬�������̳���Object
		out.println("Integer.toString( , 16)\t:"+Integer.toString(i1, 16));//�˴�toString:��̬����
		out.println("Integer.toHexString( )\t:"+Integer.toHexString(i1));
		
		/**
		 * 3. �Զ�װ��
		 * 
		 */
		Integer i4 = new Integer(57);
		Integer i5 = i4;
		out.println("i4 == i5\t:"+(i4 == i5));
		//�˴���ʵ���ϴ�������һ����װ�����󡣡���������װ�������״̬�ǲ��ɱ�ģ�������
		i4 ++;  
		out.println("i4 == i5\t:"+(i4 == i5));
		
		out.println("i4 ++\t: "+i4);
		
		/**
		 * 4. ==
		 * 
		 * ���°�װ����ֻҪ����ֵ��ͬ����==��
		 * 	Boolean
		 * 	Byte
		 * 	\u0000~\u007f���ַ�
		 *  -128~127��Short��Integer
		 */
		Integer i6 = 1000;
		Integer i7 = 1000;
		out.println("i6 == i7\t:"+(i6 == i7));	//��==
	
		
		Integer i8 = 127;
		Integer i9 = 127;
		out.println("i8 == i9\t:"+(i8 == i9));
		//-128~127��Short��Integer��ֻҪ����ֵ��ͬ����==��
		
		
	}

}
