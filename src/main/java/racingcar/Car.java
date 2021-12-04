package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		if (isValidLength(name)) {
			this.name = name;
		}
		throw new IllegalArgumentException();
	}

	boolean isValidLength(String name) {
		int len = name.length();
		return 0 < len && len <= 5;
	}

	// 추가 기능 구현
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
		System.out.printf("%s : %s", name, new DashAsPosition().getDash());
		System.out.println();
	}

	private StringBuilder dash;

	class DashAsPosition {
		private StringBuilder dash;

		DashAsPosition() {
			for (int i = 0; i < position; i++) {
				dash.append("-");
			}
		}

		public StringBuilder getDash() {
			return dash;
		}
	}
}