/**
 * <p>文件名称: Ch7_0_Add.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-28</p>
 * <p>完成日期：2011-12-28</p>
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
		
		//ArrayList实现Collection接口
		Collection<Parent> parents1 = new ArrayList<Parent>(Arrays.asList(p1,p2));
		Collection<Parent> parents2 = Arrays.asList(p1,p2);
		
		/**
		 * Arrays.asList()得到的List，不能add元素、delete元素
		 * 否则运行时报错：UnsupportedOperationException * underlying array cannot be resized		 * 
		 * 因为，Arrays.asList()得到的List 其底层表示的是数组，不可调整大小！
		 */
		     parents1.add(p3);
		//// parents2.add(p3); //！运行时异常，parents2不可添加删除元素！
		
		
		/**
		 * 2. 添加：
		 * add()
		 * addAll()
		 * Collections.addAll(Collection<? super T> c,  T... a) ————！运行快，首选方法！
		 */
		Parent[] ps = new Parent[]{p1,p2};
		Collections.addAll(parents1, ps);
		Collections.addAll(parents1, p1,p2);
		//The method addAll(Collection<? super T>, T...) in the type Collections is not applicable for the arguments (Collection<Parent>, Collection<Parent>)
		//// Collections.addAll(parents1, parents2);
		parents1.addAll(parents2);
		//parents1.addAll(2,parents2);  //List.addAll(2, )允许在中间插入；但Collection无此方法
		
		System.out.println(parents1);
		System.out.println(parents2);
		/**
		 * Arrays.asList()与多态
		 */
		List<Parent> parentList = Arrays.asList(
				new Child1(1),
				new Child2(2),
				new Child3(3)
		);
		
		/*
		 * asList()元素只能是<T>的直接子类？
		 * Type mismatch: cannot convert from List<Child1> to List<Parent>
		 * 
		 * 解决办法：
		 * 1. 改成List<Child1> 可解决				————parentList2_2
		 * 2. 增加一个Parent子元素，例如new Child3()	————parentList2_1
		 * 3. 显式类型参数说明						————parentList2_3
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
		 * 显式类型参数说明：
		 * 可以再Arrays.asList()中插入一个“线索hint”
		 */
		List<Parent> parentList2_3 = Arrays.<Parent>asList(
				new Child1_1(114),
				new Child1_2(124)	
		);
				
		/*
		 * Collections.addAll()则没有这个限制
		 */
		List<Parent> parentList4 = new ArrayList<Parent>();
		parentList4.add(new Child1_1(112));
		Collections.addAll(parentList4, new Child1_1(113));
		
		
		
		/**
		 * 2_1. List.addAll()方法
		 * 
		 * Collections.addAll(Collection<? super T> c, T... a)
		 * List.addAll(int index, Collection<? extends E> c)
		 */
		List<Parent> list = new ArrayList<Parent>(parentList);
		list.addAll(2, parentList4);
		
		
		/**
		 * 4. 子集合subList()
		 *    subList()产生的列表的幕后就是初始列表，————对子列表的修改 都会反映到初始列表！
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
		//————？ConcurrentModificationException
		//// System.out.println(sublist);
	}

}
