package racingcar.view;

public class ExceptionView {

	private static final String ERROR_MESSAGE = "[ERROR] ";

	public static void exceptUI(String errorMessage) {
		System.out.println(ERROR_MESSAGE + errorMessage);
	}
}
