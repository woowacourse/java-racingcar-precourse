/*
 * @Car.java     0.1 2019-04-04
 * Copyright(c) 2019 LeeYunSeop All rights reserved.
 * */

package domain;

import java.util.*;

/**
 * RacingCar class
 * @version 0.1
 * @author yun
 *
 * 자동차 이름을 콤마(,)로 구분하여 입력
 * 최대 5글자로 입력할 수 있고 중복된 이름 허용X
 * 중복된 이름이 있으면 Warning message 출력
 * N번 시행하며 Car의 position이 임의로 증가
 * 매 시행마다 Car의 위치를 보여주는 Progression bar를 출력
 * 최종 (공동)우승자 출력
 * ex) 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
 * woowa,yogiyo,tong,bmin
 * 자동차 이름의 길이는 5입니다(yogiyo: 6).
 * 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
 * woowa,yogi,tong,bmin,woowa,bmin
 * [Warning]중복된 이름(woowa, bmin)이 발생하였습니다.
 * 시도할 횟수는 몇회인가요?
 * 5
 * woowa : -
 * yogi :
 * tong :
 * bmin : -
 *
 * woowa : --
 * yogi : -
 * tong :
 * bmin : -
 *
 * woowa : ---
 * yogi : -
 * tong : -
 * bmin : --
 *
 * woowa : ---
 * yogi : --
 * tong : --
 * bmin : ---
 *
 * woowa : ----
 * yogi : --
 * tong : ---
 * bmin : ----
 *
 * woowa, bmin가 최종 우승했습니다.
 * */
public class RacingCar {

