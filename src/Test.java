import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



/**
 * <p>文件名称: Test.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-12-31</p>
 * <p>完成日期：2011-12-31</p>
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



public class Test {
	public String convertFrmOsfToWsf(String fieldName, String fieldValue) {
		String value = "0";
		int index = fieldName.toUpperCase().lastIndexOf("BIT");
		if(index >= 0){
			String bitnumStr = fieldName.substring(index + 3, fieldName.length());
			String[] ind = bitnumStr.split("-");
			String binValue = Long.toBinaryString(Long.parseLong(fieldValue));
			Integer length = binValue.length();
			
			if(ind != null && ind.length >= 2){
				int start = Integer.parseInt(ind[0]);
				int stop = Integer.parseInt(ind[1]);
				if(start > stop){
					return value;
				}				
				
				if(length < (stop + 1)){
					for(int i = length; i < stop + 1; i ++){
						binValue = "0" + binValue;
					}
				}
				
				String tmp = binValue.substring(binValue.length() - (stop+1), binValue.length() - start );	
				value = String.valueOf(Long.parseLong(tmp, 2));
				
			}else if (ind != null && ind.length == 1){
				int bitnum = Integer.parseInt(ind[0]);				
				if(binValue.length() >= (bitnum + 1) ){
					char c = binValue.charAt(binValue.length()- (bitnum + 1));
					value = String.valueOf(c);
				}	
			}			
		}				
		return value;
	}
	public static void main(String[] args){
		System.out.println("cast null: "+(String)null);
	    //System.out.println("test".compareTo(null));
		
		//System.out.println(new Test().convertFrmOsfToWsf("TEST_BIT4","28"));
		
		//Pattern p = new Pattern();
		String s = "0102";
		int l =s.length();
		System.out.println(s.matches("[01]+")  );
		System.out.println( 255 << 8 );
		System.out.println( 255 * 256 );
		
		System.out.println( (4512014 & 16711680) >> 16 );
		System.out.println( (4512014 & 16711680) / 65536  );
		
		System.out.println( (512 * 512) >> 8 );
		System.out.println( 512 * 512 / 256  );
		System.out.println( 1237754978 %(5124111 - 4075536) +  4075536);
		
		double d = 2.1;
		int i = 3;
		double d2 = Double.parseDouble("3");
		System.out.println( d2 - d );
	
	
		//String.valueOf(char[]) String.valueOf(Object)对同一对象返回结果不同！！
		Object o1 = new char[]{'a','b'};
		char[] o2 = new char[]{'a','b'};
		System.out.println( String.valueOf(o1));
		System.out.println( String.valueOf(o2));
		
		//float double计算不精确
		System.out.println( 1.03 - 0.42); //0.6100000000000001
		System.out.println( 1 - 0.9);     //0.09999999999999998
		
		MathContext context = new MathContext(2);
		BigDecimal big1 = new BigDecimal(1.03, MathContext.DECIMAL32);
		BigDecimal big2 = new BigDecimal(0.42, MathContext.DECIMAL32);
		System.out.println( big1.scale() );
		System.out.println( big2.scale() );
		//未设MathContext时：	0.610000000000000042188474935755948536098003387451171875
		//MathContext.DECIMAL32:0.6100000
		System.out.println( big1.subtract(big2)); 
		
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		
		System.out.println(System.getProperty("java.class.path"));
		Test test = new Test();
		ClassLoader loader = test.getClass().getClassLoader();//AppClassLoader
		ClassLoader loaderP = loader.getParent();   //ExtClassLoader
		ClassLoader loaderPP = loaderP.getParent(); //null
		System.out.println(loader);
		System.out.println(loaderP);
		
		try {
			Class c = Class.forName("Test2");
			ClassLoader loader2 = c.getClassLoader();//AppClassLoader
			System.out.println(loader2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Arrays.toString(e.getStackTrace()));
		}
		
		
		Map<String, String> nameMap = new HashMap<String, String>();
		nameMap.put("key1", "v1");
		nameMap.put("key2", "v2");
		System.out.println(nameMap.get(null));
		System.out.println(nameMap.get("key2"));
		System.out.println(nameMap.get("key3"));
		
		String s1 = "\r";
		String s2 = s1.trim();
		System.out.println(s2);
	}
}
