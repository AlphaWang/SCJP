//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2013
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
package ch06_api;

import java.util.StringTokenizer;


public class Ch6_1_Token {
	
	public static void main(String[] args) {
		String name = "ddddddeeeeeeeeeeeeeeeeeeeefffff^dddddddddddddddddddddddddddddddddddd";
		
		Ch6_1_Token client = new Ch6_1_Token();
		client.test(name, false);
	}
	
	
	PersonNameImpl ideographic, phonetic;
    String[] components;
    
	public void test(String s, boolean lenient){
		components = new String[5];
		
        int grLen = s.indexOf('=');
        if((grLen != -1 ? grLen : s.length()) > 64)
            if(lenient)
            	System.out.println("To long PN: " + s);
//                log.warn("To long PN: " + s);
            else
                throw new IllegalArgumentException(s);
        
        
        StringTokenizer stk = new StringTokenizer(s, "=^", true);
        int field = 0;
        String tk;
label0:
        do
        {
            if(!stk.hasMoreTokens())
                break;
            tk = stk.nextToken();
            switch(tk.charAt(0))
            {
            case 61: // '='
                break label0;

            case 94: // '^'
                if(++field > 4)
                {
                	System.out.println("Illegal PN: " + s + " - ignore '^' delimiter");
//                    log.warn("Illegal PN: " + s + " - ignore '^' delimiter");
                    field--;
                }
                break;

            default:
                components[field] = tk;
                break;
            }
        } while(true);
        if(!stk.hasMoreTokens())
            return;
        tk = stk.nextToken("=");
        if(tk.charAt(0) != '=')
        {
            ideographic = new PersonNameImpl(tk, lenient);
            if(stk.hasMoreTokens())
                tk = stk.nextToken("=");
        }
        if(!stk.hasMoreTokens())
            return;
        tk = stk.nextToken();
        if(tk.charAt(0) == '=' || stk.hasMoreTokens())
        {
            throw new IllegalArgumentException(s);
        } else
        {
            phonetic = new PersonNameImpl(tk, lenient);
            return;
        }
	}
	
	
	class PersonNameImpl {

		public PersonNameImpl(String tk, boolean lenient) {
			// TODO Auto-generated constructor stub
		}
		
	}
}
