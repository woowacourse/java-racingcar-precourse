package view;

import domain.Car;
import validator.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String COMMA = ",";

    private static InputValidator validator = InputValidator.getInstance();

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
        while (true) {
            try {
                return Integer.parseInt(br.readLine().trim());
            } catch (NumberFormatException e) {
                PrintHandler.notifyFormatError();
            }
        }
    }
}
