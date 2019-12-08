package view;

import domain.Car;
import validator.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 김시영
 * @apiNote 사용자 입력과 관련된 메서드와 데이터가 모인 클래스입니다.
 * @apiNote 사용자를 입력하고, 몇 번을 플레이 할지를 결정하는 메서드로 이루어져 있습니다.
 * @since 2019-12-05
 */
public class UserInput {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String COMMA = ",";

    private static InputValidator validator = new InputValidator();


    public List<Car> makeCars() throws IOException {
        String[] userInputArray = br.readLine().split(COMMA);
        while (!validator.checkCarNames(userInputArray)) {
            PrintHandler.notifyCarNameError();
            userInputArray = br.readLine().split(COMMA);
        }
        return makeCarArrayToList(userInputArray);
    }

    private static List<Car> makeCarArrayToList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
        }
        return carList;
    }

    public int chooseHowManyPlay() throws IOException {
        try {
            int howManyPlay = Integer.parseInt(br.readLine().trim());
            if (InputValidator.checkItIsZero(howManyPlay)) {
                PrintHandler.notifyFormatError();
                return chooseHowManyPlay();
            }
            return howManyPlay;
        } catch (NumberFormatException e) {
            PrintHandler.notifyFormatError();
            return chooseHowManyPlay();
        }
    }
}
