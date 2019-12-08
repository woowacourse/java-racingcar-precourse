package com.woowacourse.two;

import java.util.Arrays;
import java.util.Scanner;

public class CarRacingGame {

    Scanner sc = new Scanner(System.in);

    public void run(){
        String[] carNameArr = getCarNameArr(sc);
        System.out.println(Arrays.toString(carNameArr));
    }

    public String[] getCarNameArr(Scanner sc){

        String carNameStr = sc.nextLine();
        String[] carNameArr = carNameStr.split(",");

        return carNameArr;

    }
}
