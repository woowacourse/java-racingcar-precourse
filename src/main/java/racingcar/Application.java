package racingcar;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<Car> carList = new CarList().getList();
		Race race = new Race(carList);
		// 우승자 인스턴스 생성
		// 우승자 출력
	}
}
