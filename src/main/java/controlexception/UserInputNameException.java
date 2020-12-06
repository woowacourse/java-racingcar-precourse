package controlexception;

public class UserInputNameException extends RuntimeException{
	//입력에 관련된 예외를 처리하는 클래스.
	static final private String LENGTHLIMIT = "5";
	static private String userInputNumber;
	public UserInputNameException(int userInputNumber){
		this.userInputNumber = Integer.toString(userInputNumber);
	}

	@Override
	public String getMessage() {
		return "[ERROR] 입력된 데이터의 길이가 "+ userInputNumber + "입니다. 다시 입력해주세요." + "(제한된 길이 : " + LENGTHLIMIT +")" ;
	}
}
