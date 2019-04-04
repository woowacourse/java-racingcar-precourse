package domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Race {

    private Scanner sc = new Scanner(System.in);

    private StringBuilder result = new StringBuilder("실행 결과\n");
    private ArrayList<Car> cars = new ArrayList<>();
    private int count;

    public void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        initCar(sc.nextLine());

        System.out.println("시도할 회수는 몇회인가요?");
        count = sc.nextInt();
        sc.nextLine();

        while (count-- > 0) {
            doRace();
            makeResult();
        }
        getWinner();
        printResult();
    }

    private void initCar(String input) {
        StringTokenizer name = new StringTokenizer(input, ",");

        while (name.hasMoreTokens()) {
            String car = name.nextToken();
            cars.add(new Car(isNameValid(car) ? car : car.substring(0, 5)));
        }
    }

    private void doRace() {
        for (Car car : cars)
            car.tryRide();
    }

    private boolean isNameValid(String name) {
        return name.length() <= 5;
    }

    private void makeResult() {
        for (Car car : cars) {
            result.append(car.getName()).append(" : ");
            result.append(positionToResult(car.getPosition())).append("\n");
        }
        result.append("\n");
    }

    private void printResult() {
        System.out.println(result.toString());
    }

    private String positionToResult(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++)
            result.append("-");

        return result.toString();
    }

    private void getWinner() {
        int max = 0;
        for (Car car : cars)
            max = Math.max(max, car.getPosition());

        for (Car car : cars) {
            if (car.getPosition() < max) continue;
            result.append(car.getName()).append(", ");
        }
        result.delete(result.length()-2, result.length()); // 맨 뒤 쉼표 삭제
        result.append("가 최종 우승했습니다.");
    }
}
