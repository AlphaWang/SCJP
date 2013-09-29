/**
 * <p>文件名称: Ch7_2_Queue.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-1</p>
 * <p>完成日期：2011-3-1</p>
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
		 * 6. Queue接口：保存“要执行的任务”

		 * 
		 * 		基本队列可用LinkedList————先进先出FIFO
		 * 
		 */
		out.println("======Queue接口======");
		out.println("==: LinkedList==");
		Queue<String> linkedlist = new LinkedList<String>();
		linkedlist.add(item2);
		linkedlist.add(item1);
		linkedlist.offer(item3);
		linkedlist.offer(item2);
		linkedlist.offer(item3);
		//The method sort(List<T>) in the type Collections is not applicable for the arguments (Queue<String>)
		//// Collections.sort(linkedlist);
		
		//poll()出来的是插入顺序————polling 轮询
		while(linkedlist.peek() != null)
		{
			out.print(linkedlist.poll() +" ");
		}
		/**
		 						ordered	sorted
		 * 		PriorityQueue		√		√ 	优先进，优先出: 以用户定义的优先级来排序
		 *      调用peek()、poll()、remove()方法时，获取的是优先级最高的元素
		 * 
		 * 可以自定义排序方法：
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
		//poll()出来的是按照自然顺序排列的！！！
		while(priorityqueue.peek() != null)
		{ 
			out.print(priorityqueue.poll() + " ");
		}
		
		out.println("\nsize: " + priorityqueue.size());
		
		
	}

}
