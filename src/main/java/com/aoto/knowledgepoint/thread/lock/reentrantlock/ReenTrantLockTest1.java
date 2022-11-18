package com.aoto.knowledgepoint.thread.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一章：重入锁（ReenTrantLock）
 * 1、重入锁说明：
 *    1）重入锁是为了解决在一个方法（方法一）获得锁后，执行这个方法的过程中，又调用了另外一个方法（方法二），而方法二
 *      又需要获得锁才能执行。那么久变成了这么一种情况：方法一获得锁，在调用方法二时，方法二要等方法一释放锁后才行，
 *      但是方法一没有执行完方法二，就无法释放锁，这就造成了死锁的情况。重入锁就是为了解决这个问题（其实是通过获取锁
 *      计数的方式）
 *    2）重入锁的条件：可以通过重入锁设置多个条件对象，条件对象调用wait方法，让线程处于等待状态（此时释放锁），然后通过条件对象的notity
 *       方法，唤醒这个条件的线程（一个），即通过锁的条件对象实现线程等待和线程唤醒。
 *       
 *    3）尝试获取锁：尝试获取锁的方法返回true或者false.
 *    4）重入锁的公平性：在定义重入锁的时候，可以设置冲入锁是否公平。
 *    5）查看重入锁的次数：只能在当前线程中使用，查看这个获得锁的线程，重入了多少次。
 *    6）查看线程是否获得锁：查看线程是否获得锁
 *    7）
 * @author Administrator
 *
 */
public class ReenTrantLockTest1 {
	
	//定义一个重入锁
	private Lock lock = new ReentrantLock(false);
	
	//获得锁，然后执行代码，最后释放锁
	public void run1(){
		try {
			//加锁
			lock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入run1方法");
			Thread.sleep(1000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"退出run1方法");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();//执行完成释放锁
		}
	}
	
	public void run2(){
		try {
			//加锁
			lock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"进入run2方法");
			Thread.sleep(2000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"退出run2方法");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock.unlock();//执行完成释放锁
		}
	}
	
	public static void main(String[] args) {
		final ReenTrantLockTest1 reenTrantLockTest1 = new ReenTrantLockTest1();
		
		//由于ReenTrantLockTest1对象的run1和run2方法时加了锁的，所以当两个线程分别执行这两个方法时，哪个得到锁
		//哪个就会先执行，释放锁以后另一个方法才会执行，看到的顺序就一个方法执行完，才会执行另一个方法，不会之间交替执行。
		//如果哪个方法不释放锁，那么第二个线程运行方法的时候就用于执行不了
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				reenTrantLockTest1.run1();
			}
		},"t1");
		
        Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				reenTrantLockTest1.run2();
			}
		},"t2");
        
        t1.start();
        t2.start();
	}

}
