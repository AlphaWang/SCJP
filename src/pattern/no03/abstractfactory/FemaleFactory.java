/**
 * <p>�ļ�����: FemaleFactory.java </p>
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

public class FemaleFactory extends AbstractHumanFactory{

	/**
	 * ��Ʒ�ȼ�2��Ů�Թ���
	 */
	@Override
	public Human createBlackHuman() {
		return new FemaleBalckHuman();
	}

	@Override
	public Human createWhiteHuman() {
		return new FemaleWhiteHuman();
	}

}
