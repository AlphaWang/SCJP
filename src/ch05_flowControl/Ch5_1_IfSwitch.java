/**
 * <p>文件名称: Ch5_1_IfSwitch.java </p>
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

public class Ch5_1_IfSwitch 
{
	static int i = 5;
	public static void main (String[] args)
	{
		
	
		/**
		 * 1. else子句：属于 前面最接近的不带else的if语句
		 */
		int x = 5;
		if(x > 5)
			if(x < 3)
				x = 3;
		else//属于if(x < 3)！！
			x = 0;
			
		/**
		 * 2. switch表达式： 
		 * ————要么是enum，要么能提升为int：char /byte /short /int /enum
		 */
		
		/**
		 * 3. case子句：必须与switch表达式结果 类型相同
		 *              必须是编译时常量！！！
		 */
		final int a = 1 ;
		final int b;
		b = 2;
		//// b = 3;
		
		int y = 0;
		switch (y)
		{
			case 88:
			//// case y:   //case expressions must be constant expressions
			case a:
			//// case b:   //???case expressions must be constant expressions
			//// case i:   //case expressions must be constant expressions
			/*
			 * case 语句的值不能重复
			 */
			//// case 88://Duplicate case
			
		}
		
		
		/**
		 * 当switch类型小于int，case语句的值要 在取值范围内！！
		 */
		byte by = 127;
		switch (by)
		{
		 	case 127:
		 	//// case 128: //Type mismatch: cannot convert from int to byte
		}
		
		/**
		 * 4. default子句：不一定在最后一行；也会直落运行！！
		 */
		int z = 7;
		switch(z)
		{
			case 0 : System.out.println("0");
			default : System.out.println("default");
			case 2 : System.out.println("2");
			case 8 : System.out.println("8");
			//结果：default 2 8 
		}
		
		
	}
}
