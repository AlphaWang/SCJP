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

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Ch9_7_Lock {
	public static void main(String[] args) {  
//        final Data data = new Data();  
//        final syncData data = new syncData();  
        final RwLockData data = new RwLockData();  
        
        //д��
        for (int i = 0; i < 3; i++) {  
            Thread t = new Thread(new Runnable() {  
                @Override
				public void run() {  
                    for (int j = 0; j < 5; j++) {  
                        data.set(new Random().nextInt(30));  
                    }  
                }  
            });
            t.setName("Thread-W" + i);
            t.start();
        }  
        //��ȡ
        for (int i = 0; i < 3; i++) {  
        	Thread t = new Thread(new Runnable() {  
                @Override
				public void run() {  
                    for (int j = 0; j < 5; j++) {  
                        data.get();  
                    }  
                }  
            });  
        	t.setName("Thread-R" + i);
        	t.start();
        }  
    }  
}

/**
 * 1����ͬ��
 * 
 * ���ܶ��������ݣ�
 */
class Data {      
    private int data;// ��������      
    public void set(int data) {  
        System.out.println(Thread.currentThread().getName() + "׼��д������");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        this.data = data;  
        System.out.println(Thread.currentThread().getName() + "д��" + this.data);  
    }     
    public void get() {  
        System.out.println(Thread.currentThread().getName() + "׼����ȡ����");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName() + "��ȡ" + this.data);  
    }  
}  

/**
 * 2��synchronizedͬ��
 *
 * �����̶߳����⣻ 
 * ����ȡ�߳�֮��Ҳ�ǻ���ġ����������ǲ���Ҫ��
 */
class syncData {      
    private int data;// ��������      
    public synchronized void set(int data) {  
        System.out.println(Thread.currentThread().getName() + "׼��д������");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        this.data = data;  
        System.out.println(Thread.currentThread().getName() + "д��" + this.data);  
    }     
    public synchronized  void get() {  
        System.out.println(Thread.currentThread().getName() + "׼����ȡ����");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName() + "��ȡ" + this.data);  
    }  
}  

/**
 * 3�� Lockͬ��
 *
 * ��д���⣬�����߳�֮�䲻���⣡
 */
class RwLockData {      
    private int data;// ��������  
    
    private ReadWriteLock rwl = new ReentrantReadWriteLock();     
    public void set(int data) {  
        rwl.writeLock().lock();// ȡ��д��  
        try {  
            System.out.println(Thread.currentThread().getName() + "׼��д������");  
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            this.data = data;  
            System.out.println(Thread.currentThread().getName() + "д��" + this.data);  
        } finally {  
            rwl.writeLock().unlock();// �ͷ�д��  
        }  
    }     
    public void get() {  
        rwl.readLock().lock();// ȡ������  
        try {  
            System.out.println(Thread.currentThread().getName() + "׼����ȡ����");  
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println(Thread.currentThread().getName() + "��ȡ" + this.data);  
        } finally {  
            rwl.readLock().unlock();// �ͷŶ���  
        }  
    }  
}  