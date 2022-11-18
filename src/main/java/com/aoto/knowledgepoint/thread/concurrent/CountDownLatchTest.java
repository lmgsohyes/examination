package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 1、并发工具类：CountDownLatch
 * 作用：1）允许一个或多个线程等待指定操作完成后再执行。
 *      2）实际上就是一个计数器，当CountDownLatch没有余量时，那些执行等待的线程就开始执行。
 *      3）调用一次countdown方法就余量减1
 * 使用：1)初始化时给到一个初始值
 *      2）使用await方法进入等待阻塞状态
 *      3）其他线程调用countdown方法，减去初始值。每调用一次就减1
 *      4）直到countdownLatch的初始值变为0后，使用await的等待的线程就同时开始执行。
 * 场景：所有的线程进入等待状态，只有当CountDownLatch的计算器变为0时，所有线程才开始同时执行。
 *      
 * @author Administrator
 *
 */
public class CountDownLatchTest {
	
	public static void main(String[] args) {
		
		//定义一个计数器，当计数器变为0时，等待的线程就继续执行
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		
		//线程1，等待其他线程执行完成后执行（其实通过这个我就可以控制线程执行顺序）
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("线程1执行...........等待countdownlatch为0后执行");
					countDownLatch.await();//此方法就是为了等待countDownLatch为0,
					System.out.println("开始执行线程1，线程执行完成");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("线程2执行...........等待countdownlatch为0后执行");
					countDownLatch.await();//此方法就是为了等待countDownLatch为0
					System.out.println("开始执行线程2，线程执行完成。");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("线程3执行...........进行型号量递减一个");
					Thread.sleep(2000);
					countDownLatch.countDown();//
					System.out.println("线程3执行...........进行型号量递减一个");
					Thread.sleep(2000);
					countDownLatch.countDown();
					System.out.println("线程3执行...........进行型号量递减一个");
					Thread.sleep(2000);
					countDownLatch.countDown();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
		
	}

}
