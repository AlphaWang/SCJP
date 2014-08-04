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
package ch08_inner_class;

public class Twisted {
	 
    private final String name;
 
    Twisted(String name) {
        this.name = name;
    }
 
    private String name() {
        return name;
    }
 
    private void reproduce() {
        new Twisted("reproduce") {
            void printName() {
                System.out.println(name());
            }
            void test() {
            	System.out.println(name());
            }
        }.test();
 
    }
 
    public static void main(String[] args) {
        new Twisted("main").reproduce();
    }
 
}
