/**
 * <p>�ļ�����: Item39_�����Կ���.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-10</p>
 * <p>������ڣ�2010-9-10</p>
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
package ch01_declaration;

import java.util.Date;

public class Item39_ProtectionCopy {
	private Date date;
	public void period(Date d)
	{
		//this.date = new Date(d.getTime());
		this.date = d;
	}
	public static void main(String[] args){
		Date today = new Date();
		String name = new String("old");
		
		Item39_ProtectionCopy o = new Item39_ProtectionCopy();
		o.period(today);
		System.out.println(o.date);
		
		today.setYear(89);
		name = name.toUpperCase();
		System.out.println(o.date);//�޸�today��dateֵҲ���
	}
}
