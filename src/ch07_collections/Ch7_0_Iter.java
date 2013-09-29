/**
 * <p>�ļ�����: Ch7_0_Iter.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-29</p>
 * <p>������ڣ�2011-12-29</p>
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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ch7_0_Iter {
	
	/**
	 *  Iterator���������ܹ����������еĲ���  �� ���еײ�Ľṹ����
	 */
	public static void display(Iterator<Parent> iter){
		while(iter.hasNext()){
			Parent p = iter.next();
			System.out.print(p +" ");
		}
		System.out.println();
	}
	/**
	 * Iterator.remove()���������½����ص�Ԫ��ɾ��
	 * ������������remove()ǰ�����ȵ���next()
	 */
	public static void remove(Iterator<Parent> iter, int num){
		for(int i = 0; i < num; i++){
			iter.next();
			iter.remove();
		}
	}
	public static void main(String[] args){
		List<Parent> list = new ArrayList<Parent>();
		list.add(new Parent(1));
		list.add(new Child1(1));
		list.add(new Child2(1));
		Iterator<Parent> iter = list.iterator();
		display(iter);
		
		Iterator<Parent> iter2 = list.iterator();
		remove(iter2, 1);
		display(iter2);
		
		/**
		 * ��ǿ�ĵ�������ListIterator, ����˫��������滻Ԫ��
		 */
		//1. ��ǰ����
		System.out.println("====ListIterator: forward");
		ListIterator<Parent> listIter = list.listIterator();
		while(listIter.hasNext()){
			System.out.println(
					listIter.next() + ", "
					+ listIter.nextIndex() + ", "
					+ listIter.previousIndex() + "; " 
					);
		}
		//2. ������
		System.out.println("====ListIterator: backward");
		while(listIter.hasPrevious()){
			System.out.println(
					listIter.previous() + ", "
					+ listIter.nextIndex() + ", "
					+ listIter.previousIndex() + "; " 
					);
		}
		//3. �滻Ԫ��: set()�滻���ʹ������һ��Ԫ��
		System.out.println("====ListIterator: set()");
		while(listIter.hasNext()){
			listIter.next();
			listIter.set(new Child3(1));
		}
		Iterator<Parent> iter3 = list.iterator();
		display(iter3);
	}

}
