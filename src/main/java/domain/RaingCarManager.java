package domain;
/*
 * 클래스 이름 : RacingGameManager
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/12/04
 * Copyright (c) 2019 Moonyoung Chae
 */

import java.util.Scanner;

public class RaingCarManager {
    Scanner scanner = new Scanner(System.in);

    void run() {
        String[] splitedCarName;
        do {
            String carNamesFromUser = getCarNamesFromUser();
            splitedCarName = splitCarName(carNamesFromUser);
        } while (!checkCarName(splitedCarName));
    }

    String getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNamesFromUser = scanner.nextLine();
        return carNamesFromUser;
    }

    String[] splitCarName(String carNamesFromUser) {
        String[] splitedCarNames = carNamesFromUser.split(",");
        return splitedCarNames;
    }

    Boolean checkCarName(String[] splitedCarName) {
        boolean result = true;
        if (splitedCarName.length == 0)
            result = false;

        for (int i = 0; i < splitedCarName.length; i++) {
            if (splitedCarName[i].length() > 5 || splitedCarName[i].length() == 0) {
                result = false;
                break;
            }
        }
        if (!result)
            System.out.println("자동차 이름을 5자이하로 입력해주세요.");
        return result;
    }
}
