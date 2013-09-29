/**
 * <p>�ļ�����: JPanelAlarm.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2009-12-4</p>
 * <p>������ڣ�2009-12-4</p>
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
package com.zte.scjp.swing.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/*import com.zte.ums.truomcr.wsf.simurnc.comm.EmfTDRncJID;
import com.zte.ums.truomcr.wsf.simurnc.comm.MConst;
import com.zte.ums.truomcr.wsf.simurnc.comm.SimuNEException;
import com.zte.ums.truomcr.wsf.simurnc.fm.AlarmInfo;
import com.zte.ums.truomcr.wsf.simurnc.fm.AlarmReportPacket;
import com.zte.ums.truomcr.wsf.simurnc.view.GuiIntegerDocument;
import com.zte.ums.truomcr.wsf.simurnc.view.SimuRncView;*/

/**
 * �澯���ķ��ͽ��棬������JDialog��JTabbedPane�����ø�JPanel
 * @author WangZhongXing192063
 *
 */
public class TestPanel extends JFrame
{
	    public static Font menuFont = new Font("Arial,����",Font.PLAIN,12);//Ϊ�˱��������ʾ;
	 	private static final int DIALOG_WIDTH = 500;
	    private static final int DIALOG_HEIGHT = 710;
	    private JPanelSendAlarm panelAlarm;
		private JScrollPane alarmScropanel;
		private JTextArea textarea;
		private DefaultListModel model1;
		private JList jinfoList;


		/**
		 * main()���Խ�����
		 * @author WangZhongXing192063
		 */
		public static void main(String[] args)
		{
			TestPanel dialog = new TestPanel(null,6);
		    dialog.setVisible(true);
		}
		
		
		public TestPanel(JFrame frame,int k)
		{
			super("���͸澯��");
			Container contentpane=getContentPane();
			//contentpane.setLayout(new GridBagLayout());
			contentpane.setLayout(new BorderLayout());
			
			panelAlarm = new JPanelSendAlarm();

			//*******�ϲ�������ı�
	        JPanel textAreaPanel = new  JPanel();
	        textAreaPanel.setLayout(new GridLayout(1,3));
	        textarea=new JTextArea();
	        textarea.setRows(5);
	        textarea.setEditable(false);
	        invalidate();
	        /*20090421�����*/
	        model1=new DefaultListModel();
	        jinfoList=new JList(model1);
	        textarea.add(jinfoList);        
	        alarmScropanel=new JScrollPane(textarea);
	        textAreaPanel.add(alarmScropanel);
	    
		
	        contentpane.add(panelAlarm,BorderLayout.CENTER);
	        contentpane.add(textAreaPanel,BorderLayout.SOUTH);
	        contentpane.add(new JPanel(),BorderLayout.EAST);
	        contentpane.add(new JPanel(),BorderLayout.WEST);
	        
	        //contentpane.add(panelAlarm);

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			this.setSize( DIALOG_WIDTH, DIALOG_HEIGHT);
			//this.setResizable(false);
			this.setLocation((toolkit.getScreenSize().width - DIALOG_WIDTH) / 2 , 
					        (toolkit.getScreenSize().height - DIALOG_HEIGHT) / 2);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		}
}
class JPanelSendAlarm extends JPanel
{
    protected JPanel contentPanel;
    protected JPanel titlePanel;
    protected JPanel inputPanel;
    protected JPanel buttonPanel;
    protected static AlarmPanel[] alarmPanel = new AlarmPanel[20];
    
    public static boolean isGsmAlarm = false;
    protected JComboBox setAlarmType; //�ƻ����ݸ澯��ʽ ��ʾ��ͬGUI��δʵ�֡�����
    protected static int columnNum = 5;	//�����Ƿ�GSM�澯 ���ò�ͬ����
    
    protected JButton bCancle;
    protected JButton bClear;
    protected JButton bSend;
    
    protected ButtonGroup radioGroup ;
    protected JRadioButton setAllAlarm ;
    protected JRadioButton setAllRestore;
    public JPanelSendAlarm()
    {
    	if(isGsmAlarm)
    	{
    		columnNum = 6;
    	}
    	else
    	{
    		columnNum = 5;
    	}
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        //contentPanel.setLayout(new GridBagLayout());
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(21,1));
        
