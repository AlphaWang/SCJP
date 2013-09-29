/**
 * <p>文件名称: Test.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-10-21</p>
 * <p>完成日期：2011-10-21</p>
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
package pattern.no04.templatemethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	protected static boolean hasRemain = true;
	static BufferedReader reader;
	static{
		FileReader fileReader;
		try {
			fileReader = new FileReader(new File("D:\\tmp.txt"));
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String args[]){
		
		/*//String input = ",,2012,0,,3,'1/2/15',\"2,5@4,6\",\"1,6@8,9\",4096";
		String input;
		try {
			input = reader.readLine();
			System.out.println("转换前："+input);
			String[] s = formatString(input);
			System.out.println("转换后：");
			for(int i = 0; i<s.length; i++){
				System.out.println(s[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String before = "4097";
		String tmp = Long.toBinaryString(Long.parseLong(before));
		System.out.println(tmp);
		for(int i=tmp.length(); i<32; i++){
			tmp = "0" + tmp;
		}
		System.out.println(tmp);
		int binaryLength = tmp.length();
		String bin16to32 = tmp.substring(binaryLength-32, binaryLength-16);
		String bin0to12 = tmp.substring(binaryLength-12, binaryLength);
		
		String after = bin16to32 + "0000" + bin0to12;
		Long afterLong = Long.parseLong(after,2);
		System.out.println(after);
		System.out.println(afterLong);
		
		long m = Long.parseLong(before);
		System.out.println(Long.parseLong("11111111111111110000111111111111", 2));
		
		
		System.out.println(m & 4294905855L);
		
		
		
		
		
		
		
		
	}
	
	private static String[] formatString(String content)
	{
		if(content == null) {
			hasRemain = false;
			return new String[0];
		}
		
		String[] split = content.split(",");
		System.out.println("转换中：");
		for(int i = 0; i<split.length; i++){
			System.out.println(split[i]);
		}
		ArrayList list = new ArrayList();
		boolean index = false;
		String tempStr = "";
		for(int i=0; i<split.length; i++)
		{
			if(split[i].indexOf("\"") != -1)
			{
				tempStr = tempStr + "," + split[i];
				if(index)
				{
					index = false;	
					//tempStr = tempStr.substring(3, tempStr.length()-2);
					tempStr = tempStr.substring(2, tempStr.length()-1);
					list.add(tempStr);
					tempStr="";
				}
				else
				{
					index = true;
				}
			}
			else
			{
				if(index== true)
				{
					tempStr = tempStr+ "," + split[i];
				}
				else
				{
					list.add(split[i]);
				}
			}
		}
		String[] str = new String[list.size()];
		for(int i=0; i<list.size(); i++)
		{
			str[i] = list.get(i).toString();
		}
		return str;
	}

}
