/**
 * <p>�ļ�����: Ch6_1_String.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-25</p>
 * <p>������ڣ�2011-1-25</p>
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
import static java.lang.System.out;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Ch6_1_String {

	public static void main(String[] args) {
		/**
		 * 1. String�����в��ɱ��ԡ�
		 */
		String s = "abc";
		s.concat("def");
		s.replace('a','x');
		out.println(s); //abc
		
		/*
		 * String���ڴ棺
		 * JVM����һ��������ڴ�����String�����ء���
		 * ����String����ֵʱ ���ȼ������Ƿ��Ѵ�����ͬ������ֵ�����ҵ�����ֱ���ṩ��������
		 * 
		 * ��������String�Ĳ��ɱ��Ե�ԭ��
		 * ��������String���ᱻ�̳���д����Ϊ��final��
		 */
		String s1 = "abc";//����String������
		String s2 = new String("abc");//���볣���ڴ棡��
		
		/**
		 * 2. StringBuffer��StringBuilder
		 *    ����Ҫ���ַ����������޸�ʱ ����
		 *    ����StringBuilder�����̰߳�ȫ�ģ�StringBuffer���еķ��� ����ͬ����
		 *    ����StringBuilder�еķ�������
		 */
		StringBuilder sb = new StringBuilder("0123456789");
		sb.insert(4, "---");//ƫ������0��ʼ���㣬���뵽���ĸ�λ�á�
		out.println(sb);    //0123---456789
		
		out.println(sb.substring(1, 3));//12
										//��һ��ƫ���� �� 0 ��ʼ����
		                                //�ڶ����� 1 ��ʼ����
		
		
		/**
		 * ? ÿ��Writer���Ḳ��ԭ�������ݣ�
		 */
		File file2 = new File("test.txt");
		//createNewFile()������ļ������ڣ��򴴽�
		try {
			//boolean newFile = file2.createNewFile();
			//out.println("�ٴδ�������װ.txt��"+newFile);
			PrintWriter pw4 = new PrintWriter(new FileWriter(file2));
			pw4.println("new line");
			pw4.flush();
			pw4.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
