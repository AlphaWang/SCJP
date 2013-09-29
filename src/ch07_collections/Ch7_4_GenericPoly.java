/**
 * <p>�ļ�����: Ch7_4_GenericPoly.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-4</p>
 * <p>������ڣ�2011-3-4</p>
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

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenu;

public class Ch7_4_GenericPoly {

	public static void main(String[] args) 
	{
		/**
		 * Generic �� Polymorphism
		 * 
		 * ��ֻ̬�����ڻ������ͣ��������ڷ������ͣ���
		 * 
		 */
		//�������Type mismatch: cannot convert from ArrayList<JButton> to List<Object>
		//// List<Object> list2 = new ArrayList<JButton>(); //��̬�������ڷ�������
		     List<Object> list1 = new ArrayList<Object>();  //��̬�����ڻ�������
		  
		  JButton b = new JButton();
		  list1.add(b);
		  System.out.println(list1);
		  /*
		   * ���� ʹ�ü���������һ���������Ͱ�ȫ�����Ƿ����ж�̬�Ĺ�����ʽ�������в�ͬ
		   */
		  Object[] o1 = new JButton[3];		
		  Object   o2 = new JButton();
		  //����ʱ��java.lang.ArrayStoreException:
		  changeElem(o1);    
		  
		  
		  
		  
		//List<Object> list1 = new new ArrayList<JButton>();
		  List<? extends Object> list2 = new ArrayList<JButton>();
		  List<? super JMenu> list3 = new ArrayList<Object>();
		  
		  List<?> list4 = new ArrayList<JButton>();
		  /**
		   * List<? extends Object>
		   * List<?>
		   * ��ȫ��ͬ
		   */
		  
		  

	}
	private static void  changeElem(Object[] o){
		o[0] = new JMenu();
	}

}
