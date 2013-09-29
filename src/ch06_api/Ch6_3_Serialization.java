/**
 * <p>�ļ�����: Ch6_3_Serialization.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-2-10</p>
 * <p>������ڣ�2011-2-10</p>
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
package ch06_api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import static java.lang.System.out;

public class Ch6_3_Serialization {

	public static void main(String[] args) {

		/**
		 *  1.���л����ڣ������������ ����ȫ��ʵ������(����transient����)
		 *  
		 *  ObjectOutputStream <- FileOutputStream
		 */
		CatHouse house = new CatHouse(123);
		Cat c = new Cat(house, "Cat���캯������name");
		Cat.staticName = "Cat�޸�staticName1";
		c.age = 2;
		c.weight = 32;//weigth�Ǽ̳����ģ������л�
		c.color = "white";
		
		
		out.println("���л���");
		out.println("c.name:"+c.staticName);
		out.println("c.color:"+c.color);
		out.println("c.age:"+c.age);
		out.println("c.length:"+c.length);
		out.println("c.weight:"+c.weight);
		/*
		 * ���л�
		 */
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.ser"));
			oos.writeObject(c);
			oos.close();
			
		} catch (FileNotFoundException e) {	e.printStackTrace();} 
		  catch (IOException e) {e.printStackTrace();}
		
		/*
		 * �����л�
		 * 
		 * �����л�ʱ���������κγ����ʼ�����������й��캯������������ʾ������ֵ
		 */
		Cat c2 = null;
		Cat.staticName = "�޸�staticNname2";
		try {
			
			ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("cat.ser"));
			c2 = (Cat) ois.readObject();
			ois.close();
			
		} catch (FileNotFoundException e) {e.printStackTrace();} 
		  catch (IOException e) {e.printStackTrace();} 
		  catch (ClassNotFoundException e) {e.printStackTrace();}
		  
		out.println("�����л���");
		out.println("c2.name:"+c2.staticName);
		out.println("c2.color:"+c2.color);//null, transient�����������л�������Ĭ��ֵ����������������������ʱ�����ֵ
		out.println("c2.age:"+c2.age);
		out.println("c2.length:"+c2.length);
		out.println("c2.weight:"+c2.weight);//weigth�Ǽ̳����ģ������л��� ����Ĭ��ֵ/����ĸ�ֵ
		/**
		 * ��ΪhouseΪtransient�����Է����л��� c2.house == null���˴��׳�NullPointerException
		 * ��ν���� ==> ʹ��writeObject()��readObject()�������μ� 3
		 */
		System.out.println("c2.house.size:"+c2.house.size );
		

	}

}

/**********************************/
class Animal{
	/*
	 * �����һ�����л��࣬���丸���Ƿ����л���
	 * �����л��󣬴Ӹ���̳е�ʵ���������ᱻ����Ϊ����ԭʼ�����ڼ��������ֵ
	 * 
	 * ��������������Ĺ��캯���ᱻ���á�������Ĺ��캯��Ҳ�ᱻ����
	 */
	int weight = 45;
}
class Cat extends Animal implements Serializable{
	/**
	 * 2. �����л�һ������Java���л����ƻᱣ����������������ͼ��
	 *    ����Cat����CatHouse������Ҳ�����л�CatHouse
	 */
	
	/*
	 * ���ʵ������ Ϊ��������CatHouse����CatHouse��û��implements Serializable	 * 
	 * �������л�ʱ������ʾjava.io.NotSerializableException
	 * 
	 * ���������
	 * 1. �޸�CatHouseΪimplements Serializable
	 * 2. �½�CatHouse���࣬��implements Serializable �������ܷ���CatHouseԴ��ʱ
	 *                                               ����ȱ�㣺������final�ࣻ���ܰ������������л����󣬲��ɱ���
	 * 3. ʹ��transient
	 */
	transient CatHouse house;
	//CatHouse house;
	
	/*
	 * ���л��������ھ�̬������
	 * ��Ϊ��̬�����������κζ���
	 */
	static String staticName = "��ʼ�����staticName";
	Object[] objects;
	transient String color;
	int length;
	int age;
	public Cat(CatHouse house, String name){
		 this.house = house;
		 Cat.staticName = name;
	}
	/**
	 * 3. ���transient�������� �����л�NullPointerException����
	 * 
	 * ����writeObject()��readObject()����������������д
	 * �����л�/�����л�ʱ������Щ����
	 * 
	 * ע����ʱʹ��writeObject()��readObject()��
	 *    ��������Ҫ�ֹ��������״̬��ĳһ����ʱ��
	 */
	 private void writeObject(ObjectOutputStream oos)	 {
		 try {
			oos.defaultWriteObject();
			oos.writeInt(house.size);//��һ�������intд�봴�����л�Cat������
			
		} catch (IOException e) {e.printStackTrace();}
		 
	 }
	 private void readObject(ObjectInputStream ois){
		 try {
			 ois.defaultReadObject();
			 house = new CatHouse(ois.readInt());//��ȡ�����int
			
		} catch (IOException e) {e.printStackTrace();} 
		  catch (ClassNotFoundException e) {e.printStackTrace();}
	 }
}

class CatHouse {
	int size;
	public CatHouse(int size){
		this.size = size;
	}
}
