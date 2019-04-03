import domain.Car;
import java.util.Vector;

public class Game {
    private static final String SEPERATOR = ",";
    private static final int MAX = 5;
    private static final String FIRST_WORD = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SECOND_WORD = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_STRING = "\n실행 결과";
    private static final int TOP = 9;
    private static final int BOTTOM = 0;
    private static final int BOUNDARY = 4;
    private static final char dash = '-';

    static Vector<String> getCarNames() {
        String input;
        Vector<String> names;

        while(true) {
            input = InputHandler.getInput(FIRST_WORD);
            names = InputHandler.parse(input, SEPERATOR);
            if(!Oracle.checkFaultyInput(names, MAX)) {
                break;
            }
        }

        return names;
    }

    static int getNumberOfRound() {
        String input;
        int numberOfRound;

        while(true) {
            try {
                input = InputHandler.getInput(SECOND_WORD);
                numberOfRound = Integer.parseInt(input);
                return numberOfRound;
            }
            catch (Exception e) {
                System.out.println("숫자가 아닙니다. 입력을 다시 해 주세요.");
            }
        }
    }

    static Vector<Car> generateCarsByNames(Vector<String> names) {
        Vector<Car> cars = new Vector<>();

        for (String name : names
             ) {
            Car car = new Car(name);
            cars.add(car);
        }

        return cars;
    }

    static void doRound(Vector<Car> cars) {
        for (Car car : cars
        ) {
            if (Oracle.tellGoOrStop(TOP, BOTTOM, BOUNDARY)) {
                car.move();
            }
        }
        Oracle.showRoundResult(cars, dash);
    }

    static void doRace(Vector<Car> cars, int rumberOfRound) {
        System.out.println(RESULT_STRING);
        for(int i = 0; i < rumberOfRound; i++) {
            doRound(cars);
        }
    }

}
