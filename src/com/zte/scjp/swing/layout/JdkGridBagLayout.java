/**
 * <p>�ļ�����: TestGridBagLayout.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-21</p>
 * <p>������ڣ�2010-6-21</p>
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
        
        //���������ʾ������������������ʾ����Ĵ�Сʱʹ�ô��ֶ�
        c.fill = GridBagConstraints.BOTH;
        //ָ����ηֲ������ˮƽ�ռ䡣
        //����õ��Ĳ�����ˮƽ�����ϱ���Ҫ��������С����ϵͳ�Ὣ����Ŀռ䰴����Ȩ�ر����ֲ���ÿһ�С�
        //Ȩ��Ϊ����в���õ�����Ŀռ䡣 
        c.weightx = 1.0;
        makebutton("Button1", gridbag, c);
        makebutton("Button2", gridbag, c);
        makebutton("Button3", gridbag, c);

          //ָ���������ʾ�����һ���еĵ�Ԫ������ 
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

