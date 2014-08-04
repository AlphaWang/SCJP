/**
 * <p>文件名称: Ch2_4_重载.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-10-20</p>
 * <p>完成日期：2010-10-20</p>
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

public class Ch2_4_重载 
{
	/**
	 *  1. 重载方法必须改变参数列表
	 *  
	 * 重载的var-arg方法 是最后的选择。
	 * 数组is a Object。
	 */
	
	public String eat(String s){
		return s;
	}
	//*** !!! 自动装箱的参数，也认为是改变了参数列表
	public String eat(int i){
		return "eat(int i)";
	}
	public String eat(Integer j){
		return "eat(Integer j)";
	}
	public String eat(int i,int j){
		return "eat(int i,int j) ";
	}
	//*** var-arg，也认为改变了参数列表 ？？！！
	public String eat(int... is){
		return "eat(int... is)";
	}
	// 重复方法，与int... is	
//	public String eat(int[] is){
//		return "eat(int[] is)";
//	}
	
	
	//数组类型的var-arg测试
	public String  eat(int[]... is){
		return "eat(int[]... is)";
	}
	public String eat(int[] i, int[] j){
		return "eat(int[] i, int[]j)";
	}
	/**
	 *  String[] 与String... 重复！！！！！
	 */
	/*
	public String  eat(String[] is)
	{
		return "eat(String[] is)";
	}
	*/
	
	/*
	public String  eat(String... is)
	{
		return "eat(String... is)";
	}*/
	public String  eat(String[]... is){
		return "eat(String[]... is)";
	}
	public String eat(String[] i, String[] j){
		return "eat(String[] i, String[]j)";
	}
	
	public String eat(Object o){
		return "eat(Object o)";
	}
	/**
	 *  2. 参数列表为父类/子类的两个方法，也是重载
	 *     调用时，若参数为父类引用 子类对象，调用父类方法
	 */
	public void method(Parent1 p){
		System.out.println(p.getClass()+", 参数列表=Parent");
	}
	public void method(Child1 c){
		System.out.println(c.getClass()+", 参数列表=Child");
	}
	public static void main(String[] args)
	{
		Ch2_4_重载 o = new Ch2_4_重载();
		System.out.println("o.eat(2)\t: "+o.eat(2));		//eat(int i)
		System.out.println("o.eat(new Integer(2))\t: "+o.eat(new Integer(2)));//eat(Integer j)
		System.out.println("o.eat(1,2)\t:"+o.eat(1,2));		//eat(int i,int j) 
		System.out.println("o.eat(1,2,3)\t:"+o.eat(1,2,3));	//eat(int... is)
		/**
		 * 参数为int[]； 调用eat(int... )
		 *              而非eat(int[]... )
		 */
		System.out.println("o.eat(new int[]{1,2})\t:"+o.eat(new int[]{1,2})); //eat(int... is)
		/**
		 * 参数为int[],int[]；调用eat(int[], int[])
		 *                    而非eat(int[]... )
		 */
		System.out.println("o.eat(new int[]{1,2},new int[]{1,2})\t:"+o.eat(new int[]{1,2},new int[]{1,2}));//eat(int[] i, int[]j)
		/**
		 * 参数为String[]；调用eat(Object )；eat(String... is)
		 *                 而不是eat(String[]... )！！
		 *                 
		 * ————一般，重载的var-arg方法 是最后的选择。数组is a Object。
		 */
		System.out.println("o.eat(new String[]{\"a\",\"b\"})\t:"+o.eat(new String[]{"a","b"}));//eat(Object o)
		
		
		System.out.println("------------------");
		/**
		 * 3. 选择调用哪个重载方法，并不是在运行时动态决定的!!!!
		 */
		Parent1 pp = new Parent1();
		Parent1 pc = new Child1();
		Child1 cc = new Child1();
		o.method(pp);//参数为Parent
		o.method(pc);//参数为Parent！！
		o.method(cc);//参数为Child
		
		
		System.out.println("------------------");
		//测试多态 对重载的影响		
		pp.methodP();//调用父类方法
		pc.methodP();//调用子类重写方法
		
		//下句不合法！除非进行强制转换
		//// pc.methodC()
		if(pc instanceof Child1){
			Child1 c = (Child1)pc;
			c.methodC();//调用子类方法
		}
		
		cc.methodP();
		cc.methodC("Test");
		cc.methodC();
	}
	

}

class Parent1
{
	public void methodP(){
		System.out.println("父类methodP方法");
	}
}
class Child1 extends Parent1
{
	public void methodC(){
		System.out.println("子类methodC()重载方法");
	}
	public void methodC(String s){
		System.out.println("子类methodC(String)重载方法 "+s);
	}
	@Override
	public void methodP(){
		System.out.println("子类重写methodP方法");
	}
}
