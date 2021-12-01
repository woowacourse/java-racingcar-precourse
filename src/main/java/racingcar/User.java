package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class User {
	public String [] carNameInput(){
		String [] driverNameList = new String[3];
		String driverNameInput = Console.readLine();
		driverNameList = driverNameInput.split(",");
		return driverNameList;
	}
}
