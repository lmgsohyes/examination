package com.aoto.knowledgepoint.thread.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第二章：重入锁的线程间的通讯（condit的wait和notify方法） 1）通过重入锁获得conditon条件对象，可以获取多个。
 * 2）通过conditon对象调用await方法让线程进入等待，释放锁。
 * 3）其他线程通过condition调用signal（notify）或者signalAll(notifyall)方法唤醒这个条件上面等待的线程。 说明：一个锁可以有多个条件
 * 
 * @author Administrator
 *
 */
public class ReenTrantLockConditionTest {
	// 定义一个重入锁
	private Lock lock = new ReentrantLock(false);
	
	//创建这个重入锁的条件(条件是属于某一把锁的)
	private Condition condition = lock.newCondition();
	
	

	// 获得锁，然后执行代码，最后释放锁
	public void run1() {
		try {
			// 加锁
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入run1方法");
			Thread.sleep(1000);
			System.out.println("当前线程：" + Thread.currentThread().getName() + "释放锁进入等待状态");
			condition.await(); //进入等待状态，同时释放锁
			System.out.println("当前线程：" + Thread.currentThread().getName() + "退出run1方法");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();// 执行完成释放锁
		}
	}
	
	// 获得锁，然后执行代码，最后释放锁
		public void run2() {
			try {
				// 加锁
				lock.lock();
				System.out.println("当前线程：" + Thread.currentThread().getName() + "进入run2方法");
				Thread.sleep(2000);
				System.out.println("当前线程：" + Thread.currentThread().getName() + "释放锁进入等待状态");
				condition.signal(); //发出唤醒通知,但此时没有释放锁，方法二还会继续执行
				Thread.sleep(2000);
				System.out.println("当前线程：" + Thread.currentThread().getName() + "退出run2方法");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();// 执行完成释放锁
			}
		}
		
		public static void main(String[] args) {
			final ReenTrantLockConditionTest reenTrantLockTest1 = new ReenTrantLockConditionTest();
			
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
	        t1.setPriority(10);
	        t2.start();
	        t2.setPriority(1);
		}
}
