/**
 * <p>文件名称: Ch11_2_ExceptionChain.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2012-1-17</p>
 * <p>完成日期：2012-1-17</p>
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
package ch11_exception;

/**
 * Throwable子类 在构造器中都可接受一个 cause 对象作为参数， * 
 * 用于把原始异常传递给新的异常 
 *
 */
public class Ch11_2_ExceptionChain {
	private String name;
	public void setName(String n) throws MyException{
		if(name != null){
			name = n;
		}else{
			System.out.println("参数为空！");
			
			MyException me = new MyException();
			me.initCause(new NullPointerException());
			throw me;
			//或者：
			//throw new MyException(new NullPointerException());
		}
	}
	
	
	public static void main(String[] args){
		Ch11_2_ExceptionChain instance = new Ch11_2_ExceptionChain();
		try {
			
			instance.setName(null);
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
		/*
		参数为空！
		ch11_exception.MyException
			at ch11_exception.Ch11_2_ExceptionChain.setName(Ch11_2_ExceptionChain.java:36)
			at ch11_exception.Ch11_2_ExceptionChain.main(Ch11_2_ExceptionChain.java:49)
		Caused by: java.lang.NullPointerException
			at ch11_exception.Ch11_2_ExceptionChain.setName(Ch11_2_ExceptionChain.java:37)
			... 1 more
		*/	
		
	}
}



class MyException extends Exception{
	public MyException(Throwable cause) {
        super(cause);
    }
	public MyException(){
		super();
	}
	
}