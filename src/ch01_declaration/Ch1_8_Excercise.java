/**
 * <p>�ļ�����: Ch1_8_Excecise.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-31</p>
 * <p>������ڣ�2011-3-31</p>
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

public class Ch1_8_Excercise extends Hobbit{
	public static void main(String[] args){
		Short myGold = 7;
		System.out.println(countGold(myGold, 6));
	}

}

class Hobbit{
	static int countGold(int x, int y){
	////int countGold(int x, int y){
		return x + y;
	}
}