/**
 * <p>�ļ�����: Student.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-18</p>
 * <p>������ڣ�2010-6-18</p>
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
package com.zte.scjp.enumtest;
import static java.lang.System.out;
public class Student {
	private String name;
	private int age;
	private Grade grade;
	
	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public void assignGrade(Grade grade)
	{
		this.grade = grade;
	}
	public Grade getGrade()
	{
		return this.grade;
	}
	public static void main(String[] args)
	{
		
	}
}
