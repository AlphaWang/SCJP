/**
 * <p>�ļ�����: Minister.java </p>
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
package pattern.no01.sigleton;

public class Minister {

	public static void main(String[] args){
		/**
		 * ����ģʽ-Singleton Pattern
		 * 
		 * Ensure a class has only one instance, and provide a global point of access to it.
		 */
		
		/**
		 * �ŵ㣺
		 * 1. �����ڴ濪֧
		 * 2. �������ܿ���
		 * 3. �������Դ�Ķ���ռ��(����ֻ�ܴ���һ����Դ�ļ���ʵ��)
		 * 4. ������ϵͳ����ȫ�ֵķ��ʵ�
		 * 
		 * ȱ�㣺
		 * 1. һ��û�нӿڣ���չ����
		 */
		
		/**
		 * ʹ�ó�����
		 * 1. ��Ҫ����Ψһ���к�ʱ
		 * 2. ��Ҫһ��������ʵ�������ݿ�ʱ
		 * 3. ����һ������Ҫ���ĵ���Դ����ʱ
		 * 4. ��Ҫ��������ľ�̬�����;�̬����ʱ
		 */
		for(int day=0; day<3; day++){
			Emperor emperor = Emperor.getInstance();
			emperor.say();
		}
	}
}
