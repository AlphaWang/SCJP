/**
 * <p>�ļ�����: Ch7_2_Stack.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-30</p>
 * <p>������ڣ�2011-12-30</p>
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
 * LinkedList������Ϊջ���ã�����������Stack��ʱ��
 * 
 */
class MyStack<T>{
	private LinkedList<T> linkedList = new LinkedList<T>();
	//��ջ
	public void push(T value){
		linkedList.addFirst(value);
	}
	//��ջ����ɾ��
	public T peek(){
		return linkedList.getFirst();
	}
	//��ջ��ɾ��
	public T pop(){
		return linkedList.removeFirst();
	}
	
	
}
