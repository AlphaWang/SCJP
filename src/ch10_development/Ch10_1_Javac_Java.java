/**
 * <p>文件名称: Ch10_1_Javac_Java.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2001-2004</p>
 * <p>公    司: 深圳市中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2011-3-25</p>
 * <p>完成日期：2011-3-25</p>
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
package ch10_development;

import java.util.Properties;

public class Ch10_1_Javac_Java {

	public static void main(String[] args) {
		/**
		 * 1. javac
		 * 
		 * javac -d path *.java
		 * javac -d ../target ch10_development/Ch10_1_Javac_Java.java
		 * 
		 * 
		 * 可以指定class文件输出的路径。如果目录不存在，则编译报错
		 */
		
		
		/**
		 * 2. java
		 * 
		 * java -D属性="属性值" class
		 * java -DmyProp=myValue Ch10_1_Javac_Java
		 * ———— -D用于设置系统属性
		 * 
		 */
		Properties p = System.getProperties();
		p.setProperty("==myProperties1", "myValue1");
		p.list(System.out);
		
		System.out.println("自定义的属性值："+p.getProperty("==myProperties1"));
		
		/**
		 * 
		 * 3. 查找其他类
		 * 
		 * 首选查找 java标准类库
		 * 次要超找 类路径
		 * 
		 * 有两个地方可以声明类路径
		 * 1)操作系统环境变量
		 * 2)javac/java命令中的参数：-classpath 
		 * 
		 * 类路径中如果包含jar，必须指定jar的文件名
		 */

	}

}
