/**
 * <p>�ļ�����: Ch1_5_�������Ա_����ö��.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-17</p>
 * <p>������ڣ�2010-9-17</p>
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

public class Ch1_5_�������Ա_����ö�� {

	public static void main(String[] args)
	{
		Coffee coffee = new Coffee();
		/**
		 * ����һ���������ڲ����� ��ö��
		 * 1. =Coffee.Grade.GOOD;
		 * 2. =Grade.GOOD; ͬʱimport ch01_declaration.Coffee.Grade;
		 */
		coffee.size = CoffeeSize.BIG;//size ��һ��CoffeSize���ʵ��
		coffee.grade = Coffee.Grade.GOOD;
		
		coffee.size2 = CoffeeSize2.HUGE;
		System.out.println("coffee.size:" + coffee.size );
		System.out.println("coffee.size2:"+ coffee.size2 );
		
		/**
		 * ��������Զ����ֱ�ӵ���enum�Ĺ��캯����
		 */
		//// coffee.size2  = new CoffeeSize2(10);
		
		/**
		 * enum��values�������Ա���ö��ֵ
		 */
		CoffeeSize2[] allSize = CoffeeSize2.values();
		for(CoffeeSize2 size : allSize){
			System.out.println(size + ":"+size.getOunces());
		}
		
	}
}

//1.ö�ٿ��Զ���Ϊ��������
enum CoffeeSize{
	BIG,
	HUGE,
	OVERWHELMING
}
/**
 * ö�������У����԰������캯����ʵ������������
 */
enum CoffeeSize2{
	BIG(8),//����public static final CoffeeSize2 BIG = new CoffeeSize2(8);
	HUGE(10),
	/**
	 * enum�ڲ����Զ��� "�����ض�����" constant specific class body��
	 * ������������дENUM����ķ���
	 */
	OVERWHELMING(20){
		public int getOunces(){
			return 100;
		}
	};//******** <- ö�ٳ���ֵ�����ԷֺŽ���
	
	
	private int ounces;
	CoffeeSize2(int ounces){
		this.ounces = ounces;
	}
	public int getOunces(){
		return ounces;
	}
	
	
}
class Coffee{
	CoffeeSize size; 
	CoffeeSize2 size2;
	Grade grade;
	
	/**
	 * 2.ö�ٿ��Զ���Ϊ���Ա
	 *
	 */
	enum Grade{
		NORMAL, 
		//����public static final Grade NORMAL2;
		GOOD
	}; //****** <-�����зֺ�
	public void getCoffee()
	{
		/**
		 * 3.ö�ٲ����Զ����ڷ����ڲ�����:���ɶ���Ϊ�ֲ�����
		 */
		/*enum Test{
			ENUM1,
			ENUM@
		}*/
	}
}