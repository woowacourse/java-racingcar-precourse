package domain;
/*
 * 클래스 이름 : RacingGameManager
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/12/04
 * Copyright (c) 2019 Moonyoung Chae
 */

import java.util.Scanner;

public class RaingCarManager {
    Car[] cars;
    String[] splitedCarName;
    int gameCount;
    Scanner scanner = new Scanner(System.in);

    void run() {
        getInfoFromUser();
        makeCars();
        race();
    }

    void getInfoFromUser(){
        do {
            String carNamesFromUser = getCarNamesFromUser();
            splitedCarName = splitCarName(carNamesFromUser);
        } while (!checkCarName(splitedCarName));

        do{
            gameCount = getGameCountFromUser();
        }while(gameCount <= 0);
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


    public int getGameCountFromUser() {
        System.out.println("시도할 회수는 몇 회인가요?");
        int gameCountFromUser;
        try {
            gameCountFromUser = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("1이상의 자연수를 입력해주세요.");
            gameCountFromUser = 0; // 문자이거나 정수가 아니라면 0을 반환한다.
        }
        return gameCountFromUser;
    }

    public void makeCars() {
        cars = new Car[splitedCarName.length];
        for (int i = 0; i < splitedCarName.length; i++) {
            cars[i] = new Car(splitedCarName[i]);
        }
    }

    public void race() {
        for (int nowGameCount = 0; nowGameCount < gameCount; nowGameCount++) {
            for (int carIndex = 0; carIndex < cars.length; carIndex++) {
                int randomNumber = cars[carIndex].makeRandomNumber();
                cars[carIndex].move(randomNumber);
            }
        }
    }
}
