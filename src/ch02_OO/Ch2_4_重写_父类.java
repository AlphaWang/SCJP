/**
 * <p>�ļ�����: Ch2_3_��д_����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-10-9</p>
 * <p>������ڣ�2010-10-9</p>
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
package ch02_OO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ch2_4_��д_���� {
	//���ྲ̬����
	public static String staticVar = "pStaticVar";
	//��������
	public void eat(){
		System.out.println("����eat()");
	}
	
	public void eat(String arg){
		System.out.println("����eat(String)"+arg);
	}
	
	
	
	public void eat(HashMap map){
		
	}
	public void eat2(Map map){
		
	}
	//���Է�������
	public Ch2_4_��д_���� getInstance()
	{
		return new Ch2_4_��д_����();
	}
	//����private����
	private void privateMethod()
	{
		System.out.println("����private����");
	}
	//����final����
	public final void finalMethod()
	{
		System.out.println("����final����");
	}
	//����static����
	public static void staticMethod()
	{
		System.out.println("����static����");
	}
	//���෽�����������׳��쳣
	public void ioExceptionMethod() throws IOException
	{
		System.out.println("�����е�IOException����");
	}
	//���෽�����������׳��쳣
	public void classCastExceptionMethod() throws ClassCastException
	{
		System.out.println("�����е�ClassCastException����");
	}

}
