package racingcar;

public class Game {
	private int numberOfStage;

	private Car[] cars;
	private int numberOfCars;

	public void carMaker(String[] carNames){
		this.numberOfCars = carNames.length;

		cars = new Car[numberOfCars];

		for(int i = 0; i < numberOfCars; i++){
			this.cars[i] = new Car(carNames[i]);
		}
	}

	public void stageProcess(){
		for(Car car : this.cars){
			car.goForward();
		}

		GamePrinter.stagePrint(this.cars);
	}

	public void gameProcess(){

		initGame();

		for(int i = 0; i < this.numberOfStage; i++){
			stageProcess();
		}

		endGame();
	}

	public void initGame(){

		String[] carNames = getCarNames();
		carMaker(carNames);
		getNumberOfStage();
	}

	public void getNumberOfStage(){


		GamePrinter.getNumberPrint();

		String trialNumber;

		while(true){
			try{
				trialNumber = UserInputGetter.getUserInput();
				if(UserInputValidator.checkInt(trialNumber)){
					break;
				}
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				GamePrinter.getNumberPrint();
			}
		}

		this.numberOfStage = Integer.parseInt(trialNumber);
	}

	public String[] getCarNames(){

		GamePrinter.getNamePrint();

		String[] carNames;

		while(true) {
			try {
				carNames = UserInputGetter.parseCarName(UserInputGetter.getUserInput());
				if (UserInputValidator.checkNameLength(carNames)) {
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				GamePrinter.getNamePrint();
			}
		}

		return carNames;
	}

	public void endGame(){

		String[] champions = findChampion();
		GamePrinter.printChampion(champions);
	}

	public String[] findChampion(){

		int maxPosition = findChampionsPosition();
		int numberOfChampion = findNumberOfChampion(maxPosition);


		String[] champions = new String[numberOfChampion];

		int tempChampion = 0;

		for(int i = 0; i < this.numberOfCars; i++){
			if(this.cars[i].getPosition() == maxPosition){
				champions[tempChampion] = this.cars[i].getName();
				tempChampion++;
			}
		}

		return champions;
	}

	public int findChampionsPosition(){

		int maxPosition = 0;

		for(Car car : this.cars){
			if(car.getPosition() > maxPosition){
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}

	public int findNumberOfChampion(int maxPosition){

		int numberOfChampion = 0;

		for(Car car : this.cars){
			if(car.getPosition() == maxPosition){
				numberOfChampion++;
			}
		}

		return numberOfChampion;
	}
}
