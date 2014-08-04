/**
 * <p>�ļ�����: Ch2_2_InterfaceTest.java </p>
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
package ch02_OO.interface1;

/**
 * Interface��  ��Ĭ��static��final   ���������ӿ��в��涨״̬��ֻ�涨��Ϊ�����������ʺ��������������飬enum��ԭ��
 * Interface������Ĭ��public��abstract
 */

/**
 * ʹ�ýӿڻ��ǳ����ࣿ
 * ���Ҫ���������κη������塢�Լ���Ա�����Ļ��࣬Ӧ���ýӿ�
 */


/*
 *  �ӿ�
 */
interface Processor{
	String name(); //Ĭ��public
	Object process(Object input);
	void imethod();
}
/*
 * ====����
 */
abstract class StringProcessor implements Processor{
	@Override
	public String name() {
		return getClass().getSimpleName();
	}
	@Override
	public abstract Object process(Object input);	
}
/*
 * ����Upcase
 */
class Upcase extends StringProcessor{
	public String process(Object input){ //�����public����
		return ((String)input).toUpperCase();
	}

	@Override
	public void imethod() {
		/**
		 * �ӿڵ�ʵ���࣬������super!!
		 */
		//// super.imethod();	
	}
}
/*
 * ����Lowcase
 */
class Lowcase extends StringProcessor{
	public String process(Object input){
		return ((String)input).toLowerCase();
	}
	public void imethod() {
	}
}
class Waveform{
	
}
/*
 * ====����Filter
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



/**
 * �����������ģʽ
 *   �������еĴ��룬����������ӵ�еĽӿڣ�����������Ҫ�Ľӿ�
 * 
 */
class FilterAdapter implements Processor{
	Filter filter;
	FilterAdapter(Filter f){
		filter = f;
	}

	@Override
	public String name() {
		return filter.name();
	}

	@Override
	public Waveform process(Object input) {//Э�䷵������
		return filter.process((Waveform)input);
	}
	
	public void imethod() {
	}
	
}




	
public class Ch2_2_InterfaceTest {
	/**
	 * 
	 */
	public static void process(Processor p, Object s){
		System.out.println("Processor: " +p.name());
		System.out.println(p.process(s));
		
	}
	public static String s = "Hello, World!";
	public static Waveform w = new Waveform();
	
	public static void main(String[] args){
		process(new Upcase(),s);
		process(new Lowcase(),s);
		/**
		 * process()�����ɸ����ˣ�
		 */
		process(new FilterAdapter(new HighPass()),w); //HighPass��Ch2_1_AbstracClassTest2�ж���
		process(new FilterAdapter(new LowPass()),w);
		
	}
}


