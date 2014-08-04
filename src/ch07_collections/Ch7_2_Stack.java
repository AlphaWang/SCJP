/**
 * <p>文件名称: Ch7_2_Stack.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-30</p>
 * <p>完成日期：2011-12-30</p>
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

import java.util.LinkedList;
import java.util.Stack;

public class Ch7_2_Stack {
	public static void main(String[] args){
		Stack<String> statck = new Stack<String>();
		
		MyStack<String> myStack = new MyStack<String>();
		
		
	}

}

/**
 * 
 * LinkedList可以作为栈来用！！————Stack过时了
 * 
 */
class MyStack<T>{
	private LinkedList<T> linkedList = new LinkedList<T>();
	//入栈
	public void push(T value){
		linkedList.addFirst(value);
	}
	//出栈而不删除
	public T peek(){
		return linkedList.getFirst();
	}
	//出栈并删除
	public T pop(){
		return linkedList.removeFirst();
	}
	
	
}
