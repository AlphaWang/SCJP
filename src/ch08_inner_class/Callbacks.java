/**
 * <p>�ļ�����: Callbacks.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-26</p>
 * <p>������ڣ�2011-12-26</p>
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
package ch08_inner_class;


/**
 * �հ����հ���һ���ɵ��õĶ�������¼��һЩ���� �������������� ����Ϣ
 *
 */



interface Incrementable{
	void increment();
}
//Callee1�� ����ʵ��
class Callee1 implements Incrementable{
	private int i = 0;
	public void increment() {
		i++;
		System.out.println(i);
	}

}

//Callee2���ڲ���ʵ��
class MyIncrement {
	public void increment(){
		System.out.println("MyIncrement.increment()");
	}
	static void method(MyIncrement mi){
		mi.increment();
	}
}
class Callee2 extends MyIncrement {
	private int i = 0;
	@Override
	public void increment(){//�̳��Ը���
		super.increment();
		i++;
		System.out.println(i);
	}	
	//�ڲ��ࣺ�հ�	
	private class Closure implements Incrementable{
		public void increment() {
			Callee2.this.increment();
		}
	}
	//���ӣ�
	Incrementable getCallbackRef(){
		return new Closure();
	}
	
}








class Caller{
	private Incrementable callbackRef;
	Caller(Incrementable cb){
		callbackRef = cb;
	}
	void go(){
		callbackRef.increment();
	}
}

public class Callbacks {
	public static void main(String[] args){
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.method(c2);
		
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackRef());
		
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}
