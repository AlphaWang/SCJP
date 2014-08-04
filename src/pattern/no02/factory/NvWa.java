/**
 * <p>文件名称: NvWa.java </p>
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
package pattern.no02.factory;

import static java.lang.System.out;

public class NvWa {
	public static void main(String[] args){
		/**
		 * 工厂模式- Factory Pattern
		 * 
		 * Define an interface for creating an object, but let subclasses decide which class to instantiate.
		 * Factory Method lets a class defer instantiation to subclasses
		 */
		
		/**
		 * 优点：
		 * 1. 封装性。无需知道创建产品类的具体过程，减低模块间耦合
		 * 2. 扩展性。e.g.增加产品类只需增加一个Human子类即可
		 * 3. 屏蔽产品类。e.g.jdbc
		 * 4. 是典型的解耦框架。高层模块只知道产品的抽象类
		 */
		
		/**
		 * 使用场景：
		 * 1. 所有需要生成对象的地方都可用
		 * 2. 有产品类时。e.g.邮件服务程序中的不同连接协议
		 */
		AbstractHumanFactory factory = new HumanFactory();
		//高层模块只知道产品的抽象类Human
		Human blackHuman = factory.createHuman(BlackHuman.class);
		Human whiteHuman = factory.createHuman(WhiteHuman.class);
		
		out.println("第一次造白人：");
		whiteHuman.getColor();
		whiteHuman.talk();
		out.println("第二次造黑人");
		blackHuman.getColor();
		blackHuman.talk();
	}

}
