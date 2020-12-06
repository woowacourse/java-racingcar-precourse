package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] cars;
        List<Car> carList;
        String cntInput;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carsInput = scanner.next();
            cars = carsInput.split(",");
        } while (!validCarNameList(cars));
        carList = createCars(cars);
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            cntInput = scanner.next();
        } while (!validGameCntInput(cntInput));

        Game game = new Game(Integer.parseInt(cntInput), carList);
        game.start();
    }

    private static boolean validCarNameList(String[] cars) {
        CarValidator carValidator = new CarValidator();
        for (String carName : cars) {
            if (!carValidator.isValid(carName)) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            }
        }
        return true;
    }

    private static List<Car> createCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    private static boolean validGameCntInput(String cntInput) {
        for (int i = 0; i < cntInput.length(); i++) {
            if (!Character.isDigit(cntInput.charAt(i))) {
                System.out.println("[ERROR] 시도횟수는 숫자여야 한다.");
                return false;
            }
        }
        return true;
    }

}
