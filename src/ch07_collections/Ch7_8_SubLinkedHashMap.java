/**
 * <p>文件名称: Ch7_8_WeakHashMap.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2012-1-12</p>
 * <p>完成日期：2012-1-12</p>
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

import java.util.LinkedHashMap;
import java.util.WeakHashMap;

public class Ch7_8_SubLinkedHashMap<K,V> extends LinkedHashMap<K,V>{

	private static final int MAX_SIZE = 5;
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
		
		return size() >= MAX_SIZE;
	}
	
	public static void main(String[] args){
		Ch7_8_SubLinkedHashMap<String,String> map = new Ch7_8_SubLinkedHashMap<String,String>();
		map.put("1", "1");
		System.out.println(map);		
		map.put("2", "1");
		System.out.println(map);
		map.put("3", "1");
		System.out.println(map);
		map.put("4", "1");
		System.out.println(map);
		map.put("5", "1");
		System.out.println(map);
		map.put("6", "1");
		System.out.println(map);
		map.put("7", "1");
		System.out.println(map);
		map.put("8", "1");
		System.out.println(map);
		map.put("9", "1");
		System.out.println(map);
		map.put("10", "1");
		System.out.println(map);
		map.put("11", "1");		
		System.out.println(map);
		
	}
	
	
}
