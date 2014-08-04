import java.util.regex.Matcher;
import java.util.regex.Pattern;

//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2014
//             A G F A - G E V A E R T  G R O U P
//                    All Rights Reserved
/////////////////////////////////////////////////////////////////
//
//       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                    Agfa-Gevaert Group
//      The copyright notice above does not evidence any
//     actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//
//

public class TestRegular {

	/**
	 * @param args
	 */
	public static synchronized void main(String[] args) {
//		String content = "@outbound *\nfunction startQDoc() {}";
//				//"/** @outbound */\r\nfunction startQDoc() {}";
//		Pattern pattern = Pattern.compile("@outbound" + ".*\\n??function.*\\(\\)");
		
		
		String content = "/**   @protected   */    \n\n\nfunction startTest(){\n/**   @version   testversion.1   */ }";
//		String reg = "^\\s*\\n*/\\*\\*\\s*@protected\\s*\\*/\\s*\\n*";
//		String reg = "/\\*\\*\\s*@version\\s*\\*/";
		String reg = "/\\*\\*\\s*@version\\s*\\S*\\s*\\*/";
		
		Pattern pattern = Pattern.compile(reg);
		
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String match = matcher.group();
			
			System.out.println(match);
//			System.out.println(match.substring(match.indexOf("function ")+9, match.indexOf("(")));
		}
		
		System.out.println("----");
		System.out.println(content.replaceAll(reg, ""));
		
		String name = "PID(1,2)";
//		"PID(6)";
		int leftBracket = name.lastIndexOf("(");
		int rightBracker = name.lastIndexOf(")");
		int lastComma = name.lastIndexOf(",");
		int prefix = lastComma > 0 ? lastComma : leftBracket;
		String pre = name.substring(0, prefix+1);
		System.out.println(pre);
		System.out.println(name.substring(rightBracker));
		
	}

}
