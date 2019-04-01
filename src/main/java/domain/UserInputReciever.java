package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInputReciever  {
    Scanner scanner = new Scanner(System.in);
    static final int MAX_CAR_NAME_LENGTH = 5;

    private void RecieveCarNamesFromUser(){
        try {
            tryToRecieveCarNamesFromUser();
        } catch (Exception e){
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            RecieveCarNamesFromUser();
        }
    }

    private String[] tryToRecieveCarNamesFromUser() throws Exception{
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)기준으로 구분");
        String carNames[] = scanner.nextLine().split(",");
        if(!isValidCarNamesInput(carNames)){
            throw new Exception();
        }
        return carNames;
    }

    private boolean isValidCarNamesInput(String[] carNames){
        for(int i=0; i<carNames.length; i++){
            if(!isValidCarName(carNames[i])){
                return false;
            }
        }
        return true;
    }

    private boolean isValidCarName(String carName){
        return carName.length() < MAX_CAR_NAME_LENGTH ? true:false;
    }




}
