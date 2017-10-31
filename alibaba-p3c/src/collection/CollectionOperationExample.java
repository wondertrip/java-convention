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
 * - ʹ�ü���ת����ķ���������ʹ�ü��ϵ� toArray(T[] array)���������������ȫ һ�������飬��С���� list.size()
 * @see CollectionToArray
 * 
 * - ʹ�ù����� Arrays.asList()������ת���ɼ���ʱ������ʹ�����޸ļ�����صķ� �������� add/remove/clear �������׳� UnsupportedOperationException �쳣
 * @see ListFromArray
 * 
 * - ����ͨ���<? extends T>�����շ��ص����ݣ���д���ķ��ͼ��ϲ���ʹ�� add �� ������<? super T>����ʹ�� get ��������Ϊ�ӿڵ��ø�ֵʱ�׳���
 * @see GenericMatching
 * 
 * - ��Ҫ�� foreach ѭ�������Ԫ�ص� remove/add ������remove Ԫ����ʹ�� Iterator ��ʽ�����������������Ҫ�� Iterator �������
 * @see UpdateDuringIteration
 * 
 * - ���ϳ�ʼ��ʱ��ָ�����ϳ�ʼֵ��С
 * @see CollectionInitialization
 * 
 * 
 * @author xiaodong
 *
 */
public class CollectionOperationExample {
	
	//CollectionInitialization ����
	private Map<String, String> key2Value = new HashMap<>(4096);
	
	//CollectionInitialization ����
	private Map<String, String> key2ValueWithoutInitSize = new HashMap<>();

	private static void whatWillHappen() {
		List<String> stringList = Arrays.asList("one", "two", "three");
		
		//ListFromArray  : what will happen and why???
		stringList.add("four");
	}
	
	public String[] list2Array(List<String> stringList) {
		//CollectionToArray ����
		String[] result = stringList.toArray(new String[stringList.size()]);
		
		//CollectionToArray ����
		String[] anotherWay = stringList.toArray(new String[0]);
		
		return result;
	}
	
	//UpdateDuringIteration ����
	private static void unsafeDelete(List<String> targetList, String targetValue) {
		for (String s : targetList) {
			if (s.equals(targetValue)) {
				targetList.remove(s);
			}
		}
	}
	
	//UpdateDuringIteration ����
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
