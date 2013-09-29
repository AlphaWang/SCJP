/**
 * <p>�ļ�����: Ch11_2_ExceptionChain.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2012-1-17</p>
 * <p>������ڣ�2012-1-17</p>
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
 * Throwable���� �ڹ������ж��ɽ���һ�� cause ������Ϊ������ * 
 * ���ڰ�ԭʼ�쳣���ݸ��µ��쳣 
 *
 */
public class Ch11_2_ExceptionChain {
	private String name;
	public void setName(String n) throws MyException{
		if(name != null){
			name = n;
		}else{
			System.out.println("����Ϊ�գ�");
			
			MyException me = new MyException();
			me.initCause(new NullPointerException());
			throw me;
			//���ߣ�
			//throw new MyException(new NullPointerException());
		}
	}
	
	
	public static void main(String[] args){
		Ch11_2_ExceptionChain instance = new Ch11_2_ExceptionChain();
		try {
			
			instance.setName(null);
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
		/*
		����Ϊ�գ�
		ch11_exception.MyException
			at ch11_exception.Ch11_2_ExceptionChain.setName(Ch11_2_ExceptionChain.java:36)
			at ch11_exception.Ch11_2_ExceptionChain.main(Ch11_2_ExceptionChain.java:49)
		Caused by: java.lang.NullPointerException
			at ch11_exception.Ch11_2_ExceptionChain.setName(Ch11_2_ExceptionChain.java:37)
			... 1 more
		*/	
		
	}
}



class MyException extends Exception{
	public MyException(Throwable cause) {
        super(cause);
    }
	public MyException(){
		super();
	}
	
}