/**
 * <p>�ļ�����: Ch7_2_Map.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-1</p>
 * <p>������ڣ�2011-3-1</p>
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
		 * 5. Map�ӿڣ�����Ψһ��ʶ������������дhashCode()��equals()
		 * 
		 *   					ordered	sorted
		 * 		HashMap				��		��	����ʱ������˳�򡣼���HashMap�е�λ�� �ɼ��Ĺ�ϣ�����,������ֵΪnull��һ����Ϊnull
		 * 		Hashtable			��		��	HashMap��ͬ���汾������Vector-ArrayList
		 * 		LinkedHashMap		��		��	����LinkedHashSet
		 * 		TreeMap				��		��	Ԫ�ذ�����Ȼ˳�� ��������
		 * 
		 * HashMap: �ӹ�ϣ��ļ����в��Ҷ���ʱ��ͨ��hashCode()�ҵ���ȷ��ͨ��Ȼ��ʹ��equals()��Ͱ�ڲ�����ȷ��Ԫ��
		 */
		out.println("======Map�ӿ�======");
		HashMap<String,String>  hashmap = new HashMap<String, String>();
		hashmap.put(itemC, itemC+"value");
		hashmap.put(itemA, itemA+"value");
		hashmap.put(itemB, itemB+"value");
		hashmap.put(itemB2, itemB2+"value");
		hashmap.put(null, "value1");
		hashmap.put(null, "value2");//���ǵ�����
		
		out.println("----��������keySet()");
		for(String s : hashmap.keySet())
		{
			//������˳�򲢲��ǲ���˳�� >>����Ȼ˳�򣿣�����ɢ����˳��
			out.println("key="+s+", value="+hashmap.get(s));
		}
		out.println("----��������entrySet()");
		for(Map.Entry<String, String> entry : hashmap.entrySet()){
			out.println("key="+entry.getKey()+", value="+entry.getValue());
		}
		/**
		 * entrySet()�ṩ��ͼ �����Ǹ���������ͼ�����ԭʼӳ�������޸ģ����������У�
		 * 
		 * �������������ص�Set���ṩ�޸ķ������ֲ�����������޸�֮������������ֻ��ɾ��
		 */
		Set<Map.Entry<String, String>> entrySet = hashmap.entrySet();
		Iterator entryIter = hashmap.entrySet().iterator();		
		
		entrySet.remove(entryIter.next());
		
		//��������UnsupportedOperationException
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
		
		out.println("----�޸�entrySet��");
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
