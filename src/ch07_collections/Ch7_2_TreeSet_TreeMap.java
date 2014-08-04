/**
 * <p>�ļ�����: Ch7_2_TreeSet_TreeMap.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-2</p>
 * <p>������ڣ�2011-3-2</p>
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

import java.util.HashMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;
import static java.lang.System.out;

public class Ch7_2_TreeSet_TreeMap {
	public static void main(String[] args) 
	{
		/**
		 * 0. TreeSet�в��ܲ����޷��Ƚϵ�Ԫ�أ�����
		 * 
		 * ���Ԫ�����Զ�����࣬����ʵ��Comparable������
		 */
		TreeSet<Integer> times = new TreeSet<Integer>();
		times.add(800);
		times.add(1030);
		times.add(1245);
		times.add(1635);
		times.add(1840);
		times.add(2010);
		times.add(2210);
		times.add(1525);
		out.println("set : " + times);
		/**
		 * 
		 * ���������
		 * 
		 * ���󣺲��ұ�1600ʱ��С�ģ���ӽ���ʱ��
		 * 
		 * TreeSet.higher(e)
		 * TreeMap.higherKey(e)
		 * TreeSet.ceiling(e)
		 * TreeMap.ceilingKey(e)
		 * 
		 */
		
		//JDK5:
		TreeSet<Integer> sub1 = new TreeSet<Integer>();
		sub1 = (TreeSet<Integer>)times.headSet(1600);
		out.println("last before 1600: Set.headSet(1600).last(): " + sub1.last());
		
		TreeSet<Integer> sub2 = new TreeSet<Integer>();
		sub2 = (TreeSet<Integer>)times.tailSet(2000);
		out.println("first after 2000: Set.tailSet(2000).first(): " + sub2.first());
		
		//JDK6:
		int lower16 = times.lower(1600);	// lower() < | floor()  <=
		int higer20 = times.higher(2000);	//higher() > | ceiling()>=
		out.println("last before 1600: Set.lower(1600): " + lower16);
		out.println("first after 2000: Set.higher(2000):" + higer20);
		
		/**
		 * 
		 * ��ѯ polling
		 * 
		 * TreeSet.pollFirst()
		 * TreeMap.pollFirstEntry():���ؼ�ֵ��
		 * TreeSet.pollLast()
		 * TreeMap.pollLastEntry()
		 */
		out.println("==��ѯ");
		out.println("set : " + times);
		int first = times.pollFirst(); 
		int last = times.pollLast();
		out.println("last : Set.pollLast() : " + last);
		out.println("first: Set.pollFirst(): " + first);
		out.println("set : " + times);
		/**
		 * 
		 * ����
		 * 
		 * TreeSet.descendingSet()
		 * TreeMap.descendingMap()
		 */
		out.println("==�����poll");
		TreeSet<Integer> desTimes= (TreeSet<Integer>) times.descendingSet();//����ֵ��NavigableSet<E> 
		out.println("set : " + desTimes);
		int first2 = desTimes.pollFirst(); 
		int last2 = desTimes.pollLast();
		out.println("last : Set.pollLast() : " + last2);
		out.println("first: Set.pollFirst(): " + first2);
		out.println("set : " + desTimes);
		
		/**
		 * TreeSet.subSet()
		 * TreeMap.subMap():	����������֮һ����һ�����Զ�����
		 * 		�����������Ƶģ�Arrays.asList(int[])
		 */
		out.println("==subSet()");
		TreeSet<Integer> sub = (TreeSet<Integer>) times.subSet(1525,1830);
		out.println("set : " + times);
		out.println("subset : " + sub);
		
		out.println("���Ԫ�غ����߶����£�");
		//subֻ�����1525~1830֮�ڵģ�
		//����java.lang.IllegalArgumentException: key out of range
		//// sub.add(2000);
		
		sub.add(1815); 
		times.add(2030);
		
		out.println("set : " + times);
		out.println("subset : " + sub);
		
		out.println("--sub.pollFirst()");
		sub.pollFirst();
		out.println("set : " + times);
		out.println("subset : " + sub);
		
		out.println("--times.pollFirst()");
		times.pollFirst();
		out.println("set : " + times);
		out.println("subset : " + sub);
		
		out.println("--times.pollFirst()");
		times.pollFirst();
		out.println("set : " + times);
		out.println("subset : " + sub);

	}

}
