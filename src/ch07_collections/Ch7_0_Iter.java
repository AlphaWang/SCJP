/**
 * <p>文件名称: Ch7_0_Iter.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-29</p>
 * <p>完成日期：2011-12-29</p>
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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ch7_0_Iter {
	
	/**
	 *  Iterator的威力：能够将遍历序列的操作  与 序列底层的结构分离
	 */
	public static void display(Iterator<Parent> iter){
		while(iter.hasNext()){
			Parent p = iter.next();
			System.out.print(p +" ");
		}
		System.out.println();
	}
	/**
	 * Iterator.remove()将迭代器新近返回的元素删除
	 * ————调用remove()前必须先调用next()
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
		 * 更强的迭代器：ListIterator, 可以双向迭代、替换元素
		 */
		//1. 向前迭代
		System.out.println("====ListIterator: forward");
		ListIterator<Parent> listIter = list.listIterator();
		while(listIter.hasNext()){
			System.out.println(
					listIter.next() + ", "
					+ listIter.nextIndex() + ", "
					+ listIter.previousIndex() + "; " 
					);
		}
		//2. 向后迭代
		System.out.println("====ListIterator: backward");
		while(listIter.hasPrevious()){
			System.out.println(
					listIter.previous() + ", "
					+ listIter.nextIndex() + ", "
					+ listIter.previousIndex() + "; " 
					);
		}
		//3. 替换元素: set()替换访问过的最后一个元素
		System.out.println("====ListIterator: set()");
		while(listIter.hasNext()){
			listIter.next();
			listIter.set(new Child3(1));
		}
		Iterator<Parent> iter3 = list.iterator();
		display(iter3);
	}

}
