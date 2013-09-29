/**
 * <p>�ļ�����: JTableColor.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-7-23</p>
 * <p>������ڣ�2010-7-23</p>
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
  * �Զ�����MyJTable,����ʱֻ��new MyTable�����к��д��빹�췽���м���   
  */   
 private static final long serialVersionUID = 1L;    
   
 static int current = -1;    
   
 public JTableColor(final Vector rowData, Vector columnNames) {    
  super(new DefaultTableModel(rowData, columnNames));    
  // setAutoCreateRowSorter(true);// �������ǿ�������    
  // setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ��ӱ���¹�����    
  /*���ñ�����Ⱦ*/   
  for (int i = 1; i < this.getColumnCount(); i++) {    
   this.setDefaultRenderer(this.getColumnClass(i), new RoutineColor());    
   
  }    
   
  //������������˳����ļ���������˳����ʹ����ɫ��ԭ    
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
   
  //������������ƶ��ļ���������ƶ�ˢ�±����ɫ    
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
   
  //ʹ����ͷ��������У����������ң�ֻҪ�ı�������    
  DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) this   
    .getTableHeader().getDefaultRenderer();    
  renderer.setHorizontalAlignment(renderer.CENTER);    
   
 }    
   
 //�����񲻿ɱ༭�ķ���    
 public boolean isCellEditable(int row, int column) {    
  return false;    
 }    
   
 @Override   
 public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {    
  DefaultTableCellRenderer tableRenderer = (DefaultTableCellRenderer) super   
    .getDefaultRenderer(columnClass);    
   
  // ���õ�Ԫ�����ݾ�����ʾ    
  tableRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);    
  return tableRenderer;    
 }    
   
}    
   
/*   
 * ������Ⱦ��   
 */   
class RoutineColor extends DefaultTableCellRenderer {    
   
 public Component getTableCellRendererComponent(JTable table, Object value,    
   boolean isSelected, boolean hasFocus, int row, int column) {    
  if (row % 2 == 0) {    
   // ����ż���еı�����ɫ    
   setBackground(new Color(236, 246, 248));    
  } else {    
   // �����еı�����ɫ    
   setBackground(new Color(255, 255, 255));    
  }    
   
  if (row == JTableColor.current) {    
   //��������е���ɫ    
   setBackground(new Color(154,221,151));    
  }    
   
  /*�̳�Label��ķ���, ����table�ĵ�Ԫ����뷽ʽ*/   
  setHorizontalAlignment((int) Component.CENTER_ALIGNMENT); // ˮƽ����    
  setHorizontalTextPosition((int) Component.CENTER_ALIGNMENT); // ��ֱ����    
   
  // table.getTableHeader().setBackground(new Color(206, 231, 255));//���ñ�ͷ������ɫ    
  table.setSelectionBackground(new Color(213, 235, 243));//����ѡ���еı���ɫ    
  table.setSelectionForeground(new Color(247, 81, 53));//����ѡ���е�ǰ��ɫ    
  return super.getTableCellRendererComponent(table, value, isSelected,    
    hasFocus, row, column);    
 }    
   
 // ����и������ݵ�����С    
 public static void adjustTableColumnWidths(JTable table) {    
  JTableHeader header = table.getTableHeader(); // ��ͷ    
  int rowCount = table.getRowCount(); // ��������    
  TableColumnModel cm = table.getColumnModel(); // ������ģ��    
   
  for (int i = 0; i < cm.getColumnCount(); i++) { // ѭ������ÿһ��    
   TableColumn column = cm.getColumn(i); // ��i���ж���    
   int width = (int) header.getDefaultRenderer()    
     .getTableCellRendererComponent(table,    
       column.getIdentifier(), false, false, -1, i)    
     .getPreferredSize().getWidth(); // �ñ�ͷ�Ļ����������i�б�ͷ�Ŀ��    
   for (int row = 0; row < rowCount; row++) { // ѭ�������i�е�ÿһ�У��õ�Ԫ������������i�е�row�еĵ�Ԫ���    
    int preferedWidth = (int) table.getCellRenderer(row, i)    
      .getTableCellRendererComponent(table,    
        table.getValueAt(row, i), false, false, row, i)    
      .getPreferredSize().getWidth();    
    width = Math.max(width, preferedWidth); // ȡ���Ŀ��    
   }    
   column.setPreferredWidth(width + table.getIntercellSpacing().width); // ���õ�i�е���ѡ���    
  }    
   
  table.doLayout(); // ���ող����õĿ�����²��ָ�����    
 }    
}   