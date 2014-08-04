/**
 * <p>�ļ�����: VarargMethodOverLoad.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-18</p>
 * <p>������ڣ�2010-6-18</p>
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
package com.zte.scjp.vararg;
import static java.lang.System.out;
/**
 * ����ΪVararg�ķ��� ����
 * @author WangZhongXing192063
 *
 */
public class VarargMethodOverLoad {

	/**
	 * ȡһ��int�е����ֵ, ����Ϊvarargv
	 */
	public static int max(int... values)
	{
		int max = Integer.MIN_VALUE;
		if(values.length == 0)
		{
			throw new IllegalArgumentException("�������Ȳ���Ϊ0");
		}
		for(int i : values)
		{
			if(i>max)
			{
				max = i;
			}
		}
		return max;
	}
	/**
	 * �������Ϊint[]������ʾ�����ظ�
	 */
	/*public static int max(int[] values)
	{
		int max = Integer.MIN_VALUE;
		if(values.length == 0)
		{
			throw new IllegalArgumentException("�������Ȳ���Ϊ0");
		}
		for(int i : values)
		{
			if(i>max)
			{
				max = i;
			}
		}
		return max;
	}*/
	
	public static void main(String[] args)
	{
		out.println("���Ϊ���int:" + max(7,2,3));
		out.println("���Ϊint[]:" +   max(new int[]{2,78,7}));
		
		//out.println(max());
		//out.println(max(null));
	}
}
