import java.util.*;

public class RacingCar {
    private static final int STRIDE_LENGTH = 1;

    public static void main(String[] args) {
        List<Car> cars = makeCars(inputCarNames());
        int trialLength = Integer.parseInt(inputTrialLength());
        RacingCar racingCars = new RacingCar(cars);
        System.out.println(cars);
        System.out.println(trialLength);
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

    private static void updateCars(List<Car> cars) {
        for (Car car : cars) {
            updateCar(car);
        }
    }

    private static void updateCar(Car car) {
        if (shouldMove()) {
            car.moveForward(STRIDE_LENGTH);
        }
    }

    private static boolean shouldMove() {
        Random random = new Random();
        // 60% 확률로 참값을 반환함
        return random.nextInt(10) >= 4;
    }

    private static String[] split(String text) {
        return text.split(",");
    }
}
