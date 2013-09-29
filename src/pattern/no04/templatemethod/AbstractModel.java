/**
 * <p>文件名称: AbstractModel.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-9-7</p>
 * <p>完成日期：2011-9-7</p>
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
package pattern.no04.templatemethod;

public abstract class AbstractModel {
	/**
	 * 基本方法：
	 * 1.提供给子类实现
	 * 2.通过基本方法，子类可重定义算法的特定步骤
	 * 3. 尽量设计为protected，符合迪米特法则！！！
	 */
	protected abstract void start();
	protected abstract void stop();
	protected abstract void alarm();
	protected abstract void engineBoom();
	/**
	 * 模板方法：
	 * 1.如果放到子类实现，每个子类都有重复代码，所以提到父类 称为模板方法。
	 * 2.模板方法是一个"框架"，实现对基本方法的调度，完成固定的逻辑！！
	 * 3.一般为final，防止恶意重写
	 */
	public final void run(){
		start();
		engineBoom();
		if(isAlarm()){//扩展：钩子方法
			alarm();
		}
		stop();
	}
	//扩展：由子类控制是否alarm
	/**
	 * 钩子方法！
	 * 钩子方法的返回值，影响了模板方法的执行结果
	 */
	protected boolean isAlarm(){
		return true;
	}
}
