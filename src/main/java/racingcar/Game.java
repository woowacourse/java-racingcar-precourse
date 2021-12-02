package racingcar;

public class Game {

	private final Car[] cars;
	private final int numberOfCars;

	public Game() {
		String[] nameList = InputReader.returnCarNameList();
		numberOfCars = nameList.length;
		cars = new Car[numberOfCars];

		for (int i = 0; i < numberOfCars; i++) {
			cars[i] = new Car(nameList[i]);
		}
	}

}
