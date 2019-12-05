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

    void run(){
        String carNamesFromUser = getCarNamesFromUser();
        String[] splitedCarName = splitCarName(carNamesFromUser);
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
}
