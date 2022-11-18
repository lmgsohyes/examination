package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、并发工具类：CyclicBarrier(循环栅栏/循环起跑线)
 * 作用：1）设置一个栅栏，当达到指定数目后，线程一起执行。
 *      2）实际上就是一个计数器，当没有CyclelicBarrier达到最大值时，那些执行等待的线程就开始执行。
 *      3）调用一次cyclicBarrier.await()方法就余量+1
 * 场景：1）所有的线程都在栅栏前等待，当大家都到齐后，开始一起执行。(子线程都执行好了，执行主线程)
 *      2）循环的栅栏，可以设置多个栅栏
 *      3) await()可以设置超时时间，超过等待时间，会抛出异常，可以捕获异常后继续处理，重点后续的线程执行时会进入
 *         BrokenBarrierException（损坏的栅栏异常），需要捕获此异常。
 * @author Administrator
 *
 */
class CyclicBarrierRunner implements Runnable {
	
	private CyclicBarrier cyclicBarrier;
	
	private String name; //线程名称

	//线程类的构造方法（这个循环栅栏式所有runable线程共用的，）
	public CyclicBarrierRunner(CyclicBarrier cyclicBarrier,String name) {
		super();
		this.cyclicBarrier = cyclicBarrier;
		this.name = name;
	}

	@Override
	public void run() {
		try{
			System.out.println("已经准备好了："+name);
			Thread.sleep(2000);
			cyclicBarrier.await(); //进入等待，直到所有人都准备好
			System.out.println("开始气泡："+name);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}


 public class CyclicBarrierMain{
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		
		//固定大小线程池
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		executorService.submit(new CyclicBarrierRunner(cyclicBarrier,"hong"));
		executorService.submit(new CyclicBarrierRunner(cyclicBarrier,"xian"));
		executorService.submit(new CyclicBarrierRunner(cyclicBarrier,"zhi"));
		
		//关闭线程池
		executorService.shutdown();
		
	}
}
