package domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Race {

    private Scanner sc = new Scanner(System.in);

    private ArrayList<Car> cars = new ArrayList<>();;
    private int count;

    // 레이스 실행
    public void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        initCar(sc.nextLine());

        System.out.println("시도할 회수는 몇회인가요?");
        count = sc.nextInt();
        sc.nextLine();

        while (count-- > 0) {
            doRace();
        }

        printWinner();
    }

    // 자동차 초기화
    public void initCar(String input) {
        StringTokenizer name = new StringTokenizer(input, ",");

        while (name.hasMoreTokens()) {
            String car = name.nextToken();
            cars.add(new Car(isNameValid(car) ? car : car.substring(0, 5)));
        }
    }

    // 레이스 실행
    public void doRace() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).tryRide();
        }
    }

    // 이름 조건 확인
    protected boolean isNameValid(String name) {
        return name.length() <= 5;
    }

    // 실행결과 출력
    private void printResult() {
        StringBuilder result = new StringBuilder("실행 결과");
        for (int i = 0; i < cars.size(); i++) {
            result.append(cars.get(i).getName()).append(" : ");
            result.append(positionToResult(cars.get(i).getPosition())).append("\n");
        }
        result.append("\n");

        System.out.println(result.toString());
    }

    // 자동차 위치를 문자열로 바꿈
    private String positionToResult(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++)
            result.append("-");

        return result.toString();
    }

    // 우승자 출력
    private void printWinner() {
        System.out.println("");

    }
}
