package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameTools {

	public static int getRandomNumber(){
		return Randoms.pickNumberInRange(1,9);
	}

	public static boolean judgeMoreThan4(int randomNumber){
		if(randomNumber > 3){
			return true;
		}
		return false;
	}

}
