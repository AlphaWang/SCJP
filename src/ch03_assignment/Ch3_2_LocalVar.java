/**
 * <p>�ļ�����: Ch3_2_�ֲ�����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-12-10</p>
 * <p>������ڣ�2010-12-10</p>
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

public class Ch3_2_LocalVar 
{
	String instanceVar;
	
	int[] instanceArray = new int[10];
	
	static Integer staticInt;
	
	public static void main(String[] args)
	{
		Ch3_2_LocalVar obj = new Ch3_2_LocalVar();
		
		if(obj.instanceVar == null){
			System.out.println("instanceVar == null");
		}
		/**
		 * 1. �ֲ����ñ��� ���ᱻ����Ĭ��ֵ��������null��
		 */
		String localVar;
		//--localVar may not have been initialized
		/*
		if(localVar == null){
			System.out.println("localVar == null");
		}
		*/		
		
		String localVar2 = null;
		if(localVar2 == null){
			System.out.println("localVar2 == null");
		}
		
		
		
		/**
		 * Integerʵ�����������ᱻ��ʼ��Ϊ0������null��������
		 */
		System.out.println("staticInt = " +staticInt);
		
		/**
		 * 2. ��ʼ�������������Ԫ�ض�������Ĭ��ֵ��	int = 0
		 */
		System.out.print("instanceArray: ");
		for(int elem : obj.instanceArray){
			System.out.print(elem+",");
		}
		System.out.println();
		/**
		 * 2. ��������Ϊ�ֲ���������Ԫ��Ҳ�ḳ��Ĭ��ֵ��
		 */
		System.out.print("localArray: ");
		int[] localArray = new int[2];
		for(int elem : localArray){
			System.out.print(elem+"," );
		}
		System.out.println();
		
	}

}
