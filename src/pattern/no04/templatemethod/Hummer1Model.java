/**
 * <p>�ļ�����: Hummer1Model.java </p>
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
import static java.lang.System.out;
public class Hummer1Model extends AbstractModel{

	@Override
	public void alarm() {
		out.println("Hummer1 alarm!!");
		
	}

	@Override
	public void engineBoom() {
		out.println("Hummer1 boom!!");
		
	}

	@Override
	public void start() {
		out.println("Hummer1 start.");
		
	}

	@Override
	public void stop() {
		out.println("Hummer1 stop.");
		
	}
	//��չ������������Ƿ�alarm
	private boolean alarmFlag = false;
	public void setAlarm(boolean isAlarm){
		this.alarmFlag = isAlarm;
	}
	@Override
	protected boolean isAlarm(){
		return this.alarmFlag;
	}

}
