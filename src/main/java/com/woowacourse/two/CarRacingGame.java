package com.woowacourse.two;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class CarRacingGame {

    private Scanner sc;
    private int maxPosition;
    private int countComma;
    private static final int MIN_LETTER_SIZE = 0;
    private static final int MAX_LETTER_SIZE = 5;
    private static final int MAX_RANDOM = 10;
    private static final int OVER_NUMBER_MOVE = 4;



    public void run(){

        sc = new Scanner(System.in);
        maxPosition = Integer.MIN_VALUE;
        countComma = 0;

        String[] carNameArr = setCarNameArr(sc);
        Car[] carArr = setCar(carNameArr);
        int playCount = setPlayCount(sc);
        playCarMove(carArr, playCount);
        printWinner(carArr);
    }

    public String[] setCarNameArr(Scanner sc){

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNameStr = sc.nextLine();

        while(true){
            String[] carNameArr = carNameStr.split(",");

            if(!checkCarNameArr(carNameArr)){
                System.out.println("아무 글자도 입력하지 않았거나 글자가 5자 초과입니다.");
                System.out.println("다시 입력해주세요.");
                carNameStr = sc.nextLine();
                continue;
            }

            return carNameArr;
        }
    }

    public boolean checkCarNameArr(String[] carNameArr){

        for(String carName : carNameArr){
            if(!isRightCarName(carName)){
                return false;
            }
        }

        return true;

    }

    public boolean isRightCarName(String carName){
        if(carName.length() == MIN_LETTER_SIZE || carName.length() > MAX_LETTER_SIZE){
            return false;
        }
        return true;
    }

    public Car[] setCar(String[] carNameArr){

        Car[] carArr = new Car[carNameArr.length];

        for(int i = 0 ; i < carNameArr.length ; i++){
            carArr[i] = new Car(carNameArr[i]);
        }

        return carArr;

    }

    public int setPlayCount(Scanner sc){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int playCount = sc.nextInt();
        return playCount;
    }

    public void playCarMove(Car[] carArr, int playCount){
        System.out.println("실행결과");
        for(int i = 0 ; i < playCount ; i++){
            for(int j = 0 ; j < carArr.length ; j++){
                moveCarOrNot(carArr, j);
            }
            printCarMove(carArr, i, playCount);
        }

    }

    public void moveCarOrNot(Car[] carArr, int carIndex){
        int randomNumber = (int) (Math.random() * MAX_RANDOM);

        if(randomNumber >= OVER_NUMBER_MOVE){
            carArr[carIndex].movePosition();
        }

    }

    public void printCarMove(Car[] carArr, int playIndex, int playCount){
        for(Car car : carArr){
            System.out.println(car.getName() + " : " + car.getCarDistance());

            if(playIndex == playCount - 1){
                findMaxPosition(car);
            }
        }
        System.out.println();
    }

    public void findMaxPosition(Car car){
        if(car.getPosition() > maxPosition){
            maxPosition = car.getPosition();
            countComma++;
        }
    }

    public void printWinner(Car[] carArr){

        String str = "";

        for(Car car : carArr){
            if(car.getPosition() == maxPosition){
                str += car.getName() + ", ";
            }
        }

        str = deleteComma(str);

        System.out.println(str + "가 최종 우승했습니다.");
    }

    public String deleteComma(String str){
        if(str.length() > 0 && str.charAt(str.length() - 2) == ','){
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }

}
