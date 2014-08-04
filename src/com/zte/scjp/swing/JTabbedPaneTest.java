/**
 * <p>文件名称: TestJTabbedPane.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-28</p>
 * <p>完成日期：2010-6-28</p>
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
package com.zte.scjp.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class JTabbedPaneTest extends JFrame{

	public static JTabbedPane tabbedPane;
	public JPanel bodyPanel;
	public JTabbedPaneTest() 
	{
		 tabbedPane = new JTabbedPane();
		 bodyPanel = new JPanel(new BorderLayout());
		 tabbedPane.addTab("title", 
				 new CloseTabIcon(null), 
				 new JLabel("Test"));
		 
	     tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);//只显示一行标签栏
	     tabbedPane.addMouseListener(new CloseTabListener());//双击关闭
	     bodyPanel.add(tabbedPane, BorderLayout.CENTER);
	     
	     Container container = getContentPane();
	     
	     container.add(tabbedPane,BorderLayout.CENTER);
	     

	}
	public static void main(String[] args)
	{
		JTabbedPaneTest test = new JTabbedPaneTest();
		test.setSize(400,500);
		test.setVisible(true);
		
	}
	
	

}

/**  
 * 选项卡JTabbedPane中的关闭按钮。
 * The class which generates the 'X' icon for the tabs. The constructor  
 * accepts an icon which is extra to the 'X' icon, so you can have tabs  
 * like in JBuilder. This value is null if no extra icon is required.  
 */  
 class CloseTabIcon implements Icon {   
     private int x_pos;   
     private int y_pos;   
     private int width;   
     private int height;   
     private Icon fileIcon;   
     public CloseTabIcon(Icon fileIcon) {   
         this.fileIcon = fileIcon;   
         width = 16;   
         height = 16;   
     }   
     public void paintIcon(Component c, Graphics g, int x, int y) {   
         this.x_pos = x;   
         this.y_pos = y;   
         Color col = g.getColor();   
         g.setColor(Color.black);   
         int y_p = y + 2;   
         g.drawLine(x + 1, y_p, x + 12, y_p);   
         g.drawLine(x + 1, y_p + 13, x + 12, y_p + 13);   
         g.drawLine(x, y_p + 1, x, y_p + 12);   
         g.drawLine(x + 13, y_p + 1, x + 13, y_p + 12);   
         g.drawLine(x + 3, y_p + 3, x + 10, y_p + 10);   
         g.drawLine(x + 3, y_p + 4, x + 9, y_p + 10);   
         g.drawLine(x + 4, y_p + 3, x + 10, y_p + 9);   
         g.drawLine(x + 10, y_p + 3, x + 3, y_p + 10);   
         g.drawLine(x + 10, y_p + 4, x + 4, y_p + 10);   
         g.drawLine(x + 9, y_p + 3, x + 3, y_p + 9);   
         g.setColor(col);   
         if (fileIcon != null) {   
             fileIcon.paintIcon(c, g, x + width, y_p);   
         }   
     }   
     public int getIconWidth() {   
         return width + (fileIcon != null ? fileIcon.getIconWidth() : 0);   
     }   
     public int getIconHeight() {   
         return height;   
     }   
     public Rectangle getBounds() {   
         return new Rectangle(x_pos, y_pos, width, height);   
     }   
 } 


class CloseTabListener implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		int tabNumber = JTabbedPaneTest.tabbedPane.getUI().tabForCoordinate(JTabbedPaneTest.tabbedPane, e.getX(), e.getY());   
        if (tabNumber < 0) {   
            return;   
        }   
        Rectangle rect = ((CloseTabIcon) JTabbedPaneTest.tabbedPane.getIconAt(tabNumber)).getBounds();   
        if (rect.contains(e.getX(), e.getY())) {   
        	//在界面上移除选项卡。
        	JTabbedPaneTest.tabbedPane.removeTabAt(tabNumber);
         } 
        if   (JTabbedPaneTest.tabbedPane.indexAtLocation(e.getX(),   e.getY())   ==   -1)
        { 
            //当单击位置 无标签时：不做处理 
        }else if(e.getClickCount()==2)
        { 
            //双击关闭的代码 //tabbedPane.removeTabAt(tabbedPane.indexAtLocation(e.getX(),   e.getY())); 
        } 


	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

