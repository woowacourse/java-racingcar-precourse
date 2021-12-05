package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.exception.CarNameException.*;

import java.util.Arrays;
import java.util.List;

public class Input {

	static final String CAR_NAME_DISTINGUISH_STRING = ",";

	public List<String> requestCarsName() {
		String carsName = readLine();
		String[] carsNameList = stringToArraysByComma(carsName);
		checkCarNameException(carsNameList);
		return Arrays.asList(carsNameList);
	}

	public String[] stringToArraysByComma(String carsName) {
		return carsName.split(CAR_NAME_DISTINGUISH_STRING);
	}

	

}
