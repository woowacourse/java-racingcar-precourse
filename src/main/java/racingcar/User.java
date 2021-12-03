package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Constant;

public class User {
	public static String [] driverNameInput(){
		String [] driverNames = new String[3];

		System.out.println(Constant.ASK_CARS_NAME);
		String driverNameInput = Console.readLine();
		driverNames = driverNameInput.split(",");

		return driverNames;
	}

	public static int gameCountInput(){
		System.out.println(Constant.ASK_GAME_COUNT);
		int gameCount = Integer.parseInt(Console.readLine());
		System.out.println();
		return gameCount;
	}
}
