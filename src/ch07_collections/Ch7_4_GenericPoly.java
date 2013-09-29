/**
 * <p>文件名称: Ch7_4_GenericPoly.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-4</p>
 * <p>完成日期：2011-3-4</p>
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

public class Ch7_4_GenericPoly {

	public static void main(String[] args) 
	{
		/**
		 * Generic 与 Polymorphism
		 * 
		 * 多态只适用于基础类型，不适用于泛型类型！！
		 * 
		 */
		//编译错误：Type mismatch: cannot convert from ArrayList<JButton> to List<Object>
		//// List<Object> list2 = new ArrayList<JButton>(); //多态不适用于泛型类型
		     List<Object> list1 = new ArrayList<Object>();  //多态适用于基础类型
		  
		  JButton b = new JButton();
		  list1.add(b);
		  System.out.println(list1);
		  /*
		   * 泛型 使得集合与数组一样有了类型安全，但是泛型中多态的工作方式与数组中不同
		   */
		  Object[] o1 = new JButton[3];		
		  Object   o2 = new JButton();
		  //运行时：java.lang.ArrayStoreException:
		  changeElem(o1);    
		  
		  
		  
		  
		//List<Object> list1 = new new ArrayList<JButton>();
		  List<? extends Object> list2 = new ArrayList<JButton>();
		  List<? super JMenu> list3 = new ArrayList<Object>();
		  
		  List<?> list4 = new ArrayList<JButton>();
		  /**
		   * List<? extends Object>
		   * List<?>
		   * 完全等同
		   */
		  
		  

	}
	private static void  changeElem(Object[] o){
		o[0] = new JMenu();
	}

}
