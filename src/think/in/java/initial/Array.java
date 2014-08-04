/**
 * <p>文件名称: Array.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-6</p>
 * <p>完成日期：2011-12-6</p>
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
package think.in.java.initial;

public class Array {
	public static void main(String[] args){
		printArray();
		printArray(0);
		printArray(1, new Object[]{
				new Book(false, "A"),
				new Book(true, "B"),
		});
		/**
		 * The argument of type Integer[] should explicitly be cast to Object[] 
		 * for the invocation of the varargs method printArray(int, Object...) from type Array. 
		 * 
		 * It could alternatively be cast to Object for a varargs invocation
		 */
		printArray(2, new Integer[]{1,2,3});
		printArray(3, (Object[]) new Integer[]{3,2,1});
	}
	
	static void printArray(int count, Object... array){
		System.out.print("Array "+count+": ");
		for(Object o : array){
			System.out.print(o + " ");
		}
		System.out.println();
	}
	
	static void printArray(Object... array){
		System.out.print("Array : ");
		for(Object o : array){
			System.out.print(o + " ");
		}
		System.out.println();
	}

}
