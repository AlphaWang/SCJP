package api.guava;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

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

public class Guava {
	
	public static void main(String[] args) {
		Function<String, Boolean> isPalindrome =  new  Function<String, Boolean>() {  
		     @Override
			public  Boolean apply(String from) {  
		        Preconditions.checkNotNull(from);  
		         return   new  StringBuilder(from).reverse().toString().equals(from);  
		    }  
		};  

		List<String> from = Lists.newArrayList( "rotor" ,  "radar" ,  "hannah" ,  "level" ,  "botox" );  
		
		List<Boolean> to = Lists.transform(from, isPalindrome);  
		for  ( int  i =  0 ; i < from.size(); i++) {  
		    System.out.printf( "%s is%sa palindrome\n" , from.get(i), to.get(i) ?  " "  :  " NOT " );  
		}   

		// changes in the "from" list are reflected in the "to" list   
		System.out.printf( "\nnow replace hannah with megan...\n\n" );  
		from.set( 2 ,  "megan" );  
		for  ( int  i =  0 ; i < from.size(); i++) {  
		    System.out.printf( "%s is%sa palindrome\n" , from.get(i), to.get(i) ?  " "  :  " NOT " );  
		}

	}

}
