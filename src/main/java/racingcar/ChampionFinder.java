package racingcar;

public class ChampionFinder {

	public static String[] findChampion(Car[] cars) {

		int maxPosition = findChampionsPosition(cars);
		int numberOfChampion = findNumberOfChampion(cars, maxPosition);


		String[] champions = new String[numberOfChampion];

		int tempChampion = 0;

		for(int i = 0; i < cars.length; i++){
			if(cars[i].getPosition() == maxPosition){
				champions[tempChampion] = cars[i].getName();
				tempChampion++;
			}
		}

		return champions;
	}

	public static int findChampionsPosition(Car[] cars){

		int maxPosition = 0;

		for(Car car : cars){
			if(car.getPosition() > maxPosition){
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}

	public static int findNumberOfChampion(Car[] cars, int maxPosition){

		int numberOfChampion = 0;

		for(Car car : cars){
			if(car.getPosition() == maxPosition){
				numberOfChampion++;
			}
		}

		return numberOfChampion;
	}
}
