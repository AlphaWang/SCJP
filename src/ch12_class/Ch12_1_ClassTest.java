/**
 * <p>�ļ�����: RTTI.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2012-2-6</p>
 * <p>������ڣ�2012-2-6</p>
 * <p>�޸ļ�¼1: // �޸���ʷ��¼�������޸����ڡ��޸��߼��޸�����</p>
 * <pre>
 *    �޸����ڣ�
 *    �� �� �ţ�
 *    �� �� �ˣ�
 *    �޸����ݣ�
 * </pre>
 * <p>�޸ļ�¼2����</p>
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
		 * ��ȡĳ�����Class��object.getClass()
		 */
		char[] chars = new char[]{1 , new Character((char) 2)};	
		System.out.println("==��ӡchar[]");
		printClass(chars.getClass());//getName:[C   ??
		
		/**
		 * ��ȡĳ�����Class������.class
		 */
		Class c1 = Super.class;
		System.out.println("==��ӡClass c1 = Super.class");
		printClass(c1);
		
		/**
		 * ������Class����
		 */
		Class<Super> c2 = Super.class;
		System.out.println("==��ӡClass<Super> c2 = Super.class");
		printClass(c2);
		
		
		//ʹ�÷��ͺ󣬱���������ж�������ͼ�飺Type mismatch: cannot convert from Class<Integer> to Class<Super>
		//c2 = Integer.class;
		//c2 = Sub.class;
		c1 = Integer.class;
		System.out.println("==��ӡClass c1 = Integer.class");
		printClass(c1);
		
		//c1��c3�ȼۣ���c3Ҫ����c1
		Class<?> c3 = Integer.class;
		System.out.println("==��ӡClass<?> c3 = Integer.class");
		printClass(c3);
		
		Class<? extends Number> c4 = Integer.class;
		System.out.println("==��ӡClass<? extends Number> c4 = Integer.class");
		printClass(c4);
		
		//Integer Class������Number Class��������ࣺClass<? extends Number> c4 = Integer.class;
		//Class<Number> c5 = Integer.class;
		
		
		/**
		 * getSuperclass()��newInstance()�뷺��
		 * 
		 * ʹ�÷��ͺ�newInstance()�����ظö����ȷ�����ͣ�������Object
		 * ������getSuperclass()���ʱ�ֻ����ޣ�
		 * 
		 * 1. getSuperclass()���ص��ǻ��� ? super Sub��������Super����
		 *    �����к�����
		 * 2. ���ֺ����ԣ�����supClass.newInstance()���ص�������  ? super Sub����������ֻ��дObject
		 */
		
		try {
			Class<Sub> subClass = Sub.class;
			System.out.println("==��ӡClass<Sub> subClass = Sub.class");
			printClass(subClass);
			
			
			Sub subInstance = subClass.newInstance();
			//1. 
			//Type mismatch: cannot convert from Class<capture#2-of ? super Sub> to Class<Super>
			//// Class<Super> supClass = subClass.getSuperclass();
			Class<? super Sub> supClass = subClass.getSuperclass();
			System.out.println("==��ӡClass<? super Sub> supClass = subClass.getSuperclass()");
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
