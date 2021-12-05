package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInputGetter {

	public String[] parseCarName(String nameString){

		String[] names = nameString.split(",");

		return names;
	}

	public String getUserInput(){

		String userInput = Console.readLine();

		return userInput;
	}

	
}
