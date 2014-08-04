/**
 * <p>文件名称: Ch7_4_Generic.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-3</p>
 * <p>完成日期：2011-3-3</p>
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Test0<K> extends ArrayList<K> {
	K get(K k){
		return super.get(0);
	}
}

class Test1 extends ArrayList<String>{}

//Waring: The type parameter String is hiding the type String
class Test2<String> extends ArrayList<String>{}

class Test3 implements Iterator<String> {
	@Override
	public boolean hasNext() { return false;}
	@Override
	public String next() {	return null;}
	@Override
	public void remove() {}
}

//Warning: The type parameter String is hiding the type String
class Test4<String> implements Iterator<String>{
	@Override
	public boolean hasNext() { return false;}
	@Override
	public String next() {	return null;}
	@Override
	public void remove() {}
}

public class Ch7_4_Generic {
	public static void main(String[] args) {
		//The type Test1 is not generic; it cannot be parameterized with arguments <String>
		//// Test1<String> t1 = new Test1<String>();
		     Test2<String> t2 = new Test2<String>();
		//// Test3<String> t3 = new Test3<String>();
		     Test4<String> t4 = new Test4<String>();
		/**
		 * 泛型可以用于：
		 * 1. 声明集合变量
		 * 2. 方法参数
		 * 3. 返回类型
		 */
		
		/**
		 * 1. 混用泛型、非泛型集合
		 * 
		 * 作为参数传入 非泛型方法
		 * addAll并不对intList做修改，所以无风险，顶多ClassCastException
		 * 
		 * ！！会有编译警告：
		           注意：Ch7_4_Generic.java 使用了未经检查或不安全的操作。
			注意：要了解详细信息，请使用 -Xlint:unchecked 重新编译。
			
		 */
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(4);
		intList.add(6);
		
		out.println("===初始状态");
		out.println("list: "+ intList);
		int total = addAll(intList);
		out.println("total: "+total);
		 
	   /*
	    *  在insertInt中，对intList插入Integer，正常运行。可以理解。
	    */
		out.println("===insertInt()");
		insertInt(intList);
		out.println("list: "+ intList);
		
		/*
		 * 在insertStr中，对intList插入String，正常运行！！！！
		 */
		/**
		 * 为什么能运行呢？
		 * 
		 * ————泛型是为了进行“编译时保护”。
		 * 在运行时已经进行类型擦除(type erasure)，泛型化信息不存在！(为了支持遗留代码)
		 * 甚至在运行时会自动插入强制转换
		 * 
		 */
		out.println("===insertStr()");
		insertStr(intList);            //1) add错误类型的元素时，没有问题；
		out.println("list: "+ intList);
		
		// 此时再addAll()，会抛ClassCastException:java.lang.String cannot be cast to java.lang.Integer
		// add错误类型的元素时，没有问题；但将这个元素取出并错误使用时 ，则有问题！！！
		
		int total2 = addAll(intList);  //2) 但将这个元素取出并错误使用时 ，则有问题
		out.println("total: "+total2);

	}
	/**
	 * 非泛型方法： 不修改list
	 */
	static int addAll(List list) {
		int total = 0;
		for(Object o : list){
			total += (Integer)o;
		}
		return total;
	}
	/**
	 * 非泛型方法： 修改list，插入int
	 */
	static void insertInt(List list) {
		list.add(new Integer(42));
	}
	/**
	 * 非泛型方法： 修改list，插入String
	 */
	static void insertStr(List list){
		list.add(new String("s"));
	}

}
