package racingcar;

public class Game {

	private Car[] cars;
	private int numberOfCars;

	public void carMaker(){
		numberOfCars = 0;
		String[] carsName = UserInputGetter.parseCarName(UserInputGetter.getUserInput());

		for(String name : carsName){
			cars[numberOfCars++] = new Car(name);
		}
	}
}
