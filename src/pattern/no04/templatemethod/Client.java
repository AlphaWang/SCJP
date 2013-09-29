/**
 * <p>�ļ�����: Client.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-9-7</p>
 * <p>������ڣ�2011-9-7</p>
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
package pattern.no04.templatemethod;

public class Client {
	public static void main(String[] args){
		/**
		 * ģ�巽��ģʽ - Template Method Pattern
		 * 
		 * Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
		 * Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
		 */
		
		/**
		 * �ŵ㣺
		 * 1. ��ס���䲿�֣�ģ�巽��������չ�ɱ䲿�֣�����������
		 * 2. ��ȡ�������ִ��루ģ�巽����������ά��
		 * 3. ��Ϊ�ɸ�����ƣ�����ʵ��
		 * �������������ͨ�����ӷ��� Ӱ��ģ�巽����ִ�н������AbstractModel.isAlarm()
		 * 
		 * ȱ�㣺
		 * 1. �����ִ�н��Ӱ���˸���Ľ�����ɶ��Խ���
		 */
		
		/**
		 * ʹ�ó�����
		 * 1. ��������й��еķ��������ҷ����߼�������ͬʱ
		 * 2. ����Ҫ�ġ����ӵ��㷨ʱ���ɰѺ����㷨���Ϊģ�巽��
		 */
		Hummer1Model h1 = new Hummer1Model();
		h1.run();
		
		String s = "1,2,3,4,5";
		System.out.println(s.length() +":" +s.charAt(s.length()-1));
		
		String nri =   "03ff000000000000";
		String str = nri.substring(0, 4);
		Integer shownum = Integer.parseInt(str,16);
		System.out.println(shownum);
		
		System.out.println(Integer.toHexString(1023));
		
		//��nriת�������ݿ�ֵ
		nri="";
    	//��nriת�������ݿ�ֵ
    	String oneNriStr = Integer.toHexString(Integer.parseInt("1023"));
    	for(int len = oneNriStr.length(); len < 4; len ++){
    		oneNriStr = "0" + oneNriStr;
    	}
    	int nrinum = 0;
    	for(int i = 0; i < nrinum; i++ ){
    		nri = nri + oneNriStr;
    	}
    	for(int j = nrinum; j < 4; j++){
    		nri = nri + "0000";
    	}
    	System.out.println(nri);
		
    	System.out.println(Math.pow(2, 23));
    	
    	String value = "0";
		long longValue = Long.parseLong("254");
		String binValue = Long.toBinaryString(longValue);
		char c = binValue.charAt(binValue.length()-1);
		value = String.valueOf(c);
		System.out.println(value);
		
		long l = 8888888889999999L;
		float l2 = 54e23F;
		
		byte a = 2;
		byte b = 3;
		byte c1 = (byte) (a * b);
		
		int i = 0, j=9 , k = j + 1;
	}
}
