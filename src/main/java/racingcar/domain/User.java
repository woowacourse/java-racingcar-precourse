package racingcar.domain;

import racingcar.util.Util;
import racingcar.util.Validation;

public class User {

	public String saveCars() {
		String userInput = Util.getUserInput();
		Validation.verifyCar(userInput);
	}

}
