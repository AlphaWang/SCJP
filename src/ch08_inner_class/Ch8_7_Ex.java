/**
 * <p>文件名称: Ch8_7_Ex.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-16</p>
 * <p>完成日期：2011-3-16</p>
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
package ch08_inner_class;

import java.util.Comparator;

public class Ch8_7_Ex {
	
	public static void main(String[] args)
	{
		String[] strs = {"nickel","button","key","lint"};
		Sorter s = new Ch8_7_Ex().new Sorter();
	}
	
	class Sorter implements Comparator<String>
	{
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	}

}
