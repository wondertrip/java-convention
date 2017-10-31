package concurrency;

/**
 * This is an example of thread safe singleton double-checked locking implementation.
 * 
 * Open question: is this implementation really thread safe?
 * 
 * @author user
 *
 */
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;
	
	private ThreadSafeSingleton() {
		
	}
	
	public static ThreadSafeSingleton getInstance() {
		if (instance == null) {
			synchronized(ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}
