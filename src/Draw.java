//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2013
//             A G F A - G E V A E R T  G R O U P
//                    All Rights Reserved
/////////////////////////////////////////////////////////////////
//
//       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                    Agfa-Gevaert Group
//      The copyright notice above does not evidence any
//     actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//
//

/**
 * һ����ʽ���ı��������ֵ����Ϳ���ӵ�и��ָ����ĳ���ͼ����������
 * ʹ��һ����ť���ƻ���
 */
  
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
  
public class Draw extends JFrame implements ActionListener {
      
    //��������������Ϊ������ԣ���������ķ�����ʹ��
    private Graphics g;
      
    //��ں���
    public static void main(String[] args) {
        Draw d = new Draw();
        d.init();
          
    }
      
    // ��ʼ������
    public void init() {
        this.setTitle("����ĺ���");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
          
        // ��ȡ��������
        g = this.getGraphics();
  
        // ���һ�����ư�ť
        JButton bu = new JButton("��ͼ");
        bu.setActionCommand("draw");
//        this.add(new JTextField("a"));
//        this.add(new JTextField("b"));
//        this.add(new JTextField("c"));
//        this.add(new JTextField("d"));
        this.add(bu);
        bu.addActionListener(this);
    }
       
    //��дActionLitener�еķ������ڴ�ʵ�ֻ��Ƶķ���
    @Override
	public void actionPerformed(ActionEvent e) {
          
        //��ʼ��x��y
        double x = 0, y = 0;
          
        //����ʽ�ĳ�����ֵ���ı�ÿ��ֵ���Եõ���ͬ��ͼ��
        double a =-1.7, b = -2.5, c = -2, d = -1;
          
        //ʹ��ѭ�������ÿ�ε�����ֵ������ɻ���
        for (int i = 0; i < 100000; i++) {
              
            //����java��Math�еķ���,���㺯��ֵ���������ǰ��x��y��ֵ����һ��ѭ��ʱ�õ�ǰ��x,y��ֵ������һ�˵�x��y��ֵ��������ȥ
            x = d * Math.sin(a * x) - Math.sin(b * y);
            y = c * Math.cos(a * x) + Math.cos(b * y);
              
            //���ڻ���������ص㣬���������´������Ͻ�Ϊԭ�㣬��ֱ����Ϊ���ᣬ�����ֵ̫С����*100��+330��Ϊ�˽����صĵ�ƽ�Ƶ�����������
            int m = (int) ((d * Math.sin(a * x) - Math.sin(b * y)) * 100+330);
            int n = (int) ((c * Math.cos(a * x) + Math.cos(b * y)) * 100+350);
              
            //��ÿ��������ɫ��������
            g.setColor(new Color(250,i%255,i%155));
            g.drawLine(m, n, m, n);
  
        }
    }
}
