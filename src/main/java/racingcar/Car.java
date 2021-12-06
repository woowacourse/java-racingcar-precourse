package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		isValidLength(name);
		this.name = name;
	}

	boolean isValidLength(String name) {
		int len = name.length();
		if (0 < len && len <= 5) {
			return true;
		}
		throw new IllegalArgumentException("[ERROR] 자동차 이름은 최대 5글자 입니다.");
	}

	String getName() {
		return name;
	}

	int getPosition() {
		return position;
	}

	void moveNext() {
		position++;
	}

	void printPosition() {
		System.out.println(name + " : " + new DashAsPosition().getDash());
	}

	class DashAsPosition {
		private StringBuilder dash;

		DashAsPosition() {
			dash = new StringBuilder();
			for (int i = 0; i < position; i++) {
				dash.append("-");
			}
		}

		public StringBuilder getDash() {
			return dash;
		}
	}
}
