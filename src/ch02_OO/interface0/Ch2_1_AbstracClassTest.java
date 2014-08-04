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




/*
 *  父类
 */
abstract class Processor{
	public String name(){
		return getClass().getSimpleName();
	}
	Object process(Object input){
		return input;
	}
}
/*
 * 子类Upcase
 */
class Upcase extends Processor{
	String process(Object input){
		return ((String)input).toUpperCase();
	}
}
/*
 * 子类Lowcase
 */
class Lowcase extends Processor{
	String process(Object input){
		return ((String)input).toLowerCase();
	}
}
	
public class Ch2_1_AbstracClassTest {
	/**
	 * 策略设计模式：
	 * process方法包含要执行的算法中固定不变的部分；而“策略”p中包含变化的部分
	 */
	public static void process(Processor p, Object s){
		System.out.println("Processor: " +p.name());
		System.out.println(p.process(s));
		
	}
	public static String s = "Hello, World!";
	
	public static void main(String[] args){
		process(new Upcase(),s);
		process(new Lowcase(),s);
	}
}



