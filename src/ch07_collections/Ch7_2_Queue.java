/**
 * <p>�ļ�����: Ch7_2_Queue.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-1</p>
 * <p>������ڣ�2011-3-1</p>
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

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ch7_2_Queue {
	public static void main(String[] args) 
	{
		String item1 = "1";
		String item2 = "2";
		String item3 = "3";
		String item4 = "4";
		

		/**
		 * 
		 * 6. Queue�ӿڣ����桰Ҫִ�е�����

		 * 
		 * 		�������п���LinkedList���������Ƚ��ȳ�FIFO
		 * 
		 */
		out.println("======Queue�ӿ�======");
		out.println("==: LinkedList==");
		Queue<String> linkedlist = new LinkedList<String>();
		linkedlist.add(item2);
		linkedlist.add(item1);
		linkedlist.offer(item3);
		linkedlist.offer(item2);
		linkedlist.offer(item3);
		//The method sort(List<T>) in the type Collections is not applicable for the arguments (Queue<String>)
		//// Collections.sort(linkedlist);
		
		//poll()�������ǲ���˳�򡪡�����polling ��ѯ
		while(linkedlist.peek() != null)
		{
			out.print(linkedlist.poll() +" ");
		}
		/**
		 						ordered	sorted
		 * 		PriorityQueue		��		�� 	���Ƚ������ȳ�: ���û���������ȼ�������
		 *      ����peek()��poll()��remove()����ʱ����ȡ�������ȼ���ߵ�Ԫ��
		 * 
		 * �����Զ������򷽷���
		 * PriorityQueue( int initialCapacity,  Comparator<? super E> comparator) 
		 */
		out.println("\n==: PriorityQueue==");
		PriorityQueue<String> priorityqueue = new PriorityQueue<String>();
		priorityqueue.add(item2);
		priorityqueue.add(item1);
		priorityqueue.offer(item3);
		priorityqueue.offer(item2);
		priorityqueue.offer(item3);
		
		out.println("size: " + priorityqueue.size());
		//poll()�������ǰ�����Ȼ˳�����еģ�����
		while(priorityqueue.peek() != null)
		{ 
			out.print(priorityqueue.poll() + " ");
		}
		
		out.println("\nsize: " + priorityqueue.size());
		
		
	}

}
