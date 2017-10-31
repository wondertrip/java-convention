package statement;

/**
 * - 在一个 switch 块内，每个 case 要么通过 break/return 等来终止，
 *   要么注释说明程 序将继续执行到哪一个 case 为止；
 *   在一个 switch 块内，都必须包含一个 default 语句并且 放在最后，即使它什么代码也没有
 * @see SwitchExample
 * 
 * - 在 if/else/for/while/do 语句中必须使用大括号。即使只有一行代码，避免采用 单行的编码方式：if (condition) statements
 * @see IfExample
 * 
 * - 除常用方法（如 getXxx/isXxx）等外，不要在条件判断中执行其它复杂的语句，
 *   将复 杂逻辑判断的结果赋值给一个有意义的布尔变量名，以提高可读性
 * @see ConditionChecking
 * 
 * @author xiaodong
 *
 */
public class StatementExample {
	
	private void contitionCheckExample(String argument) {
		
		//ConditionChecking 正例
		boolean isValid = validPerDBConfiguration(argument) && validPerBusinessRequirement(argument); 
		if (isValid) {
			//then let's continue the business
		}
		
		
		//ConditionChecking 反例
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
		
		//IfExample 正例
		if ("ok".equals(input)) {
			//great! processing completed successfully! Let's celebrate!
		}
		
		//IfExample 反例
		if ("ok".equals(input)) celebrate(); //ah! you are celebrating too early! Please fix this problem firstly!
		
	}
	
	private void celebrate() {
		
	}

	//SwitchExample 正例
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
	
	//SwitchExample 反例
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
