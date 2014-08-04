/**
 * <p>文件名称: Ch1_5_SubClass_引用.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-9-15</p>
 * <p>完成日期：2010-9-15</p>
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
package ch01_declaration_subclass;


public class Ch1_5_OutPackSubClass_Ref {
	
	public  static void main(String[] args)
	{
		//TODO test
		Ch1_5_OutPakSubClass subclass = new Ch1_5_OutPakSubClass();
		
		/**
		 * 1. 外包中的子类， 可以继承protected成员，	
		 *    但子类中的该protected成员 不可被其他类访问！
		 *    
		 *    is not visible
		 */
		int i = subclass.protectedVar;
		subclass.protectedMethod();
		
	}

}
