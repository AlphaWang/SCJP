/**
 * <p>�ļ�����: Ch1_1_�������ڶ�̬����_����.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-12</p>
 * <p>������ڣ�2011-12-12</p>
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

public class Ch1_1_PolyInConstructorSub extends Ch1_1_PolyInConstructor{
	private int radius = 1;
	
	@Override
	void draw(){
		System.out.println("����draw()��radius="+radius);
	}
	
	Ch1_1_PolyInConstructorSub(int r) {
		//super();
		radius = r;
		System.out.println("���๹������draw()֮ǰ");
		
		draw();
		
		System.out.println("���๹������draw()֮��");
	}
	
	
	public static void main(String[] args){
		
		new Ch1_1_PolyInConstructorSub(5);
		/*
		 * output:
		 * 
		 * ���๹������draw()֮ǰ
		 * ����draw()��radius=0                 //�������bug  ////Ϊʲô��0������1�����๹����draw()ʱ��������δ��ʼ��
		 * ���๹������draw()֮��)
		 * 
		 * ���๹������draw()֮ǰ
		 * ����draw()��radius=5
		 * ���๹������draw()֮��
		 */
	}
	

}
