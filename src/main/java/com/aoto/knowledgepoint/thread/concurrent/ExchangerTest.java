package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 1、并发工具类：Exchanger(线程之间的数据交换)
 * 作用：1）两两线程交换的数据进行交换
 *      2）成双成对的出现，如果是单数，那么没有交换的那个线程会被一直阻塞在那边等待交换。
 *      3）线程之间有个数据交换的汇合点，都到达那个点后交换玩数据后才会王下面进行执行，否则会等待。
 * 使用：1)初始化时给到一个交换器
 *      2）要交换的线程使用同一个交换器
 *      3）都运行到交换点才回进行数据交换(this.object = exchanger.exchange(this.object);)
 * 场景：1）控制两个线程之间数据交换
 * @author Administrator
 *
 */
public class ExchangerTest {
	
	public static void main(String[] args) {
		//定义一个数据交换器
		Exchanger<String> exchanger = new Exchanger<String>();
		//初始化两个线程
		new Thread(new ExchangerRunable(exchanger, "A")).start();
		new Thread(new ExchangerRunable(exchanger, "B")).start();
		
		
		//使用2个数据交换器
		Exchanger<String> exchanger2 = new Exchanger<String>();
		new Thread(new ExchangerRunable(exchanger2, "C")).start();
		new Thread(new ExchangerRunable(exchanger2, "D")).start();
	}
}


class ExchangerRunable implements  Runnable {
	
	Exchanger<String> exchanger = null;  //交换器
	String object = null; //当前线程数据
	
	/**
	 * 构造函数
	 * @param exchanger 交换器
	 * @param exdata    交换前的数据
	 */
	public ExchangerRunable(Exchanger<String> exchanger, String data) {
		super();
		this.exchanger = exchanger;
		this.object = data;
		
	}

	public void run() {
		Object previous = object;
		
		try {
			System.out.println(Thread.currentThread().getName()+":交换前的数据-"+previous);
			
			if ("A".equals(object)) {
				Thread.sleep(3000);
				System.out.println("对A的处理3秒");
			}
			
			if ("B".equals(object)) {
				Thread.sleep(2000);
				System.out.println("对B的处理2秒");
			}
			
			if ("C".equals(object)) {
				Thread.sleep(4000);
				System.out.println("对C的处理4秒");
			}
			
			if ("D".equals(object)) {
				Thread.sleep(5000);
				System.out.println("对D的处理5秒");
			}
			
			//两个线程执行到此处时进行汇合，只有一个线程在这个地方不会进行数据交换，只会进行等待
			this.object = exchanger.exchange(this.object);
			
			System.out.println(Thread.currentThread().getName()+":交换前的数据-"+previous+"  交换后的数据："+this.object);;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}