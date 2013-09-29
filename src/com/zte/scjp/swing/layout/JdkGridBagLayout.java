/**
 * <p>文件名称: TestGridBagLayout.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-21</p>
 * <p>完成日期：2010-6-21</p>
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
package com.zte.scjp.swing.layout;

import java.awt.*;
import java.util.*;
import java.applet.Applet;

import javax.swing.JFrame;

public class JdkGridBagLayout extends JFrame {
	  private static int WIDTH = 700;
	  private static int HEIGHT = 400;

    protected void makebutton(String name,
                              GridBagLayout gridbag,
                              GridBagConstraints c) {
        Button button = new Button(name);
        gridbag.setConstraints(button, c);
        add(button);
    }

    public void init() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(gridbag);
        
        //当组件的显示区域大于它所请求的显示区域的大小时使用此字段
        c.fill = GridBagConstraints.BOTH;
        //指定如何分布额外的水平空间。
        //如果得到的布局在水平方向上比需要填充的区域小，则系统会将额外的空间按照其权重比例分布到每一列。
        //权重为零的列不会得到额外的空间。 
        c.weightx = 1.0;
        makebutton("Button1", gridbag, c);
        makebutton("Button2", gridbag, c);
        makebutton("Button3", gridbag, c);

          //指定在组件显示区域的一行中的单元格数。 
          c.gridwidth = GridBagConstraints.REMAINDER; //end row
        makebutton("Button4", gridbag, c);

          c.weightx = 0.0;                  //reset to the default
          c.gridheight = 2;
          c.weighty = 0.1; 
        makebutton("Button5", gridbag, c); //another row

          c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
          c.gridheight = 1;
          c.weighty = 0.0; 
        makebutton("Button6", gridbag, c);

          c.gridwidth = GridBagConstraints.REMAINDER; //end row
        makebutton("Button7", gridbag, c);

          c.gridwidth = 1;                //reset to the default
          c.gridheight = 3;
          c.weighty = 0.0;
          //c.anchor = GridBagConstraints.NORTH ;
        makebutton("Button8", gridbag, c);

          c.weighty = 0.0;                  //reset to the default
          c.gridwidth = GridBagConstraints.REMAINDER; //end row
          c.gridheight = 1;               //reset to the default
        makebutton("Button9", gridbag, c);
           c.weighty = 1.0; 
           c.gridheight = 2;
        makebutton("Button10", gridbag, c);

        
    }

    public static void main(String args[]) {
          //Frame f = new Frame("GridBag Layout Example");
          JdkGridBagLayout ex1 = new JdkGridBagLayout();

          ex1.init();

          //f.add("Center", ex1);
          ex1.pack();
         
         // f.show();
          ex1.setVisible(true);
         ex1.setSize(WIDTH, HEIGHT);
          //ex1.setSize(ex1.getPreferredSize());
          ex1.setDefaultCloseOperation(EXIT_ON_CLOSE);
          Toolkit toolkit = Toolkit.getDefaultToolkit();
          ex1.setLocation((toolkit.getScreenSize().width - WIDTH) / 2 , 
                  (toolkit.getScreenSize().height - HEIGHT) / 2);
    }
}

