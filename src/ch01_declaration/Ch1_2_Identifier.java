/**
 * <p>�ļ�����: �Ϸ�.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-8</p>
 * <p>������ڣ�2010-9-8</p>
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
import static java.lang.System.out;


/**
 * 1. �Ϸ���ʶ���������Unicode�ַ������֡����ҷ��š����ַ����
 * 2. ���������ֿ�ͷ
 *
 */
public class Ch1_2_Identifier {
	int _a;
	int $a;
	//// int e/;
	//// int e#;
	//// int \n;
	//// int e.;
	//// int 2b;
	int e$;
	
	/**
	 * ����Ҳ��Unicode�ַ���
	 */
	int ���� = 420;
	int ����2 = 2;
	//// int ����3�� = 3;
	//// int ����4���� = 4;
	
	public static void main (String[] args)
	{
		Ch1_2_Identifier obj = new Ch1_2_Identifier();
		out.println(obj.����);  //420
		out.println(obj.����2);   //2
		obj.��ӡ();
	}
	public void ��ӡ()
	{
		out.println("����������()");
	}
	/**
	 * �ڲ���ķ������η������Բ�Ϊpublic��Ĭ�� 
	 *
	 */
	protected class InnerClass1{}
	private class InnerClass2{}
	/*
	 * ��չ��
	 * protected�ڲ��࣬Ĭ�ϵĹ��췽��Ҳ��protected��
	 * �������ⲿ�������У��Ͳ��ܵ��� new InnerClass1()
	 */

}
/**
 * �ⲿ��ķ������η���ֻ��Ϊpublic��Ĭ�� 
 *
 */

//// protected class Class1{}
//// private class Class2{}

