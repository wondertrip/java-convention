package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * - 使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全 一样的数组，大小就是 list.size()
 * @see CollectionToArray
 * 
 * - 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方 法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常
 * @see ListFromArray
 * 
 * - 泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add 方 法，而<? super T>不能使用 get 方法，做为接口调用赋值时易出错
 * @see GenericMatching
 * 
 * - 不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator 方式，如果并发操作，需要对 Iterator 对象加锁
 * @see UpdateDuringIteration
 * 
 * - 集合初始化时，指定集合初始值大小
 * @see CollectionInitialization
 * 
 * 
 * @author xiaodong
 *
 */
public class CollectionOperationExample {
	
	//CollectionInitialization 正例
	private Map<String, String> key2Value = new HashMap<>(4096);
	
	//CollectionInitialization 反例
	private Map<String, String> key2ValueWithoutInitSize = new HashMap<>();

	private static void whatWillHappen() {
		List<String> stringList = Arrays.asList("one", "two", "three");
		
		//ListFromArray  : what will happen and why???
		stringList.add("four");
	}
	
	public String[] list2Array(List<String> stringList) {
		//CollectionToArray 正例
		String[] result = stringList.toArray(new String[stringList.size()]);
		
		//CollectionToArray 反例
		String[] anotherWay = stringList.toArray(new String[0]);
		
		return result;
	}
	
	//UpdateDuringIteration 反例
	private static void unsafeDelete(List<String> targetList, String targetValue) {
		for (String s : targetList) {
			if (s.equals(targetValue)) {
				targetList.remove(s);
			}
		}
	}
	
	//UpdateDuringIteration 正例
	private static void safeDelete(List<String> targetList, String targetValue) {
		Iterator<String> iteratorOfString = targetList.iterator();
		while (iteratorOfString.hasNext()) {
			String nextValue = iteratorOfString.next();
			if (nextValue.equals(targetValue)) {
				iteratorOfString.remove();
			}
		}
		
		System.out.println(targetList.stream().collect(Collectors.joining(",")));
	}
	
	public static void main(String[] args) {
		//whatWillHappen();
		
		List<String> targetList = new ArrayList<>(3);
		targetList.add("one");
		targetList.add("two");
		targetList.add("three");
		unsafeDelete(targetList, "two");
		
		//safeDelete(targetList, "two");
	}
}
