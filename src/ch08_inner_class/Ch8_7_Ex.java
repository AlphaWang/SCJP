/**
 * <p>�ļ�����: Ch8_7_Ex.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-16</p>
 * <p>������ڣ�2011-3-16</p>
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
package ch08_inner_class;

import java.util.Comparator;

public class Ch8_7_Ex {
	
	public static void main(String[] args)
	{
		String[] strs = {"nickel","button","key","lint"};
		Sorter s = new Ch8_7_Ex().new Sorter();
	}
	
	class Sorter implements Comparator<String>
	{
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	}

}
