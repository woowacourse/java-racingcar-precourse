package com.conatuseus.racingcar.appview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class AppView {
    private static final Scanner sc=new Scanner(System.in);

    private AppView(){
    }

    public static void outputLine(String aString){
        System.out.println(aString);
    }

    public static void inputNameOfCar(){
        String[] scannedName;
        while (true){
            outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            scannedName=sc.nextLine().split(",");

            if(isNamesValid(scannedName)){
                break;
            }
            outputLine("잘못 입력하였습니다.");
        }
    }

    public static boolean isNamesValid(String[] scannedName){
        for(String name : scannedName){
            if((name.length()>5) || (!name.matches("^[a-zA-Z]*$"))){
                return false;
            }
        }
        return !isContains(scannedName);
    }

    public static boolean isContains(String[] scannedName){
        Set<String> hashSet=new HashSet<>();
        for(String name : scannedName){
            if(hashSet.contains(name)){
                return true;
            }
            hashSet.add(name);
        }
        return false;
    }




}
