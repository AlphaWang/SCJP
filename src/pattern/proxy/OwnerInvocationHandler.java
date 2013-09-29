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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler{
	
	IPerson person;
	
	public OwnerInvocationHandler(IPerson person) {
		this.person = person;
	}

	@Override
	//prox参数没用上？
	public Object invoke(Object proxy, Method method, Object[] args)
			throws IllegalAccessException {
		if (method.getName().equals("setRate")) {
			throw new IllegalAccessException();
		} else {
			try {
				return method.invoke(person, args);
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
