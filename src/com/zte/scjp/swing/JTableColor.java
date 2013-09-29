/**
 * <p>文件名称: JTableColor.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-7-23</p>
 * <p>完成日期：2010-7-23</p>
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

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;    
import javax.swing.table.DefaultTableCellRenderer;    
import javax.swing.table.DefaultTableModel;    
import javax.swing.table.TableCellRenderer;    
import java.awt.Color;    
import java.awt.Component;    
import java.awt.Point;    
import java.awt.event.MouseAdapter;    
import java.awt.event.MouseEvent;    
import java.awt.event.MouseMotionAdapter;    
   
import javax.swing.table.JTableHeader;    
import javax.swing.table.TableColumn;    
import javax.swing.table.TableColumnModel;    
   
public class JTableColor extends JTable {    
	public static void main(String[] args)
	{
		Vector row = new Vector();
		Vector row1 = new Vector();
		Vector row2 = new Vector();
		row1.add("1");
		row1.add("2");
		row1.add("3");
		row2.add("1");
		row2.add("2");
		row2.add("3");
		row.add(row1);
		row.add(row2);
		Vector col = new Vector();
		
		
		col.add("A");
		col.add("B");
		col.add("C");
		JTableColor table = new JTableColor(row,col);
		JScrollPane sp = new JScrollPane(table);
		JDialog dialog = new JDialog();
		dialog.add(sp);
		dialog.setSize(400,400);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
 /*   
  * 自定义类MyJTable,调用时只需new MyTable并将行和列传入构造方法中即可   
  */   
 private static final long serialVersionUID = 1L;    
   
 static int current = -1;    
   
 public JTableColor(final Vector rowData, Vector columnNames) {    
  super(new DefaultTableModel(rowData, columnNames));    
  // setAutoCreateRowSorter(true);// 调出三角块表格排序    
  // setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 添加表格下滚动条    
  /*调用表格的渲染*/   
  for (int i = 1; i < this.getColumnCount(); i++) {    
   this.setDefaultRenderer(this.getColumnClass(i), new RoutineColor());    
   
  }    
   
  //给表格添加鼠标退出表格的监听，鼠标退出表格，使其颜色还原    
  this.addMouseListener(new MouseAdapter() {    
   @Override   
   public void mouseExited(MouseEvent e) {    
    for (int i = 0; i < rowData.size(); i++) {    
   
     if (i == current) {    
      setBackground(Color.yellow);    
      break;    
     }    
   
    }    
    setBackground(Color.black);    
    current = -1;    
   }    
   
  });    
   
  //给表格添加鼠标移动的监听，鼠标移动刷新表格颜色    
  this.addMouseMotionListener(new MouseMotionAdapter() {    
   public void mouseMoved(MouseEvent e) {    
    Point p = e.getPoint();    
    current = rowAtPoint(p);    
   
    for (int i = 0; i < rowData.size(); i++) {    
   
     if (i == current) {    
      setBackground(Color.yellow);    
      break;    
     }    
   
    }    
    setBackground(Color.black);    
   }    
  });    
   
  //使表格表头的字体居中，若想居左居右，只要改变其属性    
  DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) this   
    .getTableHeader().getDefaultRenderer();    
  renderer.setHorizontalAlignment(renderer.CENTER);    
   
 }    
   
 //定义表格不可编辑的方法    
 public boolean isCellEditable(int row, int column) {    
  return false;    
 }    
   
 @Override   
 public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {    
  DefaultTableCellRenderer tableRenderer = (DefaultTableCellRenderer) super   
    .getDefaultRenderer(columnClass);    
   
  // 设置单元格内容居中显示    
  tableRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);    
  return tableRenderer;    
 }    
   
}    
   
/*   
 * 表格的渲染器   
 */   
class RoutineColor extends DefaultTableCellRenderer {    
   
 public Component getTableCellRendererComponent(JTable table, Object value,    
   boolean isSelected, boolean hasFocus, int row, int column) {    
  if (row % 2 == 0) {    
   // 设置偶数行的背景颜色    
   setBackground(new Color(236, 246, 248));    
  } else {    
   // 基数行的背景颜色    
   setBackground(new Color(255, 255, 255));    
  }    
   
  if (row == JTableColor.current) {    
   //鼠标悬浮行的颜色    
   setBackground(new Color(154,221,151));    
  }    
   
  /*继承Label类的方法, 设置table的单元格对齐方式*/   
  setHorizontalAlignment((int) Component.CENTER_ALIGNMENT); // 水平居中    
  setHorizontalTextPosition((int) Component.CENTER_ALIGNMENT); // 垂直居中    
   
  // table.getTableHeader().setBackground(new Color(206, 231, 255));//设置表头的字体色    
  table.setSelectionBackground(new Color(213, 235, 243));//设置选中行的背景色    
  table.setSelectionForeground(new Color(247, 81, 53));//设置选中行的前景色    
  return super.getTableCellRendererComponent(table, value, isSelected,    
    hasFocus, row, column);    
 }    
   
 // 表格列根据内容调整大小    
 public static void adjustTableColumnWidths(JTable table) {    
  JTableHeader header = table.getTableHeader(); // 表头    
  int rowCount = table.getRowCount(); // 表格的行数    
  TableColumnModel cm = table.getColumnModel(); // 表格的列模型    
   
  for (int i = 0; i < cm.getColumnCount(); i++) { // 循环处理每一列    
   TableColumn column = cm.getColumn(i); // 第i个列对象    
   int width = (int) header.getDefaultRenderer()    
     .getTableCellRendererComponent(table,    
       column.getIdentifier(), false, false, -1, i)    
     .getPreferredSize().getWidth(); // 用表头的绘制器计算第i列表头的宽度    
   for (int row = 0; row < rowCount; row++) { // 循环处理第i列的每一行，用单元格绘制器计算第i列第row行的单元格度    
    int preferedWidth = (int) table.getCellRenderer(row, i)    
      .getTableCellRendererComponent(table,    
        table.getValueAt(row, i), false, false, row, i)    
      .getPreferredSize().getWidth();    
    width = Math.max(width, preferedWidth); // 取最大的宽度    
   }    
   column.setPreferredWidth(width + table.getIntercellSpacing().width); // 设置第i列的首选宽度    
  }    
   
  table.doLayout(); // 按照刚才设置的宽度重新布局各个列    
 }    
}   