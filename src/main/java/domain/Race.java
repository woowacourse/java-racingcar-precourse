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

    public void initCar(String input) {
        StringTokenizer name = new StringTokenizer(input, ",");

        while (name.hasMoreTokens()) {
            String car = name.nextToken();
            cars.add(new Car(isNameValid(car) ? car : car.substring(0, 5)));
        }
    }

    public void doRace() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).tryRide();
        }
    }

    protected boolean isNameValid(String name) {
        return name.length() <= 5;
    }

    private void makeResult() {
        for (int i = 0; i < cars.size(); i++) {
            result.append(cars.get(i).getName()).append(" : ");
            result.append(positionToResult(cars.get(i).getPosition())).append("\n");
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
        for (int i = 0; i < cars.size(); i++)
            max = Math.max(max, cars.get(i).getPosition());

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() < max) continue;
            result.append(cars.get(i).getName()).append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("가 최종 우승했습니다.");
    }
}
