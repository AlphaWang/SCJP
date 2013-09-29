/**
 * <p>文件名称: Ch9_5_Exercise.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-25</p>
 * <p>完成日期：2011-3-25</p>
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
package ch09_thread;

/**
 * 第15题
 * @author WangZhongXing192063
 *
 */
class Dudes{
	
	static long flag = 0;
	/**
	 * 功能：第一次调用，打印yo；否则打印dude
	 * @param id
	 */
	//synchronized void chat(long id){	
	void chat(long id){
		if(flag == 0) flag = id;
		for(int x = 1; x < 3; x++){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (flag == id)
				System.out.println(id + "-yo ");
			else
				System.out.println(id + "-dude");
		}
	}
	
}
public class Ch9_5_Exercise implements Runnable{

	static Dudes d;
	public static void main(String[] args) {
		new Ch9_5_Exercise().go();

	}
	void go(){
		d = new Dudes();
		new Thread(new Ch9_5_Exercise()).start();
		new Thread(new Ch9_5_Exercise()).start();
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		d.chat(Thread.currentThread().getId());
		
	}

}
