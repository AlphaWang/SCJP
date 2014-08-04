/**
 * <p>文件名称: Minister.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-9-5</p>
 * <p>完成日期：2011-9-5</p>
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
package pattern.no01.sigleton;

public class Minister {

	public static void main(String[] args){
		/**
		 * 单例模式-Singleton Pattern
		 * 
		 * Ensure a class has only one instance, and provide a global point of access to it.
		 */
		
		/**
		 * 优点：
		 * 1. 减少内存开支
		 * 2. 减少性能开销
		 * 3. 避免对资源的多重占用(例如只能创建一个资源文件的实例)
		 * 4. 可以在系统设置全局的访问点
		 * 
		 * 缺点：
		 * 1. 一般没有接口，扩展困难
		 */
		
		/**
		 * 使用场景：
		 * 1. 需要生成唯一序列号时
		 * 2. 需要一个共享访问点或共享数据库时
		 * 3. 创建一个对象要消耗的资源过多时
		 * 4. 需要定义大量的静态变量和静态方法时
		 */
		for(int day=0; day<3; day++){
			Emperor emperor = Emperor.getInstance();
			emperor.say();
		}
	}
}
