package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1�����������ࣺCyclicBarrier(ѭ��դ��/ѭ��������)
 * ���ã�1������һ��դ�������ﵽָ����Ŀ���߳�һ��ִ�С�
 *      2��ʵ���Ͼ���һ������������û��CyclelicBarrier�ﵽ���ֵʱ����Щִ�еȴ����߳̾Ϳ�ʼִ�С�
 *      3������һ��cyclicBarrier.await()����������+1
 * ������1�����е��̶߳���դ��ǰ�ȴ�������Ҷ�����󣬿�ʼһ��ִ�С�(���̶߳�ִ�к��ˣ�ִ�����߳�)
 *      2��ѭ����դ�����������ö��դ��
 *      3) await()�������ó�ʱʱ�䣬�����ȴ�ʱ�䣬���׳��쳣�����Բ����쳣����������ص�������߳�ִ��ʱ�����
 *         BrokenBarrierException���𻵵�դ���쳣������Ҫ������쳣��
 * @author Administrator
 *
 */
class CyclicBarrierRunner implements Runnable {
	
	private CyclicBarrier cyclicBarrier;
	
	private String name; //�߳�����

	//�߳���Ĺ��췽�������ѭ��դ��ʽ����runable�̹߳��õģ���
	public CyclicBarrierRunner(CyclicBarrier cyclicBarrier,String name) {
		super();
		this.cyclicBarrier = cyclicBarrier;
		this.name = name;
	}

	@Override
	public void run() {
		try{
			System.out.println("�Ѿ�׼�����ˣ�"+name);
			Thread.sleep(2000);
			cyclicBarrier.await(); //����ȴ���ֱ�������˶�׼����
			System.out.println("��ʼ���ݣ�"+name);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}


 public class CyclicBarrierMain{
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		
		//�̶���С�̳߳�
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		executorService.submit(new CyclicBarrierRunner(cyclicBarrier,"hong"));
		executorService.submit(new CyclicBarrierRunner(cyclicBarrier,"xian"));
		executorService.submit(new CyclicBarrierRunner(cyclicBarrier,"zhi"));
		
		//�ر��̳߳�
		executorService.shutdown();
		
	}
}
