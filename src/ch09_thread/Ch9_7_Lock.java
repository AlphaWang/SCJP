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
        
        //写入
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
        //读取
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
 * 1、不同步
 * 
 * 可能读到脏数据！
 */
class Data {      
    private int data;// 共享数据      
    public void set(int data) {  
        System.out.println(Thread.currentThread().getName() + "准备写入数据");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        this.data = data;  
        System.out.println(Thread.currentThread().getName() + "写入" + this.data);  
    }     
    public void get() {  
        System.out.println(Thread.currentThread().getName() + "准备读取数据");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName() + "读取" + this.data);  
    }  
}  

/**
 * 2、synchronized同步
 *
 * 各个线程都互斥； 
 * 但读取线程之间也是互斥的————这是不必要的
 */
class syncData {      
    private int data;// 共享数据      
    public synchronized void set(int data) {  
        System.out.println(Thread.currentThread().getName() + "准备写入数据");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        this.data = data;  
        System.out.println(Thread.currentThread().getName() + "写入" + this.data);  
    }     
    public synchronized  void get() {  
        System.out.println(Thread.currentThread().getName() + "准备读取数据");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName() + "读取" + this.data);  
    }  
}  

/**
 * 3、 Lock同步
 *
 * 读写互斥，但读线程之间不互斥！
 */
class RwLockData {      
    private int data;// 共享数据  
    
    private ReadWriteLock rwl = new ReentrantReadWriteLock();     
    public void set(int data) {  
        rwl.writeLock().lock();// 取到写锁  
        try {  
            System.out.println(Thread.currentThread().getName() + "准备写入数据");  
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            this.data = data;  
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);  
        } finally {  
            rwl.writeLock().unlock();// 释放写锁  
        }  
    }     
    public void get() {  
        rwl.readLock().lock();// 取到读锁  
        try {  
            System.out.println(Thread.currentThread().getName() + "准备读取数据");  
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println(Thread.currentThread().getName() + "读取" + this.data);  
        } finally {  
            rwl.readLock().unlock();// 释放读锁  
        }  
    }  
}  