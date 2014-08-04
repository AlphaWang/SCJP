/**
 * <p>�ļ�����: Ch5_5_Assertion.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-20</p>
 * <p>������ڣ�2011-1-20</p>
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

public class Ch5_5_Assertion 
{
	/**
	 * 0. ���������ڿ����ڼ���Լ��衣�����������󣬶��Դ���ʵ���ϻᱻ����������κ�����
	 * 
	 *    ��������Ѳ���ĳ���������⣬�������ö��ԣ��Խ��ж���Ĳ���
	 */
	public static void main(String[] args)
	{
		Ch5_5_Assertion obj = new Ch5_5_Assertion();
		int i = -50;
		obj.methodA(i);
	}
	
	private void method(int num)
	{
		if(num >= 0){
			//���>=0��������������
			// do more
			System.out.println("method()�����߼�"+num);
		}else{
			//���<0���򲻺Ϸ���method()����ֻ�ܽ��ܷǸ��Ĳ���
			System.out.println("���Ϸ��Ĳ�����");
		}
	}
	/**
	 * 1. ����method()�����Ż�Ϊassert
	 */
	//ע�⣺public���� ���ʺ�ʹ���������ԣ�
	private void methodA(int num)
	{
		
		assert( num >= 0 );//����ж�Ϊtrue�������������У������û���κ�����Ӱ��
		                   //����ж�Ϊfalse�����׳�AssertionError��(java ch05_flowControl.Ch5_5_Assertion)
		
		//do more
		System.out.println("methodA()�����߼�"+num);
		
		
		/**
		 * �Ը�����ʽ�Ķ���:
		 * ����ж�Ϊfalse�����ð�ź������Ϣ��ӡ����	
		 * ע�⣺ð�ź��� ������ת��ΪString��ע�������method��һ�����ܷ���void
		 */
		int x = 7;
		int y = 6;
		assert (x < y): "x=" +x +",y="+y;
		
		
	}
	/**
	 * 2. ������ж��ԵĴ���	
	 * ���ϣ���ڴ����а�assert��Ϊ��ʶ��������ʹ��-source 1.3����
	 */
	
	
	/**
	 * 3. ����ʱ���ö���
	 * 
	 * Ĭ�϶����ǽ��õģ�
	 * 
	 * ��ĳ�������ö��ԣ�
	 * java -ea com.Test
	 * java -enableassertions com.Test
	 * 
	 * ��ĳ������ö��ԣ�(����)
	 * java -da com.Test
	 * java -disableassertions com.Test
	 * 
	 * ��ѡ������ý��ö��ԣ�
	 * java -ea -da:com.Test	����ͨ�����ö��ԣ�����Test�����
	 * java -ea -da:com...		����ͨ�����ö��ԣ�����com�����Ӱ��н���
	 * 
	 */
	
	/**
	 * 4. �ʵ���ʹ�ö���
	 */
	/*
	 * ��Ҫ�ö�����֤ public �����ĉ�Ԫ�������Љ�Ԫ
	 * �����ö�����֤ private �����ĉ�Ԫ 
	 */

	
	/*
	 * ��
	 * ���Ա��ʽֻ��Ϊ�жϣ� һ�����ܲ�������������
	 */
	public void doStuff(){
		
		assert(modifyVar());
		//do more...
	}
	public boolean modifyVar(){
		y = x ++;
		return true;
	}
	static int x;
	static int y;

}
