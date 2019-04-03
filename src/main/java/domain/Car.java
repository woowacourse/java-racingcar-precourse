package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
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

	private final int threshold = 4;

//	public String getName() {
//		return this.name;
//	}
//
//	public int getPosition() {
//		return this.position;
//	}
//
//	public int getThreshold() {
//		return this.threshold;
//	}

	public static void playGame() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputCarsNames(br);
		inputNumMove(br);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		System.out.println("\n실행결과");
		try {
			for (int i = 0; i < numMove; i++) {
				moveOneRound();
				printState(bw);
			}
			printResult(bw);
			bw.flush();
			bw.close();
		} catch (IOException e) {
		}
	}

	private static void inputCarsNames(BufferedReader br) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreTokens()) {
				cars.add(new Car(validName(st.nextToken())));
			}
		} catch (Exception e) {
			cars.clear();
			inputCarsNames(br);
		}
	}

	private static String validName(String s) throws Exception {
		if (s.length() > 5) {
			System.out.println("입력 이름 중 길이가 5 초과인 값이 있습니다.");
			throw new Exception();
		}
		return s;
	}

	private static void inputNumMove(BufferedReader br) {
		System.out.println("시도할 회수는 몇회인가요?");
		try {
			numMove = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			inputNumMove(br);
		}
	}

	private static void moveOneRound() {
		Iterator<Car> it = cars.iterator();
		while (it.hasNext()) {
			moveOrNot(it.next());
		}
	}

	private static void moveOrNot(Car c) {
		int tmp = (int) (Math.random() * 10);
		if (tmp >= c.threshold)
			c.position++;
	}

	private static void printState(BufferedWriter bw) throws IOException {
		Iterator<Car> it = cars.iterator();
		while (it.hasNext()) {
			bw.write(it.next().toString() + "\n");
		}
		bw.write("\n");
	}

	private static void printResult(BufferedWriter bw) throws IOException {
		int maxPosition = 0;
		Iterator<Car> it = cars.iterator();
		while (it.hasNext()) {
			maxPosition = Math.max(maxPosition, it.next().position);
		}
		it = cars.iterator();
		ArrayList<String> winner = new ArrayList<>();
		while (it.hasNext()) {
			Car c = it.next();
			if(c.position == maxPosition) winner.add(c.name);
		}
		bw.write(String.join(", ", winner)+"가 최종 우승 했습니다.");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(Car.numMove + 10);
		sb.append(String.format("%-7s", this.name + ":"));
		for (int i = 0; i < this.position; i++)
			sb.append("-");
		return sb.toString();
	}

}
