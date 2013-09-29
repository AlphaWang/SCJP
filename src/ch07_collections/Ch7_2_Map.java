/**
 * <p>文件名称: Ch7_2_Map.java </p>
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

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ch7_2_Map {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String itemC = "C";
		String itemA = "A";
		String itemB = "B";
		String itemB2 = "B";
		
		/**
		 * 
		 * 5. Map接口：关心唯一标识符。键必须重写hashCode()、equals()
		 * 
		 *   					ordered	sorted
		 * 		HashMap				×		×	遍历时不关心顺序。键在HashMap中的位置 由键的哈希码决定,允许多个值为null、一个键为null
		 * 		Hashtable			×		×	HashMap的同步版本，类似Vector-ArrayList
		 * 		LinkedHashMap		√		×	类似LinkedHashSet
		 * 		TreeMap				√		√	元素按照自然顺序 升序排列
		 * 
		 * HashMap: 从哈希码的集合中查找对象时，通过hashCode()找到正确的通，然后使用equals()在桶内查找正确的元素
		 */
		out.println("======Map接口======");
		HashMap<String,String>  hashmap = new HashMap<String, String>();
		hashmap.put(itemC, itemC+"value");
		hashmap.put(itemA, itemA+"value");
		hashmap.put(itemB, itemB+"value");
		hashmap.put(itemB2, itemB2+"value");
		hashmap.put(null, "value1");
		hashmap.put(null, "value2");//覆盖掉上者
		
		out.println("----遍历方法keySet()");
		for(String s : hashmap.keySet())
		{
			//遍历的顺序并不是插入顺序 >>是自然顺序？？？？散列码顺序！
			out.println("key="+s+", value="+hashmap.get(s));
		}
		out.println("----遍历方法entrySet()");
		for(Map.Entry<String, String> entry : hashmap.entrySet()){
			out.println("key="+entry.getKey()+", value="+entry.getValue());
		}
		/**
		 * entrySet()提供视图 而不是副本，该视图允许对原始映射表进行修改（而副本则不行）
		 * 
		 * ————但返回的Set不提供修改方法，又不能增，如何修改之？？————只能删除
		 */
		Set<Map.Entry<String, String>> entrySet = hashmap.entrySet();
		Iterator entryIter = hashmap.entrySet().iterator();		
		
		entrySet.remove(entryIter.next());
		
		//————UnsupportedOperationException
//		entrySet.add(new Map.Entry<String, String>(){
//			public String getKey() {
//				return "NewKey";
//			}
//			public String getValue() {
//				return "NewValue";
//			}
//			public String setValue(String value) {
//				return null;
//			}
//		});
		
		out.println("----修改entrySet后");
		for(Map.Entry<String, String> entry : hashmap.entrySet()){
			out.println("key="+entry.getKey()+", value="+entry.getValue());
		}
		
	}

}

class SlowMap<K,V> extends AbstractMap<K, V>{

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
