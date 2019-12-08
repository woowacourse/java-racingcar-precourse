package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameCheck {

    private static final int CAR_NAME_MAX_LENGTH = 5;       // 차 객체가 가질 수 있는 최대 이름 길이.

    public static ArrayList<Car> setCarName() {
        String namesList = new InputScanner().getCarName();
        List<String> carNames = Arrays.asList(namesList.split(","));
        ArrayList<Car> carList = new ArrayList<Car>();
        for (int i = 0; i < carNames.size(); i++) {
            String currentName = nameLengthCheck(carNames.get(i));
            carList.add(new Car(currentName));
        }
        return carList;
    }

    private static String nameLengthCheck(String name) {
        while (name.length() > CAR_NAME_MAX_LENGTH) {
            new OutputPrint().moreThanFiveLength(name);
            name = new InputScanner().getCarName();
        }
        return name;
    }

}
