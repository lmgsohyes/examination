package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 1�����������ࣺCountDownLatch
 * ���ã�1������һ�������̵߳ȴ�ָ��������ɺ���ִ�С�
 *      2��ʵ���Ͼ���һ������������CountDownLatchû������ʱ����Щִ�еȴ����߳̾Ϳ�ʼִ�С�
 *      3������һ��countdown������������1
 * ʹ�ã�1)��ʼ��ʱ����һ����ʼֵ
 *      2��ʹ��await��������ȴ�����״̬
 *      3�������̵߳���countdown��������ȥ��ʼֵ��ÿ����һ�ξͼ�1
 *      4��ֱ��countdownLatch�ĳ�ʼֵ��Ϊ0��ʹ��await�ĵȴ����߳̾�ͬʱ��ʼִ�С�
 * ���������е��߳̽���ȴ�״̬��ֻ�е�CountDownLatch�ļ�������Ϊ0ʱ�������̲߳ſ�ʼͬʱִ�С�
 *      
 * @author Administrator
 *
 */
public class CountDownLatchTest {
	
	public static void main(String[] args) {
		
		//����һ��������������������Ϊ0ʱ���ȴ����߳̾ͼ���ִ��
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		
		//�߳�1���ȴ������߳�ִ����ɺ�ִ�У���ʵͨ������ҾͿ��Կ����߳�ִ��˳��
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("�߳�1ִ��...........�ȴ�countdownlatchΪ0��ִ��");
					countDownLatch.await();//�˷�������Ϊ�˵ȴ�countDownLatchΪ0,
					System.out.println("��ʼִ���߳�1���߳�ִ�����");
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
					System.out.println("�߳�2ִ��...........�ȴ�countdownlatchΪ0��ִ��");
					countDownLatch.await();//�˷�������Ϊ�˵ȴ�countDownLatchΪ0
					System.out.println("��ʼִ���߳�2���߳�ִ����ɡ�");
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
					System.out.println("�߳�3ִ��...........�����ͺ����ݼ�һ��");
					Thread.sleep(2000);
					countDownLatch.countDown();//
					System.out.println("�߳�3ִ��...........�����ͺ����ݼ�һ��");
					Thread.sleep(2000);
					countDownLatch.countDown();
					System.out.println("�߳�3ִ��...........�����ͺ����ݼ�һ��");
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
