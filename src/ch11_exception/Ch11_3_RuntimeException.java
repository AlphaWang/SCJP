/**
 * <p>�ļ�����: Ch11_3_RuntimeException.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2012-1-18</p>
 * <p>������ڣ�2012-1-18</p>
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
package ch11_exception;

/**
 * RuntimeException�������� �ǡ����ܼ���쳣�������Բ�����
 * ���RuntimeExceptionδ�������ֱ��main(), ��ô�ڳ����˳�ǰ������printStackTrace()
 *
 */
public class Ch11_3_RuntimeException {

	static void f(){
		System.out.println("ִ��f()���׳�RuntimeException");
		throw new RuntimeException();
	}
	static void g(){
		System.out.println("ִ��g()������f()");
		f();
	}
	static void h(){
		System.out.println("ִ��h()���׳�RuntimeException");
		throw new RuntimeException();
	}
	public static void main(String[] args) {
		
		try{
			h();
		}catch(RuntimeException e){
			System.out.println("main()����RuntimeException");
		}
		
		g();
		
	}

}
