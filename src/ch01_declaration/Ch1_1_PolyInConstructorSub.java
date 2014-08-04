/**
 * <p>文件名称: Ch1_1_构造器内多态方法_子类.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-12</p>
 * <p>完成日期：2011-12-12</p>
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
package ch01_declaration;

public class Ch1_1_PolyInConstructorSub extends Ch1_1_PolyInConstructor{
	private int radius = 1;
	
	@Override
	void draw(){
		System.out.println("子类draw()，radius="+radius);
	}
	
	Ch1_1_PolyInConstructorSub(int r) {
		//super();
		radius = r;
		System.out.println("子类构造器，draw()之前");
		
		draw();
		
		System.out.println("子类构造器，draw()之后");
	}
	
	
	public static void main(String[] args){
		
		new Ch1_1_PolyInConstructorSub(5);
		/*
		 * output:
		 * 
		 * 父类构造器，draw()之前
		 * 子类draw()，radius=0                 //！易造成bug  ////为什么是0，不是1：父类构造器draw()时，子类域未初始化
		 * 父类构造器，draw()之后)
		 * 
		 * 子类构造器，draw()之前
		 * 子类draw()，radius=5
		 * 子类构造器，draw()之后
		 */
	}
	

}
