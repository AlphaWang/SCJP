/**
 * <p>�ļ�����: Ch1_5_�������Ա_�������η�.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-15</p>
 * <p>������ڣ�2010-9-15</p>
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
package ch01_declaration;

public class Ch1_5_�������Ա_�������η� {
	/**
	 * 1. �����������ʼ���
	 *    ��������public�����������п��Է����࣬�����ܷ������е�default����
	 */
	void  defaultMethod(){
		System.out.println("default����");
	}
	/**
	 * 2. ������protected����
	 *    ����ɼ̳У�������������������
	 *    
	 *    ���ǣ��������е����಻���ٸ���������ʹ�� ������� ������protected��Ա����ֻ��ͨ���̳еķ�ʽ
	 */
	protected int protectedVar = 5;
	
	protected void protectedMethod()
	{		
		/**
		 * 3.�ֲ����������� �������η���
		 *           ֻ���� final
		 */
		//// private int privateVar;
		final int y = 10;
		System.out.println("Ĭ�����е�protected����"+y);
	}
	/**
	 * private ����
	 */
	private int privateVar = 6;
	
	/**
	 * 4. final�����Ա��̳У�����������д��
	 */
	final String  finalVar = "finalVar";
	final void finalMethod()
	{
		System.out.println("����finalMethod");
	}

}
/**
 *  ������Ȩ�޵���
 */
class PackageClass
{
	/**
	 * ���췽����private�����Բ��ܴ��������ʵ��	 
	 * ���ǿ��Է��ʸ����public ��̬������
	 */
	static int staticVar;	
	private PackageClass(){
		
	}	
	
	public PackageClass(String name){
		
	}
}
