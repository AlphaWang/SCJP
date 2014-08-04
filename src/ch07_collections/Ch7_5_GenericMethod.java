/**
 * <p>�ļ�����: Ch7_4_GenericMethod.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-3-7</p>
 * <p>������ڣ�2011-3-7</p>
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

public class Ch7_5_GenericMethod {

	public static void main(String[] args)
	{
		/**
		 * ���������������Ϊ List<Object>
		 * ��������������� List<JButton>,
		 *          ���ɴ��� ArrayList<Object>
		 * 
		 * 1)Ϊʲô���ܴ��룿
		 * 2)��ν����
		 * 
		 * !!���������鲻һ������
		 * ���������������ΪObject[]
		 * �����������Ϊ  JButton[]
		 */
				
		List<Object> ol = new ArrayList<Object>();
		addObjectList(ol);
		
		//���ܰ� List<JButton>����List<Object>����
		//The method addObject(List<JButton>) is undefined for the type Ch7_5_GenericMethod
		List<JButton> ol2 = new ArrayList<JButton>();
		//// addObjectList(ol2);
		
		
		/**
		 * 1.Ϊʲô���ܴ��룿
		 * ����������������List��������������ͣ�������������෺�ʹ��뷽����
		 *     ������⣺���ܻ��򼯺�����Ӵ���Ķ���
		 * 
		 * ����������ʵ���������飬�������������Ҳ���з��յ�
		 *     ��Ȼ�ܱ���ͨ����
		 *     ������ʱ�쳣ArrayStoreException
		 * 
		 *     �����ڼ�����˵��û�ж�Ӧ������ʱ�쳣
		 *     ��Ϊ�����Ͳ�����
		 *     (����ʱJVM֪����������ͣ����ǲ�֪�����ϵ�����)
		 */
		Object[] os = new Object[3];
		addObjectArray(os);
		
		JButton[] os2 = new JButton[3];
		//***java.lang.ArrayStoreException:
		//// addObjectArray(os2);
		
		
		
		
		/**
		 * 2.��ν����
		 * ������������һ������List<Object>��ע��List<Object>�п���add JButtonԪ�أ�
		 * 
		 */
		List<Object> ol3 = new ArrayList<Object>();
		
		ol3.add(new JButton());
		addObjectList(ol3);
		
		/**
		 * 2.��ν����
		 * �������������������������ŵ ������List"���"�κζ���(ֻ��)������������List<? extends Object>
		 * 
		 */
		List<JButton> ol4 = new ArrayList<JButton>();
		addObjectList2(ol4);
		
		/**
		 * ���� ?
		 * 
		 * add(List<? extends Parent>)	��ͬ����
		 * add(List<? super   Child>)	��Child���κθ���
		 * add(List<?>)					���κ��࣬= <? extends Object>
		 * add(List<Object>)			����Object�࣬�ҿ�����List�����Ԫ��
		 * 
		 * ��������?��ʾ�������ԣ� �����û��? ���ʾ��һ�ֿ��ܡ�
		 */
		//List<Object> list1 = new new ArrayList<JButton>();
		  List<? extends Object> list2 = new ArrayList<JButton>();
		  List<? super JMenu> list3 = new ArrayList<Object>();
		  List<?> list4 = new ArrayList<JButton>();
		// The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (JMenu)
		////  list4.add(new JMenu());
		////  list4.add(new JButton());
		  list4.add(null);
		

	}
	
	////////����������
	static void addObjectArray(Object[] os) {
		System.out.println("addObjectArray(Object[])");
		System.out.println(os);
		
		os[0] = new JMenu();
		
		System.out.println(os+"\n");
	}
	
	/////////�����Ǽ���
	static void addObjectList(List<Object> ol) {
		System.out.println("addObjectList(List<Object>))");
		System.out.println(ol);
		
		ol.add(new JMenu());
		
		System.out.println(ol+"\n");
	}
	/**
	 * 2.��ν����
	 * �������������������������ŵ��������List"���"�κζ���(ֻ��)
	 *             ʹ��ͨ���<?>
	 * 
	 *  <? extends Object>�ĺ��壺
	 *  ���Ը���һ�����ϣ�������ϵ�������List�������ͣ��ҿ��Ա����ͻ�ΪObject����Object������
	 *  ���ң��Ҳ�����κζ������������
	 *  ��������ע��extends��ʾIS-A, ���������һ���ӿ�
	 */
	static void addObjectList2 (List<? extends Object> ol)	{
		System.out.println("addObjectList2 (List<? extends Object> )");
		System.out.println(ol);
		
		/*
		 * ���Υ��Լ��  ���Ԫ�ص����ϣ���������
		 * The method add(capture#2-of ? extends Object)
		 * in the type List<capture#2-of ? extends Object>
		 * is not applicable for the arguments (JMenu)
		 */
		
		//// ol.add(new JMenu());
		
		/*
		 * ���ǿ������null
		 */
		ol.add(null);
		
		System.out.println(ol+"\n");
	}
	
	

}
