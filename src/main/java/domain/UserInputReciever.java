package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInputReciever  {
    Scanner scanner = new Scanner(System.in);
    static final int MAX_CAR_NAME_LENGTH = 5;

    private String[] tryToRecieveCarnamesFromUser(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)기준으로 구분");
        String carNames[] = scanner.nextLine().split(",");
        return carNames;
    }
    private boolean isValidCarname(String carname){
        return carname.length() < MAX_CAR_NAME_LENGTH ? true:false;
    }
    

}
