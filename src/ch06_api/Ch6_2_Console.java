/**
 * <p>文件名称: Ch6_2_Console.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-2-10</p>
 * <p>完成日期：2011-2-10</p>
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
package ch06_api;

import java.io.Console;

public class Ch6_2_Console {

	static String name;
	public static void main(String[] args) {
		/**
		 * Console类使得从命令行接受输入变得容易
		 */
		Console console = System.console();
		
		name = console.readLine("%s", "name: ");
		/**
		 * readPassword()返回一个char[](出于安全考虑)
		 */
		char[] pw = console.readPassword("%s", "password: ");
		
			console.format("用户名: %s ", name);
			console.format("密码: ");
		for(char c : pw){
			console.format("%c", c);
		}
			console.format("\n");
		pw = null;
		
		/**
		 * 2. 循环读取命令行输入	
		 */
		String input;
		MyUtility mu = new MyUtility();
		while(true)
		{
			input = console.readLine("%s", "message:");
			console.format("new message: %s \n", input);
			console.format("new message: %s \n", mu.doStuff(input));
			
			if("exit".equalsIgnoreCase(input)){
				break;
			}
		}
		
		
		

	}

}
class MyUtility{
	String doStuff(String arg){
		return Ch6_2_Console.name + " : " + arg;
	}
}
