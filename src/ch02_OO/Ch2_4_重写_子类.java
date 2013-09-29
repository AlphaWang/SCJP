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

import java.util.HashMap;
import java.util.Map;

public class Ch2_4_��д_���� extends Ch2_4_��д_����{
	
	public static String staticVar2 = "cStaticVar2";
	public static String staticVar = "cStaticVar���������¶���";
	
	//��д���෽��
	@Override	
	public void eat() {
		System.out.println("������д��eat()");
		super.eat("test");//��super.method()���ñ������ĳ���汾
		
	}
	@Override	
	public void eat(final HashMap map){
		
	}
	//��д�ķ���������������ȫһ�¡�����������Ҳ���У�
	//// @Override	
	public void eat(Map map){
		
	}
	
	/**���ظ��෽��ʱ�������������С�������������滻ԭ��
	 * ���ࣺpublic void eat2(Map map)
	 * ��α�����ȫһ�£���������Ҳ����
	*/
	//// @Override	
	public void eat2(HashMap map){
		
	}
	/**
	 * 0. ��д�����ķ������ͣ������Ǹ��෽���������� ������
	 */
	@Override	
	public Ch2_4_��д_���� getInstance()
	{
		return new Ch2_4_��д_����();
	}
	
	/**
	 *  1. ��д�ķ��� Ȩ�޲�����С
	 */
	 //// private void eat(String arg){}
	
	
	/**
	 *  2. �����е�private�������ɱ���д
	 */
	//// @Override
	private void privateMethod()
	{
		System.out.println("������������private����");
	}
	/**
	 *  3. �����е�final�������ɱ���д
	 *     ע�⣬������final������private�ģ�������������¶���
	 *     
	 *     //��super.method()���ñ������ĳ���汾
	 */
	/*
	public final void finalMethod()
	{
		System.out.println("�����в�����дfinal����");
	}
	*/
	/**
	 *  4. �����е�static�������ɱ���д���������������������
	 */
	//// @Override
	public static void staticMethod()
	{
		System.out.println("������������static����");
	}
	/**
	 *  5. ������д�ķ����׳����쳣�����ɱ�ԭ�������������
	 *  ���⣺�����׳�������û�е� RuntimeException
	 */
	
	/*
	@Override
	public void classCastExceptionMethod() throws IOException 
	{
		System.out.println("������д��ClassCastException����");
	}
	*/
	
	/**
	 * ??? ���෽���׳�ClassCastException��������д ������IOException
	 *     ���෽���׳�IOException��       ������д ����ClassCastException
	 *
	 */
	@Override
	public void ioExceptionMethod() throws ClassCastException
	{
		System.out.println("������д��ioExceptionMethod() throws ClassCastException");
	}
	
	
	
	//������������
	public void childMethod()
	{
		System.out.println("���������ķ���childMethod()");
	}
	
	

	public static void main(String[] args)
	{
		Ch2_4_��д_���� pp = new Ch2_4_��д_����();
		Ch2_4_��д_���� pc = new Ch2_4_��д_����();
		Ch2_4_��д_���� cc = new Ch2_4_��д_����();
		
		pp.eat();  //����eat()
		/**
		 * 3.����Ǹ�������ã���ֻ�ܵ��ø��෽��
		 */
		pc.eat();  //������дeat()
		//pc.childMethod();
		//�����private��������Ȩ����
		//pc.privateMethod();
		
		cc.eat();  //������дeat()
		cc.privateMethod();
		cc.childMethod();
		/**
		 * 4. �����static���������Լ̳�
		 */
		String s1 = cc.staticVar;
		String s2 = cc.staticVar2;
		String s3 = Ch2_4_��д_����.staticVar;
		System.out.println("cc.staticVar: "+s1+"\ncc.staticVar2��"+s2+"\nCh2_4_��д_����.staticVar��"+s3);
		/**
		 * 5. ��ֻ̬������ʵ���������������� ʵ������
		 *    �˴�Ӧ�õ��Ǹ���������൱�ڣ�Ch2_4_��д_����.staticVar
		 */
		System.out.println("pc.staticVar: "+pc.staticVar);
	}

}
