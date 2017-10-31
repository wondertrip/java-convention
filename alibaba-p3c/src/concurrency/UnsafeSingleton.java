package concurrency;

/**
 * This is a bad Singleton implementation that used to demonstrate p3c convention!
 * 
 * @author xiaodong
 *
 */
public class UnsafeSingleton {
	
	private static UnsafeSingleton instance;
	
	private UnsafeSingleton() {
	}
	
	public static UnsafeSingleton getInstance() {
		if (instance == null) {
			instance = new UnsafeSingleton();
		}
		return instance;
	}

}
