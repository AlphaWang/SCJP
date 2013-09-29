/**
 * <p>文件名称: FormatHex.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-21</p>
 * <p>完成日期：2010-6-21</p>
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
package com.zte.scjp.format;
import static java.lang.System.out;

public class FormatHex {
	public static void main(String[] args) 
	{
		int num = 656898;
		long longNum = 653857658;
		out.printf("%%x :%x\n", num);
		out.printf("%%#x :%#x\n", num);
		out.printf("%%o :%o\n", longNum);
		out.printf("%%#o :%#o\n", longNum);

	}

}
