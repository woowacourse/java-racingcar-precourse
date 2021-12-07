package racingcar;

public class RacingGameCarManager {

	private Car[] cars;

	protected void makeCarInstance(String[] carNameBucket) {
		cars = new Car[carNameBucket.length];
		for (int i = 0; i < carNameBucket.length; ++i) {
			cars[i] = new Car(carNameBucket[i]);
		}
	}

	protected void moveAllCars() {
		for (int i = 0; i < cars.length; ++i) {
			cars[i].moveCar();
		}
	}

	protected StringStringPair[] getAllCarsCurrentPositionData() {
		StringStringPair[] allCarsCurrentPositionData = new StringStringPair[cars.length];
		for (int i = 0; i < cars.length; ++i) {
			allCarsCurrentPositionData[i] = new StringStringPair(cars[i].getName(),
				cars[i].getCurrentPositionVisualization());
		}
		return allCarsCurrentPositionData;
	}
}
