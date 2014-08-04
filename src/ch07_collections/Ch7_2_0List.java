/**
 * <p>�ļ�����: Ch7_2_Collection.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-2-22</p>
 * <p>������ڣ�2011-2-22</p>
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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static java.lang.System.out;
public class Ch7_2_0List {

	public static void main(String[] args) 
	{
		/**
		 * 1. Collection ��һ���ӿڣ�Set List Queueʵ����������Mapδʵ����
		 *    Collections��һ��������
		 */
		
		/**
		 * 2. ordered: ����ġ�
		 * 		������������ʱ���ܹ���ѭ�ض���˳��
		 * 
		 * 		ArrayList�ᰴ��Ԫ������λ�ý���˳��
		 * 		LinkedHashSet�ᰴ��Ԫ�ز���˳��
		 * 
		 *    sorted: ����ġ�
		 *    	�����е�˳�� �Ǹ���ĳ������ȷ���ģ���Ϊ����˳��(���������˳������Ȼ˳��)��
		 *    	������������˳������Щ�޹أ���ʱ���롢�����λ��
		 *    	��������ֻ��TreeSet��TreeMap��sorted��
		 *    
		 *    	��ordered��һ���������
		 *    	�����ǻ��ڶ���������Խ��еģ�����ͨ��ʵ��Comparable/Comparator�ӿ�����������˳��
		 */
		
		
		/**
		 * 
		 * 3. List�ӿڣ���������
		 * 					ordered	sorted
		 * 		ArrayList: 		��		��	������������. �����������������ٷ�������Щλ�ã��Լ��Ժ���˳����ʵ�
		 * 		Vector��			��		��	ArrayList��ͬ���汾
		 * 		LinkedList��		��		��	Ԫ��֮����˫���ӵġ�ʵ����List+Queue��������ArrayList���������Կ��ٲ���ɾ��
		 * 									���������������п���LinkedList���������Ƚ��ȳ�FIFO
		 * 
		 *  ʹ��Collectionsͬ����List list = Collections.synchronizedList(new LinkedList(...));
		 */
		out.println("======List�ӿ�======");
		List<String> arraylist = new ArrayList<String>();
		String item1 = "C";
		String item2 = "A";
		String item3 = "B";
		String item4 = "B";
		arraylist.add(item1);//Ĭ��index���ǲ����˳��
		arraylist.add(item2);	
		arraylist.add(1,item3);	//���뵽item2֮ǰ��
		arraylist.add(item4);
		//arraylist.add(5,item3); //java.lang.IndexOutOfBoundsException:
		
		for(String s : arraylist)
		{
			//��������ڣ��򷵻�-1
			out.println("Ԫ��"+s+",index = "+arraylist.indexOf(s));
		}
		/**
		 * 
		 * 3.1 �������ȱ����ǿɱȽϵ�
		 * 
		 * List�е�Ԫ�ر���ʵ��Comparable�ӿ��е�compareTo()����sort(List)����ʱ����
		 * ���ߣ�����Collections.sort(List,Comparator)
		 * 
		 * ��������Arrays.sort(int[])
		 * 
		 */
		out.println("==δ����"+arraylist);
		Collections.sort(arraylist);
		out.println("==Collections.sort()�����"+arraylist);
		for(String s : arraylist)
		{
			out.println("Ԫ��"+s+",index = "+arraylist.indexOf(s));
		}
		
		out.println("==���������Զ�����");
		ArrayList<DVDinfo> list2 = new ArrayList<DVDinfo>();
		DVDinfo info1 = new DVDinfo("Life","Andy","1992-1-2");
		DVDinfo info2 = new DVDinfo("Death","Bob","1998-7-5");
		DVDinfo info3 = new DVDinfo("Zero","Selina","2008-7-5");
		list2.add(info1);
		list2.add(info2);
		list2.add(info3);
		out.println("����ǰ��"+list2);
		Collections.sort(list2);
		out.println("�����"+list2);
		/*
		 * ���⣺Collections.sort(list2)��ֻ�����title������Ҫ��һ�����򷽷���ô�죿
		 * ����������дDVDinfo���comapraTo()������
		 * ��������NO! ʹ��Collections.sort(List,Comparator)
		 */
		Collections.sort(list2, new DVDinfoSortBySinger());
		out.println("�����2��"+list2);
		
		/**
		 * 
		 * 3.2 ���ң����ȱ�������
		 * 
		 * Collections.binarySearch(List, elem, Comparator)
		 * ��������Ԫ�ص�int����ֵ(+)������int�����(-)
		 * 
		 * 1.����֮ǰ��������
		 * 2.����ʱ����ʹ�� �������õ�Comparator,���򷵻�������ĸ�ֵ
		 * 
		 * ������Arrays.binarySearch()����������
		 * 
		 */
		out.println("==���Բ���");
		List<String> arraylist2 = new ArrayList<String>();
		String item11 = "C";
		String item12 = "A";
		String item13 = "B";
		String item14 = "D";
		arraylist2.add(item11);
		arraylist2.add(item12);	
		arraylist2.add(item13);	
		arraylist2.add(item14);
		
		Collections.sort(arraylist2);
		int index = Collections.binarySearch(arraylist2, "C");
		out.println("List ��"+arraylist2);
		out.println("����C��" + index);
		out.println("����E��" + Collections.binarySearch(arraylist2, "E"));
		/**
		 * ��ӣ�
		 * add()
		 * addAll()
		 * Collections.addAll(Collection<? super T> c,  T... a) �������������п죬��ѡ������
		 */
		Collections.addAll(arraylist2, "X","Y");
		Collections.addAll(arraylist2, new String[]{"U","V"});
		
		/**
		 * 
		 * 3.3 �����Listת��
		 * 
		 * 1. Arrays.asList(int[])
		 * 		��������������б�����֮һ����һ�����Զ�����  ��������??����add��delete������set
		 * 		�����������Ƶģ�Map.suMap()
		 * 2. List.toArray()
		 * 		: �������޲�����������޲���������Object[]���в���������ָ����������
		 */
		out.println("==�����Listת��");
		String[] sa = {"one", "two","three"};
		
		/**
		 * asList()�������ṩ��һ�������̶����ȵ��б�ı�ݷ��������б���ʼ��Ϊ�������Ԫ��
		 */
		List<String> list = Arrays.asList(sa);
		List<String> list_ = Arrays.asList("one", "two","three");
		
		/**
		 * Arrays.asList()�õ���List������addԪ�ء�deleteԪ��
		 * ��������ʱ����UnsupportedOperationException * underlying array cannot be resized		 * 
		 * ��Ϊ��Arrays.asList()�õ���List ��ײ��ʾ�������飬���ɵ�����С��
		 */
		//Collections.addAll(list, "X","Y");		
		//list.add("");
		//list_.add("");
		
		
		sa[0] = "one1";//list�����Զ����£�����
		out.println("Arrays.asList(sa)��"+list);
		
		Object[] oa= list.toArray(); //1.�޲���������Object[]
		out.print("list.toArray()��");
		for(Object o:oa) 
			out.print(o+" ");
		
		String[] sa2 = new String[5];
		sa2 = list.toArray(sa2);     //2.�в���������ָ����������
		out.print("" +
				"\nlist.toArray(sa2)��");
		for(String s:sa2) 
			out.print(s+" ");
		
		/**
		 * 
		 * 3.4 Iterator����
		 * 
		 * ������ǿ��for��Ҳ����Iterator����List
		 */
		out.println("\n==Iterator����:");
		
		Iterator<String> ite = list.iterator();
		while(ite.hasNext())
		{
			//������Ϊʹ���˷���Iterator��������������ǿ��ת��
			String item = ite.next();
			out.println(item);
		}
		

	}

}
/**
 *  ʵ��Comparable<DVDinfo>�ӿ�
 *
 */
class DVDinfo implements Comparable<DVDinfo>
{
	String title;
	String singer;
	String   date;
	public DVDinfo(String title, String singer, String date){
		this.title = title;
		this.singer = singer;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return title + " "+singer +" "+date;
	}

	@Override
	public int compareTo(DVDinfo o) 
	{
		int i = this.title.compareTo(o.title); //String������compareTo����
		return i;
		/*
		 * ����ֵ
		 * ������this < o
		 * ��     ��this = o
		 * ������this > o
		 */
	}
}
/**
 * 
 * �½�Comparator<DVDinfo>�ӿ�ʵ���� ��������public interface Comparator<T>
 * 
 * !!�ŵ㣺�����޸����������
 *        ���Դ��������������
 */
class DVDinfoSortBySinger implements Comparator<DVDinfo>
{

	@Override
	public int compare(DVDinfo o1, DVDinfo o2) 
	{
		return o1.singer.compareTo(o2.singer);
	}
	
}
