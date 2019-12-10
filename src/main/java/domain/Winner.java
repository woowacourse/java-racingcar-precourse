package domain;

import java.util.List;

public class Winner {

	/* 우승자 이름을 저장 */
	private String winner = "";

	/*
	 * 우승자를 계산해서 출력하는 메서드 가장 높은 position에 해당하는 carName을 출력한다.
	 */
	public void showWinner(List<Car> carList) {
		int MAX = 0;
		for (Car car : carList) {
			MAX = updateMAX(MAX, car);
			if (MAX == car.getPosition() && winner != car.getName()) {
				winner += ", " + car.getName();
			}
		}
		System.out.println(winner + "가 최종 우승했습니다.");

	}

	/*
	 * MAX값이 업데이트 되면 winner변수도 같이 업데이트시키는 메서드
	 */
	private int updateMAX(int MAX, Car car) {
		if (MAX < car.getPosition()) {
			winner = car.getName();
			return car.getPosition();
		}
		return MAX;
	}

}
