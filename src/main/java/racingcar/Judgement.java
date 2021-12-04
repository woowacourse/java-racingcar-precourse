package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Judgement {

	public void judgeRanking(List<Car> carList) {
		Collections.sort(carList, new CarComparator());
	}

	public List<Car> judgeWinner(List<Car> carList) {
		List<Car> results = new ArrayList<Car>();
		int max = carList.get(0).getPosition();
		for(Car car:carList) {
			if(car.getPosition() != max) {
				break;
			}
			results.add(car);
		}
		return  results;
	}

	public boolean checkGameEnd(int count) {
		return count == 0;
	}

	private class CarComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o2.getPosition() - o1.getPosition();
		}
	}
}
