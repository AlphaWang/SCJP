/**
 * <p>�ļ�����: Ch3_3_�򷽷����ݱ���.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-12-28</p>
 * <p>������ڣ�2010-12-28</p>
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

public class Ch3_3_PassVar2Method 
{
	/**
	 * 1. ���ݶ������ã�
	 *    ���ݵ��Ƕ������õ�һ������������ʵ�ʵĶ������ã�����ʵ�ʵĶ���
	 *    
	 *    ��Ϊ���á����ø�����ָ��ͬһ���������Զԡ����ø�����״̬���޸� ��Ӱ�쵽�����õ�״̬��
	 */
	
	
	void changeIt(Bar bar){
		bar.size = 99;
		System.out.println("changeIt()ִ���У�"+bar.size);
	}
	public static void main(String[] args)
	{
		Ch3_3_PassVar2Method obj = new Ch3_3_PassVar2Method();
		Bar bar= new Bar();
		System.out.println("��ʼ״̬��"+bar.size);
		obj.changeIt(bar);
		System.out.println("����״̬��"+bar.size);
	}
	
	/**
	 * 2.���ݻ�������
	 *   ���ݵ��ǻ���������λ������������ֵ����
	 *   
	 */
}
class Bar{
	int size = 28;
}