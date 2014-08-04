/**
 * <p>文件名称: Java2Xml.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-29</p>
 * <p>完成日期：2010-6-29</p>
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
package com.zte.scjp.xml;

import java.io.FileOutputStream;          
import java.io.IOException;          
import org.jdom.Document;          
import org.jdom.Element;          
import org.jdom.JDOMException;          
import org.jdom.output.XMLOutputter;          
           
public class Java2Xml {          
           
    public void BuildXMLDoc() throws IOException, JDOMException {          
           
       // 创建根节点 list;          
        Element root = new Element("list");          
                 
       // 根节点添加到文档中；          
        Document doc = new Document(root);          
           
       // 此处 for 循环可替换成 遍历 数据库表的结果集操作;          
       for (int i = 0; i < 5; i++) {          
                     
           // 创建节点 user;          
           Element elements = new Element("user");          
                     
           // 给 user 节点添加属性 id;          
           elements.setAttribute("id", "" + i);          
                     
           // 给 user 节点添加子节点并赋值；          
           // new Element("name")中的 "name" 替换成表中相应字段，setText("xuehui")中 "xuehui 替换成表中记录值；          
           elements.addContent(new Element("name").setText("xuehui"));         
           elements.addContent(new Element("age").setText("28"));         
           elements.addContent(new Element("sex").setText("Male"));         
          
           // 给父节点list添加user子节点;         
           root.addContent(elements);         
          
       }         
        XMLOutputter XMLOut = new XMLOutputter();         
                
       // 输出 user.xml 文件；         
        XMLOut.output(doc, new FileOutputStream("user.xml"));         
    }         
          
    public static void main(String[] args) {         
       try {         
           Java2Xml j2x = new Java2Xml();         
           System.out.println("生成 mxl 文件...");         
           j2x.BuildXMLDoc();         
       } catch (Exception e) {         
           e.printStackTrace();         
       }         
    }         
          
}      
