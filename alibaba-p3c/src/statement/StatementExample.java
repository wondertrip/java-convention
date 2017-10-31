package statement;

/**
 * - ��һ�� switch ���ڣ�ÿ�� case Ҫôͨ�� break/return ������ֹ��
 *   Ҫôע��˵���� �򽫼���ִ�е���һ�� case Ϊֹ��
 *   ��һ�� switch ���ڣ����������һ�� default ��䲢�� ������󣬼�ʹ��ʲô����Ҳû��
 * @see SwitchExample
 * 
 * - �� if/else/for/while/do ����б���ʹ�ô����š���ʹֻ��һ�д��룬������� ���еı��뷽ʽ��if (condition) statements
 * @see IfExample
 * 
 * - �����÷������� getXxx/isXxx�����⣬��Ҫ�������ж���ִ���������ӵ���䣬
 *   ���� ���߼��жϵĽ����ֵ��һ��������Ĳ���������������߿ɶ���
 * @see ConditionChecking
 * 
 * @author xiaodong
 *
 */
public class StatementExample {
	
	private void contitionCheckExample(String argument) {
		
		//ConditionChecking ����
		boolean isValid = validPerDBConfiguration(argument) && validPerBusinessRequirement(argument); 
		if (isValid) {
			//then let's continue the business
		}
		
		
		//ConditionChecking ����
		if (validPerDBConfiguration(argument) && validPerBusinessRequirement(argument)) {
			//then let's continue the business
		}
	}
	
	private boolean validPerDBConfiguration(String arg) {
		//complicated logic here and then return checking result, for this example we just return true!
		return true;
	}
	
	private boolean validPerBusinessRequirement(String arg) {
		//complicated logic here and then return checking result, for this example we just return true!
		return true;
	}
	
	private void forConventionOnly(String input) {
		
		//IfExample ����
		if ("ok".equals(input)) {
			//great! processing completed successfully! Let's celebrate!
		}
		
		//IfExample ����
		if ("ok".equals(input)) celebrate(); //ah! you are celebrating too early! Please fix this problem firstly!
		
	}
	
	private void celebrate() {
		
	}

	//SwitchExample ����
	private void switchExample(String input) {
		switch(input) {
		case "log":
			//log it!
			break;
		case "print":
			//print it!
			break;
		default:
			//I don't know what to do, so I won't do anything!
		}
	}
	
	//SwitchExample ����
	private void badSwitchExample(String input) {
		switch(input) {
		case "log":
			//log it!
		case "print":
			//print it!
			break;
		default:
			//I don't know what to do, so I won't do anything!
		}
	}
}
