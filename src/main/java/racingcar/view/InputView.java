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
		try {
			System.out.println(REQUEST_INPUT_NAMES);
			String inputValues = enterInput();
			ArrayList<String> nameList = convertToArrayList(inputValues);
			inputValidator.validateNames(nameList);
			return nameList;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getProperNameList();
		}
	}

	public int getProperMoveCount() {
		try {
			System.out.println(REQUEST_INPUT_MOVE);
			String inputValues = enterInput();
			moveCountValidator.validateMove(inputValues);
			int moveCount = Integer.parseInt(inputValues);
			return moveCount;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getProperMoveCount();
		}
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
