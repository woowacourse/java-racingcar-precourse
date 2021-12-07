package racingcar;

import java.util.HashSet;
import java.util.Set;

public class RacingGameRule {
	private static final int NAME_LENGTH_LIMIT = 5;

	private boolean checkNoNameException(String carsName) {
		carsName = "," + carsName + ",";
		for (int i = 0; i < carsName.length() - 1; ++i) {
			String twoChar = carsName.substring(i, i + 2);
			if (twoChar.equals(",,")) {
				return false;
			}
		}
		return true;
	}

	private boolean checkNameLengthException(String carsName) {
		String[] carNameBucket = carsName.split(",");
		for (int i = 0; i < carNameBucket.length; ++i) {
			if (carNameBucket[i].length() > NAME_LENGTH_LIMIT) {
				return false;
			}
		}
		return true;
	}

	private boolean checkNameDuplication(String carsName) {
		String[] carNameBucket = carsName.split(",");
		Set<String> existCarName = new HashSet<>();
		for (int i = 0; i < carNameBucket.length; ++i) {
			if (existCarName.contains(carNameBucket[i])) {
				return false;
			}
			existCarName.add(carNameBucket[i]);
		}
		return true;
	}

	protected boolean checkCarName(String carsName) throws IllegalArgumentException {
		if (checkNoNameException(carsName) && checkNameLengthException(carsName) && checkNameDuplication(carsName))
			return true;
		throw new IllegalArgumentException();
	}
}
