package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public Car[] makeCars(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i=0; i< names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public static void main(String[] args) {
        Application application = new Application();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        System.out.println();

        Car[] cars = application.makeCars(names);
    }
}
