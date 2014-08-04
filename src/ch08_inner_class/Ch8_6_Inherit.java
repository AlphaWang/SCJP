/**
 * <p>文件名称: Ch8_6_Inherit.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-27</p>
 * <p>完成日期：2011-12-27</p>
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
package ch08_inner_class;


class Egg{
	protected Yolk yolk = new Yolk();
	protected class Yolk{
		public Yolk(){
			System.out.println("Egg.Yolk()");
		}
		public void methodYolk(){
			System.out.println("Egg.Yolk.method()");
		}
	}
	
	public Egg(Yolk y){
		System.out.println("Egg(Yolk)");
		yolk = y;
	}
	public Egg(){
		System.out.println("Egg()");
	}
	public void setYolk(Yolk y){
		yolk = y;
	}
	public void methodEgg(){
		yolk.methodYolk();
	}
}
/**
 * 扩展父类，重新定义内部类，但不扩展内部类
 * 
 * ————此内部类BigEgg.Yolk 和Egg.Yolk 是独立的！
 */
class BigEgg extends Egg{
	
	public BigEgg(Yolk y) {//这里的Yolk是子类中的BigEgg.Yolk，所以super(y)编译出错The constructor Egg(BigEgg.Yolk) is undefined
		//// super(y);     //这里的参数只能是父类的Egg.Yolk
		
		super(new Egg(null).new Yolk());
		System.out.println("BigEgg(Yolk)");
	}
	public BigEgg(){
		System.out.println("BigEgg()");
	}

	public class Yolk{ //不是重载
		public Yolk(){
			System.out.println("BigEgg.Yolk()");
		}
	}
}
/**
 * 扩展父类，同时扩展内部类 
 *
 * BigEgg2.Yolk是Egg.Yolk子类，有重载
 */
class BigEgg2 extends Egg{
	
	public class Yolk extends Egg.Yolk{
		public Yolk(){
			System.out.println("BigEgg2.Yolk()");
		}
		public void methodYolk(){
			System.out.println("BigEgg2.Yolk.method()");
		}
	}
	public void methodEgg(){
		yolk.methodYolk();
	}
	public BigEgg2(Yolk y) { //这里的Yolk是子类中的BigEgg2.Yolk，继承自Egg.Yolk
		super(y);            //这里的参数只能为Egg.Yolk
		System.out.println("BigEgg2(Yolk)");
	}
	public BigEgg2(){
		System.out.println("BigEgg2()");
	}
}


public class Ch8_6_Inherit {
	public static void main(String[] args){
		
		BigEgg bEgg = new BigEgg();  //不会调用 子类的Yolk
		/*
		Egg.Yolk()  --父类成员初始化
		Egg()       --父类构造方法
		BigEgg()    --子类构造方法
		*/
		
		//bEgg.methodEgg();
		
		System.out.println("==================");		
		BigEgg2 bEgg2 = new BigEgg2();
		/*
		Egg.Yolk()  --父类成员初始化
		Egg()       --父类构造方法
		BigEgg2()   --子类构造方法
		 */
		
		System.out.println("==================");
		BigEgg2.Yolk bigYolk = bEgg2.new Yolk();
		/*
		Egg.Yolk()
		BigEgg2.Yolk()
		*/
		bEgg2.setYolk(bigYolk);
		bEgg2.methodEgg();  //重载：调用的是BigEgg2.Yolk.methodYolk()
		/*
		BigEgg2.Yolk.method()
		*/
	}
}


