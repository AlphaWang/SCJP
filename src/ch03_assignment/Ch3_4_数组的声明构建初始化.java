/**
 * <p>文件名称: Ch3_4_数组的声明构建初始化.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-12-29</p>
 * <p>完成日期：2010-12-29</p>
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
package ch03_assignment;

import java.util.Date;

public class Ch3_4_数组的声明构建初始化 {
	public static void main(String[] args)
	{
		
	
		/**
		 * 1. 数组声明	
		 *  声明时永远不能包含数组长度！
		 */
		Date[] dates;
		int[] nums;
		//// int [4] nums2;
		/**
		 * 2. 数组构建：在堆上创建数组对象
		 *   构建时必须指定长度！
		 */
		dates  = new Date[4];
		nums = new int[4]; //基本类型数组，各元素自动赋值为 0 ！
		//// dates = new Date[];
		/**
		 * 3. 数组初始化：将内容放入数组中
		 */
		for(int x=0; x<nums.length;x++)
			nums[x]=x;
		
		
		
		
		
		/**
		 * 4. 快捷创建1：在一行内声明、构建、初始化数组
		 * 
		 * ！可以在声明数组的同时，{}初始化。
		 * ！但不能在声明之后 单独{}初始化
		 */
		//！下面语句 非法：
		//// dates  = {new Date(), new Date()};
		//// nums = {1,2,3,4};
		Date[] dates2 = {new Date(), new Date()};
		int[] nums2 = {1,2,3,4};
		int[][] nums3 = {{1,2},{3},{4}};//这里创建了4个对象！
		
		/**
		 * 5. 快捷创建2：匿名数组
		 */
		int[] nums4;
		nums4 = new int[]{11,22};
		
		int[] nums5 = new int[]{11,22};
		//使用匿名数组时，不必指定数组大小：
		//Cannot define dimension expressions when an array initializer is provided
		//// int[] nums6 = new int[2]{11,22};
		
		/**
		 * 6. 合法的数组元素赋值
		 * 		1）基本元素：能隐式提升到声明的类型即可
		 * 		2）对象引用：支持多态
		 * 		3）多维数组：将一个数组赋值给另一个数组引用，二个数组必须维数一致！
		 */
		byte b=4;
		char c = 'c';
		short s = 7;
		int[] is2 = new int[3];
		is2[0] = b;
		is2[1] = c;
		is2[2] = s;
		
		

		/**
		 * 数组的多态性
		 */
		P p = new C();		
		P[] ps;
		ps = new P[5];
		ps = new C[5];
		
		long l = new Integer(2);
		//// long[] ls = new Integer[3];
		/*
		 * byte可以显式提升为int，但是byte[]不能赋值给int[]
		 * byte[] is not a int[]
		 */
		////int[] is = new byte[3];
		
	}
}

class P{
	
}
class C extends P{
	
}
