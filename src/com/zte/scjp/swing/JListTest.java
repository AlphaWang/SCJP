/**
 * <p>文件名称: TestJList.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-6-23</p>
 * <p>完成日期：2010-6-23</p>
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
import java.awt.Color;   
import java.awt.Dimension;   
import java.awt.Rectangle;   
import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;   
import java.util.ArrayList;   
import java.util.Collections;   
import java.util.List;   
import javax.swing.DefaultListModel;   
import javax.swing.JButton;   
import javax.swing.JFrame;   
import javax.swing.JLabel;   
import javax.swing.JList;   
import javax.swing.JPanel;   
import javax.swing.JScrollPane;   
import javax.swing.SwingConstants;   


public class JListTest extends JPanel {
	
	private static final long serialVersionUID = 1L;   
    private JButton but[];   
    private JPanel jPanel = null; // @jve:decl-index=0:visual-constraint="51,44"   
    private JLabel jLabel1 = null;   
    private JLabel jLabel2 = null;   
    private JList jList = null;   
    private JList jList2 = null;   
    private JLabel jLabel3 = null;   
    private JLabel jLabel4 = null;   
    public JScrollPane scrollPane = null;   
    public JScrollPane scrollPane2 = null;   
    List list = null;   
    List list2 = null;   
    private String[] str = { "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh",   
            "ii", "jj", "kk", "ll" };   
    private String[] str2 = { "11", "22", "33", "44", "55", "66", "77", "88",   
            "99", "00", "12", "13" };   
    DefaultListModel model1, model2;   
    /**  
     * This method initializes jPanel  
     *   
     * @return javax.swing.JPanel  
     */  
    public JListTest() {   
        list = GetList();   
        list2 = GetList();   
        Collections.sort(list);   
        Collections.sort(list2);   
           
        this.setLayout(null);   
        //this.setBounds(new Rectangle(100,100,500,300));   
        jLabel4 = new JLabel();   
        jLabel4.setBounds(new Rectangle(328, 84, 126, 18));   
        jLabel4.setText("products selected");   
        jLabel3 = new JLabel();   
        jLabel3.setBounds(new Rectangle(66, 84, 126, 18));   
        jLabel3.setText("all products");   
        jLabel2 = new JLabel();   
        jLabel2.setBounds(new Rectangle(40, 44, 128, 18));   
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);   
        jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);   
        jLabel2.setText("content");   
        jLabel1 = new JLabel();   
        jLabel1.setBounds(new Rectangle(148, 13, 217, 18));   
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);   
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);   
        jLabel1.setText("title");   
        jPanel = new JPanel();   
        jPanel.setLayout(null);   
        jPanel.setSize(new Dimension(519, 305));   
        // jPanel.setBackground(Color.white);   
        jPanel.add(jLabel1, null);   
        jPanel.add(jLabel2, null);   
        jPanel.add(jLabel3, null);   
        jPanel.add(jLabel4, null);   
        model1 = new DefaultListModel();   
        jList = new JList(model1);   
        jList.setBounds(new Rectangle(0, 0, 126, 152));   
        for (int i = 0; i < list.size(); i++) {   
            Object s = list.get(i);   
            model1.addElement(s);   
        }   
        scrollPane = new JScrollPane(jList);   
        scrollPane.setBackground(Color.LIGHT_GRAY);   
        scrollPane.setBounds(new Rectangle(66, 101, 126, 152));   
        model2 = new DefaultListModel();   
        jList2 = new JList(model2);   
        jList2.setBounds(new Rectangle(0, 0, 126, 152));   
        for (int i = 0; i < list2.size(); i++) {   
            Object s = list2.get(i);   
            model2.addElement(s);   
        }   
        scrollPane2 = new JScrollPane(jList2);   
        scrollPane2.setBackground(Color.LIGHT_GRAY);   
        scrollPane2.setBounds(new Rectangle(335, 101, 126, 152));   
        jPanel.add(scrollPane, null);   
        jPanel.add(scrollPane2, null);   
        but = new JButton[2];   
        but[0] = new JButton();   
        but[0].setBounds(new Rectangle(225, 132, 72, 24));   
        but[0].setHorizontalTextPosition(SwingConstants.CENTER);   
        but[0].setText(">");   
        but[1] = new JButton();   
        but[1].setBounds(new Rectangle(227, 197, 72, 24));   
        but[1].setHorizontalTextPosition(SwingConstants.CENTER);   
        but[1].setText("<");   
        for (int i = 0; i < but.length; i++) {   
            but[i].addActionListener(new Handler());   
        }   
        jPanel.add(but[0], null);   
        jPanel.add(but[1], null);   
        this.add(jPanel);   
    }   
    public List GetList() {   
        List list = new ArrayList();   
        list.clear();   
        list.add("aa");   
        list.add("bb");   
        list.add("vv");   
        list.add("ss");   
        list.add("dd");   
        list.add("xx");   
        list.add("cc");   
        list.add("zz");   
        list.add("ee");   
        list.add("ww");   
        list.add("qq");   
        list.add("tt");   
        list.add("yy");   
        list.add("uu");   
        return list;   
    }   
    /**  
     * @param args  
     */  
    public static void main(String[] args) {   
        // TODO Auto-generated method stub   
        JFrame f = new JFrame();   
        f.setSize(new Dimension(1024, 660));   
        JListTest p = new JListTest();   
        p.setBounds(new Rectangle(500,100,500,300));   
        f.add(p, null);   
        f.setVisible(true);   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }   
    class Handler implements ActionListener {   
        public void actionPerformed(ActionEvent e) {   
            if (e.getSource() == but[0]) {   
                while (!jList.isSelectionEmpty()) {   
                    list2.add(jList.getSelectedValue());   
                    list.remove(jList.getSelectedValue());   
                    Collections.sort(list);   
                    Collections.sort(list2);   
                    model2.removeAllElements();   
                    model1.removeAllElements();   
                    for (int i = 0; i < list2.size(); i++) {   
                        model2.addElement(list2.get(i));   
                    }   
                    for (int i = 0; i < list.size(); i++) {   
                        model1.addElement(list.get(i));   
                    }   
                }   
            }   
            if (e.getSource() == but[1]) {   
                while (!jList2.isSelectionEmpty()) {   
                    list.add(jList2.getSelectedValue());   
                    list2.remove(jList2.getSelectedValue());   
                    Collections.sort(list);   
                    Collections.sort(list2);   
                    model2.removeAllElements();   
                    model1.removeAllElements();   
                    for (int i = 0; i < list2.size(); i++) {   
                        model2.addElement(list2.get(i));   
                    }   
                    for (int i = 0; i < list.size(); i++) {   
                        model1.addElement(list.get(i));   
                    }   
                }   
            }   
        }   
    }   



}
