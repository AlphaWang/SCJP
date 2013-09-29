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

import java.util.WeakHashMap;

class Element{
	private String id;
	public Element(String id){this.id = id;}
	public String toString(){return id;}
	public int hashCode(){return id.hashCode();}
	public boolean equals(Object e){
		return e instanceof Element && id.equals(( (Element)e).id );
	}
	protected void finalize(){
		System.out.println("Finalizing " + getClass().getSimpleName() + ": "+id);
	}
}

class Key extends Element{
	public Key(String id ){super(id);}
}
class Value extends Element{
	public Value(String id ){super(id);}
}
public class Ch7_8_WeakHashMap {
	public static void main(String[] args){
		int size = 1000;
		Key[] keys = new Key[size];
		
		WeakHashMap <Key, Value> map = new WeakHashMap<Key, Value>();
		for(int i =0; i < size; i++){
			Key k = new Key(String.valueOf(i));
			Value v = new Value(String.valueOf(i));
			map.put(k, v);
			
			if(i % 3 == 0){
				keys[i] = k;
			}
			
		}
		System.out.println(map.size());
		System.out.println(map);
		System.gc();
		System.out.println(map.size());
		System.out.println(map);
	}

}
