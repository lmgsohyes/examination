package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 1�����������ࣺSemaphore(�ź������֤����)
 * ���ã�1�������̶��������ź���������ֻ���õ��ź�����ɵĵģ�����ִ�У���ʵ���ǿ��ƵĲ�����
 *      2��ʵ���Ͼ���һ������������û��CyclelicBarrier�ﵽ���ֵʱ����Щִ�еȴ����߳̾Ϳ�ʼִ�С�
 *      3������һ��acquire()��ȡһ���ź�����release�ͷ�һ���ź���
 * ʹ�ã�1)��ʼ��ʱ����һ����ʼֵ
 *      2��ʹ��acquire������������ȴ�����״̬��ֱ����ȡ���ź���
 *      3��������ɺ�ִ��release()�������ͷŵ���
 *      4) һ��Ҫ��finlly�����ͷţ���Ȼ���׳����쳣���ź������ͷ�����
 *      5) ���֤��ƽ�ԣ����캯��  true-��ƽ   false-�ǹ�ƽ    Ĭ���Ƿǹ�ƽ
 * ������1�����Ʋ���ʱ��ִ�е��߳�������
 * ˵������ƽ�����ź��������½���
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
						System.out.println(Thread.currentThread().getName()+"���Ի�ȡ�ź���.......");
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+"��ȡ���ź���,��Ϣ2s.......");
						Thread.sleep(2000);
						
						semaphore.release();
						
						System.out.println("�ͷ��ź������");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start(); 
		}
		
		
		
	}
}
