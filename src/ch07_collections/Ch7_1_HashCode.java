/**
 * <p>文件名称: Ch7_1_HashCode.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-2-17</p>
 * <p>完成日期：2011-2-17</p>
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
package ch07_collections;

public class Ch7_1_HashCode {
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * 1. equals()
	 * 
	 * 	为什么要重写equals():
	 *   如果不重写，就不能将该对象用作哈希表中的键，因为不同对象equals肯定为F
	 *   重写equals(),是为了两个不同对象 能够被视为相同
	 *   
	 *   equals()契约
	 *   1) 自反性
	 *   2) 对称性
	 *   3) 传递性
	 *   4) 一致性
	 *   5) equals(null)总是F
	 */
	public boolean equals(Object o ){
		if(o instanceof Ch7_1_HashCode &&
		   ((Ch7_1_HashCode)o).getSize() == this.getSize())
		{
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 2.hashCode()
	 * 
	 * 如果两个对象是equals()的，那它们必须具有相同的哈希码值
	 * 
	 * 默认的hashCode()：为每个对象产生一个唯一号
	 * 
	 * hashCode与集合：
	 * a)插入：将对象放入哈希码的集合中时，该集合利用hashCode()来判断该对象属于哪个桶内————为了提高查找速度！
	 * b)查找：从哈希码的集合中查找对象时，通过hashCode()找到正确的桶，然后使用equals()在桶内查找正确的元素
	 * 
	 * 好的hash算法：能得到对象在桶内的广泛随机分布————不equals的对象 产生不同的hashCode
	 * 差的hash算法：每个对象哈希码都相同————所有对象位于一个桶
	 * 
	 * hashCode与序列化：
	 * hashCode()中使用transient变量是合法的，但是不合适！！！
	 * 因为同一个对象反序列化后，hashCode可能会改变
	 * ————如果一个变量是transient的，则不要用它来判断对象的哈希码或相等性
	 */
	@Override
	public int hashCode() 
	{
		return   this.getSize() * 1000 ;

	}

	public static void main(String[] args) 
	{
		
		

	}

	

}
