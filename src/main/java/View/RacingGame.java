package View;

import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Car> carList = new ArrayList<>();

    public void inputCarName() throws Exception {
        final String delimiter = ",";
        final String exceptionMessage = "자동차의 이름은 5자 이하만 가능합니다.";

        String userInput = sc.nextLine();
        String[] carNames = userInput.split(delimiter);

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new Exception(exceptionMessage);
            }
            carList.add(new Car(carNames[i]));
        }
    }

}
