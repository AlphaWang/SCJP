/**
 * <p>文件名称: TestJTable.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-7-16</p>
 * <p>完成日期：2010-7-16</p>
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

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

class EvenOddRenderer implements TableCellRenderer {

	  public static final DefaultTableCellRenderer DEFAULT_RENDERER =
	    new DefaultTableCellRenderer();

	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    Component renderer =
	      DEFAULT_RENDERER.getTableCellRendererComponent(table, value,
	      isSelected, hasFocus, row, column);
	    Color foreground, background;
	    if (isSelected) {
	      foreground = Color.YELLOW;
	      background = Color.GREEN;
	    }  else {
	      if (row % 2 == 0) {
	        foreground = Color.BLUE;
	        background = Color.WHITE;
	      }  else {
	        foreground = Color.WHITE;
	        background = Color.BLUE;
	      }
	    }
	    renderer.setForeground(foreground);
	    renderer.setBackground(background);
	    return renderer;
	  }
	}
	public class JTableView {
	  public static void main(String args[]) {

	    final Object rowData[][] = { 
	        { "1", "one",  "I" },
	        { "2", "two",  "II" },
	        { "3", "three", "III" }};
	    final String columnNames[] = { "#", "English", "Roman" };

	    final JTable table = new JTable(rowData, columnNames);
	    JScrollPane scrollPane = new JScrollPane(table);

	    table.setDefaultRenderer(Object.class,new EvenOddRenderer());    
	    
	    JFrame frame = new JFrame("Resizing Table");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.add(scrollPane, BorderLayout.CENTER);

	    frame.setSize(300, 150);
	    frame.setVisible(true);

	  }
	}

