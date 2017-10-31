package constant;

/**
 * 
 * - 不允许任何魔法值（即未经定义的常量）直接出现在代码中
 * @see NoMagicValues
 * 
 * - long 或者 Long 初始赋值时，使用大写的 L，不能是小写的 l，小写容易跟数字 1 混 淆，造成误解
 * @see AssingLongValue
 * 
 * @author xiaodong
 *
 */
public class ContantDefinitionExample {
	
	private static final String SUCCESS_RETURN_CODE = "done";
	
	
	//AssingLongValue 正例
	private long goodUniqueNumberAssign = 1L;
	
	//AssingLongValue 反例
	private long uniqueNumber = 1l;
	
	
	//NoMagicValues 正例
	public Boolean isActionCompletedSuccessfully(String returnCode) {
		return SUCCESS_RETURN_CODE.equals(returnCode);
	}
	
	
	//NoMagicValues 反例
	public Boolean isTransactionDone(String bankResturnCode) {
		if ("1000".equals(bankResturnCode)) {
			return true;
		} else {
			return false;
		}
	}
	

}
