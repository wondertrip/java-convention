package constant;

/**
 * 
 * - �������κ�ħ��ֵ����δ������ĳ�����ֱ�ӳ����ڴ�����
 * @see NoMagicValues
 * 
 * - long ���� Long ��ʼ��ֵʱ��ʹ�ô�д�� L��������Сд�� l��Сд���׸����� 1 �� ����������
 * @see AssingLongValue
 * 
 * @author xiaodong
 *
 */
public class ContantDefinitionExample {
	
	private static final String SUCCESS_RETURN_CODE = "done";
	
	
	//AssingLongValue ����
	private long goodUniqueNumberAssign = 1L;
	
	//AssingLongValue ����
	private long uniqueNumber = 1l;
	
	
	//NoMagicValues ����
	public Boolean isActionCompletedSuccessfully(String returnCode) {
		return SUCCESS_RETURN_CODE.equals(returnCode);
	}
	
	
	//NoMagicValues ����
	public Boolean isTransactionDone(String bankResturnCode) {
		if ("1000".equals(bankResturnCode)) {
			return true;
		} else {
			return false;
		}
	}
	

}
