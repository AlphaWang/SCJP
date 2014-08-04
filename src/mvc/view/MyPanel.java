/*
 * Created by JFormDesigner on Thu Mar 14 15:07:35 CST 2013
 */

package mvc.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import mvc.model.FunctionIcon;
import mvc.model.UserBean;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;

import com.agfa.hap.genericsearch.filter.view.components.JBindableDatePicker;
import com.standbysoft.component.date.event.DateEvent;
import com.standbysoft.component.date.event.DateListener;
import com.standbysoft.component.date.swing.JDateField;
import com.standbysoft.component.date.swing.JDatePicker;

/**
 * @author AGFA Inc Waterloo
 */
public class MyPanel extends JPanel {
	private static final String EDIT_FORMAT = "yyyy/MMM/dd HH:mm";
	private static final String VIEW_FORMAT = "yyyy-MMM-dd hh:m a";
	
	public UserBean getModel(){
		return userBean1;
	}
	public void setModel(UserBean bean){
		this.userBean1 = bean;
	}
	
	public JTextField getField(){
		return textField1;
	}
	
	public JButton getButton(){
		return button1;
	}
	public MyPanel() {
		try {
			 formattedField = new JFormattedTextField(new MaskFormatter("AAA")); //$NON-NLS-1$
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		initComponents();
		formatTextField.setValue(123456);
		addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				button1.grabFocus();
				
			}
		});
		/////以下代码无作用
