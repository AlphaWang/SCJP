/**
 * <p>�ļ�����: SubClass2.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-9-15</p>
 * <p>������ڣ�2010-9-15</p>
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
package ch01_declaration;


/**
 *  �̳� Ĭ�����е�public����
 *  ������������� �̳и��࣬�����ʧ�ܣ���
 */
//������С����� �ɼ���??
class Test1  extends Ch1_5_�������Ա_�������η�{
	
}

public  class Ch1_5_SubClass2 extends Ch1_5_�������Ա_�������η�{
	public void newMethod()
	{
		Ch1_5_�������Ա_�������η� parent = new Ch1_5_�������Ա_�������η�();
		parent.defaultMethod();			    //���ø����е�default����
		       defaultMethod();			    //�̳и����е�default����
		  this.defaultMethod();
		
		parent.protectedMethod();			//���ø����е�protected����
		       protectedMethod();           //�̳и����е�protected����		       
		  this.protectedMethod();
		  
		parent.finalMethod();
		       finalMethod();
		  this.finalMethod();
		
		int i1 = parent.protectedVar;        //���ø����е�protected����
		int i2 = this.protectedVar;          //�̳и����е�protected����
				
		/**
		 * ���ɵ��ø���private��Ա
		 * ���ɼ̳и���private��Ա
		 */
		//// int j = parent.privateVar;
		//// int k = privateVar;
		
		
	}
	//// ������С���෽���� �ɼ���
	//// Cannot reduce the visibility of the inherited method from Ch1_5_�������Ա_�������η�
	/*
	private void defaultMethod()
	{
		System.out.println("������дdefault����");
	}
	public void protectedMethod()
	{
		System.out.println("������дprotected����");
	}
	*/
	
	
	public static void main(String[] args){
		Ch1_5_SubClass2 subClass2 = new Ch1_5_SubClass2();
		subClass2.newMethod();
		
		int i = subClass2.protectedVar;
		
		//he field Ch1_5_�������Ա_�������η�.privateVar is not visible
		//// int j = subClass2.privateVar;
		
		
	}
	
}