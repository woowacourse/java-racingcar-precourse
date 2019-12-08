package com.woowacourse.two;

import java.util.Arrays;
import java.util.Scanner;

public class CarRacingGame {

    Scanner sc = new Scanner(System.in);

    public void run(){
        String[] carNameArr = setCarNameArr(sc);
        System.out.println(Arrays.toString(carNameArr));
        int playCount = setPlayCount(sc);
    }

    public String[] setCarNameArr(Scanner sc){

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
        if(carName.length() == 0 || carName.length() > 5){
            return false;
        }
        return true;
    }

    public int setPlayCount(Scanner sc){
        int playCount = sc.nextInt();
        return playCount;
    }

}
