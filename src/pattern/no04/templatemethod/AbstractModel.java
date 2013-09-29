/**
 * <p>�ļ�����: AbstractModel.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-9-7</p>
 * <p>������ڣ�2011-9-7</p>
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
package pattern.no04.templatemethod;

public abstract class AbstractModel {
	/**
	 * ����������
	 * 1.�ṩ������ʵ��
	 * 2.ͨ������������������ض����㷨���ض�����
	 * 3. �������Ϊprotected�����ϵ����ط��򣡣���
	 */
	protected abstract void start();
	protected abstract void stop();
	protected abstract void alarm();
	protected abstract void engineBoom();
	/**
	 * ģ�巽����
	 * 1.����ŵ�����ʵ�֣�ÿ�����඼���ظ����룬�����ᵽ���� ��Ϊģ�巽����
	 * 2.ģ�巽����һ��"���"��ʵ�ֶԻ��������ĵ��ȣ���ɹ̶����߼�����
	 * 3.һ��Ϊfinal����ֹ������д
	 */
	public final void run(){
		start();
		engineBoom();
		if(isAlarm()){//��չ�����ӷ���
			alarm();
		}
		stop();
	}
	//��չ������������Ƿ�alarm
	/**
	 * ���ӷ�����
	 * ���ӷ����ķ���ֵ��Ӱ����ģ�巽����ִ�н��
	 */
	protected boolean isAlarm(){
		return true;
	}
}
