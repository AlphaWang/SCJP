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

public class Reluctant {
 
    private Reluctant internalInstance = new Reluctant();  
 
//    public Reluctant() throws Exception { 
//        throw new Exception("I'm not coming out"); 
//    }
    
    public Reluctant(){ 
       
    }
 
 
 
    public static void main(String[] args) { 
        try {
            Reluctant b = new Reluctant(); 
            System.out.println("Surprise!"); 
        } catch (Exception ex) { 
            System.out.println("I told you so");
 
        }
 
    }
 
}
