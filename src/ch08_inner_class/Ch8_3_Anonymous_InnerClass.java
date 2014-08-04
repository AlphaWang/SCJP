/**
 * <p>�ļ�����: Ch8_3_Anonymous_InnerClass.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-15</p>
 * <p>������ڣ�2011-3-15</p>
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
package ch08_inner_class;


class Outer3
{
	/**
	 * 
	 * 1. ��ͨ�� ��ʽ�����ڲ��࣬��ʽһ
	 * �����ڲ��಻���й��캯�������캯����ʵ����ʼ���������
	 * 
	 */
	
	//Outer3��ʵ������innerObj1��innerObj1��ParentClass���һ�����������ࡱ����
	ParentClass innerObj1 = new ParentClass(){
		private String name = null;
		
		/**
		 * ʵ����ʼ���飬�൱�������ڲ���Ĺ��캯��
		 * ���𣺲������أ�����һ�����캯��
		 */		
		{
			name = "Initial name";
		}
		
		//��дParentClass���doStuff����
		public void doStuff(){
			System.out.println("����һ��Inner ��дParentClass.doStuff()");
		}
		//�����·���
		public void newMethod(){
			System.out.println("����һ��Inner ����newMethod()");
		}
	};

	/**
	 * 
	 * 2. ��ͨ�ľ�ʽ�����ڲ��࣬��ʽ��
	 * 
	 * ������������ʽһ�Ĳ��
	 * ��ʽһ������ָ�� ���� ����������
	 * ��ʽ��������ָ�� �ӿ� ������ʵ���� (ֻ��ʵ��һ���ӿ�)
	 * 
	 * �������������ڲ���Ҫô��չ�࣬Ҫôʵ�ֽӿڣ����ǲ������߼汸��
	 */
	MyInterface innerObj2 = new MyInterface(){
		@Override
		public void interfaceMethod() {
			System.out.println("��������ʵ��MyInterface.interfaceMethod()");
		}
		
	};
	
	public void outerMethod(){
		innerObj1.doStuff();
		/**
		 * ע�����������ڲ��� ���ö�̬����
		 * The method newMethod() is undefined for the type Test
		 */
		//// t.newMethod();
		
		innerObj2.interfaceMethod();
	}
	
	//���ڲ��Է�����
	public void doStuff(ParentClass arg){
		arg.doStuff();
		
	}
	
	
}
class ParentClass{
	public void doStuff(){
		System.out.println("ParentClass");
	}
	ParentClass(){
		
	}
}
interface MyInterface{
	public void interfaceMethod();
}

public class Ch8_3_Anonymous_InnerClass 
{

	public static void main(String[] args) 
	{

		//���Է���һ����
		Outer3 outer = new Outer3();
		outer.outerMethod();
		
		/**
		 * 
		 * 3. ��Ԫ�����������ڲ���
		 * 
		 */
		
		outer.doStuff(new ParentClass(){
			//��дParentClass���doStuff����
			public void doStuff(){
				System.out.println("����������Ԫ�����������ڲ��ࣺ ��дParentClass.doStuff()");
			}
			//�����·���
			public void newMethod(){
				System.out.println("����������Ԫ�����������ڲ��ࣺ ����newMethod()");
			}
		});
		

	}

}
