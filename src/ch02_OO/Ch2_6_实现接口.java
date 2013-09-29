/**
 * <p>文件名称: Ch2_6_实现接口.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-10-25</p>
 * <p>完成日期：2010-10-25</p>
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
package ch02_OO;

import java.io.IOException;
/**
 * 0. 只能继承一个类，但可以实现多个接口
 *
 */
public class Ch2_6_实现接口 implements MyInterface,Runnable
{

	/**
	 * 1. 必须满足重写的条件，包括不能抛出更广、更多的异常
	 */
	/*
	@Override
	public void bounce() throws IOException{
		// TODO Auto-generated method stub
		
	}
	*/
	/**
	 * 2. 非抽象实现类，必须实现接口中定义的所有方法
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bounce(){
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	
	

}
/**
 * 3. 子接口 只是向父接口的契约中添加更多的要求
 *    不是先父接口的方法！！
 *
 */
interface MyInterface extends Runnable
{
	public void eat()throws ClassCastException;
	public void bounce();
	/**
	 * 3. 接口中的方法都是抽象的，不能有具体内容
	 *    ————接口是一个100%抽象类
	 */
	/*
	 public void method(){}
	 */
	
}
