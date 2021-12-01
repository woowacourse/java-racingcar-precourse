package racingcar.view;

public class ProcessView implements View {

	private String PROCESS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	@Override
	public void printView() {
		System.out.println(PROCESS_INPUT_MESSAGE);
	}

	@Override
	public String getUserInput() {
		return null;
	}
}
