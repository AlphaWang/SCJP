/**
 * <p>�ļ�����: Book.java </p>
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

public class Book {
	String name = "";
	boolean checkedOut = false;
	Book(Boolean checkOut, String bookname){
		checkedOut = checkOut;
		name = bookname;
	}
	void checkIn(){
		checkedOut = false;
	}
	void checkOut(){
		checkedOut = true;
	}
	protected void finalize(){
		if(checkedOut){
			System.out.println("���ܻ����ѽ����BOOK: "+ name);
		}
	}

}
