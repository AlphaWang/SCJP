/**
 * <p>�ļ�����: Ch8_6_InheritInner.java </p>
 * <p>�ļ�����: ��</p>
 * <p>��Ȩ����: ��Ȩ����(C)2001-2004</p>
 * <p>��    ˾: ����������ͨѶ�ɷ����޹�˾</p>
 * <p>����ժҪ: ��</p>
 * <p>����˵��: ��</p>
 * <p>�������ڣ�2011-12-27</p>
 * <p>������ڣ�2011-12-27</p>
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
package ch08_inner_class;

class OuterSuper{
	class Inner{
		void innerMethod(){
			System.out.println("ԭʼinnerMethod(): by outer "+OuterSuper.this.getClass().getSimpleName());
		}
		Inner(String name ){
			System.out.println("OuterSuper.Inner():" + name);
		}
		Inner(){
			System.out.println("OuterSuper.Inner()" );
		}
	}
	
	OuterSuper(String name){
		System.out.println("OuterSuper():" + name);
		Inner inner = new Inner(name); //�����������ᱻ���أ�
		inner.innerMethod();
	}

}

/**
 * �ڲ���ļ̳�
 *
 */
class InheritInner extends OuterSuper.Inner{

	/**
	 * 1. �����д���췽����������Ĭ�Ϲ��췽����
	 * No enclosing instance of type Outer is available due to some intermediate constructor invocation
	 */
	//// InheritInner(){ }
	
	/**
	 * 2. ���췽���У����ø���Ĺ��췽�� ��������Inner�ģ�
	 */
	InheritInner(OuterSuper outer){
		outer.super();
	}
	InheritInner(OuterSuper outer, String name){
		outer.super(name); 
	}
	
	//Type mismatch: cannot convert from Outer.Inner to OuterSuper
//	InheritInner(Outer.Inner inner){
//		inner.super();
//	}
}

/**
 * 
 * �ڲ���ĸ��ǣ����أ�
 *
 * InheritOuter.Inner��OuterSuper.Inner����ȫ����������ʵ�壬��������
 */
class InheritOuter1 extends OuterSuper{
	class Inner{ 
		void innerMethod(){
			System.out.println("InheritOuter.innerMethod(): by outer "+InheritOuter1.this.getClass().getSimpleName());
		}
		Inner(String name ){
			System.out.println("InheritOuter.Inner():" + name);
		}
		Inner(){
			System.out.println("InheritOuter.Inner()" );
		}
	}

	InheritOuter1(String name) {
		//�����OuterSuper���췽�����������е��õ�Inner��OuterSuper.Inner��������û������
		super(name); 
		
		//������õ�Inner��InheritOuter.Inner 
		Inner inner = new Inner(name);
		inner.innerMethod();
	}
}
/**
 * OuterSuper.Inner���Ա��̳�����������
 *
 */
class InheritOuter2 extends OuterSuper{
	InheritOuter2(String name) {
		super(name);
		Inner inner = new Inner(name); 
		inner.innerMethod();
	}
}

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////


/**
 * 
 *
 */
class InheritOuter11 extends OuterSuper{
	class Inner extends OuterSuper.Inner{ 
		void innerMethod(){
			System.out.println("InheritOuter3.innerMethod(): by outer "+InheritOuter11.this.getClass().getSimpleName());
		}
		Inner(String name ){//���Զ�����super()
			System.out.println("InheritOuter3.Inner():" + name);
		}
		Inner(){
			System.out.println("InheritOuter3.Inner()" );
		}
	}
	InheritOuter11(String name) {
		super(name);
		Inner inner = new Inner(name); 
		inner.innerMethod();
	}
}

public class Ch8_6_InheritInner {
	public static void main(String[] args){
		System.out.println("=================new OuterSuper()" );
		OuterSuper outer = new OuterSuper(" outer ");
		
		System.out.println("=================new InheritInner()" );
		InheritInner inheritInner = new InheritInner(outer, "inheritInner");
		
		System.out.println("=================new InheritOuter()1" );
		InheritOuter1 inheritOuter = new InheritOuter1("inheritOuter");
		
		System.out.println("=================new InheritOuter2()" );
		InheritOuter2 inheritOuter2 = new InheritOuter2("inheritOuter2");
		
		System.out.println("=================new InheritOuter11()" );
		InheritOuter11 inheritOuter3 = new InheritOuter11("inheritOuter2");
		
	}
	
}
