/**
 * <p>�ļ�����: Ch10_1_Javac_Java.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-25</p>
 * <p>������ڣ�2011-3-25</p>
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
package ch10_development;

import java.util.Properties;

public class Ch10_1_Javac_Java {

	public static void main(String[] args) {
		/**
		 * 1. javac
		 * 
		 * javac -d path *.java
		 * javac -d ../target ch10_development/Ch10_1_Javac_Java.java
		 * 
		 * 
		 * ����ָ��class�ļ������·�������Ŀ¼�����ڣ�����뱨��
		 */
		
		
		/**
		 * 2. java
		 * 
		 * java -D����="����ֵ" class
		 * java -DmyProp=myValue Ch10_1_Javac_Java
		 * �������� -D��������ϵͳ����
		 * 
		 */
		Properties p = System.getProperties();
		p.setProperty("==myProperties1", "myValue1");
		p.list(System.out);
		
		System.out.println("�Զ��������ֵ��"+p.getProperty("==myProperties1"));
		
		/**
		 * 
		 * 3. ����������
		 * 
		 * ��ѡ���� java��׼���
		 * ��Ҫ���� ��·��
		 * 
		 * �������ط�����������·��
		 * 1)����ϵͳ��������
		 * 2)javac/java�����еĲ�����-classpath 
		 * 
		 * ��·�����������jar������ָ��jar���ļ���
		 */

	}

}
