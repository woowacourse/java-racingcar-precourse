package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class CarListMaker {
	ArrayList<Car> carList = new ArrayList<>();

	ArrayList<Car> getCarList(){
		return this.carList;
	}

	CarListMaker(){
		makeList();
	}

	private void makeList(){
		boolean passed = false;
		while (!passed) {
			String chunkOfCarNames = new NameStringMaker().getNameString();
			passed = isValidList(chunkOfCarNames);
		}
	}

	private boolean isValidList(String chunkOfCarNames){
		try {
			carList = getCarList(chunkOfCarNames);
		} catch (IllegalArgumentException error) {
			carList = new ArrayList<>();
			System.out.println(error.getMessage());
			return false;
		}
		return true;
	}

	private ArrayList<Car> getCarList(String chunkOfCarNames) throws IllegalArgumentException {
		InputValidator checker = new InputValidator();
		for (String carName : splitStrToListByComma(chunkOfCarNames)) {
			checker.hasValidLengthAndNoDuplication(carName);
			carList.add(new Car(carName));
		}
		return carList;
	}

	private ArrayList<String> splitStrToListByComma(String str){
		String[] arr = str.split(",");
		List<String> myList =  Stream.of(arr).collect(Collectors.toList());
		return (new ArrayList<String>(myList));
	}
}

class NameStringMaker{
	private String chunkOfCarNames;

	String getNameString(){
		return chunkOfCarNames;
	}

	NameStringMaker(){
		input();
	}

	private String input(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		do {
			String chunkOfCarNames = Console.readLine();
		} while (!isValidInput(chunkOfCarNames));
		return chunkOfCarNames;
	}

	private boolean isValidInput(String input){
		try {
			return InputValidator.isStrContainOnlyAlphabetOrComma(input);
		} catch (Exception error) {
			System.out.println(error.getMessage());
			return false;
		}
	}
}