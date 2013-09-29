/**
 * <p>文件名称: Ch5_2_Iterator.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-18</p>
 * <p>完成日期：2011-1-18</p>
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
package ch05_flowControl;

public class Ch5_2_Iterator 
{
	public static void main(String[] args)
	{
		/**
		 * 1. while循环
		 *    表达式内使用的任何变量，必须在表达式计算之前 声明
		 */
		/**
		 * 2. do循环
		 *    do循环内的代码将保证至少执行一次
		 *    while表达式末尾应该有分号！
		 */
		/**
		 * 3. for循环
		 *    除了强制退出外，for循环最后做的两件事总是：先计算迭代表达式，再计算条件表达式
		 *    (强制退出: break /return /System.exit()
		 *    
		 *    ——增强型for循环，第一部分必须是声明变量！
		 */
		int age = 15;
		iterator:
			while( age <= 17){
				age ++;
				if(age == 16){
					System.out.println("get your driver's license");
					continue iterator;
				}else{
					System.out.println("another age");
				}
			}
		
		
		int x = 0;
		int[] y = {1,2};
		//——增强型for循环，第一部分必须是声明变量！
		//// for( x:y)    {System.out.println(x);}
		
	}
	

}
