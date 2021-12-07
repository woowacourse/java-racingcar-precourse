package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInputGetter {

	public static String[] parseCarName(String nameString){

		String[] names = nameString.split(",");

		return names;
	}

	public static int getNumberOfStage(){


		GamePrinter.getNumberPrint();

		String trialNumber;

		while(true){
			try{
				trialNumber = Console.readLine();
				UserInputValidator.checkInt(trialNumber);
				return Integer.parseInt(trialNumber);
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				GamePrinter.getNumberPrint();
			}
		}


	}

	public static String[] getCarNames(){

		GamePrinter.getNamePrint();

		String[] carNames;

		while(true) {
			try {
				carNames = UserInputGetter.parseCarName(Console.readLine());
				UserInputValidator.checkNameLength(carNames);
				return carNames;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				GamePrinter.getNamePrint();
			}
		}

	}

}
