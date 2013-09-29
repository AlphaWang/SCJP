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
package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JFrame;

import mvc.model.UserBean;
import mvc.view.MyPanel;

public class Controller {
	
	public UserBean bean;
	MyPanel pnl ;
	
	public static void main(String[] args){
		Controller c = new Controller();
		c.initGui();
	}
	
	public Controller(){
		bean = new UserBean();
		bean.setName("controll");
	}

	public void initGui(){
		JFrame frm = new JFrame();
		pnl =  new MyPanel();
		
		pnl.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("model::"+bean.getDate());
				pnl.getDatePicker().setText("2000-01-01");
				System.out.println("getText()::"+pnl.getDatePicker().getText()
						+"; getDate()::" + pnl.getDatePicker().getSelectedDate());
				
				try {
					pnl.getDatePicker().setSelectedDate(
							pnl.getDatePicker().getDateFormat().parse("2001-01-01"));
					System.out.println("getText()::"+pnl.getDatePicker().getText()
							+"; getDate()::" + pnl.getDatePicker().getSelectedDate());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Object v = pnl.getFormatTextField().getValue();
				System.out.println("format value:" + v);
				
			}
		});
		bean.setDate(new Date());
		pnl.setModel(bean);
		
		bean.addPropertyChangeListener("name", new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getNewValue() != null && !evt.getNewValue().equals(evt.getOldValue())){
					pnl.getField().setText(evt.getNewValue().toString());
					System.out.println("PropertyChangeListener: " + evt.getNewValue());
				}
			}
			
		});
		
		frm.add(pnl);
		
		
		frm.setVisible(true);
		frm.setSize(800, 600);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		testBean();
	}
	
	
	public void testBean(){
		for(int i=0; i<5; i++){
			try {
				Thread.sleep(300);
				this.bean.setName("name_"+i);
				
				System.out.println("controller.bean="+bean.getName());
				System.out.println("view.bean="+pnl.getModel().getName());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
