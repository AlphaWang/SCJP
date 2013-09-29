/**
 * <p>�ļ�����: Ch6_5_Regex.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-2-12</p>
 * <p>������ڣ�2011-2-12</p>
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

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;
public class Ch6_5_Regex {

	/**
	 * 0. Pattern���ҵ�ͳһ����
	 *    java.util.regex.Pattern: ���ڱ���������ʽ�ı�ʾ���Ա�Matcher����ʹ�ú͸�����
	 *    java.util.regex.Matcher: ���ڵ���������ʽ���棬�Ա�ִ��ƥ�����
	 */
	public static void match(String expres, String source)
	{
		out.println("��"+source+"����"+expres+": ");
		
		Pattern pattern = Pattern.compile(expres);      //Pattern.compile(String):��������������ʽ���뵽ģʽ��
		Matcher matcher = pattern.matcher(source); 		//pattern.matcher(String):����ƥ������������ģʽ��ƥ����
		
		//Matcher.groupCount(): ���ش�ƥ����ģʽ�еĲ��������� 
		out.println("matcher.groupCount() = "+matcher.groupCount());
		//Matcher.find():���Բ������ģʽƥ����������е���һ��������		
		while(matcher.find())                     
		{
			//Matcher.start():������ǰƥ��ĳ�ʼ����
			//Matcher.group():��������ǰƥ�������ƥ�������������
			out.println(matcher.start() + "~"+matcher.end()+"\t: >" + matcher.group()+"<");    
		}
		out.println();
	}
	


	public static void main(String[] args) 
	{
		String source;
		String expres;
		/**
		 ** 1. ������ʽ>>>����
		 **    ������ʽ���Կ�����һ�μ��̵ĳ����ű�
		 **    
		 */
		out.println("======1. ����");
		/**
		 * 1.1 �򵥲���
		 * 
		 *     source		:abababa
		 *     index		:0123456
		 *     expression	:aba
		 */
		//ע��������ʽ�������Ҳ��ң�ֻҪ��һ��ƥ�����õ���Դ��һ���ַ����Ͳ������ظ�ʹ����
		
		expres = "aba";
		source = "abababa";
		 //index :0123456
		match(expres, source);
		
		
		
		/**
		 * 1.2 ʹ��Ԫ�ַ�����(meta-character)
		 * 
		 * 		source		:a12c3e456f
		 * 		index		:0123456789
		 *      expression	:\d
		 *   
		     	\d	:����
		     	\s	:�ո�
		     	\w	:�ַ�(��ĸ�����֡�_)
		     	[abc] 		a��b �� c�����ࣩ 
				[^abc] 		�κ��ַ������� a��b �� c���񶨣� 
				[a-zA-Z] 	a �� z �� A �� Z����ͷ����ĸ�������ڣ���Χ�� 
				[a-d[m-p]] 	a �� d �� m �� p��[a-dm-p]�������� 
				[a-z&&[def]] d��e �� f�������� 
				[a-z&&[^bc]] a �� z������ b �� c��[ad-z]����ȥ�� 
				[a-z&&[^m-p]] a �� z������ m �� p��[a-lq-z]����ȥ�� 

		 */
		expres = "\\d";
		source = "a12c3e456f";
		//index	 :0123456789
		match(expres, source);
		/*
		1~2	: >1<
		2~3	: >2<
		4~5	: >3<
		6~7	: >4<
		7~8	: >5<
		8~9	: >6<		
		*/
		//TODO "������"����α�ʾ��
		System.out.println("a12c3e456f".replaceAll("(\\d)", ""));
		
		
		/**
		 * 1.3 ʹ�����ʲ���
		 * 
		 		
		 		+	: 1�λ���ƥ��
		 		*	: 0�λ���ƥ��
		 		?	: 0�λ�1��ƥ��
		 		.	: ƥ�������ַ�
		 */
		
		// + ̰�����ʣ�1���� (������Ӧ��ǿ���ʣ�+?)
		expres = "0[xX]([0-9a-fA-F])+";//0x֮����ַ� �ɳ���1~��Σ�����+
		source = "12 0x 0x12 0xf 0xg";
		//index  :012345678901234567
		out.println("����ʮ����������ֵ��");
		match(expres, source);
		/*
		6~10	: >0x12<
		11~14	: >0xf<
		*/
		
		// * ̰�����ʣ�0���� (������Ӧ��ǿ���ʣ�*?)
		expres = "proj([^,])*";//proj��ɸ�0�����ַ�����������","
		source = "proj,proj.txt,proj.java,proj2.java,ptest.class";
		//index  :0123456789012345678901234567890123456789012345
		out.println("������proj��ͷ��proj([^,])*��");
		match(expres, source);
		/*
		0~4	    : >proj<
		5~13	: >proj.txt<
		14~23	: >proj.java<
		24~34	: >proj2.java<
		*/
		
		// ? ̰�����ʣ�0��1�� (������Ӧ��ǿ���ʣ�??)
		expres = "\\d\\d\\d\\d([\\s-])?\\d\\d\\d\\d";//�ո�-������0�λ�1��
		source = "0556-5261 0556 4031 05564031";
		//index  :0123456789012345678901234567
		out.println("���ҵ绰�����ַ�\\d\\d\\d\\d[\\s-]?\\d\\d\\d\\d��");
		match(expres, source);
		/*
		0~9	    : >0556-5261<
		10~19	: >0556 4031<
		20~28	: >05564031<
		*/
		
		// . ���� ���˴������������ַ�
		//���Ҫ����.�ַ�����Ҫʹ��"\\."
		expres = "a.c";
		source = "abc  ac a c acc";
		//index  :012345678901234
		match(expres, source);
		/*
		0~3	    : >abc<
		8~11	: >a c<
		12~15	: >acc<
		*/
		
		//̰������
		// *��̰�����ʣ�0����ƥ��
		expres = "\\d*";
		source = "ab34ef";
		match(expres,source);
		/*
		0~0	: ><
		1~1	: ><
		2~4	: >34<
		4~4	: ><
		5~5	: ><
		6~6	: ><
		*/
		
		expres = ".*xx";
		source = "yyxxxyxx";
		//index  :01234567
		match(expres, source);//�����0 yyxxxyxx,
		/*
		0~8	: >yyxxxyxx<
		*/
		
		// *? ����ǿ���ʣ�0����ƥ��
		expres = ".*?xx";
		match(expres, source);//�����0 yyxx;4 xyxx
		/*
		0~4	: >yyxx<
		4~8	: >xyxx<
		*/
		
		expres = ".?xx";
		match(expres, source);
		/*
		1~4	: >yxx<
		5~8	: >yxx<
		*/
		
		
		/*
		 * �ο�������̰������*��?���ʹ��ʱ��find()�������㳤��ƥ�䡰
		 */
		expres ="y?";
		match(expres, source);
		/*
		0~1	: >y<
		1~2	: >y<
		2~2	: ><
		3~3	: ><
		4~4	: ><
		5~6	: >y<
		6~6	: ><
		7~7	: ><
		8~8	: ><
		*/
		
		/**
		 * java.util.Scanner Ҳ�����ڲ���
		 * 
		 * new Scanner(source)
		 * Scanner.findInLine(expres)
		 */
		Scanner s = new Scanner("ab12aba355b77a");
		String token ;
		out.println("Scanner���ң�source=ab12aba355b77a, expres=\\d\\d: ");
		do{
			token = s.findInLine("\\d\\d");
			out.println(token);
		}while(token != null);
		 
		
		/**
		 ** 2. �ֽ� tokenizing
		 ** 
		 **	��ǣ�token, ʵ�����ݲ���
		 ** �������delimiter, ����������Ϊ������ʽ���κ����ݣ�����\d
		 */
		out.println("======2. �ֽ�");
		/*
		 * 2.1 ����String.split()���зֽ�
		 *    ȱ�㣺�ֽ����һ����ɣ�����ֹͣ
		 */
		String token2 = "ad,cd54b,6 x,z4"; //54,���������� �ᴴ��һ���ձ��
		String[] tokens = token2.split("\\d");
		
		out.println("\n==����String.split()���зֽ�==");
		out.println("token="+token2 +"; delimiter = \\d");
		for(String st : tokens){
			out.println(">"+st+"<");
		}
		/*
		 * 2.2 ����Scanner���зֽ�
		 * �ŵ㣺
		 *    ���Խ��ļ��������ַ�����Ϊsource
		 *    �ֽ���ѭ����ִ�У�������ʱ�˳��ֽ�
		 *    ���Խ����token�Զ�ת��Ϊ��������
		 */
		String source1 ="ad,cd54b,6 x,z4 6 a 9";
		String source2 ="78 5 a b1 ";
		Scanner sc1 = new Scanner(source1);
		Scanner sc2 = new Scanner(source2);
		
		out.println("\n==����Scanner���зֽ�==");
		out.println("Scanner��Ĭ�϶������"+sc1.delimiter());
		
		sc1.useDelimiter("\\d");
		out.println("ʹ�ö����sc.useDelimiter(\"\\d\")��"+sc1.delimiter());
		out.println("token="+source1 +"; delimiter = "+sc1.delimiter());
		
		while(sc1.hasNext())
		{
			out.println(">"+sc1.next()+"<" );
		}
		
		out.println("token="+source2 +"; delimiter = "+sc2.delimiter()+", nextInt():");
		while(sc2.hasNextInt())
		{
			out.println(">"+sc2.nextInt()+"<");//�Զ�ת��Ϊ��������
		}
		
		/**
		 * 3. �滻
		 * 
		 *   ���ַ����е�Ԫ����ĸ��д��ʾ
		 */
		out.println("======3. �滻");
		String text = " ab cd ef gh  i   j\n kl m";
		out.println("ԭʼ��\n"+text);
		//����ո� --> һ���ո�
		text = text.replaceAll(" {2,}", " ");
		//���׿ո� --> ""
		text = text.replaceAll("(?m)^ +", "");   //??
		out.println("ȥ���ո�\n"+text);
		
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[aeiou]");
		Matcher matcher = pattern.matcher(text);
		
		out.println("matcher�滻��");
		out.print("matcher.group(): ");
		while(matcher.find()){
			out.print(matcher.group() + ", ");
			/*
			 * String.replace()ֻ���滻��ͨ�ַ����� ��appendReplacement������������滻���ַ�����
			 */
			matcher.appendReplacement(sb, matcher.group().toUpperCase());
		}
		/*
		 * ��ʣ��δ����Ĳ��ִ���sb
		 */
		matcher.appendTail(sb);
		
		out.println("\n matcher.appendReplacement()��\n"+sb);
	}

}
