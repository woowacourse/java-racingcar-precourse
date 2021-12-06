package racingcar;

public class Game {
	private static int numberOfStages;

	private Car[] cars;
	private int numberOfCars;

	public void carMaker(){
		numberOfCars = 0;
		String[] carsName = UserInputGetter.parseCarName(UserInputGetter.getUserInput());

		for(String name : carsName){
			cars[numberOfCars++] = new Car(name);
		}
	}

	public void stageProcess(){
		for(Car car : cars){
			car.goForward();
		}

		//GamePrinter.stagePrinter();
	}

	public void gameProcess(){
		//GamePrinter.getNamePrint();
		carMaker();
		//GamePrinter.getNumberPrint();

		String trialNumber = UserInputGetter.getUserInput();

		if(UserInputValidator.checkInt(trialNumber)){
			numberOfStages = trialNumber.charAt(0) - '0';
		}

		for(int i = 0; i < numberOfStages; i++){
			stageProcess();
		}

		Car[] Champions = findChampion();

	}

	public Car[] findChampion(){

		int maxPosition = findChampionsPosition();
		int numberOfChampion = findNumberOfChampion(maxPosition);


		Car[] champions = new Car[numberOfChampion];

		int tempChampion = 0;

		for(int i = 0; i <= numberOfCars; i++){
			if(cars[i].getPosition() == maxPosition){
				champions[tempChampion] = cars[i];
				tempChampion++;
			}
		}

		return champions;
	}

	public int findChampionsPosition(){

		int maxPosition = 0;

		for(Car car : cars){
			if(car.getPosition() > maxPosition){
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}

	public int findNumberOfChampion(int maxPosition){

		int numberOfChampion = 0;

		for(Car car : cars){
			if(car.getPosition() == maxPosition){
				numberOfChampion++;
			}
		}

		return numberOfChampion;
	}
}
