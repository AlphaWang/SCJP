/**
 * <p>文件名称: Ch7_4_GenericMethod.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-7</p>
 * <p>完成日期：2011-3-7</p>
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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenu;

public class Ch7_5_GenericMethod {

	public static void main(String[] args)
	{
		/**
		 * 如果方法参数定义为 List<Object>
		 * 则传入参数不可以是 List<JButton>,
		 *          但可传入 ArrayList<Object>
		 * 
		 * 1)为什么不能传入？
		 * 2)如何解决？
		 * 
		 * !!这里与数组不一样！！
		 * 如果方法参数定义为Object[]
		 * 则传入参数可以为  JButton[]
		 */
				
		List<Object> ol = new ArrayList<Object>();
		addObjectList(ol);
		
		//不能把 List<JButton>传入List<Object>参数
		//The method addObject(List<JButton>) is undefined for the type Ch7_5_GenericMethod
		List<JButton> ol2 = new ArrayList<JButton>();
		//// addObjectList(ol2);
		
		
		/**
		 * 1.为什么不能传入？
		 * ————方法能在List中添加任意子类型，如果把其他子类泛型传入方法，
		 *     则出问题：可能会向集合中添加错误的东西
		 * 
		 * ————其实即便是数组，传入参数的子类也是有风险的
		 *     虽然能编译通过，
		 *     但运行时异常ArrayStoreException
		 * 
		 *     但对于集合来说，没有对应的运行时异常
		 *     因为有类型擦除！
		 *     (运行时JVM知道数组的类型，但是不知道集合的类型)
		 */
		Object[] os = new Object[3];
		addObjectArray(os);
		
		JButton[] os2 = new JButton[3];
		//***java.lang.ArrayStoreException:
		//// addObjectArray(os2);
		
		
		
		
		/**
		 * 2.如何解决？
		 * ————方法一：传入List<Object>，注意List<Object>中可以add JButton元素！
		 * 
		 */
		List<Object> ol3 = new ArrayList<Object>();
		
		ol3.add(new JButton());
		addObjectList(ol3);
		
		/**
		 * 2.如何解决？
		 * ————方法二：向编译器承诺 不会向List"添加"任何东西(只读)；方法参数用List<? extends Object>
		 * 
		 */
		List<JButton> ol4 = new ArrayList<JButton>();
		addObjectList2(ol4);
		
		/**
		 * 关于 ?
		 * 
		 * add(List<? extends Parent>)	：同上文
		 * add(List<? super   Child>)	：Child的任何父类
		 * add(List<?>)					：任何类，= <? extends Object>
		 * add(List<Object>)			：仅Object类，且可以向List中添加元素
		 * 
		 * ————?表示许多可能性； 而如果没有? 则表示仅一种可能。
		 */
		//List<Object> list1 = new new ArrayList<JButton>();
		  List<? extends Object> list2 = new ArrayList<JButton>();
		  List<? super JMenu> list3 = new ArrayList<Object>();
		  List<?> list4 = new ArrayList<JButton>();
		// The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (JMenu)
		////  list4.add(new JMenu());
		////  list4.add(new JButton());
		  list4.add(null);
		

	}
	
	////////参数是数组
	static void addObjectArray(Object[] os) {
		System.out.println("addObjectArray(Object[])");
		System.out.println(os);
		
		os[0] = new JMenu();
		
		System.out.println(os+"\n");
	}
	
	/////////参数是集合
	static void addObjectList(List<Object> ol) {
		System.out.println("addObjectList(List<Object>))");
		System.out.println(ol);
		
		ol.add(new JMenu());
		
		System.out.println(ol+"\n");
	}
	/**
	 * 2.如何解决？
	 * ————方法二：向编译器承诺：不会向List"添加"任何东西(只读)
	 *             使用通配符<?>
	 * 
	 *  <? extends Object>的含义：
	 *  可以赋予一个集合，这个集合的类型是List的子类型，且可以被类型化为Object、或Object的子类
	 *  而且，我不添加任何东西到这个集合
	 *  ————注，extends表示IS-A, 后面可以是一个接口
	 */
	static void addObjectList2 (List<? extends Object> ol)	{
		System.out.println("addObjectList2 (List<? extends Object> )");
		System.out.println(ol);
		
		/*
		 * 如果违反约定  添加元素到集合，则编译出错：
		 * The method add(capture#2-of ? extends Object)
		 * in the type List<capture#2-of ? extends Object>
		 * is not applicable for the arguments (JMenu)
		 */
		
		//// ol.add(new JMenu());
		
		/*
		 * 但是可以添加null
		 */
		ol.add(null);
		
		System.out.println(ol+"\n");
	}
	
	

}
