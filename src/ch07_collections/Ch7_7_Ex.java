/**
 * <p>�ļ�����: Ch7_7_Ex.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-14</p>
 * <p>������ڣ�2011-3-14</p>
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

public class Ch7_7_Ex {

	
	
	
	
	public static void main(String[] args) 
	{

	}

}

interface Hungry<E>{
	void munch(E e);
}
interface Carnivore<E extends Animal> extends Hungry<E>{
	
}
interface Herbivore<E extends Plant> extends Hungry<E>{
	
}



abstract class Plant{
	
}

class Grass extends Plant{
	
}

abstract class Animal{
	
}


class Sheep extends Animal implements Herbivore<Sheep>{
	public void munch(Grass x){
		
	}

	@Override
	public void munch(Sheep e) {
		// TODO Auto-generated method stub
		
	}
}

//Sheep���ܸĳ���������Ӱ��Wolf�࣡
class Sheep2 extends Plant implements Carnivore<Wolf>{
	public void munch(Wolf x){
		
	}
}

class Wolf extends Animal implements Carnivore<Sheep>{
	public void munch(Sheep x){
		
	}
}

