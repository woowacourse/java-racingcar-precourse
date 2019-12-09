import java.util.*;

public class RacingCarGame {
    private static final String PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_TRIAL_LENGTH = "시도할 회수는 몇 회인가요?";
    private static final String TITLE_RACE_RESULT = "%n실행결과%n";

    public void startGame() {
        List<Car> cars = makeCars(receiveInput(PROMPT_CAR_NAMES));
        RacingCars racingCars = new RacingCars(cars);
        int trialLength = Integer.parseInt(receiveInput(PROMPT_TRIAL_LENGTH));
        runRace(racingCars, trialLength).printWinners();
    }

    private static RacingCars runRace(RacingCars racingCars, int trialLength) {
        System.out.printf(TITLE_RACE_RESULT);
        for (int i = 0; i < trialLength; i++) {
            racingCars.updateCars();
            racingCars.printStatus();
        }
        return racingCars;
    }

    private static String receiveInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private static List<Car> makeCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : split(carNames)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static String[] split(String text) {
        return text.split(",");
    }
}
