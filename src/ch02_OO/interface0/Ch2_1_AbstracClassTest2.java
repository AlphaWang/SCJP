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

class Waveform{
	
}
/*
 * ����Filter
 */
abstract class Filter {
	public String name(){
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform w){
		System.out.println("����Filter.process()");
		return w;
	}
}
/*
 * ����HighPass
 */
class HighPass extends Filter{
	public Waveform process(Waveform w){
		System.out.println("����HighPass.process()");
		return w;
	}
}
/*
 * ����LowPass
 */
class LowPass extends Filter{
	public Waveform process(Waveform w){
		System.out.println("����LowPass.process()");
		return w;
	}
}
	
public class Ch2_1_AbstracClassTest2 {
	/**
	 * �������ģʽ��
	 * process��������Ҫִ�е��㷨�й̶�����Ĳ��֣��������ԡ�p�а����仯�Ĳ���
	 * 
	 * 1�����⣺
	 * ���ܸ���Ch2_1_AbstracClassTest.process()����
	 * 
	 * 2��ԭ��
	 * Ch2_1_AbstracClassTest.process()��Processor����Ϲ���
	 * Filter��Processor��������������
	 * 
	 * 3�������
	 * ��Porcessor��Ϊ�ӿڣ���Ch2_2_InterfaceTest��
	 * 
	 */
	public static void process(Filter f, Object s){
		System.out.println("Processor: " +f.name());
		System.out.println(f.process((Waveform)s));
		
	}
	public static Waveform w = new Waveform();
	
	public static void main(String[] args){
		process(new HighPass(),w);
		process(new LowPass(),w);
	}
}
