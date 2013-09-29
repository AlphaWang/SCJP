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
package pattern.no03.abstractfactory;

import static java.lang.System.out;

public class NvWa {
	public static void main(String[] args){
		/**
		 * ���󹤳�ģʽ - Abstract Factory Pattern
		 * 
		 * Provide an interface for creating families of related/dependent objects 
		 * without specifying their concrete classes.
		 */
		
		/**
		 * �ŵ㣺
		 * 1. ��װ�ԡ��߲�ģ�鲻����ÿ����Ʒ��ʵ����
		 * 2. ��Ʒ���ڵ�Լ��Ϊ�ǹ���״̬��e.g.��Ů��Ʒ�����ı������Ը߲�ģ��͸����
		 * 
		 * ȱ�㣺
		 * 1. ��Ʒ�ȼ���չ���ף�����Ʒ����չ���ѡ�
		 * e.g.����һ����Ʒ�ȼ��������ˣ����ס�����������һ�������ࡢ���Ӳ�Ʒ��
		 *     ����һ����Ʒ�壺��ɫ���֣����ѡ����������󹤳�������create������������ʵ���඼����֮�޸ģ����Ӳ�Ʒ��
		 */
		
		/**
		 * ʹ�ó�����
		 * 1. �в�Ʒ�壬��Ʒ�������ͬ��Լ��
		 */
		//����������
		AbstractHumanFactory maleFactory = new MaleFactory();
		AbstractHumanFactory femaleFactory = new FemaleFactory();
		
		Human maleWhite = maleFactory.createWhiteHuman();
		Human femaleBlack = femaleFactory.createBlackHuman();
		
		
		out.println("��һ����������ԣ�");
		maleWhite.getColor();
		maleWhite.talk();
		maleWhite.getSex();
		out.println("�ڶ��������Ů��");
		femaleBlack.getColor();
		femaleBlack.talk();
		femaleBlack.getSex();
	}

}
