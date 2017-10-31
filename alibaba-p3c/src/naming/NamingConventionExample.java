package naming;

/**
 * - ����ʹ�� UpperCamelCase ���
 * @see UpperCamelCase
 * 
 * - �������������»��߻���Ԫ���ſ�ʼ�����
 * @see NoDolarOrUnderscore
 * 
 * - �����Ͻ�ʹ��ƴ����Ӣ�Ļ�ϵķ�ʽ����������ֱ��ʹ������
 * @see NoMixture
 * 
 * - ������������������Ա�������ֲ�������ͳһʹ�� lowerCamelCase ���
 * @see lowerCamelCase
 * 
 * - ��������ȫ����д�����ʼ����»��߸��������������������������Ҫ�����ֳ�
 * @see ConstantExample
 * 
 * - ����������ʹ�� Abstract �� Base ��ͷ���쳣������ʹ�� Exception ��β�������� ��������Ҫ���Ե�������ƿ�ʼ���� Test��β
 * @see AbstractClassInterfaceExceptionNaming
 * 
 * - ���������������͵�һ���֣����鶨�����£�String[] args;
 * @see ArrayDefinition
 * 
 * - POJO ���в������͵ı���������Ҫ�� is�����򲿷ֿ�ܽ������������л�����
 * @see BooleanNaming
 * 
 * - ����ͳһʹ��Сд����ָ���֮�����ҽ���һ����Ȼ�����Ӣ�ﵥ�ʡ�����ͳһʹ�� ������ʽ��������������и������壬��������ʹ�ø�����ʽ
 * @see our project package names
 * 
 * - �ӿ����еķ��������Բ�Ҫ���κ����η��ţ�public Ҳ��Ҫ�ӣ���
 *   ���ִ���ļ�� �ԣ���������Ч�� Javadocע�͡�
 *   ������Ҫ�ڽӿ��ﶨ����������һ��Ҫ����������϶��� ��ӿڷ�����أ�����������Ӧ�õĻ�������
 * @see InterfaceExamples
 * 
 * @author xiaodong
 *
 */

//UpperCamelCase ����
public class NamingConventionExample {
	
	//ConstantExample ����
	public static final String TRANSACTION_SUCCEED_FLAG = "true";
	
	//NoDolarOrUnderscore ����
	private String description;
	
	//NoMixture ����
	private String ipaylinks;
	private String qiyun;
	
	//ArrayDefinition ����
	private String[] cities;
	
	//BooleanNaming ����
	private Boolean qualifiedCandidate; 
	
	
	//lowerCamelCase ����
	public void goodMethodName(String input) {
		
	}
	
	//AbstractClassAndExceptionNaming ����
	abstract class AbstractNumberCalculator {
		
	}
	
	//AbstractClassAndExceptionNaming ����
	class NumberFormatException extends Exception {
		private static final long serialVersionUID = -8419746572357236481L;
		
	}
	
	//AbstractClassAndExceptionNaming ����
	class NamingConventionExampleTest {
		
	}
	
	//InterfaceExamples ����
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

//UpperCamelCase ����
class ThisisaBadexampleFornaming {
	
	//ConstantExample ����
	public static final String transaction_succeed_FLAG = "true";
	
	//NoDolarOrUnderscore ����
	private String $badnaming_;
	
	//NoMixture ����
	private String pingFenOfMerchant;
	private String promotionJiage;
	
	
	//ArrayDefinition ����
	private String countries[];
	
	//BooleanNaming ����
	private Boolean isQualifiedCandidate; 
	
	//lowerCamelCase ����
	public void badmethodName(String input) {
		
	}
	
	//AbstractClassAndExceptionNaming ����
	abstract class NumberCalculator {
		
	}
	
	//AbstractClassAndExceptionNaming ����
	class BadFormat extends Exception {
		private static final long serialVersionUID = -8419746572357236481L;
		
	}
	
	//AbstractClassAndExceptionNaming ����
	class CeShiNamingConventionExample {
		
	}
	
}