/**
 * <p>�ļ�����: GamesTest.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-14</p>
 * <p>������ڣ�2011-12-14</p>
 * <p>�޸ļ�¼1: // �޸���ʷ��¼�������޸����ڡ��޸��߼��޸�����</p>
 * <pre>
 *    �޸����ڣ�
 *    �� �� �ţ�
 *    �� �� �ˣ�
 *    �޸����ݣ�
 * </pre>
 * <p>�޸ļ�¼2����</p>
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
 * �������ģʽӦ��
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
