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
