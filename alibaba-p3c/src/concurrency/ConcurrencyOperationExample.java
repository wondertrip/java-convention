package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * - 获取单例对象需要保证线程安全，其中的方法也要保证线程安全
 * @see SingletonExample
 * 
 * - 创建线程或线程池时请指定有意义的线程名称，方便出错时回溯
 * @see NamedThread
 * 
 * - 线程资源必须通过线程池提供，不允许在应用中自行显式创建线程
 * @see ThreadResourceManagement
 * 
 * - 线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险
 * @see ThreadPoolCreation
 * 
 * - SimpleDateFormat 是线程不安全的类，一般不要定义为 static变量
 * 
 * - 使用 CountDownLatch 进行异步转同步操作，每个线程退出前必须调用 countDown 方法，
 *   线程执行代码注意 catch 异常，确保 countDown 方法被执行到，避免主线程无法执行 至 await方法，直到超时才返回结果
 * @see CountDownLatchExample
 *   
 * - 避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一 seed 导致的性能下降
 * 
 * - 在并发场景下，通过双重检查锁（double-checked locking）实现延迟初始化的优 化问题隐患
 *   (可参考 The "Double-Checked Locking is Broken" Declaration)，
 *   推荐解 决方案中较为简单一种（适用于 JDK5 及以上版本），将目标属性声明为 volatile 型
 * @see SingletonExample
 * 
 * @author xiaodong
 *
 */
public class ConcurrencyOperationExample {
	
	private void runSomeTask(Runnable task) {
		//ThreadResourceManagement 正例
		//ThreadPoolCreation 正例
		Executor executor = new ThreadPoolExecutor(10, 10, 
												   600, TimeUnit.SECONDS,
												   new LinkedBlockingQueue<>(1024));
		executor.execute(task);
		
		//ThreadPoolCreation 反例
		Executor badExecutor = Executors.newFixedThreadPool(10);
		badExecutor.execute(task);
	}
	
	private void runSomeTaskDirectly(Runnable task) {
		//ThreadResourceManagement 反例
		new Thread(task).start();
	}
	
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	
	//CountDownLatchExample 正例
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
	
	//CountDownLatchExample 反例
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
	
	//NamedThread 正例
	public TimerTaskThread() {
		super.setName("TimerTaskThread");
	}
}