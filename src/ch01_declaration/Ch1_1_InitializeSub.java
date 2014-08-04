/**
 * <p>文件名称: Ch1_1_初始化子类.java </p>
 * <p>创建日期：2011-12-7</p>
 * @version 1.0
 * @author WangZhongXing192063
 */
package ch01_declaration;

public class Ch1_1_InitializeSub extends Ch1_1_Initialize{
	/**
	 * ？？————变量不能被继承?? 这里是新建变量publicVar
	 * 
	 * 域能继承、域不能多态。
	 */
	public String publicVar = "子类publicVar";
	
	
	{
		publicVar = "子类publicVar!";
		System.out.println("子类成员初始化块");
	}
	
	
	Ch1_1_InitializeSub(){
		super("alpha");
		System.out.println("子类构造方法()");
	}
	Ch1_1_InitializeSub(String name){
		// 此行自动添加super()
		System.out.println("子类构造方法(String name)");
		/*
		 * 不可访问父类private变量
		 * ..The field Ch1_1_初始化.name is not visible
		 */
		//// this.name = name;
		//// super.name = name;
		setName(name);
	}
	
	@Override
	void print(){
		System.out.println("子类print() " + getName());
	}
	
	//不能覆盖private方法
	//// @Override
	void privateMethod(){
		System.out.println("子类privateMethod()：" );
	}
	
	public static void main(String[] args){
		Ch1_1_InitializeSub sub1 = new Ch1_1_InitializeSub();
		sub1.print();
		sub1.callPrint1();
		
		System.out.println("----------");
		Ch1_1_Initialize sub2 = new Ch1_1_InitializeSub("beta");//多态
		sub2.print();
		System.out.println("----------");
		sub2.callPrint1(); //被继承后，调用子类的print()
		
		/**
		 * 测试域的继承、多态
		 * 
		 * 子类实际上包含两个称为publicVar的域：一个是自己的，一个是从父类得到的
		 */
		System.out.println("----------");
		System.out.println(sub1.publicVar); //子类publicVar
		System.out.println(sub1.publicVar2);//父类publicVar2   --如果不能被继承，则应报错？                           --域能继承
		System.out.println(sub2.publicVar); //父类publicVar！！ --如果能被继承，则应输出子类publicVar --域不能多态
		System.out.println(sub2.publicVar2);//父类publicVar2
		
		sub1.privateMethod();
		//The method privateMethod() from the type Ch1_1_初始化 is not visible
		//// sub2.privateMethod();
		
	}

}
