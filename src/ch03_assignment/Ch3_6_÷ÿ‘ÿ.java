/**
 * <p>�ļ�����: Ch3_6_����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-4</p>
 * <p>������ڣ�2011-1-4</p>
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
package ch03_assignment;

public class Ch3_6_���� {
	// >>>>Ch2_4_����.java
	public static void main(String[] args) 
	{
		/**
		 * 1.�����������ض����ص�Ӱ�죺
		 * 1���ӿ�
		 * 2��װ��
		 * 3��var-arg
		 */
		
		/**
		 * ���Ҳ�����ȷ�ķ���ƥ��ʱ��JVM��ʹ��һ���������� ���бȲ����������С��Ԫ
		 * ���������ӿ�
		 */
		byte b = 127; 
		go(b);  //go(double)
		long l = 5;
		go(l);  //go(double)

		/**
		 * �ӿ�--װ�䣬JVM��ѡ��ӿ�
		 * ��������װ��ʱjava5�����ģ�����ӦӰ���ϴ������Ϊ
		 */
		int i = 127;
		go(i);    //go(Integer)
		          //go(double)����
		/**
		 * �ӿ�--vararg��JVM��ѡ��ӿ�
		 * ��������vararg��Java5�����ģ�����ӦӰ���ϴ������Ϊ
		 */
		byte b2 = 5;
		go(b2,b2);//go(byte...)
		          //go(int, int)����
		/**
		 *  װ��--var-arg ?????��JVM��ѡ��װ�䣡
		 *  ��������var-arg��װ������ɣ����ܴ�����������Ĳ������������쳣���� ��������
		 */
		
		
		
		
		/**
		 * 
		 * 2. �ӿ����ñ���
		 * �����������üӿ� �����ڼ̳�
		 * ����������װ�� ���ܼӿ���Ϊ��װ��֮����ƽ�ȵġ�
		 */
		/**
		 * ����Byte�����ܼӿ�Long
		 */
		Byte b3 = new Byte("2");
		//// test(b3);  //Byte����ӿ�Long   //The method test(Long) in the type Ch3_6_���� is not applicable for the arguments (Byte)
		
		
		
		
		
		/**
		 * ��������"�ȼӿ���װ��"
		 * ����byte������"�ȼӿ���װ��"��Long
		 * byte => long => Long (NNN)
		 */
		byte b4 = 2;
		//// test(b4);
		//The method test(Long) in the type Ch3_6_���� is not applicable for the arguments (byte)
		/**
		 * ��������"��װ�䣬��ӿ�"
		 * ����byte������"��װ�䣬��ӿ�"��Object
		 * byte => Byte => Object (YYY)
		 */
		BoxAndWiden(b4);
		
		
	}
	/*static void go(int x){
		System.out.println("go(int)");
	}*/
	static void go(Integer i){
		System.out.println("go(Integer)");
	}
	
	static void go(double d){
		System.out.println("go(double)");
	}
	
	static void go(int i, int j){
		System.out.println("go(int, int)");
	}
	static void go(byte... x){
		System.out.println("go(byte...)");
	}
	
	/////////////////////
	static void test(Long i){
		System.out.println("test(Long)");
	}
	////////////////////
	static void BoxAndWiden(Object o){
		System.out.println("test(Object)");
	}
	

}
