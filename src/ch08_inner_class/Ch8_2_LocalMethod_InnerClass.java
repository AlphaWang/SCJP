package ch08_inner_class;

/**
 *  �ֲ������ڲ��ࣺ�ڷ����ڲ�������
 *
 *  ʹ�ó�������������Ϊ�β��������ڲ���
 *  ����Ҫһ���������Ĺ�������������Ҫ���ع�����ʱ��
 */
class Outer2
{
	private String outerVar = "outerVar";
	
	public void doStufff(final String var)
	{
		String methodLocalVar = "methodLocalVar";
		final String methodLocalVar_Final = "methodLocalVar_Final";
		/**
		 * 1. �����ڷ����ڶ����ڲ���
		 *
		 */
		//����ֲ������ڲ���֮�󣬲���ʵ������������
		//// Inner2 inner = new Inner2();
		
		class Inner2
		{
			public void seeOuter()
			{
				System.out.println("�����ⲿ��˽�б�����"+outerVar);
				/**
				 * 2. �ڲ������ ����ʹ�������ڷ����ľֲ����������Ǿֲ�������ʶΪfinal	
				 *    ����������Ϊ�п��ֲܾ������Ѿ����������ڲ�����󻹴��
				 *    
				 *    Cannot refer to a non-final variable methodLocalVar inside an inner class defined in a different method
				 * 
				 */
			    //// System.out.println("���ʷ����ľֲ�������"+methodLocalVar);
				System.out.println("���ʷ����ľֲ�final������"+methodLocalVar_Final);
				
				/**
				 * �ڲ�����ʹ��һ�������ⲿ����Ķ�����Ҫ�������final�ģ�
				 */
				System.out.println("����final����������" + var);
			}
			/**
			 * �ڲ�������й��캯��
			 */
			Inner2(){
				System.out.println("Inner2()");
			}
		}
		/**
		 * 3. �ֲ������ڲ��� ֻ���ڷ�����ʵ����		 * 
		 *    �ڷ����ⲿ�����ܷ��ʸ��ڲ���Inner2����
		 */
		Inner2 inner2 = new Inner2();
		inner2.seeOuter();
	}//end of doStufff()
	
	
}
public class Ch8_2_LocalMethod_InnerClass {

	public static void main(String[] args) 
	{
		Outer2 outer2 = new Outer2();
		outer2.doStufff("param");

	}

}
