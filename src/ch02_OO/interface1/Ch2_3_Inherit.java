/**
 * <p>�ļ�����: Ch2_3_Inherit.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2012-1-18</p>
 * <p>������ڣ�2012-1-18</p>
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
package ch02_OO.interface1;


/**
 *  ������ࡢ�ӿ��а���ͬ���ķ�������
 *
 */
class MyException1 extends Exception{}
class MyException2 extends Exception{}

class P {
	public P() throws MyException1{}
	public void event (){
		System.out.println("P.event()");
	}
	public void event2 (){
		System.out.println("P.event2()");
	}
	public void event3 () throws MyException1{
		System.out.println("P.event3()");
	}
	
}

interface I {
	void event ();
	void event2 ();
	/**
	 * Ҫ��P�е�ͬ����������һ�£������׳����쳣
	 */
	//void event3 () throws MyException2;
}

class C extends P implements I {
	/**
	 * �쳣���ƶԹ������������á����๹���������׳����쳣
	 * 
	 * �������ڻ��๹�����ᱻ���ã�����C()���쳣˵���� �������P()���쳣MyException1
	 */
	public C() throws MyException1,MyException2 {
		super();
	}

	public void event (){
		
	}
}

public class Ch2_3_Inherit {
	public static void main(String[] args) throws MyException1, MyException2{
		C c = new C();
		c.event();
		c.event2();
	}
}
