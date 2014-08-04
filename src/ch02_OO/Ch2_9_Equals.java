package ch02_OO;

import java.awt.Color;
import java.sql.Timestamp;
import java.util.Date;

public class Ch2_9_Equals {
	
	public static void main(String[] args){
		Date date = new Date();
		Timestamp stamp = new Timestamp(date.getTime());
		
		System.out.println(date);
		System.out.println(stamp);
		System.out.println(date.equals(stamp)); //true
		System.out.println(stamp.equals(date)); //false
		
		Point p = new Point(1,1);
		ColorPoint cp = new ColorPoint(1, 1, Color.RED);
		ColorPoint1 cp1_1 = new ColorPoint1(1, 1, Color.RED);
		ColorPoint1 cp1_2 = new ColorPoint1(1, 1, Color.BLUE);
		ColorPoint2 cp2_1 = new ColorPoint2(1, 1, Color.RED);
		ColorPoint2 cp2_2 = new ColorPoint2(1, 1, Color.BLUE);		
		
//		System.out.println("测试对称�?);
		testSymmetric(p, cp);
		testSymmetric(p, cp2_1);
		testSymmetric(p, cp2_2);
		testSymmetric(p, cp1_1);
		
		System.out.println("测试传�?�?");
		testTransitive(cp2_1, p, cp2_2);
		testTransitive(cp1_1, p, cp1_2);
		
		ColorPoint3 cp3_1 = new ColorPoint3(1, 1, Color.RED);
		ColorPoint3 cp3_2 = new ColorPoint3(1, 1, Color.BLUE);
		testTransitive(cp3_1, p, cp3_2);

	}
	
	public static void  testSymmetric(Object o1, Object o2){
		String name1 = o1.getClass().getSimpleName();
		String name2 = o2.getClass().getSimpleName();
		System.out.println("----Test Symmetric : " + name1 +" - " +name2); 
		boolean result1 = o1.equals(o2);
		boolean result2 = o2.equals(o1);
		System.out.println(name1+".equals("+name2+") = " + result1); 
		System.out.println(name2+".equals("+name1+") = " + result2); 
		System.out.println(">>Test Symmetric result: " + (result1==result2 ? "YES":"NO")); 
	}
	
	public static void testTransitive(Object o1, Object o2, Object o3){
		String name1 = o1.getClass().getSimpleName();
		String name2 = o2.getClass().getSimpleName();
		String name3 = o3.getClass().getSimpleName();
		System.out.println("----Test Transitive : " + name1 +" - " +name2 + " - "+name3); 
		boolean result1 = o1.equals(o2);
		boolean result2 = o2.equals(o3);
		boolean result3 = o1.equals(o3);
		System.out.println(name1+".equals("+name2+") = " + result1); 
		System.out.println(name2+".equals("+name3+") = " + result2); 
		System.out.println(name1+".equals("+name3+") = " + result3); 
		boolean result=true;
		if((!result1 || !result2) && result3
				|| result1 && result2 && !result3){
			result = false;
		}
		System.out.println(">>Test Transitive result: " + (result ? "YES":"NO")); 
	}

}

class Point{
	private final int x;
	private final int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object o){
		if(o == null || ! (o instanceof Point)){
			return false;
		}
		Point p = (Point) o;
		return p.x == x && p.y == y;
	}
}

/**
 * 继承时，equals()违反对称性示�?
 *
 */
class ColorPoint extends Point{
    private final Color color;
	public ColorPoint(int x, int y, Color c) {
		super(x, y);
		this.color = c;
	}
//	  与父类违反对称�?！！
	@Override
	public boolean equals(Object o){		
		if(!(o instanceof ColorPoint)){
			return false;
		}
		ColorPoint p = (ColorPoint)o;
		return super.equals(p) && p.color == color;
	}	
}
/**
 * 
 * @author axpss
 *
 */
class ColorPoint1 extends Point{
    private final Color color;
	public ColorPoint1(int x, int y, Color c) {
		super(x, y);
		this.color = c;
	}
//	  
	@Override
	public boolean equals(Object o){		
		if(o instanceof ColorPoint1){
			ColorPoint1 p = (ColorPoint1)o;
			return super.equals(p) && p.color.equals(color);
		}
		if(o instanceof Point){ //Point实例
			return super.equals(o);
		}
		return false;
	}	
}
/**
 * 继承时，equals()违反传�?性示�?
 *
 */
class ColorPoint2 extends Point{
    private final Color color;
	public ColorPoint2(int x, int y, Color c) {
		super(x, y);
		this.color = c;
	}
//	  与父类违反对称�?！！
	@Override
	public boolean equals(Object o){	
		if(! (o instanceof Point)){
			return false;
		}
		if(!(o instanceof ColorPoint2)){ //Point实例
			return super.equals(o);
		}
		ColorPoint2 p = (ColorPoint2)o;
		return super.equals(p) && p.color.equals(color);
	}	
}

/**
 * equals()正确示范�?
 * 使用组合，�?不是继承
 *
 */
class ColorPoint3{
	private final Point point;
    private final Color color;
	public ColorPoint3(int x, int y, Color c) {
		point = new Point(x, y);
		this.color = c;
	}
	
	public Point asPoint(){
		return point;
	}
	
	
//	  正确！！
	@Override
	public boolean equals(Object o){	

		if(!(o instanceof ColorPoint3)){
			return false;
		}
		ColorPoint3 p = (ColorPoint3)o;
		//判断两个变量是否相等
		return p.point.equals(point) && p.color.equals(color);
	}	
}
