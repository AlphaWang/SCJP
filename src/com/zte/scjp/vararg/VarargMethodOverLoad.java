/**
 * <p>文件名称: VarargMethodOverLoad.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-18</p>
 * <p>完成日期：2010-6-18</p>
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
package com.zte.scjp.vararg;
import static java.lang.System.out;
/**
 * 参数为Vararg的方法 重载
 * @author WangZhongXing192063
 *
 */
public class VarargMethodOverLoad {

	/**
	 * 取一组int中的最大值, 参数为varargv
	 */
	public static int max(int... values)
	{
		int max = Integer.MIN_VALUE;
		if(values.length == 0)
		{
			throw new IllegalArgumentException("参数长度不可为0");
		}
		for(int i : values)
		{
			if(i>max)
			{
				max = i;
			}
		}
		return max;
	}
	/**
	 * 如果参数为int[]，则提示方法重复
	 */
	/*public static int max(int[] values)
	{
		int max = Integer.MIN_VALUE;
		if(values.length == 0)
		{
			throw new IllegalArgumentException("参数长度不可为0");
		}
		for(int i : values)
		{
			if(i>max)
			{
				max = i;
			}
		}
		return max;
	}*/
	
	public static void main(String[] args)
	{
		out.println("入参为多个int:" + max(7,2,3));
		out.println("入参为int[]:" +   max(new int[]{2,78,7}));
		
		//out.println(max());
		//out.println(max(null));
	}
}
