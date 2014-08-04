/**
 * <p>�ļ�����: Ch2_1_Interface.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-13</p>
 * <p>������ڣ�2011-12-13</p>
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
package ch02_OO.interface0;




/*
 *  ����
 */
abstract class Processor{
	public String name(){
		return getClass().getSimpleName();
	}
	Object process(Object input){
		return input;
	}
}
/*
 * ����Upcase
 */
class Upcase extends Processor{
	String process(Object input){
		return ((String)input).toUpperCase();
	}
}
/*
 * ����Lowcase
 */
class Lowcase extends Processor{
	String process(Object input){
		return ((String)input).toLowerCase();
	}
}
	
public class Ch2_1_AbstracClassTest {
	/**
	 * �������ģʽ��
	 * process��������Ҫִ�е��㷨�й̶�����Ĳ��֣��������ԡ�p�а����仯�Ĳ���
	 */
	public static void process(Processor p, Object s){
		System.out.println("Processor: " +p.name());
		System.out.println(p.process(s));
		
	}
	public static String s = "Hello, World!";
	
	public static void main(String[] args){
		process(new Upcase(),s);
		process(new Lowcase(),s);
	}
}



