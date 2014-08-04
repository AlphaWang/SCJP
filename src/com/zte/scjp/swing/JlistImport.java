/**
 * <p>文件名称: JListImport.java </p>
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
 Jlist中拖出，则该JList  setTransferHandler(new TransferHandler(){ 

    @Override
   public int getSourceActions(JComponent c){ 

    } 


    @Override 

   protected Transferable createTransferable(JComponent c){ 
    }
} ): 

拖入到 dragInList中 则 dragInLis. setTransferHandler(new TransferHandler(){ 
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

    //拖入数据到 dragInList 
    public JList getDragInList() {
        if (dragInList == null) {
            dragInList = new JList();
            dragInList.setModel(getDragInListModel());
            dragInList.setTransferHandler(new TransferHandler() {
                //重置数据导入方法
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
                //判断能否拖入数据，如从 dragOutList 中拖出的，则可以拖入到 dragInList 中 
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

//从dragOutList 中拖出数据 
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
               //创建拖出数据
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


