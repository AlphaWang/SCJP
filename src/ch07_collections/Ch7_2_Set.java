/**
 * <p>�ļ�����: Ch7_2_Set.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-1</p>
 * <p>������ڣ�2011-3-1</p>
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
package ch07_collections;

import static java.lang.System.out;

import java.util.HashSet;

public class Ch7_2_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String item1 = "C";
		String item2 = "A";
		String item3 = "B";
		String item4 = "B";
		
		/**
		 * 
		 * 4. Set�ӿڣ�����Ψһ�ԣ�Ԫ�ز���equals
		 *  					ordered	sorted
		 * 		HashSet				��		��	�������ظ�ֵ���ұ���ʱ������˳�򣬾Ϳ�ʹ��HashSet
		 * 		LinkedHashSet		��		��	Ԫ��֮��˫���ӡ�����ʱ����Ԫ�ز���˳��
		 * 		TreeSet				��		��	Ԫ�ذ�����Ȼ˳�� ��������
		 * 										�����������뵽TreeSet��Ķ��󣬱����ǿɻ���Ƚϵģ���
		 * 											�������������ͬ��Ķ������ClassCastException
		 * 
		 */
		out.println("======Set�ӿ�======");
		HashSet<String> hashset = new HashSet<String>();
		hashset.add(item1);
		hashset.add(item2);
		hashset.add(item3);
		boolean is = hashset.add(item4); //����ظ�Ԫ�أ�������ļӽ�ȥ
		out.println(is);		
		
		for(String s : hashset)
		{
			//���forѭ�������˳�򲻿�Ԥ��
			out.println("Ԫ��"+s+":"+hashset.contains(s));
		}
	}

}
