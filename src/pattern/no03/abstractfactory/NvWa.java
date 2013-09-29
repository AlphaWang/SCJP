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
package pattern.no03.abstractfactory;

import static java.lang.System.out;

public class NvWa {
	public static void main(String[] args){
		/**
		 * 抽象工厂模式 - Abstract Factory Pattern
		 * 
		 * Provide an interface for creating families of related/dependent objects 
		 * without specifying their concrete classes.
		 */
		
		/**
		 * 优点：
		 * 1. 封装性。高层模块不关心每个产品的实现类
		 * 2. 产品族内的约束为非公开状态。e.g.男女产品生产的比例，对高层模块透明。
		 * 
		 * 缺点：
		 * 1. 产品等级扩展容易，但产品族扩展困难。
		 * e.g.增加一个产品等级：中性人，容易————增加一个工厂类、增加产品类
		 *     增加一个产品族：棕色人种，困难————抽象工厂类增加create方法，其所有实现类都需随之修改，增加产品类
		 */
		
		/**
		 * 使用场景：
		 * 1. 有产品族，产品族具有相同的约束
		 */
		//两条生产线
		AbstractHumanFactory maleFactory = new MaleFactory();
		AbstractHumanFactory femaleFactory = new FemaleFactory();
		
		Human maleWhite = maleFactory.createWhiteHuman();
		Human femaleBlack = femaleFactory.createBlackHuman();
		
		
		out.println("第一次造白人男性：");
		maleWhite.getColor();
		maleWhite.talk();
		maleWhite.getSex();
		out.println("第二次造黑人女性");
		femaleBlack.getColor();
		femaleBlack.talk();
		femaleBlack.getSex();
	}

}
