/**
 * <p>�ļ�����: Ch12_2_ClassCast.java </p>
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

public class Ch12_2_ClassCast {
	public static void main(String[] args){
			
		Super obj = new Sub();
		
		/**
		 * Java5������Classת���﷨��
		 */
		Class<Sub> subType = Sub.class;		
		Sub subObj = subType.cast(obj);
		
		//���϶��У���Ч�ڣ�
		Sub subObj2 = (Sub) obj;
		
		/**
		 * instanceof �� Class.isInstance()
		 * 
		 * ����Ҫ�����ж϶��instance�����߸����á���������̬��instanceof
		 */
		boolean isInstance = subType.isInstance(subObj);
		
		boolean isInstance2 = subObj2 instanceof Sub;
		
		System.out.println("Class.isInstance(obj): "+isInstance);
		System.out.println("obj isinstanceof ����: "+isInstance2);
		
	}

}
