package seonggyu.cars;

import java.util.List;
import java.util.ArrayList;

public class Winners {
	private static final int INITIAL_MAX_DISTANCE = 0;
	
	private List<Car> winners = new ArrayList<Car>();
	private int maxDistance;
	
	public Winners() {
		this.maxDistance = INITIAL_MAX_DISTANCE;
	}
	
	public int getMaxDistance() {
		return maxDistance;
	}
	
	public void add(Car car) {
		if (car.getPosition() > this.maxDistance) {
			this.maxDistance = car.getPosition();
			this.winners.clear();
		}
		this.winners.add(car);
	}
	
	public void printWinners() {
		for (int i = 0; i < this.winners.size(); i++) {
			System.out.print(this.winners.get(i).getName() + " ");
		}
		System.out.print("가 최종 우승했습니다.");
	}
}