    /**
     * inputCarName
     * @return Set<String> 중복을 제거한 자동차 이름
     *
     * 자동차 이름을 입력받고 ","로 구분
     * 이름의 길이는 최대 5글자로 넘어가면 다시 입력(조건을 만족할 때까지 계속 입력받음)
     * 중복된 이름 발생 시 제거 하고 Warning message 출력
     * */
    public Set<String> inputCarName() {
        Scanner sc = new Scanner(System.in);
        String carNames;
        String[] splitCarNames;
        Set<String> distinctCarName = new HashSet<>();
        boolean isNamingRule;

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = sc.nextLine();
            splitCarNames = carNames.split(",");
            isNamingRule = namingRule(splitCarNames); // 이름 규칙을 만족하지 않으면 false를 반환
            if (isNamingRule) {
                Collections.addAll(distinctCarName, splitCarNames);
                printWarningMessage(splitCarNames, distinctCarName);
                break;
            }
        }
        return distinctCarName;
    }

    /**
     * printWarningMessage
     * @param splitCarNames 각 이름이 5글자 이하인 배열
     * @param distinctCarName 중복을 제거한 이름 배열
     *
     * splitCarNames와 distinctCarName을 비교
     * 중복 발생 시 duplicatedName에 ','로 join하고 Warning message 출력
     * 중복 미발생 시 출력하지 않음
     * O(N^2) 소요
     * */
    public void printWarningMessage(String[] splitCarNames,
                                    Set<String> distinctCarName) {
        int duplicatedCount; // 각 이름마다 중복된 횟수, 1을 넘어가면 duplicatedName에 추가
        StringJoiner duplicatedName = new StringJoiner(", ");
        for (String distinctName: distinctCarName) { // 중복 제거한 이름
            duplicatedCount = countingCarName(distinctName, splitCarNames);
            if (duplicatedCount > 1) {
                duplicatedName.add(distinctName);
            }
        }
        if (duplicatedName.length() > 0) { // 중복된 경우가 발생하면 warning message 출력
            System.out.printf("[Warning]중복된 이름(%s)이 발생하였습니다.\n",
                    duplicatedName);
        }
    }

    /**
     * countingCarName
     * @param distinctName 갯수를 확인할 이름
     * @param splitCarNames 각 이름이 5글자 이하인 배열
     * @return int 중복도
     *
     * distinctName이 splitCarNames에 몇개 있는지 확인
     * */
    public int countingCarName(String distinctName,
                               String[] splitCarNames) {
        int count = 0;
        for (String carName: splitCarNames) {
            if (carName.equals(distinctName)) {
                count ++;
            }
        }
        return count;
    }

    /**
     * namingRule
     * @param carNames ','로 분리한 자동차 이름 배열
     * @return boolean
     *
     * 입력한 자동차 이름 중 하나라도 5글자를 넘어가면 false를 반환
     * */
    public boolean namingRule(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > 5) {
                System.out.printf("자동차 이름의 길이는 5입니다(%s: %d).\n",
                        name, name.length());
                return false;
            }
        }
        return true;
    }

    /**
     * moveCount
     * @return int 시행할 횟수
     * */
    public int moveCount() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * getCarList
     * @param carNames 중복제거한 자동차 이름
     * @return ArrayList<Car> Car object 저장한 배열
     *
     * 규칙에 따라 입력받은 이름 배열로 Car object 생성
     * 각 이름으로 object를 생성한 뒤 carList에 저장
     * */
    public ArrayList<Car> getCarList(Set<String> carNames) {
        ArrayList<Car> carList = new ArrayList<Car>();
        Car car;
        for (String name: carNames) {
            car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    /**
     * printCar
     * @param carList Car object 저장한 배열
     *
     * 매 시행마다 모든 자동차 이름과 progression bar 출력
     * */
    public void printCar(ArrayList<Car> carList) {
        String carName;
        int carPosition;
        String carProgression;
        for (Car car: carList) {
            carName = car.getName();
            carPosition = car.getPosition();
            carProgression = getCarProgression(carPosition);
            System.out.printf("%s : %s\n", carName, carProgression);
        }
        System.out.println();
    }

    /**
     * getCarProgression
     * @param carPosition 자동차의 위치에 따라 progression bar 반환
     * @return String
     *
     * ex) carPosition = 3 -> "---"
     * */
    public String getCarProgression(int carPosition) {
        StringBuilder carProgression = new StringBuilder();
        if (carPosition < 1) { return carProgression.toString(); }
        for (int i = 0; i < carPosition; i++) {
            carProgression.append("-");
        }
        return carProgression.toString();
    }

    /**
     * moveCars
     * @param carList Car object 저장한 배열
     *
     * loop로 모든 Car object에 대해 move method 실행
     * */
    public void moveCars(ArrayList<Car> carList) {
        for (Car car: carList) {
            car.move();
        }
    }

    /**
     * play
     *
     * Racing-Car game 실행
     * */
    public void play() {
        Set<String> carNames = inputCarName();
        ArrayList<Car> carList = getCarList(carNames);
        System.out.println("시도할 횟수는 몇회인가요?");
        int count = moveCount();
        for (int i = 0; i < count; i++) {
            moveCars(carList);
            printCar(carList);
        }
        printWinner(carList);
    }

    /**
     * printWinner
     * @param carList Car object 저장한 배열
     *
     * position 값이 가장 큰 자동차를 출력
     * */
    public void printWinner(ArrayList<Car> carList) {
        int maxPosition = getMaxPosition(carList);
        int carPosition;
        String carName;
        StringJoiner winnerName = new StringJoiner(", ");
        for (Car car: carList) {
            carPosition = car.getPosition();
            carName = car.getName();
            if (carPosition == maxPosition) {
                winnerName.add(carName);
            }
        }
        System.out.printf("%s가 최종 우승했습니다.\n", winnerName);
    }

    /**
     * getMaxPosition
     * @param carList Car object 저장한 배열
     * @return int 가장 큰 position 값
     *
     * loop로 가장 큰 position 반환
     * */
    public int getMaxPosition(ArrayList<Car> carList) {
        int maxPosition = 0;
        int carPosition;
        for (Car car: carList) {
            carPosition = car.getPosition();
            maxPosition = Math.max(maxPosition, carPosition);
        }
        return maxPosition;
    }

}
