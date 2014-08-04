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
package mvc.view;

import javax.swing.JFormattedTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericTextField extends JFormattedTextField {
	
	public NumericTextField() {
		this.setDocument(new NumberDocument(0, 10000,this));
	}
	

}


class NumberDocument extends PlainDocument{
	  int min;
	  int max;
	  JFormattedTextField field;

	public NumberDocument(int mi,int ma, JFormattedTextField field){
	    min = mi;
	    max = ma;
	    this.field = field;
	}
	  
	//重载Document的插入文本的方法
	@Override
	public void insertString(int offset,String str,AttributeSet as) throws BadLocationException{
		int value;
		try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return;
        }
        super.insertString(offset, str, as);
        String content = getContent().getString(0, this.getLength());
        if (Integer.parseInt(content) < min) {
        	field.setText(String
                    .valueOf(min));
        }
        if (Integer.parseInt(content) > max) {
        	field.setText(String
                    .valueOf(max));
        }



	}
}

