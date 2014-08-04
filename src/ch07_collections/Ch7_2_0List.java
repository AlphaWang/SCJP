/**
 * <p>文件名称: Ch7_2_Collection.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-2-22</p>
 * <p>完成日期：2011-2-22</p>
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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static java.lang.System.out;
public class Ch7_2_0List {

	public static void main(String[] args) 
	{
		/**
		 * 1. Collection 是一个接口，Set List Queue实现了它，但Map未实现它
		 *    Collections是一个工具类
		 */
		
		/**
		 * 2. ordered: 有序的。
		 * 		迭代遍历集合时，能够遵循特定的顺序
		 * 
		 * 		ArrayList会按照元素索引位置建立顺序
		 * 		LinkedHashSet会按照元素插入顺序
		 * 
		 *    sorted: 分类的。
		 *    	集合中的顺序 是根据某个规则确定的，称为排序顺序(最常见的排序顺序是自然顺序)。
		 *    	————排序顺序与这些无关：何时插入、插入的位置
		 *    	————只有TreeSet、TreeMap是sorted的
		 *    
		 *    	是ordered的一种特殊情况
		 *    	排序是基于对象本身的属性进行的，可以通过实现Comparable/Comparator接口来定义排序顺序
		 */
		
		
		/**
		 * 
		 * 3. List接口：关心索引
		 * 					ordered	sorted
		 * 		ArrayList: 		√		×	可增长的数组. ————可用来跟踪访问了哪些位置，以及以何种顺序访问的
		 * 		Vector：			√		×	ArrayList的同步版本
		 * 		LinkedList：		√		×	元素之间是双链接的。实现了List+Queue，迭代比ArrayList慢，但可以快速插入删除
		 * 									————基本队列可用LinkedList————先进先出FIFO
		 * 
		 *  使用Collections同步：List list = Collections.synchronizedList(new LinkedList(...));
		 */
		out.println("======List接口======");
		List<String> arraylist = new ArrayList<String>();
		String item1 = "C";
		String item2 = "A";
		String item3 = "B";
		String item4 = "B";
		arraylist.add(item1);//默认index就是插入的顺序
		arraylist.add(item2);	
		arraylist.add(1,item3);	//插入到item2之前！
		arraylist.add(item4);
		//arraylist.add(5,item3); //java.lang.IndexOutOfBoundsException:
		
		for(String s : arraylist)
		{
			//如果不存在，则返回-1
			out.println("元素"+s+",index = "+arraylist.indexOf(s));
		}
		/**
		 * 
		 * 3.1 排序：首先必须是可比较的
		 * 
		 * List中的元素必须实现Comparable接口中的compareTo()，则sort(List)运行时报错
		 * 或者，采用Collections.sort(List,Comparator)
		 * 
		 * 数组排序：Arrays.sort(int[])
		 * 
		 */
		out.println("==未排序："+arraylist);
		Collections.sort(arraylist);
		out.println("==Collections.sort()排序后："+arraylist);
		for(String s : arraylist)
		{
			out.println("元素"+s+",index = "+arraylist.indexOf(s));
		}
		
		out.println("==测试排序自定义类");
		ArrayList<DVDinfo> list2 = new ArrayList<DVDinfo>();
		DVDinfo info1 = new DVDinfo("Life","Andy","1992-1-2");
		DVDinfo info2 = new DVDinfo("Death","Bob","1998-7-5");
		DVDinfo info3 = new DVDinfo("Zero","Selina","2008-7-5");
		list2.add(info1);
		list2.add(info2);
		list2.add(info3);
		out.println("排序前："+list2);
		Collections.sort(list2);
		out.println("排序后："+list2);
		/*
		 * 问题：Collections.sort(list2)，只会根据title排序，想要换一种排序方法怎么办？
		 * ————重写DVDinfo类的comapraTo()方法？
		 * ————NO! 使用Collections.sort(List,Comparator)
		 */
		Collections.sort(list2, new DVDinfoSortBySinger());
		out.println("排序后2："+list2);
		
		/**
		 * 
		 * 3.2 查找：首先必须排序
		 * 
		 * Collections.binarySearch(List, elem, Comparator)
		 * 返回所查元素的int索引值(+)，或者int插入点(-)
		 * 
		 * 1.查找之前必须排序
		 * 2.查找时必须使用 排序所用的Comparator,否则返回无意义的负值
		 * 
		 * 可以用Arrays.binarySearch()来查找数组
		 * 
		 */
		out.println("==测试查找");
		List<String> arraylist2 = new ArrayList<String>();
		String item11 = "C";
		String item12 = "A";
		String item13 = "B";
		String item14 = "D";
		arraylist2.add(item11);
		arraylist2.add(item12);	
		arraylist2.add(item13);	
		arraylist2.add(item14);
		
		Collections.sort(arraylist2);
		int index = Collections.binarySearch(arraylist2, "C");
		out.println("List ："+arraylist2);
		out.println("查找C：" + index);
		out.println("查找E：" + Collections.binarySearch(arraylist2, "E"));
		/**
		 * 添加：
		 * add()
		 * addAll()
		 * Collections.addAll(Collection<? super T> c,  T... a) ————！运行快，首选方法！
		 */
		Collections.addAll(arraylist2, "X","Y");
		Collections.addAll(arraylist2, new String[]{"U","V"});
		
		/**
		 * 
		 * 3.3 数组和List转换
		 * 
		 * 1. Arrays.asList(int[])
		 * 		：当更新数组或列表其中之一，另一个将自动更新  ————??不能add、delete，可以set
		 * 		————类似的：Map.suMap()
		 * 2. List.toArray()
		 * 		: 区分有无参数的情况：无参数，返回Object[]；有参数，返回指定类型数组
		 */
		out.println("==数组和List转换");
		String[] sa = {"one", "two","three"};
		
		/**
		 * asList()方法还提供了一个创建固定长度的列表的便捷方法，该列表被初始化为包含多个元素
		 */
		List<String> list = Arrays.asList(sa);
		List<String> list_ = Arrays.asList("one", "two","three");
		
		/**
		 * Arrays.asList()得到的List，不能add元素、delete元素
		 * 否则运行时报错：UnsupportedOperationException * underlying array cannot be resized		 * 
		 * 因为，Arrays.asList()得到的List 其底层表示的是数组，不可调整大小！
		 */
		//Collections.addAll(list, "X","Y");		
		//list.add("");
		//list_.add("");
		
		
		sa[0] = "one1";//list内容自动更新！！！
		out.println("Arrays.asList(sa)："+list);
		
		Object[] oa= list.toArray(); //1.无参数，返回Object[]
		out.print("list.toArray()：");
		for(Object o:oa) 
			out.print(o+" ");
		
		String[] sa2 = new String[5];
		sa2 = list.toArray(sa2);     //2.有参数，返回指定类型数组
		out.print("" +
				"\nlist.toArray(sa2)：");
		for(String s:sa2) 
			out.print(s+" ");
		
		/**
		 * 
		 * 3.4 Iterator遍历
		 * 
		 * 除了增强型for，也可用Iterator遍历List
		 */
		out.println("\n==Iterator遍历:");
		
		Iterator<String> ite = list.iterator();
		while(ite.hasNext())
		{
			//！！因为使用了泛型Iterator，所以这里无需强制转换
			String item = ite.next();
			out.println(item);
		}
		

	}

}
/**
 *  实现Comparable<DVDinfo>接口
 *
 */
class DVDinfo implements Comparable<DVDinfo>
{
	String title;
	String singer;
	String   date;
	public DVDinfo(String title, String singer, String date){
		this.title = title;
		this.singer = singer;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return title + " "+singer +" "+date;
	}

	@Override
	public int compareTo(DVDinfo o) 
	{
		int i = this.title.compareTo(o.title); //String类中有compareTo方法
		return i;
		/*
		 * 返回值
		 * 负数：this < o
		 * 零     ：this = o
		 * 正数：this > o
		 */
	}
}
/**
 * 
 * 新建Comparator<DVDinfo>接口实现类 ————public interface Comparator<T>
 * 
 * !!优点：无需修改想排序的类
 *        可以创建多个排序序列
 */
class DVDinfoSortBySinger implements Comparator<DVDinfo>
{

	@Override
	public int compare(DVDinfo o1, DVDinfo o2) 
	{
		return o1.singer.compareTo(o2.singer);
	}
	
}
