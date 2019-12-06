import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names;
        String rawNames;
        int attempt;    // 시도할 회수

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
        rawNames = scanner.next();
        names = getNamesFromInput(rawNames);
        System.out.println(names); // for debug
        System.out.println("시도할 회수는 몇 회인가요?");
        attempt = scanner.nextInt();
        cars = createCars(names);
    }

    public static ArrayList<Car> createCars(ArrayList<String> names) {
        ArrayList<Car> cars = new ArrayList<Car>();

        for (String name: names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public static ArrayList<String> getNamesFromInput(String input) {
        ArrayList<String> answer = new ArrayList<String>();
        Collections.addAll(answer, input.split(","));

        return answer;
    }
}
