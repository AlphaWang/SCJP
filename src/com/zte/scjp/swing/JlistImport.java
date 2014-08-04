/**
 * <p>�ļ�����: JListImport.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-6-23</p>
 * <p>������ڣ�2010-6-23</p>
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
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
/*
 Jlist���ϳ������JList  setTransferHandler(new TransferHandler(){ 

    @Override
   public int getSourceActions(JComponent c){ 

    } 


    @Override 

   protected Transferable createTransferable(JComponent c){ 
    }
} ): 

���뵽 dragInList�� �� dragInLis. setTransferHandler(new TransferHandler(){ 
   @Override 
   public boolean importData(TransferSupport support) { 

       if( canImport( support ) ){ 

     

        }
    } 


     public boolean canImport(TransferSupport support) { 
     }
} ): 

 
 */
public class JlistImport extends JPanel {
    private JList dragInList = null;
    private JList dragOutList = null;
    private DefaultListModel dragInListModel =null; 

    //�������ݵ� dragInList 
    public JList getDragInList() {
        if (dragInList == null) {
            dragInList = new JList();
            dragInList.setModel(getDragInListModel());
            dragInList.setTransferHandler(new TransferHandler() {
                //�������ݵ��뷽��
                @Override
                public boolean importData(TransferSupport support) {
                    if (canImport(support)) {
                        Transferable reportObject = support.getTransferable();
                        TransferableParameter parameter = (TransferableParameter)reportObject;
                        getDragInListModel().addElement(parameter.getData());
                        return true;
                    }
                    return false;
                }
                //�ж��ܷ��������ݣ���� dragOutList ���ϳ��ģ���������뵽 dragInList �� 
                public boolean canImport(TransferSupport support) {
                    boolean canImport = false;
                    Transferable reportObject = support.getTransferable();
                    try{
                        TransferableParameter parameter = (TransferableParameter)reportObject;
                        if(parameter.getSourceComponent() == dragOutList){
                            canImport = true;
                        }

                    }catch (Exception e) {
                    }
                    return canImport;
                }
            });
        }
        return dragInList;
    }
    private DefaultListModel getDragInListModel(){
        if(dragInListModel ==null){
            dragInListModel = new DefaultListModel();
        }
        return dragInListModel;
    } 

//��dragOutList ���ϳ����� 
    public JList getDragOutList() {
        if (dragOutList == null) {
            dragOutList = new JList();
            dragOutList.setTransferHandler(new TransferHandler() {
                @Override
                public int getSourceActions(JComponent c) {
                    if (c == dragOutList) {
                        return TransferHandler.COPY;
                    }
                    return super.getSourceActions(c);
                }
               //�����ϳ�����
                @Override
                protected Transferable createTransferable(JComponent c) {
                    if (c == dragOutList) {
                        String name = "data";
                        TransferableParameter parameter = new TransferableParameter(dragOutList,name);
                        return parameter;
                    }
                    return super.createTransferable(c);
                }
            });
        }
        return dragOutList;
    }
    class TransferableParameter implements Transferable {
        protected  String localParameterType = DataFlavor.javaJVMLocalObjectMimeType + ";class=com.angelman.framework.workspace.ProjectTreeReportItemParameter";
        public  DataFlavor localParameterFlavor = null;
        private DataFlavor[] columnFlavors = new DataFlavor[] { localParameterFlavor };

        private JComponent sourceComponent = null;
        private Object data = null;
        public TransferableParameter(JComponent sourceComponent,Object data) {
            this.sourceComponent = sourceComponent;
            this.data = data;
            try {
                localParameterFlavor = new DataFlavor(localParameterType);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public JComponent getSourceComponent() {
            return sourceComponent;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setSourceComponent(JComponent sourceComponent) {
            this.sourceComponent = sourceComponent;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (isDataFlavorSupported(flavor)) {
                return this;
            }
            return null;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return columnFlavors;
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            if (flavor == null) {
                return false;
            }
            return localParameterFlavor.equals(flavor);
        }

    }
} 


