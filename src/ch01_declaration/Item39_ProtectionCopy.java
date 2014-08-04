/**
 * <p>文件名称: Item39_保护性拷贝.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-10</p>
 * <p>完成日期：2010-9-10</p>
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
package ch01_declaration;

import java.util.Date;

public class Item39_ProtectionCopy {
	private Date date;
	public void period(Date d)
	{
		//this.date = new Date(d.getTime());
		this.date = d;
	}
	public static void main(String[] args){
		Date today = new Date();
		String name = new String("old");
		
		Item39_ProtectionCopy o = new Item39_ProtectionCopy();
		o.period(today);
		System.out.println(o.date);
		
		today.setYear(89);
		name = name.toUpperCase();
		System.out.println(o.date);//修改today，date值也会变
	}
}
