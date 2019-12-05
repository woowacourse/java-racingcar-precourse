package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class GetCarNameInput {
    private static boolean isCarNameCorrect = false;

    static ArrayList<String> getCarNameInput() {
        String carNames = "";
        Scanner carNameInput = new Scanner(System.in);
        ArrayList<String> userCarNameArray = new ArrayList<String>();

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        carNames = carNameInput.next();
        Collections.addAll(userCarNameArray, carNames.split(","));

        return userCarNameArray;
    }

    static boolean checkCarNameInput(ArrayList<String> userCarNameArray) {
        if (userCarNameArray.size() < 2) {
            return false;
        }

        for (String s : userCarNameArray) {
            if (s.length() > 5) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<String> returnCarNameInput(ArrayList<String> userCarNameArray) {
        ArrayList<String> emptyArray = new ArrayList<>();
        emptyArray.add("Wrong");

        if (isCarNameCorrect) {
            return userCarNameArray;
        }
        return emptyArray;
    }
}
