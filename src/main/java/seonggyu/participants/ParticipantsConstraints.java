package seonggyu.participants;

import java.util.List;

public class ParticipantsConstraints {
	private static final int MIN_NUM_OF_NAMES = 2;

	/* 새로운 제한 조건이 생기면 메서드를 만들어 여기에 추가한다 */
	public static void checkValidParticipantsNames(List<String> inputNames) {
		checkEachinputName(inputNames);
		checkValidNumOfinputNames(inputNames);
		checkOverlappinginputNames(inputNames);
	}

	private static void checkEachinputName(List<String> inputNames) {
		inputNames.stream()
			.forEach(inputName -> CarConstraints.checkValidCarName(inputName));
	}

	private static void checkValidNumOfinputNames(List<String> inputNames) {
		if (inputNames.size() < MIN_NUM_OF_NAMES) {
			throw new IllegalArgumentException("2개 이상의 이름을 입력해주세요");
		}
	}

	private static void checkOverlappinginputNames(List<String> inputNames) {
		if (inputNames.stream().distinct().count() != inputNames.size()) {
			throw new IllegalArgumentException("중복되지 않은 이름들을 입력해주세요");
		}
	}
}
