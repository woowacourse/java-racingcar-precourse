package racingcar.exception;

public class ErrorResponse {

	private String message;

	public static void of(String message){
		System.out.println("[Error] "+message);
	}
}
