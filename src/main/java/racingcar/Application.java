package racingcar;

import java.util.ArrayList;

public class Application {

    /**
     * 차 객체들의 배열 생성하는 메서드
     * @param carList
     * @return ArrayList<Car>
     */
    public static ArrayList<Car> carGenerator(String[] carList) {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < carList.length; i++) {
            Car car = new Car(carList[i]);
            cars.add(car);
        }

        return cars;
    }

    /**
     * 사용자에게 차 이름을 입력받는 메서드
     * @return ArrayList<Car>
     */
    public static ArrayList<Car> getCars() {
        while (true) {
            try {
                String input = camp.nextstep.edu.missionutils.Console.readLine();
                String[] carList = input.split(",");

                InputChecker.checkCarName(carList);

                return carGenerator(carList);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    /**
     * 사용자에게 숫자를 입력받는 메서드
     * @return int
     */
    public static int getNumber() {
        while (true) {
            try {
                String input = camp.nextstep.edu.missionutils.Console.readLine();

                InputChecker.checkNumber(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = null;
        int num = 0;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = getCars();
        System.out.println("시도할 회수는 몇회인가요?");
        num = getNumber();

        ArrayList<Car> result = Game.startGame(cars, num);
        // TODO: determineWinner
        // TODO: printWinner
    }
}
