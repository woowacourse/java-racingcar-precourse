package racingcar.exception.dto;

public class ErrorResponse {

	public static void of(String message){
		System.out.println("[ERROR] "+message);
	}
}
