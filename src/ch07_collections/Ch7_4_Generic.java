/**
 * <p>�ļ�����: Ch7_4_Generic.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-3</p>
 * <p>������ڣ�2011-3-3</p>
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
package ch07_collections;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Test0<K> extends ArrayList<K> {
	K get(K k){
		return super.get(0);
	}
}

class Test1 extends ArrayList<String>{}

//Waring: The type parameter String is hiding the type String
class Test2<String> extends ArrayList<String>{}

class Test3 implements Iterator<String> {
	@Override
	public boolean hasNext() { return false;}
	@Override
	public String next() {	return null;}
	@Override
	public void remove() {}
}

//Warning: The type parameter String is hiding the type String
class Test4<String> implements Iterator<String>{
	@Override
	public boolean hasNext() { return false;}
	@Override
	public String next() {	return null;}
	@Override
	public void remove() {}
}

public class Ch7_4_Generic {
	public static void main(String[] args) {
		//The type Test1 is not generic; it cannot be parameterized with arguments <String>
		//// Test1<String> t1 = new Test1<String>();
		     Test2<String> t2 = new Test2<String>();
		//// Test3<String> t3 = new Test3<String>();
		     Test4<String> t4 = new Test4<String>();
		/**
		 * ���Ϳ������ڣ�
		 * 1. �������ϱ���
		 * 2. ��������
		 * 3. ��������
		 */
		
		/**
		 * 1. ���÷��͡��Ƿ��ͼ���
		 * 
		 * ��Ϊ�������� �Ƿ��ͷ���
		 * addAll������intList���޸ģ������޷��գ�����ClassCastException
		 * 
		 * �������б��뾯�棺
		           ע�⣺Ch7_4_Generic.java ʹ����δ�����򲻰�ȫ�Ĳ�����
			ע�⣺Ҫ�˽���ϸ��Ϣ����ʹ�� -Xlint:unchecked ���±��롣
			
		 */
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(4);
		intList.add(6);
		
		out.println("===��ʼ״̬");
		out.println("list: "+ intList);
		int total = addAll(intList);
		out.println("total: "+total);
		 
	   /*
	    *  ��insertInt�У���intList����Integer���������С�������⡣
	    */
		out.println("===insertInt()");
		insertInt(intList);
		out.println("list: "+ intList);
		
		/*
		 * ��insertStr�У���intList����String���������У�������
		 */
		/**
		 * Ϊʲô�������أ�
		 * 
		 * ��������������Ϊ�˽��С�����ʱ��������
		 * ������ʱ�Ѿ��������Ͳ���(type erasure)�����ͻ���Ϣ�����ڣ�(Ϊ��֧����������)
		 * ����������ʱ���Զ�����ǿ��ת��
		 * 
		 */
		out.println("===insertStr()");
		insertStr(intList);            //1) add�������͵�Ԫ��ʱ��û�����⣻
		out.println("list: "+ intList);
		
		// ��ʱ��addAll()������ClassCastException:java.lang.String cannot be cast to java.lang.Integer
		// add�������͵�Ԫ��ʱ��û�����⣻�������Ԫ��ȡ��������ʹ��ʱ ���������⣡����
		
		int total2 = addAll(intList);  //2) �������Ԫ��ȡ��������ʹ��ʱ ����������
		out.println("total: "+total2);

	}
	/**
	 * �Ƿ��ͷ����� ���޸�list
	 */
	static int addAll(List list) {
		int total = 0;
		for(Object o : list){
			total += (Integer)o;
		}
		return total;
	}
	/**
	 * �Ƿ��ͷ����� �޸�list������int
	 */
	static void insertInt(List list) {
		list.add(new Integer(42));
	}
	/**
	 * �Ƿ��ͷ����� �޸�list������String
	 */
	static void insertStr(List list){
		list.add(new String("s"));
	}

}
