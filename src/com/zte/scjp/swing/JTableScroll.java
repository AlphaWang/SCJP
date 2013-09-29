/**
 * <p>�ļ�����: TableScroll.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-7-16</p>
 * <p>������ڣ�2010-7-16</p>
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
import java.awt.Container; 
import java.awt.Rectangle;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel; 
public class JTableScroll extends JFrame 
{ 
	private JTable table = new JTable(10, 10); 
	private JButton button = new JButton("AddRow"); 
	private Rectangle rect = new Rectangle(); 
	public JTableScroll() 
	{ 
		Container contentPane = this.getContentPane(); 
		contentPane.setLayout(new BorderLayout()); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER); 
		contentPane.add(button, BorderLayout.SOUTH); 
		button.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) 
			{ 
				((DefaultTableModel) table.getModel()).insertRow( table.getRowCount() - 1, new Object[]{"", "", "", "", "", }); 
				rect = new Rectangle(0, table.getHeight(), 20, 20); 
				table.scrollRectToVisible(rect); 
				table.setRowSelectionInterval(table.getRowCount() - 1, table.getRowCount() - 1); 
				table.grabFocus(); 
				table.changeSelection(table.getRowCount() - 1, 0, false, true); 
			} 
		});
    } 
	public static void main(String[] args) 
	{ 
		JTableScroll st = new JTableScroll(); 
		st.setVisible(true); 
		st.setSize(300, 300);
		st.setDefaultCloseOperation(EXIT_ON_CLOSE); 
	} 
} 
