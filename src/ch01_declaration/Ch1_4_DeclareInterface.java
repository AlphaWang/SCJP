/**
 * <p>�ļ�����: Ch1_4_�����ӿ�.java </p>
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

    /**
     * 0. �ӿڿ���extends�������ӿڣ�������implements
     * 0. �ӿ����������� abstract��������
     * 0. �ӿڿ�����չ�Զ�������ӿ�
     */
public interface Ch1_4_DeclareInterface extends Runnable,Bounceable{
	/**
	 ******* 1. �ӿ��������ġ���������Ĭ�϶���public abstract��	
	 *          ���Բ�������Ϊfinal��static
	 */
	                void method1();
	public abstract void method2();
	
	/*
	 * Illegal modifier for the interface method staticMethod; only public & abstract are permitted
	 */
	//// static void staticMethod();
	//// final  void finalMethod();
	//// private void privateMethod();
	/**
	 ******* 2. �ӿ��������ġ���������Ĭ�϶���public static final
	 */
	                    int var2 = 2;
	public static final int var1 = 1;
	//// private int privateVar = 0 ;
	
	
	/**
	 * 3. �ӿ��������ķ�����һ��������static / final / strictfp / native��, 
	 *                     final��abstract����
	 *                     static��abstract���⣬���ܱ���д	           
	 *                     ��������Ҳ���ǽ���Ϊpublic abstract
	 *                     
	 *    ��νstatic�������ܱ���д��
	 *    ������̬ʱ���þ�̬������ʼ�յ��õ��Ǹ����еģ������з�������Ҳ���ø����еġ�
	 *    ����static ���߱����� �������������д������private�� ������ ���Ƹ�д ʵ�����¼�
	 */
	//// static void method3();
	//// final void method4();
	
	/**
	 * 4. �ӿ��еķ�����ֻ��Ϊ���󷽷���������������������
	 */
	//// public void test(){	}
}


    /**
     * 5. �ӿ����������� abstract
     */
abstract interface Bounceable{
	void bounce();
}

/**
 * ������
 * 
 * ���������й��캯��
 * ���ӿ�û�й��캯��
 *
 */
abstract class AbstractClass2{
	//û��abstract�������ԷֺŽ�β
	void method() {		
	}
	
	//static�������ڽӿ��в��ܳ���
    static void method1(){		
	}
    
    // abstract��static����
	//// abstract static void method2();
    
    public abstract  void method4();
	
}
