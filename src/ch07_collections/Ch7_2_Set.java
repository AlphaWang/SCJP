/**
 * <p>文件名称: Ch7_2_Set.java </p>
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

import java.util.HashSet;

public class Ch7_2_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String item1 = "C";
		String item2 = "A";
		String item3 = "B";
		String item4 = "B";
		
		/**
		 * 
		 * 4. Set接口：关心唯一性，元素不可equals
		 *  					ordered	sorted
		 * 		HashSet				×		×	不具有重复值，且遍历时不关心顺序，就可使用HashSet
		 * 		LinkedHashSet		√		×	元素之间双链接。迭代时按照元素插入顺序
		 * 		TreeSet				√		√	元素按照自然顺序 升序排列
		 * 										————插入到TreeSet里的对象，必须是可互相比较的！！
		 * 											如果插入两个不同类的对象，则会ClassCastException
		 * 
		 */
		out.println("======Set接口======");
		HashSet<String> hashset = new HashSet<String>();
		hashset.add(item1);
		hashset.add(item2);
		hashset.add(item3);
		boolean is = hashset.add(item4); //添加重复元素，不会真的加进去
		out.println(is);		
		
		for(String s : hashset)
		{
			//这个for循环，输出顺序不可预测
			out.println("元素"+s+":"+hashset.contains(s));
		}
	}

}
