/**
 * <p>文件名称: GamesTest.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-14</p>
 * <p>完成日期：2011-12-14</p>
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


interface Game{
	boolean move();
}
interface GameFactory{
	Game createGame();
}

//////////////////////////////
class XiangQi implements Game{
	private int moves = 0;
	private static final int TOTAL_MOVES = 3;
	@Override
	public boolean move() {
		System.out.println("XiangQi move: " +moves);
		return ++moves != TOTAL_MOVES;
	}
}
class XiangQiFactory implements GameFactory{
	@Override
	public Game createGame() {
		return new XiangQi();
	}
}
///////////////////////////////
class WuziQi implements Game{
	private int moves = 0;
	private static final int TOTAL_MOVES = 5;
	@Override
	public boolean move() {
		System.out.println("WuziQi move: " +moves);
		return ++moves != TOTAL_MOVES;
	}
}
class WuziQiFactory implements GameFactory{
	@Override
	public Game createGame() {
		return new WuziQi();
	}
}

/**
 * 工厂设计模式应用
 *
 */

public class GamesTest {
	public static void playGame(GameFactory factory){
		Game game = factory.createGame();
		while(game.move()){
			
		}
	}
	
	public static void main(String[] args){
		playGame(new XiangQiFactory());
		playGame(new WuziQiFactory());
	}

}
