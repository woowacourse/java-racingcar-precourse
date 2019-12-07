package domain;

import java.util.Scanner;

public class UserInput {

    String[] cars;
    int raceCount;

    public UserInput() {
        Scanner scanner = new Scanner(System.in);
        this.carNamesInput(scanner);
        this.raceCountInput(scanner);
    }

    public void carNamesInput(Scanner scanner) {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            System.out.println("입력 조건 : 1. 이름은 5자 까지만 가능, 공백 불가능, 쉼표(,)는 이름에 사용할수 없음, 영대소문자만 가능");
            String carNames = scanner.nextLine();
            cars = carNames.split(",");
            if (this.carNamesCheck(cars)) {
                break;
            }
        }
    }

    public void raceCountInput(Scanner scanner) {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                this.raceCount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }
            if (this.raceCount > 0) {
                break;
            }
            System.out.println("양수를 입력해주세요.");
        }
    }

    public boolean carNamesCheck(String[] cars) {
        if (cars.length == 0) {
            return false;
        }
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5 || cars[i].length() == 0 || cars[i].contains(" ") || !cars[i].matches("^[a-zA-Z]*$")) {
                return false;
            }
        }
        return true;
    }
}
