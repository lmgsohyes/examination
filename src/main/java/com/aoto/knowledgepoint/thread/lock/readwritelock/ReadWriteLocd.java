package com.aoto.knowledgepoint.thread.lock.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * ��д��
 * 1����д����ʵ���ࣺReenTrantReadWriteLock
 * 2)���ö�д������ƣ���Ϊ������д��
 * 3���߲����¶���д��ʱ����������ReenTrantLock
 * 4����������������������ụ�⣩  дд����   ��д����
 * @author Administrator
 *
 */
public class ReadWriteLocd {
	
	//����һ����д��
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	
	//�ֱ��ȡ��д���Ķ�����д��
	
	private ReadLock readLock = reentrantReadWriteLock.readLock();
	private WriteLock writeLock = reentrantReadWriteLock.writeLock();
	
	public void read(){
		try {
			readLock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"read ����");
			Thread.sleep(3000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"read �˳�");
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			readLock.unlock();
		}
		
	}
	
	public void write(){
		try {
			writeLock.lock();
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"write ����");
			Thread.sleep(3000);
			System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName()+"write �˳�");
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			writeLock.unlock();
		}
		
	}
	
	
	public static void main(String[] args) {
		final ReadWriteLocd  readWriteLocd = new ReadWriteLocd();
		
		//�߳�1ִ�ж�
		Thread t1 = new Thread(new  Runnable() {
			public void run() {
				readWriteLocd.read();
			}
		},"t1");
		
		//�߳�2ִ�ж�
				Thread t2 = new Thread(new  Runnable() {
					public void run() {
						readWriteLocd.read();
					}
				},"t2");
				
				//�߳�3ִ��д
				Thread t3 = new Thread(new  Runnable() {
					public void run() {
						readWriteLocd.write();
					}
				},"t3");
				
				//�߳�4ִ��д
				Thread t4 = new Thread(new  Runnable() {
					public void run() {
						readWriteLocd.write();
					}
				},"t4");
				
				
				//��ʼ���ԣ����������ܻ����������ִ��
//				t1.start();
//				t2.start();
				
				//��ʼ���ԣ���д���⣬���ܲ���ִ��
//				t1.start();
//				t3.start();
				
				//��ʼ���ԣ�дд���⣬���ܲ���ִ��
				t3.start();
				t4.start();
				
	}
}
