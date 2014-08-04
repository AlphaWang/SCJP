/**
 * <p>�ļ�����: Ch7_8_WeakHashMap.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2012-1-12</p>
 * <p>������ڣ�2012-1-12</p>
 * <p>�޸ļ�¼1: // �޸���ʷ��¼�������޸����ڡ��޸��߼��޸�����</p>
 * <pre>
 *    �޸����ڣ�
 *    �� �� �ţ�
 *    �� �� �ˣ�
 *    �޸����ݣ�
 * </pre>
 * <p>�޸ļ�¼2����</p>
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
