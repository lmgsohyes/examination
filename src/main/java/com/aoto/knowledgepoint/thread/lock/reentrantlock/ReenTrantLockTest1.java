package com.aoto.knowledgepoint.thread.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��һ�£���������ReenTrantLock��
 * 1��������˵����
 *    1����������Ϊ�˽����һ������������һ���������ִ����������Ĺ����У��ֵ���������һ��������������������������
 *      ����Ҫ���������ִ�С���ô�ñ������ôһ�����������һ��������ڵ��÷�����ʱ��������Ҫ�ȷ���һ�ͷ�������У�
 *      ���Ƿ���һû��ִ���귽���������޷��ͷ����������������������������������Ϊ�˽��������⣨��ʵ��ͨ����ȡ��
 *      �����ķ�ʽ��
 *    2��������������������ͨ�����������ö���������������������wait���������̴߳��ڵȴ�״̬����ʱ�ͷ�������Ȼ��ͨ�����������notity
 *       ��������������������̣߳�һ��������ͨ��������������ʵ���̵߳ȴ����̻߳��ѡ�
 *       
 *    3�����Ի�ȡ�������Ի�ȡ���ķ�������true����false.
 *    4���������Ĺ�ƽ�ԣ��ڶ�����������ʱ�򣬿������ó������Ƿ�ƽ��
 *    5���鿴�������Ĵ�����ֻ���ڵ�ǰ�߳���ʹ�ã��鿴�����������̣߳������˶��ٴΡ�
 *    6���鿴�߳��Ƿ��������鿴�߳��Ƿ�����
 *    7��
 * @author Administrator
 *
 */
public class ReenTrantLockTest1 {
	
	//����һ��������
	private Lock lock = new ReentrantLock(false);
	
	//�������Ȼ��ִ�д��룬����ͷ���
	public void run1(){
		try {
			//����
			lock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����run1����");
			Thread.sleep(1000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�˳�run1����");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();//ִ������ͷ���
		}
	}
	
	public void run2(){
		try {
			//����
			lock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"����run2����");
			Thread.sleep(2000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"�˳�run2����");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock.unlock();//ִ������ͷ���
		}
	}
	
	public static void main(String[] args) {
		final ReenTrantLockTest1 reenTrantLockTest1 = new ReenTrantLockTest1();
		
		//����ReenTrantLockTest1�����run1��run2����ʱ�������ģ����Ե������̷ֱ߳�ִ������������ʱ���ĸ��õ���
		//�ĸ��ͻ���ִ�У��ͷ����Ժ���һ�������Ż�ִ�У�������˳���һ������ִ���꣬�Ż�ִ����һ������������֮�佻��ִ�С�
		//����ĸ��������ͷ�������ô�ڶ����߳����з�����ʱ�������ִ�в���
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
        t2.start();
	}

}
