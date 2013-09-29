/**
 * <p>文件名称: Ch6_5_Regex.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-2-12</p>
 * <p>完成日期：2011-2-12</p>
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

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;
public class Ch6_5_Regex {

	/**
	 * 0. Pattern查找的统一方法
	 *    java.util.regex.Pattern: 用于保存正则表达式的表示，以便Matcher类能使用和复用它
	 *    java.util.regex.Matcher: 用于调用正则表达式引擎，以便执行匹配操作
	 */
	public static void match(String expres, String source)
	{
		out.println("从"+source+"查找"+expres+": ");
		
		Pattern pattern = Pattern.compile(expres);      //Pattern.compile(String):将给定的正则表达式编译到模式中
		Matcher matcher = pattern.matcher(source); 		//pattern.matcher(String):创建匹配给定输入与此模式的匹配器
		
		//Matcher.groupCount(): 返回此匹配器模式中的捕获组数。 
		out.println("matcher.groupCount() = "+matcher.groupCount());
		//Matcher.find():尝试查找与该模式匹配的输入序列的下一个子序列		
		while(matcher.find())                     
		{
			//Matcher.start():返回以前匹配的初始索引
			//Matcher.group():返回由以前匹配操作所匹配的输入子序列
			out.println(matcher.start() + "~"+matcher.end()+"\t: >" + matcher.group()+"<");    
		}
		out.println();
	}
	


	public static void main(String[] args) 
	{
		String source;
		String expres;
		/**
		 ** 1. 正则表达式>>>查找
		 **    正则表达式可以看做是一段极短的程序或脚本
		 **    
		 */
		out.println("======1. 查找");
		/**
		 * 1.1 简单查找
		 * 
		 *     source		:abababa
		 *     index		:0123456
		 *     expression	:aba
		 */
		//注：正则表达式从左向右查找，只要在一个匹配中用到了源的一个字符，就不能再重复使用它
		
		expres = "aba";
		source = "abababa";
		 //index :0123456
		match(expres, source);
		
		
		
		/**
		 * 1.2 使用元字符查找(meta-character)
		 * 
		 * 		source		:a12c3e456f
		 * 		index		:0123456789
		 *      expression	:\d
		 *   
		     	\d	:数字
		     	\s	:空格
		     	\w	:字符(字母、数字、_)
		     	[abc] 		a、b 或 c（简单类） 
				[^abc] 		任何字符，除了 a、b 或 c（否定） 
				[a-zA-Z] 	a 到 z 或 A 到 Z，两头的字母包括在内（范围） 
				[a-d[m-p]] 	a 到 d 或 m 到 p：[a-dm-p]（并集） 
				[a-z&&[def]] d、e 或 f（交集） 
				[a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去） 
				[a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去） 

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
		//TODO "非数字"，如何表示？
		System.out.println("a12c3e456f".replaceAll("(\\d)", ""));
		
		
		/**
		 * 1.3 使用量词查找
		 * 
		 		
		 		+	: 1次或多次匹配
		 		*	: 0次或多次匹配
		 		?	: 0次或1次匹配
		 		.	: 匹配任意字符
		 */
		
		// + 贪婪量词：1或多次 (——对应勉强量词：+?)
		expres = "0[xX]([0-9a-fA-F])+";//0x之后的字符 可出现1~多次，故用+
		source = "12 0x 0x12 0xf 0xg";
		//index  :012345678901234567
		out.println("查找十六进制字面值：");
		match(expres, source);
		/*
		6~10	: >0x12<
		11~14	: >0xf<
		*/
		
		// * 贪婪量词：0或多次 (——对应勉强量词：*?)
		expres = "proj([^,])*";//proj后可跟0或多个字符，但不能是","
		source = "proj,proj.txt,proj.java,proj2.java,ptest.class";
		//index  :0123456789012345678901234567890123456789012345
		out.println("查找以proj开头的proj([^,])*：");
		match(expres, source);
		/*
		0~4	    : >proj<
		5~13	: >proj.txt<
		14~23	: >proj.java<
		24~34	: >proj2.java<
		*/
		
		// ? 贪婪量词：0或1次 (——对应勉强量词：??)
		expres = "\\d\\d\\d\\d([\\s-])?\\d\\d\\d\\d";//空格、-，出现0次或1次
		source = "0556-5261 0556 4031 05564031";
		//index  :0123456789012345678901234567
		out.println("查找电话号码字符\\d\\d\\d\\d[\\s-]?\\d\\d\\d\\d：");
		match(expres, source);
		/*
		0~9	    : >0556-5261<
		10~19	: >0556 4031<
		20~28	: >05564031<
		*/
		
		// . 量词 ：此处可以是任意字符
		//如果要查找.字符，需要使用"\\."
		expres = "a.c";
		source = "abc  ac a c acc";
		//index  :012345678901234
		match(expres, source);
		/*
		0~3	    : >abc<
		8~11	: >a c<
		12~15	: >acc<
		*/
		
		//贪婪量词
		// *是贪婪量词：0或多次匹配
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
		match(expres, source);//结果是0 yyxxxyxx,
		/*
		0~8	: >yyxxxyxx<
		*/
		
		// *? 是勉强量词：0或多次匹配
		expres = ".*?xx";
		match(expres, source);//结果是0 yyxx;4 xyxx
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
		 * 参考：当与贪婪量词*、?组合使用时，find()会允许”零长度匹配“
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
		 * java.util.Scanner 也可用于查找
		 * 
		 * new Scanner(source)
		 * Scanner.findInLine(expres)
		 */
		Scanner s = new Scanner("ab12aba355b77a");
		String token ;
		out.println("Scanner查找：source=ab12aba355b77a, expres=\\d\\d: ");
		do{
			token = s.findInLine("\\d\\d");
			out.println(token);
		}while(token != null);
		 
		
		/**
		 ** 2. 分解 tokenizing
		 ** 
		 **	标记：token, 实际数据部分
		 ** 定界符：delimiter, 可以是能作为正则表达式的任何内容，例如\d
		 */
		out.println("======2. 分解");
		/*
		 * 2.1 利用String.split()进行分解
		 *    缺点：分解过程一次完成，不能停止
		 */
		String token2 = "ad,cd54b,6 x,z4"; //54,连续的数字 会创建一个空标记
		String[] tokens = token2.split("\\d");
		
		out.println("\n==利用String.split()进行分解==");
		out.println("token="+token2 +"; delimiter = \\d");
		for(String st : tokens){
			out.println(">"+st+"<");
		}
		/*
		 * 2.2 利用Scanner进行分解
		 * 优点：
		 *    可以将文件、流、字符串作为source
		 *    分解在循环中执行，可以随时退出分解
		 *    可以将标记token自动转换为基本类型
		 */
		String source1 ="ad,cd54b,6 x,z4 6 a 9";
		String source2 ="78 5 a b1 ";
		Scanner sc1 = new Scanner(source1);
		Scanner sc2 = new Scanner(source2);
		
		out.println("\n==利用Scanner进行分解==");
		out.println("Scanner的默认定界符："+sc1.delimiter());
		
		sc1.useDelimiter("\\d");
		out.println("使用定界符sc.useDelimiter(\"\\d\")："+sc1.delimiter());
		out.println("token="+source1 +"; delimiter = "+sc1.delimiter());
		
		while(sc1.hasNext())
		{
			out.println(">"+sc1.next()+"<" );
		}
		
		out.println("token="+source2 +"; delimiter = "+sc2.delimiter()+", nextInt():");
		while(sc2.hasNextInt())
		{
			out.println(">"+sc2.nextInt()+"<");//自动转换为基本类型
		}
		
		/**
		 * 3. 替换
		 * 
		 *   将字符串中的元音字母大写显示
		 */
		out.println("======3. 替换");
		String text = " ab cd ef gh  i   j\n kl m";
		out.println("原始：\n"+text);
		//多个空格 --> 一个空格
		text = text.replaceAll(" {2,}", " ");
		//行首空格 --> ""
		text = text.replaceAll("(?m)^ +", "");   //??
		out.println("去掉空格：\n"+text);
		
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[aeiou]");
		Matcher matcher = pattern.matcher(text);
		
		out.println("matcher替换：");
		out.print("matcher.group(): ");
		while(matcher.find()){
			out.print(matcher.group() + ", ");
			/*
			 * String.replace()只能替换普通字符串。 而appendReplacement允许操作用来替换的字符串：
			 */
			matcher.appendReplacement(sb, matcher.group().toUpperCase());
		}
		/*
		 * 将剩余未处理的部分存入sb
		 */
		matcher.appendTail(sb);
		
		out.println("\n matcher.appendReplacement()：\n"+sb);
	}

}
