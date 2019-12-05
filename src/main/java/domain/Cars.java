package domain;

import java.util.ArrayList;

public class Cars {
	private ArrayList<Car> cars = new ArrayList<Car>(); //생성된 Car 객체를 보관할 ArrayList
	private ArrayList<String> winner = new ArrayList<String>();
	private int maxPos = 0;
	
	public int getSize() {
		return this.cars.size();
	}
	public void addList(Car car) {
		this.cars.add(car);
	}
	
	public void playTurn(int idx) {
		Car currCar = cars.get(idx);
		if(moveTurn()) {
			currCar.forward();
		}
		currCar.printPos();
		int currPos = currCar.getPos();
		if(currPos > maxPos) maxPos = currPos;
	}
	
	public boolean moveTurn() {
		RN rn = new RN();
		return (rn.makeRandom() >= 4);
	}
	
	public void putResult() {
		for(int i=0; i<this.getSize(); i++) {
			Car currCar = cars.get(i);
			if(currCar.getPos() == maxPos) this.winner.add(currCar.getName());
		}
	}
	
	public void printResult() {
		for(int i=0; i<this.winner.size(); i++) {
			System.out.print(winner.get(i));
			if(i != this.winner.size()-1) System.out.print(", ");
		}
		System.out.print("가 최종 우승했습니다.\n");
	}
}
