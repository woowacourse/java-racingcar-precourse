package racingcar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Judgement {

	public void judgeRanking(List<Car> carList) {
		Collections.sort(carList, new CarComparator());
	}

	private class CarComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o2.getPosition() - o1.getPosition();
		}
	}
}
