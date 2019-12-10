package game;

import com.sun.deploy.util.StringUtils;
import domain.Car;
import domain.TrialTimes;
import exception.InvalidInputException;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCarGame {

    private static final String CAR_NAME_ASK_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_TIMES_ASK_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String AWARDS_TAIL_MESSAGE = "가 우승했습니다.";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String ROUND = "차전";
    private static final Scanner GAME_SCANNER = new Scanner(System.in);
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();
    private static final int ROUND_GENERATOR_NUMBER = 1;
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int DELAY_TIME_MILLISECONDS = 1000;

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        RacingCarGameInitializer racingCarGameInitializer = new RacingCarGameInitializer();
        RacingCarGameDecider racingCarGameDecider = new RacingCarGameDecider();
        List<Car> cars = racingCarGame.initCars(racingCarGameInitializer);
        TrialTimes trialTimes = racingCarGame.initNumberOfTimes(racingCarGameInitializer);
        racingCarGame.runGame(cars, trialTimes);
        List<String> winners = racingCarGameDecider.pickWinners(cars);
        racingCarGame.printWinner(winners);
    }

    public List<Car> initCars(RacingCarGameInitializer racingCarGameInitializer) {
        while (true) {
            try {
                String inputString = takeNames();
                return racingCarGameInitializer.makeCarList(inputString);
            } catch (InvalidInputException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    public TrialTimes initNumberOfTimes(RacingCarGameInitializer racingCarGameInitializer) {
        while (true) {
            try {
                String numberOfTimesString = takeNumberOfTimes();
                return racingCarGameInitializer.makeTrialTimes(numberOfTimesString);
            } catch (InvalidInputException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    public void runGame(List<Car> cars, TrialTimes trialTimes) {
        for (int i = 0; i < trialTimes.getTrialTimes(); i++) {
            int roundCount = i + ROUND_GENERATOR_NUMBER;
            System.out.println(roundCount + ROUND);
            runOneTurn(cars);
            System.out.println();
        }
    }

    private void runOneTurn(List<Car> cars) {
        for (Car car : cars) {
            car.proceedOrStop(RANDOM_NUMBER_GENERATOR.nextInt(RANDOM_NUMBER_BOUND));
            System.out.println(car.makeCurrentStatus());
        }
        try {
            Thread.sleep(DELAY_TIME_MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

    public void printWinner(List<String> winners) {
        String winner = StringUtils.join(winners, CAR_NAME_DELIMITER);
        System.out.println(winner + AWARDS_TAIL_MESSAGE);
    }

    private String takeNames() {
        System.out.println(CAR_NAME_ASK_MESSAGE);
        return GAME_SCANNER.nextLine();
    }

    private String takeNumberOfTimes() {
        System.out.println(TRIAL_TIMES_ASK_MESSAGE);
        return GAME_SCANNER.nextLine();
    }

}
