/**
 * <p>�ļ�����: NvWa.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-9-5</p>
 * <p>������ڣ�2011-9-5</p>
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
package pattern.no02.factory;

import static java.lang.System.out;

public class NvWa {
	public static void main(String[] args){
		/**
		 * ����ģʽ- Factory Pattern
		 * 
		 * Define an interface for creating an object, but let subclasses decide which class to instantiate.
		 * Factory Method lets a class defer instantiation to subclasses
		 */
		
		/**
		 * �ŵ㣺
		 * 1. ��װ�ԡ�����֪��������Ʒ��ľ�����̣�����ģ������
		 * 2. ��չ�ԡ�e.g.���Ӳ�Ʒ��ֻ������һ��Human���༴��
		 * 3. ���β�Ʒ�ࡣe.g.jdbc
		 * 4. �ǵ��͵Ľ����ܡ��߲�ģ��ֻ֪����Ʒ�ĳ�����
		 */
		
		/**
		 * ʹ�ó�����
		 * 1. ������Ҫ���ɶ���ĵط�������
		 * 2. �в�Ʒ��ʱ��e.g.�ʼ���������еĲ�ͬ����Э��
		 */
		AbstractHumanFactory factory = new HumanFactory();
		//�߲�ģ��ֻ֪����Ʒ�ĳ�����Human
		Human blackHuman = factory.createHuman(BlackHuman.class);
		Human whiteHuman = factory.createHuman(WhiteHuman.class);
		
		out.println("��һ������ˣ�");
		whiteHuman.getColor();
		whiteHuman.talk();
		out.println("�ڶ��������");
		blackHuman.getColor();
		blackHuman.talk();
	}

}
