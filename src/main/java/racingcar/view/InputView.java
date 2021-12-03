package racingcar.view;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.MoveCountValidator;
import racingcar.utils.NameValidator;

public class InputView {
	public static final String REQUEST_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String REQUEST_INPUT_MOVE = "시도할 회수는 몇회인가요?";
	public static final String DELIMITER = ",";

	private NameValidator inputValidator = new NameValidator();
	private MoveCountValidator moveCountValidator = new MoveCountValidator();

	public ArrayList<String> getProperNameList() {
		ArrayList<String> nameList = new ArrayList<>();
		try {
			System.out.println(REQUEST_INPUT_NAMES);
			String inputValues = enterInput();
			nameList = convertToArrayList(inputValues);
			inputValidator.validateNames(nameList);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			getProperNameList();
		}
		return nameList;
	}

	public int getProperMoveCount() {
		int moveCount = 0;
		try {
			System.out.println(REQUEST_INPUT_MOVE);
			String inputValues = enterInput();
			moveCountValidator.validateMove(inputValues);
			moveCount = Integer.parseInt(inputValues);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			getProperMoveCount();
		}
		return moveCount;
	}

	public String enterInput() {
		String inputValues = Console.readLine();
		return inputValues;
	}

	public ArrayList<String> convertToArrayList(String inputValues) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputValues, DELIMITER);
		ArrayList<String> arrayList = new ArrayList<>();
		while (stringTokenizer.hasMoreTokens()) {
			arrayList.add(stringTokenizer.nextToken().trim());
		}
		return arrayList;
	}

}
