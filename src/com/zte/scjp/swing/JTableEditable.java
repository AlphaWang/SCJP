/**
 * <p>�ļ�����: JTableEditable.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-7-19</p>
 * <p>������ڣ�2010-7-19</p>
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

import java.util.Vector;

import javax.swing.*; 
import javax.swing.table.*; 

public class JTableEditable extends JFrame 
{ 
	private Object[][] data = { {"����", "zs@csdn.net"}, 
			{"����", "ls@csdn.net"} }; 
	private String[] columnNames = { "����", "����" };
	private TableModel tableModel = new DefaultTableModel(data, columnNames)
	{ 
		public boolean isCellEditable(int row, int column) 
		{ //�������е�Ԫ�񲻿ɱ༭
			return false; 
			//���Ҫ���Ƶ�һ�в��ɱ༭�����������д //return column != 0; 
		} 
	}; 
	private JTable tblEmp = new JTable(tableModel); 

	private JPanel contentPane; 
	public JTableEditable() 
	{ 
		super("���ɱ༭�ı��"); 
		setSize(400,300); // 
		contentPane = (JPanel) getContentPane(); 
		JScrollPane pnlMain =new JScrollPane(tblEmp); 
		contentPane.add(pnlMain); 
	} 
	public static void main(String[] args) 
	{ 
		JTableEditable f = new JTableEditable(); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setLocationRelativeTo(null); 
		f.setVisible(true); 
	} 
} 


