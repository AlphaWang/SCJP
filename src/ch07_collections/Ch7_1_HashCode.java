/**
 * <p>�ļ�����: Ch7_1_HashCode.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-2-17</p>
 * <p>������ڣ�2011-2-17</p>
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
package ch07_collections;

public class Ch7_1_HashCode {
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * 1. equals()
	 * 
	 * 	ΪʲôҪ��дequals():
	 *   �������д���Ͳ��ܽ��ö���������ϣ���еļ�����Ϊ��ͬ����equals�϶�ΪF
	 *   ��дequals(),��Ϊ��������ͬ���� �ܹ�����Ϊ��ͬ
	 *   
	 *   equals()��Լ
	 *   1) �Է���
	 *   2) �Գ���
	 *   3) ������
	 *   4) һ����
	 *   5) equals(null)����F
	 */
	public boolean equals(Object o ){
		if(o instanceof Ch7_1_HashCode &&
		   ((Ch7_1_HashCode)o).getSize() == this.getSize())
		{
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 2.hashCode()
	 * 
	 * �������������equals()�ģ������Ǳ��������ͬ�Ĺ�ϣ��ֵ
	 * 
	 * Ĭ�ϵ�hashCode()��Ϊÿ���������һ��Ψһ��
	 * 
	 * hashCode�뼯�ϣ�
	 * a)���룺����������ϣ��ļ�����ʱ���ü�������hashCode()���жϸö��������ĸ�Ͱ�ڡ�������Ϊ����߲����ٶȣ�
	 * b)���ң��ӹ�ϣ��ļ����в��Ҷ���ʱ��ͨ��hashCode()�ҵ���ȷ��Ͱ��Ȼ��ʹ��equals()��Ͱ�ڲ�����ȷ��Ԫ��
	 * 
	 * �õ�hash�㷨���ܵõ�������Ͱ�ڵĹ㷺����ֲ�����������equals�Ķ��� ������ͬ��hashCode
	 * ���hash�㷨��ÿ�������ϣ�붼��ͬ�����������ж���λ��һ��Ͱ
	 * 
	 * hashCode�����л���
	 * hashCode()��ʹ��transient�����ǺϷ��ģ����ǲ����ʣ�����
	 * ��Ϊͬһ���������л���hashCode���ܻ�ı�
	 * �����������һ��������transient�ģ���Ҫ�������ж϶���Ĺ�ϣ��������
	 */
	@Override
	public int hashCode() 
	{
		return   this.getSize() * 1000 ;

	}

	public static void main(String[] args) 
	{
		
		

	}

	

}
