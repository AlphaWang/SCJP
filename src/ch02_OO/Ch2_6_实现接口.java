/**
 * <p>�ļ�����: Ch2_6_ʵ�ֽӿ�.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-10-25</p>
 * <p>������ڣ�2010-10-25</p>
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
/**
 * 0. ֻ�ܼ̳�һ���࣬������ʵ�ֶ���ӿ�
 *
 */
public class Ch2_6_ʵ�ֽӿ� implements MyInterface,Runnable
{

	/**
	 * 1. ����������д�����������������׳����㡢������쳣
	 */
	/*
	@Override
	public void bounce() throws IOException{
		// TODO Auto-generated method stub
		
	}
	*/
	/**
	 * 2. �ǳ���ʵ���࣬����ʵ�ֽӿ��ж�������з���
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bounce(){
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	
	

}
/**
 * 3. �ӽӿ� ֻ���򸸽ӿڵ���Լ����Ӹ����Ҫ��
 *    �����ȸ��ӿڵķ�������
 *
 */
interface MyInterface extends Runnable
{
	public void eat()throws ClassCastException;
	public void bounce();
	/**
	 * 3. �ӿ��еķ������ǳ���ģ������о�������
	 *    ���������ӿ���һ��100%������
	 */
	/*
	 public void method(){}
	 */
	
}
