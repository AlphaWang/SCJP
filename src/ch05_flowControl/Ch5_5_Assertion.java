/**
 * <p>文件名称: Ch5_5_Assertion.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-1-20</p>
 * <p>完成日期：2011-1-20</p>
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
package ch05_flowControl;

public class Ch5_5_Assertion 
{
	/**
	 * 0. 断言允许在开发期间测试假设。但当部署程序后，断言代码实际上会被清除，不起任何作用
	 * 
	 *    如果发现已部署的程序出现问题，可以启用断言，以进行额外的测试
	 */
	public static void main(String[] args)
	{
		Ch5_5_Assertion obj = new Ch5_5_Assertion();
		int i = -50;
		obj.methodA(i);
	}
	
	private void method(int num)
	{
		if(num >= 0){
			//如果>=0，进行正常处理
			// do more
			System.out.println("method()处理逻辑"+num);
		}else{
			//如果<0，则不合法。method()方法只能接受非负的参数
			System.out.println("不合法的参数！");
		}
	}
	/**
	 * 1. 上述method()可以优化为assert
	 */
	//注意：public方法 不适合使用下述断言！
	private void methodA(int num)
	{
		
		assert( num >= 0 );//如果判断为true，则代码继续运行，此语句没有任何其他影响
		                   //如果判断为false，则抛出AssertionError。(java ch05_flowControl.Ch5_5_Assertion)
		
		//do more
		System.out.println("methodA()处理逻辑"+num);
		
		
		/**
		 * 稍复杂形式的断言:
		 * 如果判断为false，会把冒号后面的信息打印出来	
		 * 注意：冒号后面 必须能转换为String，注意如果是method，一定不能返回void
		 */
		int x = 7;
		int y = 6;
		assert (x < y): "x=" +x +",y="+y;
		
		
	}
	/**
	 * 2. 编译带有断言的代码	
	 * 如果希望在代码中把assert作为标识符，必须使用-source 1.3编译
	 */
	
	
	/**
	 * 3. 运行时启用断言
	 * 
	 * 默认断言是禁用的！
	 * 
	 * 对某个类启用断言：
	 * java -ea com.Test
	 * java -enableassertions com.Test
	 * 
	 * 对某个类禁用断言：(无用)
	 * java -da com.Test
	 * java -disableassertions com.Test
	 * 
	 * 有选择地启用禁用断言：
	 * java -ea -da:com.Test	——通常启用断言，但在Test类禁用
	 * java -ea -da:com...		——通常启用断言，但在com及其子包中禁用
	 * 
	 */
	
	/**
	 * 4. 适当地使用断言
	 */
	/*
	 * 不要用断言验证 public 方法的変元、命令行変元
	 * 可以用断言验证 private 方法的変元 
	 */

	
	/*
	 * 错！
	 * 断言表达式只作为判断， 一定不能产生其他副作用
	 */
	public void doStuff(){
		
		assert(modifyVar());
		//do more...
	}
	public boolean modifyVar(){
		y = x ++;
		return true;
	}
	static int x;
	static int y;

}
