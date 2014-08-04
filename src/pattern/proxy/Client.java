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
package pattern.proxy;

import java.lang.reflect.Proxy;

public class Client {
	
	public static IPerson getOwnerProxy (IPerson person){
		return (IPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(), 
				person.getClass().getInterfaces(), 
				new OwnerInvocationHandler(person));
	}
	
	public static IPerson getNoOwnerProxy (IPerson person){
		return (IPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(), 
				person.getClass().getInterfaces(), 
				new NoOwnerInvocationHandler(person));
	}
	
	
	public static void main(String[] args){
		IPerson mike = new PersonBean();
		mike.setAge(26);
		mike.setName("Mike");
		mike.setGender("Male");
		mike.setRate(2);
		
		//修改自己
		IPerson ownerProxy =  getOwnerProxy(mike);
		ownerProxy.setName("Mike Scott");
		try {
			ownerProxy.setRate(1);
		} catch (Exception e){
			System.err.println("cat modify your own rate!");
		}
		
		//修改其他人
		IPerson noOwnerProxy = getNoOwnerProxy(mike);
		noOwnerProxy.setRate(1);
		try {
			noOwnerProxy.setName("Lucy");
		} catch (Exception e){
			System.err.println("cat modify the others' info!");
		}
		
	}
	

}
