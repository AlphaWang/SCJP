/**
 * <p>�ļ�����: Ch5_2_Iterator.java </p>
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

public class Ch5_2_Iterator 
{
	public static void main(String[] args)
	{
		/**
		 * 1. whileѭ��
		 *    ���ʽ��ʹ�õ��κα����������ڱ��ʽ����֮ǰ ����
		 */
		/**
		 * 2. doѭ��
		 *    doѭ���ڵĴ��뽫��֤����ִ��һ��
		 *    while���ʽĩβӦ���зֺţ�
		 */
		/**
		 * 3. forѭ��
		 *    ����ǿ���˳��⣬forѭ������������������ǣ��ȼ���������ʽ���ټ����������ʽ
		 *    (ǿ���˳�: break /return /System.exit()
		 *    
		 *    ������ǿ��forѭ������һ���ֱ���������������
		 */
		int age = 15;
		iterator:
			while( age <= 17){
				age ++;
				if(age == 16){
					System.out.println("get your driver's license");
					continue iterator;
				}else{
					System.out.println("another age");
				}
			}
		
		
		int x = 0;
		int[] y = {1,2};
		//������ǿ��forѭ������һ���ֱ���������������
		//// for( x:y)    {System.out.println(x);}
		
	}
	

}
