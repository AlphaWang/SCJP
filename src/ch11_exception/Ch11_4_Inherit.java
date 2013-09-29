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
package ch11_exception;


/**
 *  ������ࡢ�ӿ��а���ͬ���ķ�������
 *
 */
class MyException1 extends Exception{}
class MyException2 extends Exception{}

class P {
	public P() throws MyException1{}
	public P(String s) throws MyException1{}
	public void event()  { System.out.println("P.event()");}
	public void event2() { System.out.println("P.event2()");}
	public void event3() throws MyException1{	System.out.println("P.event3()");	}
	
}

interface I {
	void event ();
	void event2 ();
	/**
	 * Ҫ��P�е�ͬ����������һ�£������׳����쳣
	 */
	//// void event3 () throws MyException2;
}

class C extends P implements I {
	/**
	 * �쳣���ƶԹ������������á����๹���������׳����쳣
	 * 
	 * �������ڻ��๹�����ᱻ���ã�����C()���쳣˵���� �������P()���쳣MyException1
	 */
	public C() throws MyException1,MyException2 {
		super();
		//throw new MyException2();
	}
	/**
	 * ���������๹������ ������๹�������쳣 
	 */
	public C(String s)throws MyException1{
		//Constructor call must be the first statement in a constructor 
		//// try{
				super(s);
		//// }finally{}
	}

	public void event (){
		
	}
	/**
	 * ��ӡthis���������toString()�����������ݹ���ã�
	 * 
	 * Ӧ����super.toString()
	 */
	public String toString(){
		//// return "C :" + this;
		return "C :" + super.toString();
	}
}

public class Ch11_4_Inherit {
	public static void main(String[] args) {
		P c;
		try {
			c = (P) new C();
			c.event();
			c.event2();
		} catch (MyException1 e) {
			e.printStackTrace();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
		
		
		try {
			c = new C();
			
			//java.lang.StackOverflowError ��Ϊ�ݹ����
			System.out.println(c);
		} catch (MyException1 e) {
			e.printStackTrace();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
