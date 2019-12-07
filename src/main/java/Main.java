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
        System.out.println("시도할 회수는 몇 회인가요?");
        attempt = scanner.nextInt();
        cars = createCars(names);
        doGames(cars, attempt);
        printWinners(getWinners(cars));
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.println(createEndResultString(winners));
    }

    public static String createEndResultString(ArrayList<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        int lessThanWinnersLength = winners.size() - 1;

        for (int i = 0; i < lessThanWinnersLength; i++) {
            stringBuilder.append(winners.get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append(winners.get(lessThanWinnersLength));
        stringBuilder.append("(이)가 최종우승 했습니다.");

        return stringBuilder.toString();
    }

    public static ArrayList<String> getWinners(ArrayList<Car> cars) {
        ArrayList<String> winners = new ArrayList<String>();
        int max = getMaxPosition(cars);
        for (Car car: cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public static int getMaxPosition(ArrayList<Car> cars) {
        int max = 0;
        for (Car car: cars) {
            int position = car.getPosition();
            if (position > max) {
                max = position;
            }
        }
        return max;
    }

    public static void doGames(ArrayList<Car> cars, int attempt) {
        for (int i = 0; i < attempt; i++) {
            doOneGame(cars);
        }
    }

    public static void doOneGame(ArrayList<Car> cars) {
                for (Car car: cars) {
                    car.updateOneCycle();
            System.out.println(car.toString());
        }
        System.out.println();
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
