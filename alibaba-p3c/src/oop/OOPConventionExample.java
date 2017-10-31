package oop;

import java.time.LocalDate;
import java.util.Date;

/**
 * - ����ʹ�ù�ʱ����򷽷�
 * @see NoDeprecatedReference
 * 
 * - Object �� equals ���������׿�ָ���쳣��Ӧʹ�ó�����ȷ����ֵ�Ķ��������� equals
 * @see EqualsCall
 * 
 * - ���е���ͬ���͵İ�װ�����֮��ֵ�ıȽϣ�ȫ��ʹ�� equals �����Ƚ�
 * @see EqualsForValueObjects
 * 
 * - ���ڻ��������������װ�������͵�ʹ�ñ�׼���£�  
 *   1�� ��ǿ�ơ����е� POJO �����Ա���ʹ�ð�װ�������͡�  
 *   2�� ��ǿ�ơ�RPC �����ķ���ֵ�Ͳ�������ʹ�ð�װ�������͡�  
 *   3�� ���Ƽ������еľֲ�����ʹ�û����������͡�
 *   
 * - ���� DO/DTO/VO �� POJO ��ʱ����Ҫ�趨�κ�����Ĭ��ֵ
 * 
 * - POJO �����д toString ������ʹ�� IDE ���й��ߣ�source> generate toString ʱ������̳�����һ�� POJO �࣬ע����ǰ���һ�� super.toString
 * 
 * - ѭ�����ڣ��ַ��������ӷ�ʽ��ʹ�� StringBuilder �� append ����������չ
 * 
 * @author xiaodong
 *
 */
public class OOPConventionExample {

	//NoDeprecatedReference ����
	private LocalDate localDate = LocalDate.now();
	
	//NoDeprecatedReference ����
	private Date date = new Date("2017-10-31");
	
	private static final String BENCHMARK = "benchmark"; 
	
	public void eualsCallExamples(String firstParam, String secondParam) {
		
		//EqualsCall ����
		if (firstParam.equals(BENCHMARK)) {
			//doSomething...
		}
		
		//EqualsCall ����
		if (BENCHMARK.equals(secondParam)) {
			//doSomethingElse...
		}
	}
	
	public static void main(String[] args) {
		
		Integer int123 = 123;
		Integer anotherInt123 = 123;
		
		Integer int9898 = 9898;
		Integer anotherInt9898 = 9898;
		
		//EqualsForValueObjects : what will be the results for the following comparing???
		
		System.out.println(int123 == anotherInt123); 
		System.out.println(int9898 == anotherInt9898);
		
		System.out.println(int123.equals(anotherInt123));
		System.out.println(int9898.equals(anotherInt9898));
	}
}