//		userBean1.addPropertyChangeListener("name", new PropertyChangeListener(){
//
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				if(evt.getNewValue() != null && !evt.getNewValue().equals(evt.getOldValue())){
//					MyPanel.this.textField1.setText(evt.getNewValue().toString());
//					System.out.println("view.PropertyChangeListener: " + evt.getNewValue());
//				}
//			}
//
//		});
		bindableDatePicker1.setEditable(true);
		bindableDatePicker1.setDateFormat("yyyy-MMM-dd HH:mm:ss");
		bindableDatePicker1.getPopup().setVisible(false);
		
		dateField3.setDateFormat(VIEW_FORMAT);
		dateField3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				dateField3.setDateFormat(VIEW_FORMAT);
				dateField3.repaint();
				System.out.println("format change to " + VIEW_FORMAT);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				dateField3.setDateFormat(EDIT_FORMAT);
				dateField3.repaint();
				System.out.println("format change to " + EDIT_FORMAT);
				
			}
		});
		
		datePicker2.setDateFormat("yyyy-MM-dd");
		datePicker2.setText("2000-01-01");
		datePicker2.putClientProperty("embeddedLabel", "yyyy-MM-dd");
		datePicker2.setEditable(true);
		datePicker2.setVerifyInputWhenFocusTarget(true);
		datePicker2.addDateListener(new DateListener() {
			
			@Override
			public void dateFieldCleared(DateEvent evt) {
				System.out.println("====dateFieldCleared:"+evt.getDate());
			}
			
			@Override
			public void dateFieldChanged(DateEvent evt) {
				System.out.println("====dateFieldChanged:"+evt.getDate());
			}
			
			@Override
			public void dateChanged(DateEvent evt) {
				System.out.println("====dateChanged:"+evt.getDate());
			}
		});
		
		datePicker2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("datePicker2 focusLost");
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("datePicker2 focusGained");
				
			}
		});
		
		datePicker2.setSelectedDate(new Date(1880,2,3));
		datePicker2.setSelectedDate(null);
		
		
		imgButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					FunctionIcon icon = FunctionIcon.newCustomIcon(fc.getSelectedFile());
					imgLabel.setIcon(icon.getIcon());
				}
			}
		});
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		createUIComponents();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		textField2 = new JTextField();
		formatTextField = new JFormattedTextField();
		panel1 = new JPanel();
		textField4 = new JTextField();
		textField6 = new JTextField();
		bindableDatePicker1 = new JBindableDatePicker();
		datePicker2 = new JDatePicker();
		dateField3 = new JDateField();
		textField3 = new NumericTextField();
		button1 = new JButton();
		imgLabel = new JLabel();
		imgButton = new JButton();
		userBean1 = new UserBean();

		//======== this ========
		setName("this"); //$NON-NLS-1$
		setLayout(new TableLayout(new double[][] {
			{56, TableLayout.FILL},
			{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
		((TableLayout)getLayout()).setHGap(5);
		((TableLayout)getLayout()).setVGap(5);

		//---- label1 ----
		label1.setText("NAME"); //$NON-NLS-1$
		label1.setName("label1"); //$NON-NLS-1$
		add(label1, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- textField1 ----
		textField1.setName("textField1"); //$NON-NLS-1$
		add(textField1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- label2 ----
		label2.setText("PWD"); //$NON-NLS-1$
		label2.setName("label2"); //$NON-NLS-1$
		add(label2, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- textField2 ----
		textField2.setName("textField2"); //$NON-NLS-1$
		add(textField2, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- formatTextField ----
		formatTextField.setName("formatTextField"); //$NON-NLS-1$
		add(formatTextField, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//======== panel1 ========
		{
			panel1.setName("panel1"); //$NON-NLS-1$
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 30, 0, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

			//---- textField4 ----
			textField4.setText("pid("); //$NON-NLS-1$
			textField4.setEnabled(false);
			textField4.setName("textField4"); //$NON-NLS-1$
			panel1.add(textField4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- formattedField ----
			formattedField.setMinimumSize(new Dimension(50, 20));
			formattedField.setName("formattedField"); //$NON-NLS-1$
			panel1.add(formattedField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- textField6 ----
			textField6.setText(")"); //$NON-NLS-1$
			textField6.setEnabled(false);
			textField6.setName("textField6"); //$NON-NLS-1$
			panel1.add(textField6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		add(panel1, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- bindableDatePicker1 ----
		bindableDatePicker1.setName("bindableDatePicker1"); //$NON-NLS-1$
		add(bindableDatePicker1, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- datePicker2 ----
		datePicker2.setName("datePicker2"); //$NON-NLS-1$
		add(datePicker2, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- dateField3 ----
		dateField3.setText("mi"); //$NON-NLS-1$
		dateField3.setName("dateField3"); //$NON-NLS-1$
		add(dateField3, new TableLayoutConstraints(1, 6, 1, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- textField3 ----
		textField3.setName("textField3"); //$NON-NLS-1$
		add(textField3, new TableLayoutConstraints(1, 7, 1, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- button1 ----
		button1.setText("test"); //$NON-NLS-1$
		button1.setName("button1"); //$NON-NLS-1$
		add(button1, new TableLayoutConstraints(1, 8, 1, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- imgLabel ----
		imgLabel.setText("text"); //$NON-NLS-1$
		imgLabel.setName("imgLabel"); //$NON-NLS-1$
		add(imgLabel, new TableLayoutConstraints(0, 9, 0, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- imgButton ----
		imgButton.setText("text"); //$NON-NLS-1$
		imgButton.setName("imgButton"); //$NON-NLS-1$
		add(imgButton, new TableLayoutConstraints(1, 9, 1, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		initComponentBindings();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	private void initComponentBindings() {
		// JFormDesigner - Component bindings initialization - DO NOT MODIFY  //GEN-BEGIN:initBindings
		bindingGroup = new BindingGroup();
		{
			Binding binding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				userBean1, ELProperty.create("${name}"), //$NON-NLS-1$
				textField1, BeanProperty.create("text")); //$NON-NLS-1$
			bindingGroup.addBinding(binding);
			binding.bind();
		}
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			userBean1, ELProperty.create("${pwd}"), //$NON-NLS-1$
			textField2, BeanProperty.create("text"))); //$NON-NLS-1$
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			bindableDatePicker1, ELProperty.create("${selectedDate}"), //$NON-NLS-1$
			userBean1, BeanProperty.create("date"))); //$NON-NLS-1$
		bindingGroup.bind();
		// JFormDesigner - End of component bindings initialization  //GEN-END:initBindings
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JTextField textField1;
	private JLabel label2;
	private JTextField textField2;
	private JFormattedTextField formatTextField;
	private JPanel panel1;
	private JTextField textField4;
	private JFormattedTextField formattedField;
	private JTextField textField6;
	private JBindableDatePicker bindableDatePicker1;
	private JDatePicker datePicker2;
	private JDateField dateField3;
	private NumericTextField textField3;
	private JButton button1;
	private JLabel imgLabel;
	private JButton imgButton;
	private UserBean userBean1;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public JDatePicker getDatePicker() {
		// TODO Auto-generated method stub
		return datePicker2;
	}
	public JFormattedTextField getFormatTextField() {
		return formatTextField;
	}
}
