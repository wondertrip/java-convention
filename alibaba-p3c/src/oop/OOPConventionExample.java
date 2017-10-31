package oop;

import java.time.LocalDate;
import java.util.Date;

/**
 * - 不能使用过时的类或方法
 * @see NoDeprecatedReference
 * 
 * - Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals
 * @see EqualsCall
 * 
 * - 所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较
 * @see EqualsForValueObjects
 * 
 * - 关于基本数据类型与包装数据类型的使用标准如下：  
 *   1） 【强制】所有的 POJO 类属性必须使用包装数据类型。  
 *   2） 【强制】RPC 方法的返回值和参数必须使用包装数据类型。  
 *   3） 【推荐】所有的局部变量使用基本数据类型。
 *   
 * - 定义 DO/DTO/VO 等 POJO 类时，不要设定任何属性默认值
 * 
 * - POJO 类必须写 toString 方法。使用 IDE 的中工具：source> generate toString 时，如果继承了另一个 POJO 类，注意在前面加一下 super.toString
 * 
 * - 循环体内，字符串的连接方式，使用 StringBuilder 的 append 方法进行扩展
 * 
 * @author xiaodong
 *
 */
public class OOPConventionExample {

	//NoDeprecatedReference 正例
	private LocalDate localDate = LocalDate.now();
	
	//NoDeprecatedReference 反例
	private Date date = new Date("2017-10-31");
	
	private static final String BENCHMARK = "benchmark"; 
	
	public void eualsCallExamples(String firstParam, String secondParam) {
		
		//EqualsCall 反例
		if (firstParam.equals(BENCHMARK)) {
			//doSomething...
		}
		
		//EqualsCall 正例
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
