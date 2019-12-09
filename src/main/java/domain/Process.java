package domain;

import java.util.ArrayList;

public class Process {
	
	public static void isCarProceed(Car currentCar) {
		int condition = (int) Math.floor(Math.random() * 10);
		if (condition > 3) {
			currentCar.addPosition();
		}
	}
	
	public static void printEachCarStatus(Car currentCar) {
		System.out.print(currentCar.getName() + " : ");
		for (int i = 0; i < currentCar.getPosition(); i++) {
			System.out.print('-');
		}
		System.out.print("\n");
	}
	
	public static ArrayList<Car> findWinner(ArrayList<Car> carList) {
		ArrayList<Car> winnersCarList = new ArrayList<Car>();
		int currentMaxPosition = carList.get(0).getPosition();
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getPosition() == currentMaxPosition) {
				winnersCarList.add(carList.get(i));
			}
			if (carList.get(i).getPosition() > currentMaxPosition) {
				winnersCarList = new ArrayList<Car>();
				winnersCarList.add(carList.get(i));
				currentMaxPosition = carList.get(i).getPosition();
			}
		}
		return winnersCarList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 9;
		char slash = '-';
		//System.out.print(slash);
		//System.out.print(k);
		//System.out.print(slash * k);
		

	}

}
