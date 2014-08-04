/**
 * <p>文件名称: RTTI.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2012-2-6</p>
 * <p>完成日期：2012-2-6</p>
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
package ch12_class;

class Super{
	
}
class Sub extends Super{
	
}

public class Ch12_1_ClassTest {

	public static void main(String[] args)  {
		
		/**
		 * 获取某对象的Class：object.getClass()
		 */
		char[] chars = new char[]{1 , new Character((char) 2)};	
		System.out.println("==打印char[]");
		printClass(chars.getClass());//getName:[C   ??
		
		/**
		 * 获取某对象的Class：类名.class
		 */
		Class c1 = Super.class;
		System.out.println("==打印Class c1 = Super.class");
		printClass(c1);
		
		/**
		 * 泛化的Class引用
		 */
		Class<Super> c2 = Super.class;
		System.out.println("==打印Class<Super> c2 = Super.class");
		printClass(c2);
		
		
		//使用泛型后，编译器会进行额外的类型检查：Type mismatch: cannot convert from Class<Integer> to Class<Super>
		//c2 = Integer.class;
		//c2 = Sub.class;
		c1 = Integer.class;
		System.out.println("==打印Class c1 = Integer.class");
		printClass(c1);
		
		//c1和c3等价，但c3要优于c1
		Class<?> c3 = Integer.class;
		System.out.println("==打印Class<?> c3 = Integer.class");
		printClass(c3);
		
		Class<? extends Number> c4 = Integer.class;
		System.out.println("==打印Class<? extends Number> c4 = Integer.class");
		printClass(c4);
		
		//Integer Class对象不是Number Class对象的子类：Class<? extends Number> c4 = Integer.class;
		//Class<Number> c5 = Integer.class;
		
		
		/**
		 * getSuperclass()、newInstance()与泛型
		 * 
		 * 使用泛型后，newInstance()将返回该对象的确切类型，而不是Object
		 * 但是与getSuperclass()结合时又会受限：
		 * 
		 * 1. getSuperclass()返回的是基类 ? super Sub，而不是Super！！
		 *    这样有含糊性
		 * 2. 这种含糊性，导致supClass.newInstance()返回的类型是  ? super Sub，引用类型只能写Object
		 */
		
		try {
			Class<Sub> subClass = Sub.class;
			System.out.println("==打印Class<Sub> subClass = Sub.class");
			printClass(subClass);
			
			
			Sub subInstance = subClass.newInstance();
			//1. 
			//Type mismatch: cannot convert from Class<capture#2-of ? super Sub> to Class<Super>
			//// Class<Super> supClass = subClass.getSuperclass();
			Class<? super Sub> supClass = subClass.getSuperclass();
			System.out.println("==打印Class<? super Sub> supClass = subClass.getSuperclass()");
			printClass(supClass);
			
			// 2.
			//Type mismatch: cannot convert from capture#3-of ? super Sub to Super
			//// Super supInstance = supClass.newInstance();
			Object supInstance = supClass.newInstance();
			
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void printClass(Class c){
		
		System.out.println("getName:" + c.getName());
		System.out.println("getSuperclass:" + c.getSuperclass().getName());
	}


}
