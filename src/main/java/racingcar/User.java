package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public static String [] driverNameInput(){
		String [] driverNames = new String[3];
		String driverNameInput = Console.readLine();
		driverNames = driverNameInput.split(",");
		return driverNames;
	}

	public static int gameCountInput(){
		int gameCount = Integer.parseInt(Console.readLine());
		return gameCount;
	}
}
