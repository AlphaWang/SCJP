/**
 * <p>文件名称: Ch7_7_Ex.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-14</p>
 * <p>完成日期：2011-3-14</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
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

//Sheep不能改成这样，会影响Wolf类！
class Sheep2 extends Plant implements Carnivore<Wolf>{
	public void munch(Wolf x){
		
	}
}

class Wolf extends Animal implements Carnivore<Sheep>{
	public void munch(Sheep x){
		
	}
}

