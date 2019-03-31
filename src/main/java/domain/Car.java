package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현

	private static ArrayList<Car> cars = new ArrayList<Car>();
	private static int numMove = 0;

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void playGame() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputCarsName(br);
		inputNumMove(br);

	}

	private void inputCarsName(BufferedReader br) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreTokens()) {
				cars.add(new Car(validName(st.nextToken())));
			}
		} catch (Exception e) {
			inputCarsName(br);
		}
	}

	private String validName(String s) throws Exception {
		if (s.length() > 5) {
			System.out.println("입력 이름 중 길이가 5 초과인 값이 있습니다.");
			throw new Exception();
		}
		return s;
	}

	private void inputNumMove(BufferedReader br) {
		System.out.println("시도할 회수는 몇회인가요?");
		try {
			numMove = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			inputCarsName(br);
		}
	}

}
