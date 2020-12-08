package racingcar;

import exceptions.Errors;
import exceptions.RacingException;

import java.util.Scanner;
import java.util.List;

public class Game {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자: ";

    private String input;
    private int trial;
    private List<Car> cars;

    final Race race = new Race();

    public Game(Scanner scanner) {
        this.startGame(scanner);
    }

    private void startGame(Scanner scanner) {
        System.out.println(START_MESSAGE);
        new Player().setPlayer(scanner);
        this.cars = Player.getCars();

        System.out.println(TRIAL_MESSAGE);
        setTrial(scanner);

        playGame();
    }

    private void setTrial(Scanner scanner) {
        this.input = scanner.nextLine();
        try {
            new Errors().trialValidation(input);
        } catch (RacingException e) {
            setTrial(scanner);
        }
        this.trial = Integer.parseInt(input);
    }

    private void playGame() {
        playRace();
        finishGame();
    }

    private void playRace() {
        System.out.println(RESULT_MESSAGE);

        for (int i=0; i<trial; i++) {
            for (Car car : cars) {
                race.move(car);
            }
            System.out.println();
        }
    }

    private void finishGame() {
        race.findMaximum(cars);
        List<String> winner = race.getWinner(cars);
        String winners = String.join(", ", winner);
        System.out.println(WINNER_MESSAGE + winners);
    }
}
