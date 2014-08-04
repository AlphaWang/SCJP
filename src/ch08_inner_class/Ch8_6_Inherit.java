/**
 * <p>�ļ�����: Ch8_6_Inherit.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-27</p>
 * <p>������ڣ�2011-12-27</p>
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
package ch08_inner_class;


class Egg{
	protected Yolk yolk = new Yolk();
	protected class Yolk{
		public Yolk(){
			System.out.println("Egg.Yolk()");
		}
		public void methodYolk(){
			System.out.println("Egg.Yolk.method()");
		}
	}
	
	public Egg(Yolk y){
		System.out.println("Egg(Yolk)");
		yolk = y;
	}
	public Egg(){
		System.out.println("Egg()");
	}
	public void setYolk(Yolk y){
		yolk = y;
	}
	public void methodEgg(){
		yolk.methodYolk();
	}
}
/**
 * ��չ���࣬���¶����ڲ��࣬������չ�ڲ���
 * 
 * �����������ڲ���BigEgg.Yolk ��Egg.Yolk �Ƕ����ģ�
 */
class BigEgg extends Egg{
	
	public BigEgg(Yolk y) {//�����Yolk�������е�BigEgg.Yolk������super(y)�������The constructor Egg(BigEgg.Yolk) is undefined
		//// super(y);     //����Ĳ���ֻ���Ǹ����Egg.Yolk
		
		super(new Egg(null).new Yolk());
		System.out.println("BigEgg(Yolk)");
	}
	public BigEgg(){
		System.out.println("BigEgg()");
	}

	public class Yolk{ //��������
		public Yolk(){
			System.out.println("BigEgg.Yolk()");
		}
	}
}
/**
 * ��չ���࣬ͬʱ��չ�ڲ��� 
 *
 * BigEgg2.Yolk��Egg.Yolk���࣬������
 */
class BigEgg2 extends Egg{
	
	public class Yolk extends Egg.Yolk{
		public Yolk(){
			System.out.println("BigEgg2.Yolk()");
		}
		public void methodYolk(){
			System.out.println("BigEgg2.Yolk.method()");
		}
	}
	public void methodEgg(){
		yolk.methodYolk();
	}
	public BigEgg2(Yolk y) { //�����Yolk�������е�BigEgg2.Yolk���̳���Egg.Yolk
		super(y);            //����Ĳ���ֻ��ΪEgg.Yolk
		System.out.println("BigEgg2(Yolk)");
	}
	public BigEgg2(){
		System.out.println("BigEgg2()");
	}
}


public class Ch8_6_Inherit {
	public static void main(String[] args){
		
		BigEgg bEgg = new BigEgg();  //������� �����Yolk
		/*
		Egg.Yolk()  --�����Ա��ʼ��
		Egg()       --���๹�췽��
		BigEgg()    --���๹�췽��
		*/
		
		//bEgg.methodEgg();
		
		System.out.println("==================");		
		BigEgg2 bEgg2 = new BigEgg2();
		/*
		Egg.Yolk()  --�����Ա��ʼ��
		Egg()       --���๹�췽��
		BigEgg2()   --���๹�췽��
		 */
		
		System.out.println("==================");
		BigEgg2.Yolk bigYolk = bEgg2.new Yolk();
		/*
		Egg.Yolk()
		BigEgg2.Yolk()
		*/
		bEgg2.setYolk(bigYolk);
		bEgg2.methodEgg();  //���أ����õ���BigEgg2.Yolk.methodYolk()
		/*
		BigEgg2.Yolk.method()
		*/
	}
}


