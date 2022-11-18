package com.aoto.knowledgepoint.thread.lock.multiObject;

/**
 * 1�����е���֤
 * 1�����ʹ��class�ؼ�����Ϊ������ô������ķ�Χ�����ж���
 * 2�����ʹ��this�ؼ�����Ϊ������ô����������÷�Χ�ǣ����ʵ������Ķ�ε��á�
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

			System.out.println("��Һã�����"+name+",�Ա�"+age+"���ڿ�ʼִ��,��Ϣ10s................");
			
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("��Һã�����"+name+",�Ա�"+age+"ִ�����");
		}
	}
	
	
	/**
	 * ���Դ��룬���ɶ���̣߳�ÿ���߳�ʵ������ʵ����Ȼ��ִ��call�������鿴�Ƿ����������ִ��
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
