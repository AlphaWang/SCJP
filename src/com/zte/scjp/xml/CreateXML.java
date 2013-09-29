/**
 * <p>文件名称: CreateXML.java </p>
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

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import org.jdom.output.Format;

public class CreateXML

{

      

       //声明XML中所有的元素

       Element customer,name,age,sex,address,street,city,district;

      

       public CreateXML()

       {
             //创建customer元素，并设置为XML文档的根节点
             customer = new Element("customer");
             Document myDocument = new Document(customer);
             //创建XML文档中的其他元素，并初始化元素名
             name = new Element("name");
             age = new Element("age");
             sex = new Element("sex");
             address = new Element("address");
             street = new Element("street");
             city = new Element("city");
             district = new Element("district");

             //给XML文档中的每一个元素添加内容值
             name.addContent("Wang Xiao Yue");
             age.addContent("24");
             sex.addContent("male");
             street.addContent("No.1 East Rood,ShangDi");
             district.addContent("Hai Dian");
             city.addContent("Bei Jing");
             //将street、district和city元素作为子元素，添加到address元素中
             address.addContent(street);
             address.addContent(district);
             address.addContent(city);
             //将address元素作为子元素，添加到customer根元素中
             customer.addContent(name);
             customer.addContent(age);
             customer.addContent(sex);
             customer.addContent(address);
             try
             {
                   //创建XML文件输出流
                   XMLOutputter fmt = new XMLOutputter();
                   //创建文件输出流
                   FileWriter writer = new FileWriter("c:\\customer.xml");
                   //设置所创建的XML文档的格式
                   Format f = Format.getPrettyFormat();
                   fmt.setFormat(f);
                   //将生成的XML文档写入到"c:\customer.xml"文件中
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


