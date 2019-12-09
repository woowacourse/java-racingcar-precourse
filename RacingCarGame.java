import java.util.*;

public class RacingCarGame {
    private static final String PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_TRIAL_LENGTH = "시도할 회수는 몇 회인가요?";
    private static final String RACE_START_MESSAGE = "실행결과";
    private static final String LENGTH_ERROR_MESSAGE = "길이가 5보다 큽니다. 다시 입력해 주새요";
    private static final String ROUND_REQEUST_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String NUMBER_ERROR_MESSAGE = "숫자가 아닙니다. 숫자를 입력해주세요";

    public void startGame() {
        List<Car> cars = makeCars(receiveInput(PROMPT_CAR_NAMES));
        RacingCars racingCars = new RacingCars(cars);
        int trialLength = Integer.parseInt(receiveInput(PROMPT_TRIAL_LENGTH));
        finishedCars = runRace(racingCars, trialLength)
        finishedCars.printWinners();
    }

    private static RacingCars runRace(RacingCars racingCars, int trialLength) {
        System.out.println();
        System.out.println(RACE_START_MESSAGE);
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
