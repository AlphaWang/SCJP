/**
 * <p>�ļ�����: Ch5_1_IfSwitch.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-18</p>
 * <p>������ڣ�2011-1-18</p>
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
package ch05_flowControl;

public class Ch5_1_IfSwitch 
{
	static int i = 5;
	public static void main (String[] args)
	{
		
	
		/**
		 * 1. else�Ӿ䣺���� ǰ����ӽ��Ĳ���else��if���
		 */
		int x = 5;
		if(x > 5)
			if(x < 3)
				x = 3;
		else//����if(x < 3)����
			x = 0;
			
		/**
		 * 2. switch���ʽ�� 
		 * ��������Ҫô��enum��Ҫô������Ϊint��char /byte /short /int /enum
		 */
		
		/**
		 * 3. case�Ӿ䣺������switch���ʽ��� ������ͬ
		 *              �����Ǳ���ʱ����������
		 */
		final int a = 1 ;
		final int b;
		b = 2;
		//// b = 3;
		
		int y = 0;
		switch (y)
		{
			case 88:
			//// case y:   //case expressions must be constant expressions
			case a:
			//// case b:   //???case expressions must be constant expressions
			//// case i:   //case expressions must be constant expressions
			/*
			 * case ����ֵ�����ظ�
			 */
			//// case 88://Duplicate case
			
		}
		
		
		/**
		 * ��switch����С��int��case����ֵҪ ��ȡֵ��Χ�ڣ���
		 */
		byte by = 127;
		switch (by)
		{
		 	case 127:
		 	//// case 128: //Type mismatch: cannot convert from int to byte
		}
		
		/**
		 * 4. default�Ӿ䣺��һ�������һ�У�Ҳ��ֱ�����У���
		 */
		int z = 7;
		switch(z)
		{
			case 0 : System.out.println("0");
			default : System.out.println("default");
			case 2 : System.out.println("2");
			case 8 : System.out.println("8");
			//�����default 2 8 
		}
		
		
	}
}
