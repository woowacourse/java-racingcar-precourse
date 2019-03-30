package View;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
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

    public void play() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).goOrStop();
        }
    }

    public void displayCarPosition() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.print(car.getName() + ":");
            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public List<Car> getResult() {
        List<Car> result = new ArrayList<>();

        result.add(carList.get(0));
        for (int i = 1; i < carList.size(); i++) {

            if (result.get(0).getPosition() < carList.get(i).getPosition()) {
                result = new ArrayList<>();
                result.add(carList.get(i));
                continue;
            }
            if (result.get(0).getPosition() == carList.get(i).getPosition()) {
                result.add(carList.get(i));
            }
        }
        return  result;
    }

}
