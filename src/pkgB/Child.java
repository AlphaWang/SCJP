/**
 * <p>�ļ�����: Child.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-31</p>
 * <p>������ڣ�2011-3-31</p>
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
package pkgB;
import pkgA.*;

public class Child extends Parent{
	public static void main(String[] args){
		Child c2 = new Child();
		c2.testAuth();
		
	}
	public void testAuth()
	{
		Parent p = new Parent();
		Child c = new Child();
		System.out.println(p.publicVar);
		System.out.println(c.publicVar);
		
		System.out.println(p.defaultVar);
		System.out.println(c.defaultVar);
		
		System.out.println(p.protectedVar);//����ͨ���������÷�����protected������
		System.out.println(super.protectedVar);//??
		System.out.println(c.protectedVar);
		
		System.out.println(p.privateVar);			
		System.out.println(c.privateVar);
	}

}
