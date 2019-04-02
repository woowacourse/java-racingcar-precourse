package domain;

import java.util.Scanner;

public class CarNameReciever {
    static final int MAX_CAR_NAME_LENGTH = 5;
    private String[] carNames;
    private Scanner scanner = new Scanner(System.in);


    public String[] RecieveCarNamesFromUser() {
        try {
            tryToRecieveCarNamesFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            RecieveCarNamesFromUser();
        }
        return this.carNames;
    }

    private void tryToRecieveCarNamesFromUser() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)기준으로 구분");
        carNames = scanner.nextLine().split(",");
        if (isNotValidCarNames()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotValidCarNames() {
        for (int i = 0; i < carNames.length; i++) {
            if (isNotValidCarName(carNames[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotValidCarName(String carName) {
        return carName.length() > MAX_CAR_NAME_LENGTH ? true : false;
    }


}
