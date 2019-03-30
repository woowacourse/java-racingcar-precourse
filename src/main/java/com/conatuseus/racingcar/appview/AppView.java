package com.conatuseus.racingcar.appview;

import java.util.Scanner;

public final class AppView {

    private static Scanner sc=new Scanner(System.in);

    private AppView(){
    }

    public void outputLine(String aString){
        System.out.println(aString);
    }

}
