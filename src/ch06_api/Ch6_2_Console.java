/**
 * <p>�ļ�����: Ch6_2_Console.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-2-10</p>
 * <p>������ڣ�2011-2-10</p>
 * <p>�޸ļ�¼1: // �޸���ʷ��¼�������޸����ڡ��޸��߼��޸�����</p>
 * <pre>
 *    �޸����ڣ�
 *    �� �� �ţ�
 *    �� �� �ˣ�
 *    �޸����ݣ�
 * </pre>
 * <p>�޸ļ�¼2����</p>
 * @version 1.0
 * @author WangZhongXing192063
 */
package ch06_api;

import java.io.Console;

public class Ch6_2_Console {

	static String name;
	public static void main(String[] args) {
		/**
		 * Console��ʹ�ô������н�������������
		 */
		Console console = System.console();
		
		name = console.readLine("%s", "name: ");
		/**
		 * readPassword()����һ��char[](���ڰ�ȫ����)
		 */
		char[] pw = console.readPassword("%s", "password: ");
		
			console.format("�û���: %s ", name);
			console.format("����: ");
		for(char c : pw){
			console.format("%c", c);
		}
			console.format("\n");
		pw = null;
		
		/**
		 * 2. ѭ����ȡ����������	
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
