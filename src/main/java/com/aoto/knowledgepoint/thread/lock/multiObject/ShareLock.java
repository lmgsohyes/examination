package com.aoto.knowledgepoint.thread.lock.multiObject;

/**
 * 1、所有的验证
 * 1）如果使用class关键字作为锁，那么这个锁的范围是所有对象。
 * 2）如果使用this关键字作为锁，那么这个锁的作用范围是，这个实力对象的多次调用。
 * @author Administrator
 *
 */
public class ShareLock {
	
	
	String name;
	
	String age;
	

	public ShareLock(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}


	public void call(){
		synchronized (ShareLock.class) {

			System.out.println("大家好：我是"+name+",性别："+age+"现在开始执行,休息10s................");
			
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("大家好：我是"+name+",性别："+age+"执行完成");
		}
	}
	
	
	/**
	 * 测试代码，生成多个线程，每个线程实力化此实力，然后执行call方法，查看是否获得锁后才能执行
	 * @param args
	 */
	public static void main(String[] args) {
		
	   new Thread(new Runnable() {
		
		@Override
		public void run() {
			
			ShareLock shareLock = new ShareLock("hongxz", "20");
			shareLock.call();
		}
	},"hongxz").start();
	   
	   
	   new Thread(new Runnable() {
			
		@Override
		public void run() {
			
			ShareLock shareLock = new ShareLock("fengdw", "18");
			shareLock.call();
		}
	},"fengdw").start();
	   
	   
	   new Thread(new Runnable() {
			
		@Override
		public void run() {
			
			ShareLock shareLock = new ShareLock("gengsd", "16");
			shareLock.call();
		}
	},"gengsd").start();
		
		
	}
	
}
