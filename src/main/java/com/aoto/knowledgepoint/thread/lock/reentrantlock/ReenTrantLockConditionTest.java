package com.aoto.knowledgepoint.thread.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �ڶ��£����������̼߳��ͨѶ��condit��wait��notify������ 1��ͨ�����������conditon�������󣬿��Ի�ȡ�����
 * 2��ͨ��conditon�������await�������߳̽���ȴ����ͷ�����
 * 3�������߳�ͨ��condition����signal��notify������signalAll(notifyall)�������������������ȴ����̡߳� ˵����һ���������ж������
 * 
 * @author Administrator
 *
 */
public class ReenTrantLockConditionTest {
	// ����һ��������
	private Lock lock = new ReentrantLock(false);
	
	//�������������������(����������ĳһ������)
	private Condition condition = lock.newCondition();
	
	

	// �������Ȼ��ִ�д��룬����ͷ���
	public void run1() {
		try {
			// ����
			lock.lock();
			System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "����run1����");
			Thread.sleep(1000);
			System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�ͷ�������ȴ�״̬");
			condition.await(); //����ȴ�״̬��ͬʱ�ͷ���
			System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�˳�run1����");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();// ִ������ͷ���
		}
	}
	
	// �������Ȼ��ִ�д��룬����ͷ���
		public void run2() {
			try {
				// ����
				lock.lock();
				System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "����run2����");
				Thread.sleep(2000);
				System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�ͷ�������ȴ�״̬");
				condition.signal(); //��������֪ͨ,����ʱû���ͷ������������������ִ��
				Thread.sleep(2000);
				System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�˳�run2����");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();// ִ������ͷ���
			}
		}
		
		public static void main(String[] args) {
			final ReenTrantLockConditionTest reenTrantLockTest1 = new ReenTrantLockConditionTest();
			
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
	        t1.setPriority(10);
	        t2.start();
	        t2.setPriority(1);
		}
}
