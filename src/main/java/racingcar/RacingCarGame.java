package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class RacingCarGame {

    private Scanner scanner;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        getCarNames();
    }

    private void getCarNames() {
        while (true) {
            try{
                String[] carNames = askCarNames();
                checkUnderFiveLetters(carNames);
                break;
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
            }
        }
        System.out.println("완료");
    }

    private String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    private void checkUnderFiveLetters(String[] carNames) {
        for (String carName:  carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하이어야 한다.");
            }
        }
    }
}
