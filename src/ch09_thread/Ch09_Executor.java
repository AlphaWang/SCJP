//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2013
//             A G F A - G E V A E R T  G R O U P
//                    All Rights Reserved
/////////////////////////////////////////////////////////////////
//
//       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                    Agfa-Gevaert Group
//      The copyright notice above does not evidence any
//     actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//
//
package ch09_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Ch09_Executor {
	
	private static void run(ExecutorService threadPool) {
		for(int i = 1; i < 5; i++) {  
            final int taskID = i;  
            threadPool.execute(new Runnable() {  
                @Override
				public void run() {  
                    for(int i = 1; i < 5; i++) {  
                        try {  
                            Thread.sleep(20);// Ϊ�˲��Գ�Ч������ÿ������ִ�ж���Ҫһ��ʱ��  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                        System.out.println("��" + taskID + "������ĵ�" + i + "��ִ��");  
                    }  
                }  
            });  
        }  
        threadPool.shutdown();// ����ִ����ϣ��ر��̳߳�  
	}
	
	public static void main(String[] args) {
		// ������������3���̵߳��̳߳�
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		
		// �̳߳صĴ�С�����ִ�е���������̬����
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		
		// ���������̵߳��̳߳أ������ǰ�߳���ִ������ʱͻȻ�жϣ���ᴴ��һ���µ��߳����������ִ������  
	    ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		
	    // Ч��������Timer��ʱ��
	    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
	    
//	    run(fixedThreadPool);
//	    run(cachedThreadPool);
//	    run(singleThreadPool);
	    run(scheduledThreadPool);
	}

}
