import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;



public class Test3 {
	
	private static void test(int i, List... list){
		if (list.length >= 1) {
			System.out.println(list.length);
		} else {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args){
		Comparators c;
		
		String s1 = "\r";
		String s2 = s1.trim();
		System.out.println(s2);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(222);
		list.add(333);
//		list.set(2, 111);
		
		System.out.println(list);
		
		
		Pattern pattern = Pattern.compile("[|~^]");      //Pattern.compile(String):将给定的正则表达式编译到模式中
		Matcher matcher = pattern.matcher("name8ha");
		System.out.println(matcher.find());
		
//		System.out.println(Double.valueOf(null));
		
		
		Object s = null;
		String ss = (String)s;
		System.out.println(ss);
		
		List<String> availableFonts = Arrays.asList(
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		System.out.println(availableFonts.size());
		System.out.println(availableFonts);
		
		List<String> availableFontsUS = Arrays.asList(
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(Locale.US));
		System.out.println(availableFontsUS.size());
		System.out.println(availableFontsUS);
		
		List<String> availableFontsZH = Arrays.asList(
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(Locale.SIMPLIFIED_CHINESE));
		System.out.println(availableFontsZH.size());
		System.out.println(availableFontsZH);
		
		System.out.println( null == null);
		
		test(5, new ArrayList(), new ArrayList());
		
		
		
		String seperator = "\n";
		StringBuilder sb = new StringBuilder();
		sb.append("TESTTEST").append(seperator).append("222").append(seperator);
		System.out.print(sb);
		System.out.print("|");
		System.out.print(sb.delete(sb.length() - seperator.length(), sb.length()));
		System.out.print("|");
		
    	System.err.println(String.format("%s is %s ! %s", "A", 2, "C"));
    	
    	
    	Joiner joiner = Joiner.on(";").skipNulls();
    	String joined = joiner.join("111111", null, "", "4444444444");
		System.out.println( joined );
		
		System.out.println("123456789".length());
		System.out.println("123456789".substring(0,9));
		
       

	}
}
