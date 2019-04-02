package View;

import domain.Car;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Car> carList = new ArrayList<>();
    private int count; /*시행할 게임 횟수*/

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

    public void inputNum() throws Exception {
        final String mismatchException = "숫자를 입력해주세요";
        final String boundException = "양수를 입력해주세요";

        try {
            count = sc.nextInt();
            if (count < 1) {
                throw new Exception(boundException);
            }
        } catch (InputMismatchException e) {
            throw new Exception(mismatchException);
        }

    }

    public void play() {
        for (int i = 0; i < count; i ++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).goOrStop();
            }
            displayCarPosition();
            System.out.println();
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

    public void displayResult() {
        List<Car> carList = getResult();
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName());
            if ( i != carList.size()-1) {
                System.out.print(", ");
            }

        }
        System.out.println("가 최종 우승했습니다.");
    }


}