        //******��������������
        JPanel northPanel=new JPanel();
        /*northPanel.setLayout(new GridLayout(3,1));
        northPanel.add(new JLabel("north1"));
        northPanel.add(new JLabel("north2"));*/
        
        //*****�в���20��澯&�ָ��ı�����������   
        
         //�澯&�ָ�������  ��ÿ���澯�����20������1�������� = 21.
         ///////1. ������
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,columnNum));
        JPanel title1 = new JPanel();
        title1.setLayout(new GridLayout(1,2));
        JLabel title11 = new JLabel("���");
        JLabel title12 = new JLabel("����");
        title1.add(title11);
        title1.add(title12);
        
        JLabel title2 = new JLabel("�澯��");
        JLabel title3 = new JLabel("��ˮ��");
        JLabel title4 = new JLabel("λ��");
        JLabel title5 = new JLabel("SiteID");
        JLabel title6 = new JLabel("�澯or�ָ�");
        title11.setFont(TestPanel.menuFont);
        title12.setFont(TestPanel.menuFont);
        title2.setFont(TestPanel.menuFont);
        title3.setFont(TestPanel.menuFont);
        title4.setFont(TestPanel.menuFont);
        title5.setFont(TestPanel.menuFont);
        title6.setFont(TestPanel.menuFont);
        title11.setHorizontalAlignment(JLabel.CENTER);
        title12.setHorizontalAlignment(JLabel.CENTER);
        title2.setHorizontalAlignment(JLabel.CENTER);
        title3.setHorizontalAlignment(JLabel.CENTER);
        title4.setHorizontalAlignment(JLabel.CENTER);
        title5.setHorizontalAlignment(JLabel.CENTER);
        title6.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(title1);
        titlePanel.add(title2);
        titlePanel.add(title3);
        titlePanel.add(title4);
        if(isGsmAlarm)
        {
        	titlePanel.add(title5);
        }
        titlePanel.add(title6);
        inputPanel.add(titlePanel);
        ////////2. ������*20
        for(int i = 0; i < alarmPanel.length; i++)
        {
            try
            {
                alarmPanel[i] = new AlarmPanel(i);
            }
            catch (ParseException e1)
            {
                e1.printStackTrace();
            }
            inputPanel.add(alarmPanel[i]);
        }

        //******�ϲ���������ť
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(1,columnNum));
        JPanel bSendPanel = new JPanel();
        JPanel bCanclePanel = new JPanel();
        JPanel bClearPanel = new JPanel();
        
        JLabel labelSetAlarmType = new JLabel("��ʽ��");
        labelSetAlarmType.setHorizontalAlignment(JLabel.RIGHT);
        labelSetAlarmType.setFont(TestPanel.menuFont);
        setAlarmType = new JComboBox();
        setAlarmType.addItem("��ͨ");
        setAlarmType.addItem("GSM");
        setAlarmType.setFont(TestPanel.menuFont);
        //setAlarmType.addActionListener(new SetAlarmTypeListener());
        JPanel panelComboBox = new JPanel();
        panelComboBox.add(setAlarmType);
        JPanel panelSetAlarmType = new JPanel();
        panelSetAlarmType.setLayout(new GridLayout(1,2));
        panelSetAlarmType.add(labelSetAlarmType);
        panelSetAlarmType.add(panelComboBox);
        
        bSend = new JButton("���͸澯");
        //bSend.addActionListener(new SendListener());
        bCancle=new JButton("ȡ������");
        bCancle.addActionListener(new CancelListener());
        //bClear=new JButton("�����Ϣ");
        //bClear.addActionListener(new ClearListener());
        //��ѡ��ȫ��Ϊ�澯or�ָ�
        radioGroup = new ButtonGroup();
        setAllAlarm = new JRadioButton();
        setAllRestore  = new JRadioButton();
        radioGroup.add(setAllAlarm);
        radioGroup.add(setAllRestore);
        JPanel radioPanel = new JPanel();
        radioPanel.add(setAllAlarm);
        radioPanel.add(setAllRestore);
        setAllAlarm.setToolTipText("ȫ����Ϊ�澯");
        setAllRestore.setToolTipText("ȫ����Ϊ�ָ�");
        setAllAlarm.addActionListener(new SetAllAlarmListener());
        setAllRestore.addActionListener(new SetAllRestoreListener());

        bSendPanel.add(bSend);
        bCanclePanel.add(bCancle);
        //bClearPanel.add(bClear);
        //�ù���δʵ�֣��������ݲ���ӿؼ�������ͨ��XML����
       // buttonPanel.add(panelSetAlarmType);
        buttonPanel.add(new JLabel("  "));
        buttonPanel.add(new JLabel("  "));
        if(isGsmAlarm)
        {
        	buttonPanel.add(new JLabel("  "));
        }
        
        buttonPanel.add(bSendPanel);
        buttonPanel.add(new JLabel("  "));
        //"ȡ������"��ť���¼�������Ҫ�����
        //buttonPanel.add(bCanclePanel);
        //"�����Ϣ"��ť�ŵ�ϵͳ�˵���
        //buttonPanel.add(bClearPanel); 
        buttonPanel.add(radioPanel);
        //inputPanel.add(buttonPanel);
        contentPanel.add(inputPanel,BorderLayout.CENTER);
        contentPanel.add(buttonPanel,BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(contentPanel,BorderLayout.CENTER);
        /*this.setLayout(new GridBagLayout());
        this.add(contentPanel);*/
    }
    /**
     * �ڲ��ࣺ�����澯��һ��������棬�Ի����й���20���������С�
     * @author WangZhongXing192063
     *
     */
    protected class AlarmPanel extends JPanel
    {
        int rowNum;
        JPanel panel;          //װ��š���ѡ��
        JPanel alarmIdPanel;
        JPanel alarmCodePanel;
        JPanel alarmPosPanel;
        JPanel alarmSiteIdPanel; //GSM��������SiteId
        JPanel alarmRestorePanel; //װ������ѡ��
        
        JLabel numLabel;
        JCheckBox isActive;////�Ƿ�ֹͣ�������澯����澯��
        JTextField alarmIdField;
        JComboBox alarmCodeField;
        JFormattedTextField alarmPosFormattedField;
        JTextField siteIdField;  //GSM��������SiteId
        ButtonGroup group;
        JRadioButton isAlarm;
        JRadioButton isRestore;
        ArrayList<String> codeList;//�������и澯��
      
        /**
         * ����isActive��ѡ������ ˢ�½���
         */
        public void refreshGUI()
        {
            int rowNum = this.rowNum;
            if(isActive.isSelected() == true)
            {
                for(int i = 0; i <= rowNum; i++)
                {
                    JPanelSendAlarm.alarmPanel[i].isActive.setSelected(true);
                    JPanelSendAlarm.alarmPanel[i].alarmIdField.setEditable(true);
                    JPanelSendAlarm.alarmPanel[i].alarmIdField.setEnabled(true);
                    JPanelSendAlarm.alarmPanel[i].alarmCodeField.setEnabled(true);
                    JPanelSendAlarm.alarmPanel[i].alarmPosFormattedField.setEditable(true);
                    JPanelSendAlarm.alarmPanel[i].alarmPosFormattedField.setEnabled(true);
                    JPanelSendAlarm.alarmPanel[i].siteIdField.setEnabled(true);
                    JPanelSendAlarm.alarmPanel[i].siteIdField.setEditable(true);
                    JPanelSendAlarm.alarmPanel[i].isAlarm.setEnabled(true);
                    JPanelSendAlarm.alarmPanel[i].isRestore.setEnabled(true);
                    JPanelSendAlarm.alarmPanel[i].numLabel.setEnabled(true);
                }
            }
            else if(isActive.isSelected() == false)
            {
                for(int i = rowNum; i < JPanelSendAlarm.alarmPanel.length; i++)
                {
                    JPanelSendAlarm.alarmPanel[i].isActive.setSelected(false);
                    JPanelSendAlarm.alarmPanel[i].alarmIdField.setEditable(false);
                    JPanelSendAlarm.alarmPanel[i].alarmIdField.setEnabled(false);
                    JPanelSendAlarm.alarmPanel[i].alarmCodeField.setEnabled(false);
                    JPanelSendAlarm.alarmPanel[i].alarmPosFormattedField.setEditable(false);
                    JPanelSendAlarm.alarmPanel[i].alarmPosFormattedField.setEnabled(false);
                    JPanelSendAlarm.alarmPanel[i].siteIdField.setEnabled(false);
                    JPanelSendAlarm.alarmPanel[i].siteIdField.setEditable(false);
                    JPanelSendAlarm.alarmPanel[i].isAlarm.setEnabled(false);
                    JPanelSendAlarm.alarmPanel[i].isRestore.setEnabled(false);
                    JPanelSendAlarm.alarmPanel[i].numLabel.setEnabled(false);
                }
            }
        }
        /**
         * ���췽������ʼ����i��������
         */
        public AlarmPanel(int rowNum) throws ParseException
        {
            this.rowNum = rowNum;
            this.setLayout(new GridLayout(1,columnNum));
            panel = new JPanel();
            panel.setLayout(new GridLayout(1,2));
            numLabel = new JLabel(""+this.rowNum);
            numLabel.setHorizontalAlignment(SwingConstants.CENTER);
            /*
             * Ĭ�ϼ����һ���澯�����У������лҵ���
             */
            if(this.rowNum == 0)
            {
                isActive = new JCheckBox("",true);
            }
            else
            {
                isActive = new JCheckBox("",false);
            }
            isActive.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(numLabel);
            panel.add(isActive);
            
            alarmIdField = new JTextField(""+this.rowNum);
            alarmCodeField = new JComboBox();
            alarmCodeField.setEditable(false);//ֻ��ѡ�񣬲��������¸澯��
            alarmCodeField.setFont(new Font("Arial",Font.PLAIN,12));//Ϊ�˱��������ʾ
            MaskFormatter maskFormatter = new MaskFormatter("# / # / ## / #");
            maskFormatter.setPlaceholderCharacter('_');
            alarmPosFormattedField = new JFormattedTextField(maskFormatter);
            alarmPosFormattedField.setHorizontalAlignment(JTextField.CENTER);
            alarmPosFormattedField.setText("1/1/01/1");
            //alarmIdField.setDocument(new GuiIntegerDocument());
            alarmIdField.setText(""+this.rowNum);
            siteIdField = new JTextField();
            //siteIdField.setDocument(new GuiIntegerDocument());
            siteIdField.setText("65535");
            
            
            alarmIdPanel = new JPanel();
            alarmIdPanel.setLayout(new BorderLayout());
            alarmCodePanel = new JPanel();
            alarmCodePanel.setLayout(new BorderLayout());
            alarmPosPanel = new JPanel();
            alarmPosPanel.setLayout(new BorderLayout());
            alarmSiteIdPanel = new JPanel();
            alarmSiteIdPanel.setLayout(new BorderLayout());
            alarmIdPanel.add(new JLabel(" "),BorderLayout.EAST);
            alarmIdPanel.add(new JLabel(" "),BorderLayout.WEST);
            alarmIdPanel.add(alarmIdField, BorderLayout.CENTER);
            alarmCodePanel.add(new JLabel(" "),BorderLayout.EAST);
            alarmCodePanel.add(new JLabel(" "),BorderLayout.WEST);
            alarmCodePanel.add(alarmCodeField, BorderLayout.CENTER);
            alarmPosPanel.add(new JLabel(" "),BorderLayout.WEST);
            //alarmPosPanel.add(alarmPosField,BorderLayout.CENTER);
            alarmPosPanel.add(alarmPosFormattedField,BorderLayout.CENTER);
            alarmSiteIdPanel.add(new JLabel(" "),BorderLayout.EAST);
            alarmSiteIdPanel.add(new JLabel(" "),BorderLayout.WEST);
            alarmSiteIdPanel.add(siteIdField, BorderLayout.CENTER);
            
            group = new ButtonGroup();
            isAlarm = new JRadioButton("",true);
            isRestore = new JRadioButton("",false);
            group.add(isAlarm);
            group.add(isRestore);
            alarmRestorePanel = new JPanel();
            alarmRestorePanel.add(isAlarm);
            alarmRestorePanel.add(isRestore);
            /*
             * �澯�����������¼����������ݸ澯�������ˮ�š��澯λ�õ�
             */
            alarmCodeField.setMaximumRowCount(10);
            //codeList = MConst.alarmCodeList;
            alarmCodeField.addItem("56598445545376");
            /*for(int j = 0; j <codeList.size(); j++)
            {
                alarmCodeField.addItem(codeList.get(j));
            }
            
            String selectedCode = ((String)alarmCodeField.getSelectedItem()).trim();
            if (selectedCode == null){
                selectedCode = ((String)alarmCodeField.getItemAt(0)).trim();
            }
            String tips = MConst.alarmInfoMap.get(selectedCode).getDesc();
            alarmCodeField.setToolTipText(tips);
            
            */
            /*alarmCodeField.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    String code = (String)alarmCodeField.getSelectedItem();
                    AlarmInfo alarminfo = MConst.alarmInfoMap.get(code);
                    int id = alarminfo.getId();
                    
                    byte flag = alarminfo.getFlag();
                    String pos = alarminfo.getPos();
                    //ֻ�е�ǰ�澯�붨���˳�ʼֵ���Ÿ���id��pos
                    if(id != 0)
                    {
                        alarmIdField.setText(""+id);
                        alarmPosFormattedField.setText(pos);
                    }
                    if(flag == 2)
                    {
                        isRestore.setSelected(true);
                    }
                    else
                    {
                        isAlarm.setSelected(true);
                    }
                    String selectedCode = ((String)alarmCodeField.getSelectedItem()).trim();
                    String tips = MConst.alarmInfoMap.get(selectedCode).getDesc();
                    alarmCodeField.setToolTipText(tips);
                }
            });*/
            this.add(panel);
            this.add(alarmCodePanel);
            this.add(alarmIdPanel);
            this.add(alarmPosPanel);
            if(isGsmAlarm)
            {
            	this.add(alarmSiteIdPanel);
            }
            this.add(alarmRestorePanel);
            
           //refreshGUI();
            /**
             * Ĭ��ֻ�����һ�С�
             * ������Ƶ������Բ���������refreshGUI�׿�ָ�룬�������
             */
            if(this.rowNum == 0)
            {
                this.isActive.setSelected(true);
                this.alarmIdField.setEditable(true);
                this.alarmIdField.setEnabled(true);
                this.alarmCodeField.setEnabled(true);
                this.alarmPosFormattedField.setEditable(true);
                this.alarmPosFormattedField.setEnabled(true);
                this.siteIdField.setEnabled(true);
                this.siteIdField.setEditable(true);
                this.isAlarm.setEnabled(true);
                this.isRestore.setEnabled(true);
                this.numLabel.setEnabled(true);
            }
            else
            {
                this.isActive.setSelected(false);
                this.alarmIdField.setEditable(false);
                this.alarmIdField.setEnabled(false);
                this.alarmCodeField.setEnabled(false);
                this.alarmPosFormattedField.setEditable(false);
                this.alarmPosFormattedField.setEnabled(false);
                this.siteIdField.setEnabled(false);
                this.siteIdField.setEditable(false);
                this.isAlarm.setEnabled(false);
                this.isRestore.setEnabled(false);
                this.numLabel.setEnabled(false);
            }
            /**
             * ��ѡ�򣺡����
             */
            isActive.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // TODO Auto-generated method stub
                    refreshGUI();
                }
            });
        }
    }
    
    /**
     * 
     * ȡ�����Ͱ�ť �¼������ڲ���
     * @author WangZhongXing192063
     *
     */
    protected class CancelListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            setVisible(false);
            //dispose();
        }
    }
    /**
     * ȫ����Ϊ�澯 ����
     * @author WangZhongXing192063
     *
     */
    protected class SetAllAlarmListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            for(AlarmPanel aPanel:alarmPanel)
            {
                aPanel.isAlarm.setSelected(true);
            }
        }
    }
    /**
     * ȫ����Ϊ�ָ� ����
     * @author WangZhongXing192063
     *
     */
    protected class SetAllRestoreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            for(AlarmPanel aPanel:alarmPanel)
            {
                aPanel.isRestore.setSelected(true);
            }
        }
    }
   /* protected class SetAlarmTypeListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			String alarmType = (String) setAlarmType.getSelectedItem();
			if(alarmType!= null && alarmType.equalsIgnoreCase("��ͨ"))
			{
				isGsmAlarm = false;
				JPanelSendAlarm.this.repaint();
				SimuRncView.dPrn.info("��Ϊ��ͨ�澯");
			}
			else if(alarmType!= null && alarmType.equalsIgnoreCase("GSM"))
			{
				isGsmAlarm = true;
				JPanelSendAlarm.this.repaint();
				SimuRncView.dPrn.info("��ΪGSM�澯");
				repaint();
			}
			else
			{
				SimuRncView.dPrn.error("δ֪�澯��ʽ:"+alarmType);
			}
		}
    	
    }*/
   
}
