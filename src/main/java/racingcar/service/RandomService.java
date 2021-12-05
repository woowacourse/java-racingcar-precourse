package racingcar.service;
import camp.nextstep.edu.missionutils.Randoms;


public class RandomService {
	private static final int MIN_NUMBER_RANGE = 0;
	private static final int MAX_NUMBER_RANGE = 9;
	private static final int MOVABLE_CONDITION_NUMBER = 4;

	public static boolean isCarMovable(){
		return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE) <= MOVABLE_CONDITION_NUMBER;
	}
}
