package racingcar.exception;

public class ErrorResponse {

	public static void of(String message){
		System.out.println("[Error] "+message);
	}
}
