package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class GenerateRandomNo {
	int randomNo;

	GenerateRandomNo() {
		randomNo = pickNumberInRange(NumberRange.MIN_NO.getValue(), NumberRange.MAX_NO.getValue());
	}
}
