/**
 * <p>文件名称: Test.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-5</p>
 * <p>完成日期：2011-1-5</p>
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
package ch03_assignment;

public class Test {
	public enum Coffee{
		SMALL(1),MEDIUM(5),LARGE(10){
			public int getSize(){
				return 20;
			}
		};
		private int size;
		Coffee(int size){
			this.size = size;
		}
		public int getSize(){
			return size;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Suits.NOTRUMP.getValue(3));
		System.out.println(Suits.SPADES.getValue(3));
		//System.out.println(Suits.NOTRUMP.points);//private变量
		
		System.out.println(Coffee.MEDIUM.getSize());
		System.out.println(Coffee.LARGE.getSize());
		System.out.println(Coffee.MEDIUM.size);//可以访问内部类中的private变量
		int i = 9;
		//for(int i=0;i<10;i++);
	}

}
enum Suits{
	CLUBS(20),SPADES(30),
	NOTRUMP(40){
		public int getValue(int bid){
			return (bid - 1)* 2;
		}
	};
	
	private int points;
	Suits(int points){
		this.points = points;
	}
	public int getValue(int bid){
		return points * bid;
	}
}
