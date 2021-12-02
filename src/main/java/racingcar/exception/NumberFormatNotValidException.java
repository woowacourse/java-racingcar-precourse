package racingcar.exception;

public class NumberFormatNotValidException extends IllegalArgumentException{
	private static final String MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

	public NumberFormatNotValidException(){
		System.out.println(MESSAGE);
	}
}
