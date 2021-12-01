package racingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
	private final String name;
	private int position = 0;

	private Car(String name) {
		this.name = name;
	}

	public void goForward() {
		this.position++;
	}

	// TODO ERROR문 상수로 처리하기
	public static void validateName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력해주세요.");
		}

		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하로 입력해주세요.");
		}

		// TODO 클래스 상수로 만들어 가져다쓰기
		Matcher matchTest;
		String spaceRegex = "[\\s]";
		matchTest = Pattern.compile(spaceRegex).matcher(name);
		if (matchTest.find()) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백은 입력 불가능합니다.");
		}

		String nameRegex = "[^a-zA-Z0-9ㄱ-힣]";
		matchTest = Pattern.compile(nameRegex).matcher(name);
		if (matchTest.find()) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 영어나 한글 혹은 숫자로만 입력해주세요.");
		}
	}

	public static Car createCar(String name) {
		validateName(name);
		return new Car(name);
	}

	public int getPosition() {
		return position;
	}
}
