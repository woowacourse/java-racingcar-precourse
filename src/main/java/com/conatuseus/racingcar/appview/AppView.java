package com.conatuseus.racingcar.appview;

import java.util.Scanner;

public final class AppView {
    private static final Scanner sc=new Scanner(System.in);

    private AppView(){
    }

    public static void outputLine(String aString){
        System.out.println(aString);
    }

    public static void inputNameOfCar(){
        outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

}
