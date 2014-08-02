/ *
 * Created by JFormDesigner on Thu Mar 14 15:07:35 CST 2013
 */

package mvc.view;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		textField2 = new JTextField();
		formatTextField = new JFormattedTextField();
		bindableDatePicker1 = new JBindableDatePicker();
		datePicker2 = new JDatePicker();
		dateField3 = new JDateField();
		button1 = new JButton();
		userBean1 = new UserBean();

		//======== this ========
		setName("this"); //$NON-NLS-1$
		setLayout(new TableLayout(new double[][] {
			{56, TableLayout.FILL},
			{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
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

		//---- bindableDatePicker1 ----
		bindableDatePicker1.setName("bindableDatePicker1"); //$NON-NLS-1$
		add(bindableDatePicker1, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- datePicker2 ----
		datePicker2.setName("datePicker2"); //$NON-NLS-1$
		add(datePicker2, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- dateField3 ----
		dateField3.setText("mi"); //$NON-NLS-1$
		dateField3.setName("dateField3"); //$NON-NLS-1$
		add(dateField3, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

		//---- button1 ----
		button1.setText("test"); //$NON-NLS-1$
		button1.setName("button1"); //$NON-NLS-1$
		add(button1, new TableLayoutConstraints(1, 6, 1, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

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
	private JBindableDatePicker bindableDatePicker1;
	private JDatePicker datePicker2;
	private JDateField dateField3;
	private JButton button1;
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
