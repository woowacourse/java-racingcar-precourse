package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = scanner.nextLine();
        CarRace carRace = new CarRace(carNameInput);

        System.out.println("시도할 횟수는 몇회인가요?");
        int numberInput = scanner.nextInt();
        carRace.doRace(numberInput);
        scanner.close();
    }
}
