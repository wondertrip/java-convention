package naming;

/**
 * - 类名使用 UpperCamelCase 风格
 * @see UpperCamelCase
 * 
 * - 命名均不能以下划线或美元符号开始或结束
 * @see NoDolarOrUnderscore
 * 
 * - 命名严禁使用拼音与英文混合的方式，更不允许直接使用中文
 * @see NoMixture
 * 
 * - 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格
 * @see lowerCamelCase
 * 
 * - 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长
 * @see ConstantExample
 * 
 * - 抽象类命名使用 Abstract 或 Base 开头；异常类命名使用 Exception 结尾；测试类 命名以它要测试的类的名称开始，以 Test结尾
 * @see AbstractClassInterfaceExceptionNaming
 * 
 * - 中括号是数组类型的一部分，数组定义如下：String[] args;
 * @see ArrayDefinition
 * 
 * - POJO 类中布尔类型的变量，都不要加 is，否则部分框架解析会引起序列化错误
 * @see BooleanNaming
 * 
 * - 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用 单数形式，但是类名如果有复数含义，类名可以使用复数形式
 * @see our project package names
 * 
 * - 接口类中的方法和属性不要加任何修饰符号（public 也不要加），
 *   保持代码的简洁 性，并加上有效的 Javadoc注释。
 *   尽量不要在接口里定义变量，如果一定要定义变量，肯定是 与接口方法相关，并且是整个应用的基础常量
 * @see InterfaceExamples
 * 
 * @author xiaodong
 *
 */

//UpperCamelCase 正例
public class NamingConventionExample {
	
	//ConstantExample 正例
	public static final String TRANSACTION_SUCCEED_FLAG = "true";
	
	//NoDolarOrUnderscore 正例
	private String description;
	
	//NoMixture 正例
	private String ipaylinks;
	private String qiyun;
	
	//ArrayDefinition 正例
	private String[] cities;
	
	//BooleanNaming 正例
	private Boolean qualifiedCandidate; 
	
	
	//lowerCamelCase 正例
	public void goodMethodName(String input) {
		
	}
	
	//AbstractClassAndExceptionNaming 正例
	abstract class AbstractNumberCalculator {
		
	}
	
	//AbstractClassAndExceptionNaming 正例
	class NumberFormatException extends Exception {
		private static final long serialVersionUID = -8419746572357236481L;
		
	}
	
	//AbstractClassAndExceptionNaming 正例
	class NamingConventionExampleTest {
		
	}
	
	//InterfaceExamples 正例
	/**
	 * 
	 * This interface defines the general behaviors that any employee of 
	 * any firm might have. Different firms please implement your requirement
	 * to your employee as per your policy and needs.
	 * 
	 * @author xiaodong
	 *
	 */
	interface EmployeeBehavior {
		
		/**
		 * What kind of actions should be done when employee start working, 
		 * for example sign-in -> start your computer -> check emails etc.
		 */
		void startWorking();
		
		/**
		 * What should the employee do before go home from work. 
		 * Like shutdown computer & clean the desk etc.
		 */
		void goHome();
	}

}

//UpperCamelCase 反例
class ThisisaBadexampleFornaming {
	
	//ConstantExample 反例
	public static final String transaction_succeed_FLAG = "true";
	
	//NoDolarOrUnderscore 反例
	private String $badnaming_;
	
	//NoMixture 反例
	private String pingFenOfMerchant;
	private String promotionJiage;
	
	
	//ArrayDefinition 反例
	private String countries[];
	
	//BooleanNaming 反例
	private Boolean isQualifiedCandidate; 
	
	//lowerCamelCase 反例
	public void badmethodName(String input) {
		
	}
	
	//AbstractClassAndExceptionNaming 反例
	abstract class NumberCalculator {
		
	}
	
	//AbstractClassAndExceptionNaming 反例
	class BadFormat extends Exception {
		private static final long serialVersionUID = -8419746572357236481L;
		
	}
	
	//AbstractClassAndExceptionNaming 反例
	class CeShiNamingConventionExample {
		
	}
	
}