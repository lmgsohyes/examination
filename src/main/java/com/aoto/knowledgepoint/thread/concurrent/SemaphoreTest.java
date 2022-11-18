package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 1、并发工具类：Semaphore(信号量许可证集合)
 * 作用：1）发布固定数量的信号量，控制只有拿到信号量许可的的，才能执行，其实就是控制的并发数
 *      2）实际上就是一个计数器，当没有CyclelicBarrier达到最大值时，那些执行等待的线程就开始执行。
 *      3）调用一次acquire()获取一个信号量，release释放一个信号量
 * 使用：1)初始化时给到一个初始值
 *      2）使用acquire（）方法进入等待阻塞状态，直到获取到信号量
 *      3）运行完成后执行release()方法，释放掉。
 *      4) 一定要在finlly里面释放，不然容易出现异常后，信号量不释放问题
 *      5) 许可证公平性：构造函数  true-公平   false-非公平    默认是非公平
 * 场景：1）控制并发时，执行的线程数量。
 * 说明：公平的则信号量性能下降。
 * @author Administrator
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3,true);
		
		//final Semaphore semaphore = new Semaphore(3);
		
		
		for(int i = 0 ; i <=5 ; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try{
						System.out.println(Thread.currentThread().getName()+"尝试获取信号量.......");
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+"获取到信号量,休息2s.......");
						Thread.sleep(2000);
						
						semaphore.release();
						
						System.out.println("释放信号量完成");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start(); 
		}
		
		
		
	}
}
