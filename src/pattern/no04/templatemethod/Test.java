/**
 * <p>�ļ�����: Test.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-10-21</p>
 * <p>������ڣ�2011-10-21</p>
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
			System.out.println("ת��ǰ��"+input);
			String[] s = formatString(input);
			System.out.println("ת����");
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
		System.out.println("ת���У�");
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
