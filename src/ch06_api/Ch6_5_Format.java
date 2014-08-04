/**
 * <p>�ļ�����: Ch6_5_Format.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-2-15</p>
 * <p>������ڣ�2011-2-15</p>
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
package ch06_api;

import java.util.Formatter;

class Animal3{
	private String name;
	private Formatter f;
	int weight;
	public Animal3(String name, Formatter f){
		this.name = name;
		this.f = f;
	}
	public Animal3(){	}
	public void move(int x, int y){
		/**
		 * format()��printf()�ǵȼ۵�
		 */
		f.format("%s is at ( %d, %d). \n", name, x, y);
	}
}


public class Ch6_5_Format {

	public static void main(String[] args) {
		/**
		 * printf(	Locale l,
  					String format,
  					Object... args)
		 * 
		 * ����format������ʽ�����ݣ���ʽ������������%��ͷ:
		 * 
		 * 
		 * 	%[arg_index$] [flags] [width] [.precision] conversion_char
		 * 
		 *  [arg_index$]: ����$,ָ������ĸ���Ԫ
		 *  [flags]		: - �����
		 *  			  + ����������
		 *  			  0 ��0����Ԫ
		 *  			  , ǧλ�ָ�
		 *  			  ( ������������������       //�����Ͳ���ʾ��������
		 *  [width]		: Ҫ����������ַ���
		 *  [precision] : ���ȣ�������ʱ��Ҫ
		 *  conversion_char: ���ת���ַ� �� ʵ�ʱ�Ԫ ���Ͳ�ƥ�䣬
		 *                   ���õ�����ʱ�쳣��java.util.IllegalFormatConversionException:
		 */
		System.out.printf("%2$+(d & %1$+,d \n", 1234, -456);   //(456) & +1,234 
		//java.util.IllegalFormatConversionException:
		//// System.out.printf("%d", 12.33);
		
	    
		System.out.printf("%2$+0(20.1f & %1$+,d \n", 1234, -456.21);    //(0000000000000456.2) & +1,234 
		//java.util.IllegalFormatPrecisionException: 1
		//// System.out.printf("%2$+0(20.1d & %1$+,d \n", 1234, -456.21);
		
		/**
		 * String.format()
		 * �ڲ�����return new Formatter().format(format, args).toString();
		 */
		System.out.println(String.format("%2$+0(20.1f & %1$+,d \n", 1234, -456.21));    //(0000000000000456.2) & +1,234 
		
		Animal3 a = new Animal3("Tommy", new Formatter(System.out));
		Animal3 b = new Animal3("Jerry", new Formatter(System.err));
		
		a.move(1, 4); //Tommy is at ( 1, 4).
		b.move(5, 6);
		
		
		

	}

}
