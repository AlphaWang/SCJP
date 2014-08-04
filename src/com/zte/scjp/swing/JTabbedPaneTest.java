/**
 * <p>�ļ�����: TestJTabbedPane.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-28</p>
 * <p>������ڣ�2010-6-28</p>
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
		 
	     tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);//ֻ��ʾһ�б�ǩ��
	     tabbedPane.addMouseListener(new CloseTabListener());//˫���ر�
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
 * ѡ�JTabbedPane�еĹرհ�ť��
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
        	//�ڽ������Ƴ�ѡ���
        	JTabbedPaneTest.tabbedPane.removeTabAt(tabNumber);
         } 
        if   (JTabbedPaneTest.tabbedPane.indexAtLocation(e.getX(),   e.getY())   ==   -1)
        { 
            //������λ�� �ޱ�ǩʱ���������� 
        }else if(e.getClickCount()==2)
        { 
            //˫���رյĴ��� //tabbedPane.removeTabAt(tabbedPane.indexAtLocation(e.getX(),   e.getY())); 
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

