package domain;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class InputProcessor {
    private static ArrayList<String> getCarNameInput() {
        Scanner carNameInput = new Scanner(System.in);
        String carNames = carNameInput.next();

        ArrayList<String> userCarNameArray = new ArrayList<String>();
        Collections.addAll(userCarNameArray, carNames.split(","));

        return userCarNameArray;
    }

    private static boolean checkCarNameInput(ArrayList<String> userCarNameArray) {
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

    static int getGameNumber() {
        Scanner carNameInput = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 번인가요?");
        return parseInt(carNameInput.next());
    }

    static ArrayList<String> getCarName() {
        ArrayList<String> carNamesArray;
        boolean isCarNameCorrect;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            carNamesArray = getCarNameInput();
            isCarNameCorrect = checkCarNameInput(carNamesArray);
        } while (!isCarNameCorrect);
        return carNamesArray;
    }
}