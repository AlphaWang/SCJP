/**
 * <p>�ļ�����: Gc.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-5</p>
 * <p>������ڣ�2011-12-5</p>
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
package think.in.java.initial;

public class Gc {
	
	public static void main(String[] args) {
		Book novel = new Book(true, "novel");
		novel.checkIn();
		
		new Book(true, "Think");
		
		System.gc();
		
		
	}
	
	//int j0 = g(i);
	int i = f();	
	int f(){
		return 11;
	}
	
	int j1 = g(8);
	int j2 = g(i);
	int g(int n){
		return n * 10;
	}

}
