/**
 * <p>�ļ�����: Test.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-1-5</p>
 * <p>������ڣ�2011-1-5</p>
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
		//System.out.println(Suits.NOTRUMP.points);//private����
		
		System.out.println(Coffee.MEDIUM.getSize());
		System.out.println(Coffee.LARGE.getSize());
		System.out.println(Coffee.MEDIUM.size);//���Է����ڲ����е�private����
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
