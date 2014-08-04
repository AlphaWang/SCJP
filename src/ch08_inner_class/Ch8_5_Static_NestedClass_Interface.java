/**
 * <p>�ļ�����: Ch8_5_Static_NestedClass_Interface.java </p>
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

public class Ch8_5_Static_NestedClass_Interface {
	public static void main(String[] args){
		Interface sub = new SubClass();
		sub.fly();
	}
}


interface Interface{
	int NUM = 56;
	void fly();
	/**
	 * �ӿ��ڲ��ľ�̬Ƕ����
	 * ����StaticNestedĬ��Ϊpublic static
	 * �������ã�����Ϊ�������룬���Ա��ӿڵĲ�ͬʵ��������
	 * 
	 * ���������ӿڷ������ǳ���ģ�ͨ����̬Ƕ���� ���ṩ�ǳ��󷽷�
	 *
	 */
	class StaticNested{
		public void printClass(){
			System.out.print(this.getClass().getName());
		}
		public static void printNum(){
			//��̬�ڲ��࣬���Է����ⲿ��ľ�̬����
			System.out.print(NUM);
		}
	}
}

class SubClass implements Interface{
	int NUM = 4; //���Ǽ̳�
	@Override
	public void fly() {
		new StaticNested().printClass() ;
		System.out.print(", fly(): ");
		StaticNested.printNum();
		
	}
	
}
