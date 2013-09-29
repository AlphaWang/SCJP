/**
 * <p>文件名称: Client.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-9-7</p>
 * <p>完成日期：2011-9-7</p>
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
package pattern.no04.templatemethod;

public class Client {
	public static void main(String[] args){
		/**
		 * 模板方法模式 - Template Method Pattern
		 * 
		 * Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
		 * Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
		 */
		
		/**
		 * 优点：
		 * 1. 封住不变部分（模板方法），扩展可变部分（基本方法）
		 * 2. 提取公共部分代码（模板方法），便于维护
		 * 3. 行为由父类控制，子类实现
		 * ————子类可通过钩子方法 影响模板方法的执行结果，见AbstractModel.isAlarm()
		 * 
		 * 缺点：
		 * 1. 子类的执行结果影响了父类的结果，可读性降低
		 */
		
		/**
		 * 使用场景：
		 * 1. 多个子类有公有的方法，并且方法逻辑基本相同时
		 * 2. 有重要的、复杂的算法时，可把核心算法设计为模板方法
		 */
		Hummer1Model h1 = new Hummer1Model();
		h1.run();
		
		String s = "1,2,3,4,5";
		System.out.println(s.length() +":" +s.charAt(s.length()-1));
		
		String nri =   "03ff000000000000";
		String str = nri.substring(0, 4);
		Integer shownum = Integer.parseInt(str,16);
		System.out.println(shownum);
		
		System.out.println(Integer.toHexString(1023));
		
		//将nri转换成数据库值
		nri="";
    	//将nri转换成数据库值
    	String oneNriStr = Integer.toHexString(Integer.parseInt("1023"));
    	for(int len = oneNriStr.length(); len < 4; len ++){
    		oneNriStr = "0" + oneNriStr;
    	}
    	int nrinum = 0;
    	for(int i = 0; i < nrinum; i++ ){
    		nri = nri + oneNriStr;
    	}
    	for(int j = nrinum; j < 4; j++){
    		nri = nri + "0000";
    	}
    	System.out.println(nri);
		
    	System.out.println(Math.pow(2, 23));
    	
    	String value = "0";
		long longValue = Long.parseLong("254");
		String binValue = Long.toBinaryString(longValue);
		char c = binValue.charAt(binValue.length()-1);
		value = String.valueOf(c);
		System.out.println(value);
		
		long l = 8888888889999999L;
		float l2 = 54e23F;
		
		byte a = 2;
		byte b = 3;
		byte c1 = (byte) (a * b);
		
		int i = 0, j=9 , k = j + 1;
	}
}
