/**
 * <p>文件名称: JTableEditable.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-7-19</p>
 * <p>完成日期：2010-7-19</p>
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

import java.util.Vector;

import javax.swing.*; 
import javax.swing.table.*; 

public class JTableEditable extends JFrame 
{ 
	private Object[][] data = { {"张三", "zs@csdn.net"}, 
			{"李四", "ls@csdn.net"} }; 
	private String[] columnNames = { "姓名", "邮箱" };
	private TableModel tableModel = new DefaultTableModel(data, columnNames)
	{ 
		public boolean isCellEditable(int row, int column) 
		{ //限制所有单元格不可编辑
			return false; 
			//如果要限制第一列不可编辑，则可以这样写 //return column != 0; 
		} 
	}; 
	private JTable tblEmp = new JTable(tableModel); 

	private JPanel contentPane; 
	public JTableEditable() 
	{ 
		super("不可编辑的表格"); 
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


