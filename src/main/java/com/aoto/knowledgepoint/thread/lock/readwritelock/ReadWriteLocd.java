package com.aoto.knowledgepoint.thread.lock.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 读写锁
 * 1）读写锁的实现类：ReenTrantReadWriteLock
 * 2)采用读写分离机制，分为读锁和写锁
 * 3）高并发下读多写少时，性能优于ReenTrantLock
 * 4）读读共享（不会加锁，不会互斥）  写写互斥   读写互斥
 * @author Administrator
 *
 */
public class ReadWriteLocd {
	
	//定义一个读写锁
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	
	//分别获取读写锁的读锁和写锁
	
	private ReadLock readLock = reentrantReadWriteLock.readLock();
	private WriteLock writeLock = reentrantReadWriteLock.writeLock();
	
	public void read(){
		try {
			readLock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"read 进入");
			Thread.sleep(3000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"read 退出");
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			readLock.unlock();
		}
		
	}
	
	public void write(){
		try {
			writeLock.lock();
			System.out.println("当前线程："+Thread.currentThread().getName()+"write 进入");
			Thread.sleep(3000);
			System.out.println("当前线程："+Thread.currentThread().getName()+"write 退出");
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			writeLock.unlock();
		}
		
	}
	
	
	public static void main(String[] args) {
		final ReadWriteLocd  readWriteLocd = new ReadWriteLocd();
		
		//线程1执行读
		Thread t1 = new Thread(new  Runnable() {
			public void run() {
				readWriteLocd.read();
			}
		},"t1");
		
		//线程2执行读
				Thread t2 = new Thread(new  Runnable() {
					public void run() {
						readWriteLocd.read();
					}
				},"t2");
				
				//线程3执行写
				Thread t3 = new Thread(new  Runnable() {
					public void run() {
						readWriteLocd.write();
					}
				},"t3");
				
				//线程4执行写
				Thread t4 = new Thread(new  Runnable() {
					public void run() {
						readWriteLocd.write();
					}
				},"t4");
				
				
				//开始测试：读读，都能获得锁，并发执行
//				t1.start();
//				t2.start();
				
				//开始测试：读写互斥，不能并发执行
//				t1.start();
//				t3.start();
				
				//开始测试：写写互斥，不能并发执行
				t3.start();
				t4.start();
				
	}
}
