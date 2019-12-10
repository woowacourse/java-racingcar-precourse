/**
 * 차량의 정보와 동작을 위한 클래스
 *
 * @author	MinKyu,Song
 * @version	1.0 12/10/2019
 */

package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	private static final int THRESHOLD = 4;

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void run(int value) {
		if (isMoved(value)) {
			this.position++;
		}
	}

	private boolean isMoved(int value) {
		return value >= THRESHOLD;
	}
}
