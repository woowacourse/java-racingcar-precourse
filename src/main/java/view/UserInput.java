package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import domain.model.Car;
import domain.model.Vehicle;
import validator.InputValidator;

/**
 * @author 김시영
 * @apiNote 사용자 입력과 관련된 메서드와 데이터가 모인 클래스입니다. 자동차 생성 및 플레이 횟수 결정의 기능이 있습니다.
 * @since 2019-12-05
 */
public class UserInput<T extends Vehicle> {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String COMMA = ",";

    private static InputValidator validator = new InputValidator();

    public List<T> makeCars() throws IOException {
        String[] userInputCars = BR.readLine().split(COMMA);
        while (!validator.checkCarNames(userInputCars)) {
            PrintHandler.notifyCarNameError();
            userInputCars = BR.readLine().split(COMMA);
        }
        return carNameToCarList(userInputCars);
    }

    public List<T> carNameToCarList(String[] carNames) {
        List<T> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add((T) new Car(carNames[i]));  //TODO 차가 아닌, 자전거나 비행기일 경우 여기서 타입을 다르게 입력할 수 있습니다.
        }
        return carList;
    }

    public int chooseHowManyPlay() throws IOException {
        try {
            int howManyPlay = Integer.parseInt(BR.readLine().trim());
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
