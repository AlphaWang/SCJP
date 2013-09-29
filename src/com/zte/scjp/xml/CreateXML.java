/**
 * <p>�ļ�����: CreateXML.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-29</p>
 * <p>������ڣ�2010-6-29</p>
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
package com.zte.scjp.xml;

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import org.jdom.output.Format;

public class CreateXML

{

      

       //����XML�����е�Ԫ��

       Element customer,name,age,sex,address,street,city,district;

      

       public CreateXML()

       {
             //����customerԪ�أ�������ΪXML�ĵ��ĸ��ڵ�
             customer = new Element("customer");
             Document myDocument = new Document(customer);
             //����XML�ĵ��е�����Ԫ�أ�����ʼ��Ԫ����
             name = new Element("name");
             age = new Element("age");
             sex = new Element("sex");
             address = new Element("address");
             street = new Element("street");
             city = new Element("city");
             district = new Element("district");

             //��XML�ĵ��е�ÿһ��Ԫ���������ֵ
             name.addContent("Wang Xiao Yue");
             age.addContent("24");
             sex.addContent("male");
             street.addContent("No.1 East Rood,ShangDi");
             district.addContent("Hai Dian");
             city.addContent("Bei Jing");
             //��street��district��cityԪ����Ϊ��Ԫ�أ���ӵ�addressԪ����
             address.addContent(street);
             address.addContent(district);
             address.addContent(city);
             //��addressԪ����Ϊ��Ԫ�أ���ӵ�customer��Ԫ����
             customer.addContent(name);
             customer.addContent(age);
             customer.addContent(sex);
             customer.addContent(address);
             try
             {
                   //����XML�ļ������
                   XMLOutputter fmt = new XMLOutputter();
                   //�����ļ������
                   FileWriter writer = new FileWriter("c:\\customer.xml");
                   //������������XML�ĵ��ĸ�ʽ
                   Format f = Format.getPrettyFormat();
                   fmt.setFormat(f);
                   //�����ɵ�XML�ĵ�д�뵽"c:\customer.xml"�ļ���
                   //fmt.output(myDocument, writer);
                   fmt.output(myDocument, System.out);
                   writer.close();
             }
             catch (Exception e) {e.printStackTrace();}
       }
       public static void main(String[] args)
       {
             CreateXML createXML = new CreateXML();
       }

}


