/**
 * <p>�ļ�����: Ch7_0_Add.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-28</p>
 * <p>������ڣ�2011-12-28</p>
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Parent{
	int index;
	Parent(int ind){ index = ind; }
	public String toString(){return "Parent:"+index;}
}
class Child1 extends Parent{ 
	 Child1(int ind){ super(ind); }
	 public String toString(){return "Child1:"+index;}
}
class Child2 extends Parent{
	Child2(int ind){ super(ind); }
	public String toString(){return "Child2:"+index;}
}
class Child3 extends Parent{
	Child3(int ind){ super(ind); }
	public String toString(){return "Child3:"+index;}
}
class Child1_1 extends Child1{
	Child1_1(int ind){ super(ind); }
	public String toString(){return "Child1_1:"+index;}
}
class Child1_2 extends Child1{
	Child1_2(int ind){ super(ind); }
	public String toString(){return "Child1_2:"+index;}
}

public class Ch7_0_Add {
	public static void main(String[] args){
		Parent p1 = new Parent(1);
		Parent p2 = new Parent(2);
		Parent p3 = new Parent(3);
		
		//ArrayListʵ��Collection�ӿ�
		Collection<Parent> parents1 = new ArrayList<Parent>(Arrays.asList(p1,p2));
		Collection<Parent> parents2 = Arrays.asList(p1,p2);
		
		/**
		 * Arrays.asList()�õ���List������addԪ�ء�deleteԪ��
		 * ��������ʱ����UnsupportedOperationException * underlying array cannot be resized		 * 
		 * ��Ϊ��Arrays.asList()�õ���List ��ײ��ʾ�������飬���ɵ�����С��
		 */
		     parents1.add(p3);
		//// parents2.add(p3); //������ʱ�쳣��parents2�������ɾ��Ԫ�أ�
		
		
		/**
		 * 2. ��ӣ�
		 * add()
		 * addAll()
		 * Collections.addAll(Collection<? super T> c,  T... a) �������������п죬��ѡ������
		 */
		Parent[] ps = new Parent[]{p1,p2};
		Collections.addAll(parents1, ps);
		Collections.addAll(parents1, p1,p2);
		//The method addAll(Collection<? super T>, T...) in the type Collections is not applicable for the arguments (Collection<Parent>, Collection<Parent>)
		//// Collections.addAll(parents1, parents2);
		parents1.addAll(parents2);
		//parents1.addAll(2,parents2);  //List.addAll(2, )�������м���룻��Collection�޴˷���
		
		System.out.println(parents1);
		System.out.println(parents2);
		/**
		 * Arrays.asList()���̬
		 */
		List<Parent> parentList = Arrays.asList(
				new Child1(1),
				new Child2(2),
				new Child3(3)
		);
		
		/*
		 * asList()Ԫ��ֻ����<T>��ֱ�����ࣿ
		 * Type mismatch: cannot convert from List<Child1> to List<Parent>
		 * 
		 * ����취��
		 * 1. �ĳ�List<Child1> �ɽ��				��������parentList2_2
		 * 2. ����һ��Parent��Ԫ�أ�����new Child3()	��������parentList2_1
		 * 3. ��ʽ���Ͳ���˵��						��������parentList2_3
		 */
		
//		List<Parent> parentList2 = Arrays.asList(
//				new Child1_1(),
//				new Child1_2()				
//		);		
		List<Parent> parentList2_1 = Arrays.asList(
				new Child1_1(11),
				new Child1_2(12),
				new Child3(1)
		);	
		List<Child1> parentList2_2 = Arrays.asList(
				new Child1_1(111),
				new Child1_2(122)				
		);
		/**
		 * ��ʽ���Ͳ���˵����
		 * ������Arrays.asList()�в���һ��������hint��
		 */
		List<Parent> parentList2_3 = Arrays.<Parent>asList(
				new Child1_1(114),
				new Child1_2(124)	
		);
				
		/*
		 * Collections.addAll()��û���������
		 */
		List<Parent> parentList4 = new ArrayList<Parent>();
		parentList4.add(new Child1_1(112));
		Collections.addAll(parentList4, new Child1_1(113));
		
		
		
		/**
		 * 2_1. List.addAll()����
		 * 
		 * Collections.addAll(Collection<? super T> c, T... a)
		 * List.addAll(int index, Collection<? extends E> c)
		 */
		List<Parent> list = new ArrayList<Parent>(parentList);
		list.addAll(2, parentList4);
		
		
		/**
		 * 4. �Ӽ���subList()
		 *    subList()�������б��Ļ����ǳ�ʼ�б��������������б���޸� ���ᷴӳ����ʼ�б�
		 */
		System.out.println("==================list.subList(0, 2)");		
		List<Parent> sublist = list.subList(0, 2);
		System.out.println(list);
		System.out.println(sublist);
		
		System.out.println("==================sublist.add(0, new Child3()");	
		sublist.add(0, new Child3(2));
		System.out.println(list);
		System.out.println(sublist);
		
		System.out.println("==================list.add(1, new Child1_2())");
		list.add(1, new Child1_2(124));
		System.out.println(list);
		//����������ConcurrentModificationException
		//// System.out.println(sublist);
	}

}
