/**
 * <p>文件名称: Gc.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-5</p>
 * <p>完成日期：2011-12-5</p>
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
package think.in.java.initial;

public class Gc {
	
	public static void main(String[] args) {
		Book novel = new Book(true, "novel");
		novel.checkIn();
		
		new Book(true, "Think");
		
		System.gc();
		
		
	}
	
	//int j0 = g(i);
	int i = f();	
	int f(){
		return 11;
	}
	
	int j1 = g(8);
	int j2 = g(i);
	int g(int n){
		return n * 10;
	}

}
