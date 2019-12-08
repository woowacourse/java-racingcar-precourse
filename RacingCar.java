import java.util.*;

public class RacingCar {
    private static final int STRIDE_LENGTH = 1;

    public static void main(String[] args) {
        List<Car> cars = makeCars(inputCarNames());
        int trialLength = Integer.parseInt(inputTrialLength());
        RacingCars racingCars = new RacingCars(cars);
        System.out.printf("%n실행결과%n");
        for (int i = 0; i < trialLength; i++) {
            racingCars.updateCars();
            racingCars.printStatus();
        }
        racingCars.printWinners();
    }

    private static String inputCarNames() {
        return receiveInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static String inputTrialLength() {
        return receiveInput("시도할 회수는 몇 회인가요?");
    }

    private static String receiveInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private static List<Car> makeCars(String carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (String carName : split(carNames)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static String[] split(String text) {
        return text.split(",");
    }
}
