package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Constant;
import racingcar.utils.Validation;

public class User {
	public static String [] carNameInput(){
		String[] carNames = new String[3];
		do {
			System.out.println(Constant.ASK_CARS_NAME);
			String carNameInput = Console.readLine();
			carNames = carNameInput.split(",");
		} while (!checkRightNames(carNames));

		return carNames;
	}

	public static int gameCountInput(){
		System.out.println(Constant.ASK_GAME_COUNT);
		int gameCount = Integer.parseInt(Console.readLine());
		System.out.println();
		return gameCount;
	}

	public static boolean checkRightNames(String [] carNames){
		boolean isRightNames = true;
		try{
			Validation.CONTAIN_SAME_NAME_ERROR(carNames);
			Validation.WHITE_SPACE_NAME_ERROR(carNames);
			Validation.LESS_MORE_NAME_ERROR(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightNames = false;
		}
		return isRightNames;
	}
}
