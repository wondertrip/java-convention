package concurrency;

/**
 * This is alternative of thread safe singleton implementation using static class holder,
 * which is ensured by JSR.
 * 
 * @author user
 *
 */
public class RealThreadSafeSingleton2 {
	
	private RealThreadSafeSingleton2() {
		
	}
	
	private static class SingletonHolder {
		public static RealThreadSafeSingleton2 instance = new RealThreadSafeSingleton2();
	}
	
	public static RealThreadSafeSingleton2 getInstance() {
		return SingletonHolder.instance;
	}

}
