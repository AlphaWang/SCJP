/**
 * <p>�ļ�����: ch1_3_�����η�.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-9</p>
 * <p>������ڣ�2010-9-9</p>
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

/**
 * 1. ���������и����߼�ʱ������Ҫ�۲�������η����ܿ��ܵ��±������
 * 
 * 2. �������η���public, protected, private  | ���ڲ��� ֻ����public ��Ĭ��
 *    �Ƿ������η���strictfp, final, abstract | û��strictfp����
 */
public class Ch1_3_�����η� {
	
	public static void main(String[] args){
		System.out.println("==== normal Class ====="); 
		float aFloat = 0.6710339f; 
		double aDouble = 0.04150553411984792d; 
		double sum = aFloat + aDouble; 
		float quotient = (float)(aFloat / aDouble); 
		System.out.println("float: " + aFloat); 
		System.out.println("double: " + aDouble); 
		System.out.println("sum: " + sum); 
		System.out.println("quotient: " + quotient); 
		System.out.println("==== strictfp Class ====="); 
		
		StrictfpClass o2 = new StrictfpClass();
		o2.count();
	}
	private class InnerClass{}
	protected class InnerClass2{}
}
/**
 * 3. ���ڲ��࣬������private/protected���η���
 *             ֻ����public ���� Ĭ��
 */
//// private class PrivateClass{}
//// protected class ProtectedClass{}
/**
 * 4. ���ܽ���ͬʱ��ʶΪfinal��abstract
 */
//// abstract final class AbstractClass{}

/**
 * 5. strictfp��strict float point(��ȷ����)��
 *    ��ʾ�������з��������ڴ�������ʱ������IEEE754��׼
 *    
 *    �����������ĸ���������Ӿ�ȷ�����Ҳ�����Ϊ��ͬ��Ӳ��ƽ̨��ִ�еĽ����һ�µĻ��������ùؼ���strictfp
 */
strictfp class StrictfpClass{
	public void count(){
		float aFloat = 0.6710339f; 
		double aDouble = 0.04150553411984792d; 
		double sum = aFloat + aDouble; 
		float quotient = (float)(aFloat / aDouble); 
		System.out.println("float: " + aFloat); 
		System.out.println("double: " + aDouble); 
		System.out.println("sum: " + sum); 
		System.out.println("quotient: " + quotient); 
	}
}
/**
 * 6. final: ���ཫ��������չ���ɱ�֤��ȫ��
 *           ����������ĳ�����������⣬���޷�ͨ���������޸�
 */
final class FinalClass{}
//// class SubClass extends FinalClass{}
/**
 * 7. abstract�������࣬�����ܱ�ʵ������ΨһĿ�������ڱ���չ
 * 
 *    abstract���� ��;��β��û��{}
 */
 abstract class AbstractClass{
	private String model;//���಻�ܷ���
	String type;
	public void setType() {}//������ǳ��󷽷�
	public abstract void setModel();//abstract���� ��;��β��û��{}
	                                //������abstract�����������Ϊabstract
}
class SubClass extends AbstractClass{
	public void setModel() {
		super.type = "";
	}
}
