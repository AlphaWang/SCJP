/**
 * <p>�ļ�����: Ch3_4_���������������ʼ��.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-12-29</p>
 * <p>������ڣ�2010-12-29</p>
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
package ch03_assignment;

import java.util.Date;

public class Ch3_4_���������������ʼ�� {
	public static void main(String[] args)
	{
		
	
		/**
		 * 1. ��������	
		 *  ����ʱ��Զ���ܰ������鳤�ȣ�
		 */
		Date[] dates;
		int[] nums;
		//// int [4] nums2;
		/**
		 * 2. ���鹹�����ڶ��ϴ����������
		 *   ����ʱ����ָ�����ȣ�
		 */
		dates  = new Date[4];
		nums = new int[4]; //�����������飬��Ԫ���Զ���ֵΪ 0 ��
		//// dates = new Date[];
		/**
		 * 3. �����ʼ���������ݷ���������
		 */
		for(int x=0; x<nums.length;x++)
			nums[x]=x;
		
		
		
		
		
		/**
		 * 4. ��ݴ���1����һ������������������ʼ������
		 * 
		 * �����������������ͬʱ��{}��ʼ����
		 * ��������������֮�� ����{}��ʼ��
		 */
		//��������� �Ƿ���
		//// dates  = {new Date(), new Date()};
		//// nums = {1,2,3,4};
		Date[] dates2 = {new Date(), new Date()};
		int[] nums2 = {1,2,3,4};
		int[][] nums3 = {{1,2},{3},{4}};//���ﴴ����4������
		
		/**
		 * 5. ��ݴ���2����������
		 */
		int[] nums4;
		nums4 = new int[]{11,22};
		
		int[] nums5 = new int[]{11,22};
		//ʹ����������ʱ������ָ�������С��
		//Cannot define dimension expressions when an array initializer is provided
		//// int[] nums6 = new int[2]{11,22};
		
		/**
		 * 6. �Ϸ�������Ԫ�ظ�ֵ
		 * 		1������Ԫ�أ�����ʽ���������������ͼ���
		 * 		2���������ã�֧�ֶ�̬
		 * 		3����ά���飺��һ�����鸳ֵ����һ���������ã������������ά��һ�£�
		 */
		byte b=4;
		char c = 'c';
		short s = 7;
		int[] is2 = new int[3];
		is2[0] = b;
		is2[1] = c;
		is2[2] = s;
		
		

		/**
		 * ����Ķ�̬��
		 */
		P p = new C();		
		P[] ps;
		ps = new P[5];
		ps = new C[5];
		
		long l = new Integer(2);
		//// long[] ls = new Integer[3];
		/*
		 * byte������ʽ����Ϊint������byte[]���ܸ�ֵ��int[]
		 * byte[] is not a int[]
		 */
		////int[] is = new byte[3];
		
	}
}

class P{
	
}
class C extends P{
	
}
