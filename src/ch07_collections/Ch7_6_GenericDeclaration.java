/**
 * <p>�ļ�����: Ch7_6_GenericDeclaration.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-9</p>
 * <p>������ڣ�2011-3-9</p>
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
package ch07_collections;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;

public class Ch7_6_GenericDeclaration {

	public static void main(String[] args) 
	{
		List<Car> carList = new ArrayList<Car>();
		Car car1 = new Car();
		Car car2 = new Car();
		carList.add(car1);
		carList.add(car2);
		
		Rental<Car> rental = new Rental<Car>(carList, 10);
		
		Car rentCar = rental.getRental();
		
		//doStuff
		
		rental.returnRental(rentCar);
		
		/*String path = "conf"+File.separator+"conf\\app\\";
		System.out.println(path);*/

	}

}
/**
 * 1. �����Լ��ķ�����  ������������һ���࣬��ʵ����ʱ Ҫ�󴫵ݷ���
 * 
 * <E> ,Ҳ��Ϊ������ʶ��  ��������Ȼ��������������У��Ϳ���ʹ�á�Eռλ������
 * <E extends Animal>,Ϊ�������� ָ����Χ  �����������֣�������List/����ֻ������ʱ����<? extends Animal>
 * 
 * E ��Element, Լ�����ڼ�����
 * T ��Type��   Լ�����ڷǼ�����
 * 
 */

/*
 * ����ʹ��<?> <? extends Number>
 * 
 * Syntax error on token "?", invalid TypeParameter
 */

//class Err<? extends Number>{  }


class Rental<T>
{
	private List<T> rentalPool;
	private int maxnum;
	
	public Rental(List<T> list, int num){
		this.rentalPool = list;
		this.maxnum = num;
		
	}
	
	public T getRental(){
		return rentalPool.get(0);
	}
	
	public void returnRental(T returnedThing){
		rentalPool.add(returnedThing);
	}
}
class Car{		
}
//<E extends Animal>,Ϊ�������� ָ����Χ  
class MyList<E extends Number, T>
{
	E newElemE;
	T newElemT; //�Ϸ����� ����һ��ֻ���ڼ���
	E[] allElems;
	void add(E elem){
		
	}
	
}

class CreateList
{
	/**
	 * 2. �������ͷ��� ���������ڷǷ������� Ҫʹ�÷��ͷ���ʱ
	 * 
	 * �ڷ�������ǰ  �����������ͱ���<T>
	 * ���������������ڷ�������������������
	 * 
	 */
	public <T> List<T> makeList(T t){
		List<T> list = new ArrayList<T>();
		list.add(t);
		return list;
	}
	//����<E extends Animal>,Ϊ�������� ָ����Χ  
	public <T extends Number> void makeList2(T t){
		
	}
	
	public <T,E> void makeList3(T t,E e){
		
	}
	/*
	 * Ҳ�����ڶ��幹�췽��ʱʹ�� ���͡�
	 * ����������Ϊû�з������ͣ��������ܹ֣����ǺϷ��ģ�
	 */
	public <X> CreateList(X x){
		
	}
}

