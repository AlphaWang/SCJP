/**
 * <p>文件名称: Ch3_2_赋值运算符.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2010-11-30</p>
 * <p>完成日期：2010-11-30</p>
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

import java.awt.Dimension;

public class Ch3_2_AssignOperator 
{
	char instanceChar = '\u0000';
	public static void main(String[] args)
	{
		System.out.println("instanceChar:"+new Ch3_2_AssignOperator().instanceChar);
		
	/**
	 * 1. 浮点字面值默认定义为double型(64位)，
	 *    为了将浮点字面值 赋值 给float变量，必须强制转换，或+F
	 *    
	 */
	double d = 23.5;	
	//Type mismatch: cannot convert from double to float
	//// float  f2= 23.5;
	float  f1 = 123.5F;	
	float  f3 = (float)23.5; //强制转换，会丢失左边的所有位(高位)
	System.out.println("123.5F: "+f1);
	System.out.println("(float)23.5: "+f3);
	/**
	 * 2. 强制转换的收缩示例
	 */
	byte b3 = (byte)128;
	System.out.println("(byte)128: "+b3);
	/*
	 * 128 =                                     10 00 00 00
	 *     = 00 00 00 00 00 00 00 00 00 00 00 00 10 00 00 00
	 * 转换后，取最低8位
	 *     = 10 00 00 00
	 * 因为byte是有符号的，所以
	 *     = -128
	 */
	/**
	 * ！！ 3.  +=、-=、*=、/=运算，隐含了强制转换
	 */
	byte b4 = (byte)(0 + 128);//！必须手工强制转换
    b4 += 128;                //！ +=自动强制转换
    
    /**
     * 4. 基本变量 赋值 给另一个基本变量
     */
    int i = 10;
    int j = i; //j和i引用的内存位置不同！
    j = 21;
    System.out.println("i:"+i+" -- j:"+j);
    /**
     * 5. 引用变量 赋值 给另一个引用变量
     */
    Dimension d1 = new Dimension(5,10);
    Dimension d2 = d1; 
    d2.width = 4;//d1、d2引用相同的对象    
    System.out.println("d1:"+d1+" -- d2:"+d2);
    /**
     *   引用变量的例外：String    
     */
    String s1 = "Test";
    String s2 = s1;
    s2.toUpperCase();//并没有改变s2的值！——创建一个新字符串"TEST"，然后又被丢弃
    System.out.println("s1:"+s1+" -- s2:"+s2);
    
	}

}
