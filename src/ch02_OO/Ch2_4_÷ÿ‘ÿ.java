/**
 * <p>�ļ�����: Ch2_4_����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2010-10-20</p>
 * <p>������ڣ�2010-10-20</p>
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
package ch02_OO;

public class Ch2_4_���� 
{
	/**
	 *  1. ���ط�������ı�����б�
	 *  
	 * ���ص�var-arg���� ������ѡ��
	 * ����is a Object��
	 */
	
	public String eat(String s){
		return s;
	}
	//*** !!! �Զ�װ��Ĳ�����Ҳ��Ϊ�Ǹı��˲����б�
	public String eat(int i){
		return "eat(int i)";
	}
	public String eat(Integer j){
		return "eat(Integer j)";
	}
	public String eat(int i,int j){
		return "eat(int i,int j) ";
	}
	//*** var-arg��Ҳ��Ϊ�ı��˲����б� ��������
	public String eat(int... is){
		return "eat(int... is)";
	}
	// �ظ���������int... is	
//	public String eat(int[] is){
//		return "eat(int[] is)";
//	}
	
	
	//�������͵�var-arg����
	public String  eat(int[]... is){
		return "eat(int[]... is)";
	}
	public String eat(int[] i, int[] j){
		return "eat(int[] i, int[]j)";
	}
	/**
	 *  String[] ��String... �ظ�����������
	 */
	/*
	public String  eat(String[] is)
	{
		return "eat(String[] is)";
	}
	*/
	
	/*
	public String  eat(String... is)
	{
		return "eat(String... is)";
	}*/
	public String  eat(String[]... is){
		return "eat(String[]... is)";
	}
	public String eat(String[] i, String[] j){
		return "eat(String[] i, String[]j)";
	}
	
	public String eat(Object o){
		return "eat(Object o)";
	}
	/**
	 *  2. �����б�Ϊ����/���������������Ҳ������
	 *     ����ʱ��������Ϊ�������� ������󣬵��ø��෽��
	 */
	public void method(Parent1 p){
		System.out.println(p.getClass()+", �����б�=Parent");
	}
	public void method(Child1 c){
		System.out.println(c.getClass()+", �����б�=Child");
	}
	public static void main(String[] args)
	{
		Ch2_4_���� o = new Ch2_4_����();
		System.out.println("o.eat(2)\t: "+o.eat(2));		//eat(int i)
		System.out.println("o.eat(new Integer(2))\t: "+o.eat(new Integer(2)));//eat(Integer j)
		System.out.println("o.eat(1,2)\t:"+o.eat(1,2));		//eat(int i,int j) 
		System.out.println("o.eat(1,2,3)\t:"+o.eat(1,2,3));	//eat(int... is)
		/**
		 * ����Ϊint[]�� ����eat(int... )
		 *              ����eat(int[]... )
		 */
		System.out.println("o.eat(new int[]{1,2})\t:"+o.eat(new int[]{1,2})); //eat(int... is)
		/**
		 * ����Ϊint[],int[]������eat(int[], int[])
		 *                    ����eat(int[]... )
		 */
		System.out.println("o.eat(new int[]{1,2},new int[]{1,2})\t:"+o.eat(new int[]{1,2},new int[]{1,2}));//eat(int[] i, int[]j)
		/**
		 * ����ΪString[]������eat(Object )��eat(String... is)
		 *                 ������eat(String[]... )����
		 *                 
		 * ��������һ�㣬���ص�var-arg���� ������ѡ������is a Object��
		 */
		System.out.println("o.eat(new String[]{\"a\",\"b\"})\t:"+o.eat(new String[]{"a","b"}));//eat(Object o)
		
		
		System.out.println("------------------");
		/**
		 * 3. ѡ������ĸ����ط�����������������ʱ��̬������!!!!
		 */
		Parent1 pp = new Parent1();
		Parent1 pc = new Child1();
		Child1 cc = new Child1();
		o.method(pp);//����ΪParent
		o.method(pc);//����ΪParent����
		o.method(cc);//����ΪChild
		
		
		System.out.println("------------------");
		//���Զ�̬ �����ص�Ӱ��		
		pp.methodP();//���ø��෽��
		pc.methodP();//����������д����
		
		//�¾䲻�Ϸ������ǽ���ǿ��ת��
		//// pc.methodC()
		if(pc instanceof Child1){
			Child1 c = (Child1)pc;
			c.methodC();//�������෽��
		}
		
		cc.methodP();
		cc.methodC("Test");
		cc.methodC();
	}
	

}

class Parent1
{
	public void methodP(){
		System.out.println("����methodP����");
	}
}
class Child1 extends Parent1
{
	public void methodC(){
		System.out.println("����methodC()���ط���");
	}
	public void methodC(String s){
		System.out.println("����methodC(String)���ط��� "+s);
	}
	@Override
	public void methodP(){
		System.out.println("������дmethodP����");
	}
}
