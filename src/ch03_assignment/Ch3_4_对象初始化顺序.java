/**
 * <p>文件名称: Ch3_4_对象初始化顺序.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-12-29</p>
 * <p>完成日期：2010-12-29</p>
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
package ch03_assignment;

public class Ch3_4_对象初始化顺序 {
	/**
	 * 
1．  父类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行 

2．  子类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行 

3．  父类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行 
4．  父类构造方法 super()

5．  子类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行 
6．  子类构造方法 
	 */
	public static void main(String[] args)
	{
		new SubClass();
	}

}

class Parent {    
    // 静态变量    
    public static String p_StaticField = "父类--静态变量";    
    // 变量    
    public String p_Field = "父类--变量";    
   
    // 静态初始化块    
    static {    
        System.out.println(p_StaticField);    
        System.out.println("父类--静态初始化块");    
        System.out.println(); 
    }    
   
    // 初始化块    
    {    
        System.out.println(p_Field);    
        System.out.println("父类--实例初始化块");  
        System.out.println(); 
    }    
   
    // 构造器    
    public Parent() {    
        System.out.println("父类--构造器Parent()");   
        System.out.println(); 
    }    
}    
   
class SubClass extends Parent {    
    // 静态变量    
    public static String s_StaticField = "子类--静态变量";    
    // 变量    
    public String s_Field = "子类--变量";    
    // 静态初始化块    
    static {    
        System.out.println(s_StaticField);    
        System.out.println("子类--静态初始化块");  
        System.out.println(); 
    }    
    // 初始化块    
    {    
        System.out.println(s_Field);    
        System.out.println("子类--实例初始化块");  
        System.out.println(); 
    }    
   
    // 构造器    
    public SubClass() {    
        System.out.println("子类--构造器SubClass()");  
        System.out.println(); 
    }    

}   
