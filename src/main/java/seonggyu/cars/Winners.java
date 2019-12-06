package seonggyu.cars;

import java.util.List;
import java.util.ArrayList;

public class Winners {
	private static final int INITIAL_MAX_DISTANCE = 0;
	
	private List<String> winners = new ArrayList<String>();
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
		this.winners.add(car.getName());
	}
	
	public void printWinners() {
		for(int i = 0; i < winners.size() - 1; i++) {
			System.out.print(winners.get(i) + ", ");
		}
		if(winners.size() > 0) {
			System.out.print(winners.get(winners.size()-1) + " ");
		}
		System.out.print("가 최종 우승했습니다.");
	}
}
