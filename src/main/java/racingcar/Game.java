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

		String[] carNames = UserInputGetter.getCarNames();
		carMaker(carNames);
		this.numberOfStage = UserInputGetter.getNumberOfStage();
		GamePrinter.goToStagePrint();
	}





	public void endGame(){

		String[] champions = ChampionFinder.findChampion(this.cars);
		GamePrinter.printChampion(champions);
	}


}
