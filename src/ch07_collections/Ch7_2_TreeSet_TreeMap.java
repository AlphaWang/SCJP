/**
 * <p>文件名称: Ch7_2_TreeSet_TreeMap.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-2</p>
 * <p>完成日期：2011-3-2</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
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
		 * 0. TreeSet中不能插入无法比较的元素！！！
		 * 
		 * 如果元素是自定义的类，必须实现Comparable！！！
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
		 * 导航与查找
		 * 
		 * 需求：查找比1600时刻小的，最接近的时刻
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
		 * 轮询 polling
		 * 
		 * TreeSet.pollFirst()
		 * TreeMap.pollFirstEntry():返回键值对
		 * TreeSet.pollLast()
		 * TreeMap.pollLastEntry()
		 */
		out.println("==轮询");
		out.println("set : " + times);
		int first = times.pollFirst(); 
		int last = times.pollLast();
		out.println("last : Set.pollLast() : " + last);
		out.println("first: Set.pollFirst(): " + first);
		out.println("set : " + times);
		/**
		 * 
		 * 反序
		 * 
		 * TreeSet.descendingSet()
		 * TreeMap.descendingMap()
		 */
		out.println("==反序后poll");
		TreeSet<Integer> desTimes= (TreeSet<Integer>) times.descendingSet();//返回值：NavigableSet<E> 
		out.println("set : " + desTimes);
		int first2 = desTimes.pollFirst(); 
		int last2 = desTimes.pollLast();
		out.println("last : Set.pollLast() : " + last2);
		out.println("first: Set.pollFirst(): " + first2);
		out.println("set : " + desTimes);
		
		/**
		 * TreeSet.subSet()
		 * TreeMap.subMap():	当更新其中之一，另一个将自动更新
		 * 		————类似的：Arrays.asList(int[])
		 */
		out.println("==subSet()");
		TreeSet<Integer> sub = (TreeSet<Integer>) times.subSet(1525,1830);
		out.println("set : " + times);
		out.println("subset : " + sub);
		
		out.println("添加元素后，两者都更新：");
		//sub只可添加1525~1830之内的，
		//否则：java.lang.IllegalArgumentException: key out of range
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
