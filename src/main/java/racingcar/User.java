package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public String [] driverNameInput(){
		String [] driverNames = new String[3];
		String driverNameInput = Console.readLine();
		driverNames = driverNameInput.split(",");
		return driverNames;
	}

	public int gameCountInput(){
		int gameCount = Integer.parseInt(Console.readLine());
		return gameCount;
	}
}
