/**
 * <p>�ļ�����: Ch2_2_Interface.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-14</p>
 * <p>������ڣ�2011-12-14</p>
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
package ch02_OO;

interface CanFly{
	void fly();
}

interface CanFight {
	void fight();
}
/**
 *  �ӿڿ��Լ̳ж���ӿڣ�
 */
interface Bird extends CanFight, CanFly{
	
}
/**
 * ���μ̳У�
 */
interface SubBird extends Bird{
	
}

//////////////////////////////
interface CanFly2{
	int fly();
}
class ParentClass{
	String fly(){
		return "Flying";
	}
}
/**
 * ͬʱ�̳������ӿڣ�������ĳ������ǩ����ͬ������ֵ��ͬ��
 * ��������������� The return type is incompatible with CanFly2.fly(), CanFly.fly()
 */
//// interface SubInter extends CanFly, CanFly2{ }


/**
 * ͬʱ�̳и��ࡢʵ�ֽӿڣ�������ĳ������ǩ����ͬ������ֵ��ͬ��
 * ���������������The return type is incompatible with CanFly.fly(), Parent.fly()
 */
//// class Child extends ParentClass implements CanFly{  }




///////////////////////////
class Superman{
	public void fight(){
		System.out.println("Superman.fight()");
	}
	void fly(int time){
		System.out.println("Superman.fly():"+ time);
	}
}
/**
 * ����ͽӿ��У�ͬ�������ķ���Ȩ�����⣺
 * 
 * ���Superman.fight()��Ϊpublic������ʾ
 * The inherited method Superman.fight() cannot hide the public abstract method in CanFight
 *
 */
class Jack extends Superman implements CanFight,CanFly{
	/**
	 * �����С��ӿ��о���fight()ʱ�������е�fight()�ǴӸ���̳����ģ�
	 */
	//public void fight() //�̳��Ը���
	//void fly(int time)  //�̳��Ը���
	
	@Override
	public void fly() {
		System.out.println("Jack.fly()ʵ�ֽӿڷ���");		
	} 
}

public class Ch2_2_Interface{
	public static void main(String[] args){
		Jack jack = new Jack();
		jack.fight();
		jack.fly();
		jack.fly(110);
	}

}

