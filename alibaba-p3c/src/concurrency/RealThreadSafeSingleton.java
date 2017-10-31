package concurrency;

/**
 * 
 * This is a really thread safe singleton implementation using volatile.
 * Please note using this should be along with JDK 1.5 or above!
 * 
 * Reference: http://www.infoq.com/cn/articles/double-checked-locking-with-delay-initialization
 * 
 * @author user
 *
 */
public class RealThreadSafeSingleton {
	
	private volatile static RealThreadSafeSingleton instance;
	
	private RealThreadSafeSingleton() {
		
	}
	
	public static RealThreadSafeSingleton getInstance() {
		if (instance == null) {
			synchronized(RealThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new RealThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

}
