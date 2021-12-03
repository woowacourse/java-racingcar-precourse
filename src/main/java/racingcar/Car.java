package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;
	private StringBuffer report;

	public Car(String name) {
		this.name = name;
		this.report = new StringBuffer();
		this.report.append(name);
		this.report.append(" : ");
	}

	// 추가 기능 구현
	public void move() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			this.position++;
			this.report.append("-");
		}
	}

	public void statusReport() {
		System.out.println(report.toString());
	}
}
