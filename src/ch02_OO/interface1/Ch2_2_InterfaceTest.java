/**
 * <p>文件名称: Ch2_2_InterfaceTest.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-13</p>
 * <p>完成日期：2011-12-13</p>
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
package ch02_OO.interface1;

/**
 * Interface域  ：默认static、final   ————接口中不规定状态，只规定行为—————适合用来创建常量组，enum的原型
 * Interface方法：默认public、abstract
 */

/**
 * 使用接口还是抽象类？
 * 如果要创建不带任何方法定义、以及成员变量的基类，应该用接口
 */


/*
 *  接口
 */
interface Processor{
	String name(); //默认public
	Object process(Object input);
	void imethod();
}
/*
 * ====基类
 */
abstract class StringProcessor implements Processor{
	@Override
	public String name() {
		return getClass().getSimpleName();
	}
	@Override
	public abstract Object process(Object input);	
}
/*
 * 子类Upcase
 */
class Upcase extends StringProcessor{
	public String process(Object input){ //必须加public！！
		return ((String)input).toUpperCase();
	}

	@Override
	public void imethod() {
		/**
		 * 接口的实现类，不可用super!!
		 */
		//// super.imethod();	
	}
}
/*
 * 子类Lowcase
 */
class Lowcase extends StringProcessor{
	public String process(Object input){
		return ((String)input).toLowerCase();
	}
	public void imethod() {
	}
}
class Waveform{
	
}
/*
 * ====父类Filter
 */
abstract class Filter {
	public String name(){
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform w){
		System.out.println("父类Filter.process()");
		return w;
	}
}
/*
 * 子类HighPass
 */
class HighPass extends Filter{
	public Waveform process(Waveform w){
		System.out.println("子类HighPass.process()");
		return w;
	}
}
/*
 * 子类LowPass
 */
class LowPass extends Filter{
	public Waveform process(Waveform w){
		System.out.println("子类LowPass.process()");
		return w;
	}
}



/**
 * ！适配器设计模式
 *   适配器中的代码，将接受你所拥有的接口，产生你所需要的接口
 * 
 */
class FilterAdapter implements Processor{
	Filter filter;
	FilterAdapter(Filter f){
		filter = f;
	}

	@Override
	public String name() {
		return filter.name();
	}

	@Override
	public Waveform process(Object input) {//协变返回类型
		return filter.process((Waveform)input);
	}
	
	public void imethod() {
	}
	
}




	
public class Ch2_2_InterfaceTest {
	/**
	 * 
	 */
	public static void process(Processor p, Object s){
		System.out.println("Processor: " +p.name());
		System.out.println(p.process(s));
		
	}
	public static String s = "Hello, World!";
	public static Waveform w = new Waveform();
	
	public static void main(String[] args){
		process(new Upcase(),s);
		process(new Lowcase(),s);
		/**
		 * process()方法可复用了！
		 */
		process(new FilterAdapter(new HighPass()),w); //HighPass在Ch2_1_AbstracClassTest2中定义
		process(new FilterAdapter(new LowPass()),w);
		
	}
}


