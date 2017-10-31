package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * - ��ȡ����������Ҫ��֤�̰߳�ȫ�����еķ���ҲҪ��֤�̰߳�ȫ
 * @see SingletonExample
 * 
 * - �����̻߳��̳߳�ʱ��ָ����������߳����ƣ��������ʱ����
 * @see NamedThread
 * 
 * - �߳���Դ����ͨ���̳߳��ṩ����������Ӧ����������ʽ�����߳�
 * @see ThreadResourceManagement
 * 
 * - �̳߳ز�����ʹ�� Executors ȥ����������ͨ�� ThreadPoolExecutor �ķ�ʽ������ �Ĵ���ʽ��д��ͬѧ������ȷ�̳߳ص����й��򣬹����Դ�ľ��ķ���
 * @see ThreadPoolCreation
 * 
 * - SimpleDateFormat ���̲߳���ȫ���࣬һ�㲻Ҫ����Ϊ static����
 * 
 * - ʹ�� CountDownLatch �����첽תͬ��������ÿ���߳��˳�ǰ������� countDown ������
 *   �߳�ִ�д���ע�� catch �쳣��ȷ�� countDown ������ִ�е����������߳��޷�ִ�� �� await������ֱ����ʱ�ŷ��ؽ��
 * @see CountDownLatchExample
 *   
 * - ���� Random ʵ�������߳�ʹ�ã���Ȼ�����ʵ�����̰߳�ȫ�ģ���������ͬһ seed ���µ������½�
 * 
 * - �ڲ��������£�ͨ��˫�ؼ������double-checked locking��ʵ���ӳٳ�ʼ������ ����������
 *   (�ɲο� The "Double-Checked Locking is Broken" Declaration)��
 *   �Ƽ��� �������н�Ϊ��һ�֣������� JDK5 �����ϰ汾������Ŀ����������Ϊ volatile ��
 * @see SingletonExample
 * 
 * @author xiaodong
 *
 */
public class ConcurrencyOperationExample {
	
	private void runSomeTask(Runnable task) {
		//ThreadResourceManagement ����
		//ThreadPoolCreation ����
		Executor executor = new ThreadPoolExecutor(10, 10, 
												   600, TimeUnit.SECONDS,
												   new LinkedBlockingQueue<>(1024));
		executor.execute(task);
		
		//ThreadPoolCreation ����
		Executor badExecutor = Executors.newFixedThreadPool(10);
		badExecutor.execute(task);
	}
	
	private void runSomeTaskDirectly(Runnable task) {
		//ThreadResourceManagement ����
		new Thread(task).start();
	}
	
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	
	//CountDownLatchExample ����
	private void goodInit() {
		try {
			//something that might throw exception
			latch.countDown();
		} catch (Exception e) {
			e.printStackTrace();
			//log and notice the system here!
			latch.countDown();
		}
	}
	
	//CountDownLatchExample ����
	private void braveInit() {
		try {
			//something that might throw exception
			latch.countDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startServing() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//then do something...
	}

}

class TimerTaskThread extends Thread {
	
	//NamedThread ����
	public TimerTaskThread() {
		super.setName("TimerTaskThread");
	}
}