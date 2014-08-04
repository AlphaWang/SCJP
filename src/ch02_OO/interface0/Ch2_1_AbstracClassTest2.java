/**
 * <p>文件名称: Ch2_1_Interface.java </p>
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
package ch02_OO.interface0;

class Waveform{
	
}
/*
 * 父类Filter
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
	
public class Ch2_1_AbstracClassTest2 {
	/**
	 * 策略设计模式：
	 * process方法包含要执行的算法中固定不变的部分；而“策略”p中包含变化的部分
	 * 
	 * 1、问题：
	 * 不能复用Ch2_1_AbstracClassTest.process()方法
	 * 
	 * 2、原因：
	 * Ch2_1_AbstracClassTest.process()与Processor类耦合过紧
	 * Filter和Processor是两个独立的类
	 * 
	 * 3、解决：
	 * 将Porcessor作为接口（见Ch2_2_InterfaceTest）
	 * 
	 */
	public static void process(Filter f, Object s){
		System.out.println("Processor: " +f.name());
		System.out.println(f.process((Waveform)s));
		
	}
	public static Waveform w = new Waveform();
	
	public static void main(String[] args){
		process(new HighPass(),w);
		process(new LowPass(),w);
	}
}
