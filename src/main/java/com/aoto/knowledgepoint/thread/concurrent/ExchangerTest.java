package com.aoto.knowledgepoint.thread.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 1�����������ࣺExchanger(�߳�֮������ݽ���)
 * ���ã�1�������߳̽��������ݽ��н���
 *      2����˫�ɶԵĳ��֣�����ǵ�������ôû�н������Ǹ��̻߳ᱻһֱ�������Ǳߵȴ�������
 *      3���߳�֮���и����ݽ����Ļ�ϵ㣬�������Ǹ���󽻻������ݺ�Ż����������ִ�У������ȴ���
 * ʹ�ã�1)��ʼ��ʱ����һ��������
 *      2��Ҫ�������߳�ʹ��ͬһ��������
 *      3�������е�������Żؽ������ݽ���(this.object = exchanger.exchange(this.object);)
 * ������1�����������߳�֮�����ݽ���
 * @author Administrator
 *
 */
public class ExchangerTest {
	
	public static void main(String[] args) {
		//����һ�����ݽ�����
		Exchanger<String> exchanger = new Exchanger<String>();
		//��ʼ�������߳�
		new Thread(new ExchangerRunable(exchanger, "A")).start();
		new Thread(new ExchangerRunable(exchanger, "B")).start();
		
		
		//ʹ��2�����ݽ�����
		Exchanger<String> exchanger2 = new Exchanger<String>();
		new Thread(new ExchangerRunable(exchanger2, "C")).start();
		new Thread(new ExchangerRunable(exchanger2, "D")).start();
	}
}


class ExchangerRunable implements  Runnable {
	
	Exchanger<String> exchanger = null;  //������
	String object = null; //��ǰ�߳�����
	
	/**
	 * ���캯��
	 * @param exchanger ������
	 * @param exdata    ����ǰ������
	 */
	public ExchangerRunable(Exchanger<String> exchanger, String data) {
		super();
		this.exchanger = exchanger;
		this.object = data;
		
	}

	public void run() {
		Object previous = object;
		
		try {
			System.out.println(Thread.currentThread().getName()+":����ǰ������-"+previous);
			
			if ("A".equals(object)) {
				Thread.sleep(3000);
				System.out.println("��A�Ĵ���3��");
			}
			
			if ("B".equals(object)) {
				Thread.sleep(2000);
				System.out.println("��B�Ĵ���2��");
			}
			
			if ("C".equals(object)) {
				Thread.sleep(4000);
				System.out.println("��C�Ĵ���4��");
			}
			
			if ("D".equals(object)) {
				Thread.sleep(5000);
				System.out.println("��D�Ĵ���5��");
			}
			
			//�����߳�ִ�е��˴�ʱ���л�ϣ�ֻ��һ���߳�������ط�����������ݽ�����ֻ����еȴ�
			this.object = exchanger.exchange(this.object);
			
			System.out.println(Thread.currentThread().getName()+":����ǰ������-"+previous+"  ����������ݣ�"+this.object);;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}