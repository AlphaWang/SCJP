/**
 * <p>�ļ�����: Ch2_8_���췽��.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-11-2</p>
 * <p>������ڣ�2010-11-2</p>
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
package ch02_OO;
import java.text.DateFormat;
import java.util.*;

public class Ch2_8_Constructor 
{
	
	
	/**
	 * 0. ���췽���������ص㣺
	 *    a) û���κη�������
	 *    b) ������������ ��ȫһ��
	 *    
	 * �����ࣺ�й��췽����������������ʵ������������ʱ�ŵ���
	 *   �ӿڣ��޹��췽�����������ӿڲ��Ƕ���̳�����һ����
	 */

	public Ch2_8_Constructor(String s)
	{
		//this(3);
		System.out.println("����String���췽��");

	}
	/**
	 * 1. ���Ҫ�ڹ��췽������this()/super()���������ڵ�һ�� 
	 *    �����������췽���ĵ�һ�У��ض�Ϊthis()��super()
	 */
	public Ch2_8_Constructor(int i)
	{
		//this("");
		System.out.println("����int���췽��");
		//// this();
		
	}
	/**
	 * 2. ���ù��캯����ֻ�ܴ�����"���캯��"�ڲ����е���
	 *    ������������������
	 */
	public void aMethod(){
		//// Ch2_8_���췽��();
	}
	public static void main(String[] args)
	{
		/**
		 * 3. ע���ڲ���Ĺ��췽�����ã�
		 */
		new Ch2_8_Constructor("s");
		new Ch2_8_Constructor(3);
		
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		
		new SubClass(2);			
	}
	
	
	
	
}
class OuterClass
{
	class InnerClass
	{
    }
}

/**
 *  4.�������û��Ĭ�Ϲ��췽������������Ҫ�޲������췽����������ֹ�������޲������췽����
 *                                                      ����ʽ����super(x)
 */
class SubClass extends Ch2_8_Constructor
{
	String s;
	public SubClass()
	{
		super("");
		/**
		 * ����5. �ڸ��๹�췽������֮ǰ�����ɷ��������ʵ��������ʵ������������̬��������̬���� ����ԣ�
		 *        ���������漰�����ʼ����˳�򣡣���������������
		 *    
		 *    Cannot refer to an instance field s while explicitly invoking a constructor
		 */
		 //// super(s);
	}
	protected SubClass(int i)
	{
		/**
		 * 1. ���Ҫ�ڹ��췽������this()/super()���������ڵ�һ�� 
		 *    ��������ͬʱ��this()/super()
		 */
		super(i);
		//this();
		System.out.println("��������int���췽��");
	}
	
	
	/**
	 * 6. ������д����Ĺ��췽��
	 */
	
	//// public Ch2_8_���췽��(int i){ }
	
}