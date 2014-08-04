/**
 * <p>文件名称: Ch3_2_局部变量.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-12-10</p>
 * <p>完成日期：2010-12-10</p>
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

public class Ch3_2_LocalVar 
{
	String instanceVar;
	
	int[] instanceArray = new int[10];
	
	static Integer staticInt;
	
	public static void main(String[] args)
	{
		Ch3_2_LocalVar obj = new Ch3_2_LocalVar();
		
		if(obj.instanceVar == null){
			System.out.println("instanceVar == null");
		}
		/**
		 * 1. 局部引用变量 不会被赋予默认值，即不是null！
		 */
		String localVar;
		//--localVar may not have been initialized
		/*
		if(localVar == null){
			System.out.println("localVar == null");
		}
		*/		
		
		String localVar2 = null;
		if(localVar2 == null){
			System.out.println("localVar2 == null");
		}
		
		
		
		/**
		 * Integer实例变量，不会被初始化为0，而是null！！！！
		 */
		System.out.println("staticInt = " +staticInt);
		
		/**
		 * 2. 初始化数组后，其数组元素都被赋予默认值！	int = 0
		 */
		System.out.print("instanceArray: ");
		for(int elem : obj.instanceArray){
			System.out.print(elem+",");
		}
		System.out.println();
		/**
		 * 2. 即便数组为局部变量，其元素也会赋予默认值！
		 */
		System.out.print("localArray: ");
		int[] localArray = new int[2];
		for(int elem : localArray){
			System.out.print(elem+"," );
		}
		System.out.println();
		
	}

}
