/**
 * <p>�ļ�����: Array.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-6</p>
 * <p>������ڣ�2011-12-6</p>
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
package think.in.java.initial;

public class Array {
	public static void main(String[] args){
		printArray();
		printArray(0);
		printArray(1, new Object[]{
				new Book(false, "A"),
				new Book(true, "B"),
		});
		/**
		 * The argument of type Integer[] should explicitly be cast to Object[] 
		 * for the invocation of the varargs method printArray(int, Object...) from type Array. 
		 * 
		 * It could alternatively be cast to Object for a varargs invocation
		 */
		printArray(2, new Integer[]{1,2,3});
		printArray(3, (Object[]) new Integer[]{3,2,1});
	}
	
	static void printArray(int count, Object... array){
		System.out.print("Array "+count+": ");
		for(Object o : array){
			System.out.print(o + " ");
		}
		System.out.println();
	}
	
	static void printArray(Object... array){
		System.out.print("Array : ");
		for(Object o : array){
			System.out.print(o + " ");
		}
		System.out.println();
	}

}
