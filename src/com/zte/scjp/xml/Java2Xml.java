/**
 * <p>�ļ�����: Java2Xml.java </p>
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

import java.io.FileOutputStream;          
import java.io.IOException;          
import org.jdom.Document;          
import org.jdom.Element;          
import org.jdom.JDOMException;          
import org.jdom.output.XMLOutputter;          
           
public class Java2Xml {          
           
    public void BuildXMLDoc() throws IOException, JDOMException {          
           
       // �������ڵ� list;          
        Element root = new Element("list");          
                 
       // ���ڵ���ӵ��ĵ��У�          
        Document doc = new Document(root);          
           
       // �˴� for ѭ�����滻�� ���� ���ݿ��Ľ��������;          
       for (int i = 0; i < 5; i++) {          
                     
           // �����ڵ� user;          
           Element elements = new Element("user");          
                     
           // �� user �ڵ�������� id;          
           elements.setAttribute("id", "" + i);          
                     
           // �� user �ڵ�����ӽڵ㲢��ֵ��          
           // new Element("name")�е� "name" �滻�ɱ�����Ӧ�ֶΣ�setText("xuehui")�� "xuehui �滻�ɱ��м�¼ֵ��          
           elements.addContent(new Element("name").setText("xuehui"));         
           elements.addContent(new Element("age").setText("28"));         
           elements.addContent(new Element("sex").setText("Male"));         
          
           // �����ڵ�list���user�ӽڵ�;         
           root.addContent(elements);         
          
       }         
        XMLOutputter XMLOut = new XMLOutputter();         
                
       // ��� user.xml �ļ���         
        XMLOut.output(doc, new FileOutputStream("user.xml"));         
    }         
          
    public static void main(String[] args) {         
       try {         
           Java2Xml j2x = new Java2Xml();         
           System.out.println("���� mxl �ļ�...");         
           j2x.BuildXMLDoc();         
       } catch (Exception e) {         
           e.printStackTrace();         
       }         
    }         
          
}      
