package racingcar;

import exceptions.Errors;
import exceptions.RacingException;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String RESULT_MESSAGE = "실행 결과";
    private final String MOVEMENT = "-";
    private final String WINNER_MESSAGE = "최종 우승자: ";

    private int trial;
    private List<String> names;
    private List<Car> cars;
    private final List<String> winner = new ArrayList<>();
    private int maxScore = 0;

    public Game(Scanner scanner) {
        this.startGame(scanner);
    }

    public void startGame(Scanner scanner) {
        System.out.println(START_MESSAGE);
        new Player(scanner);
        System.out.println(TRIAL_MESSAGE);
        setTrial(scanner);
        play();
    }


    public void setTrial(Scanner scanner) {
        String input = scanner.nextLine();
        try {
            new Errors().trialValidation(input);
        } catch (RacingException e) {
            setTrial(scanner);
        }
        this.trial = Integer.parseInt(input);
    }

    public void play() {
        System.out.println(RESULT_MESSAGE);
        for (int i=0; i<trial; i++) {
            for (Car car : cars) {
                move(car);
            }
            System.out.println();
        }
        findMaximum();
        System.out.println(maxScore);
        getWinner();
        String winners = String.join(", ", winner);
        System.out.println(WINNER_MESSAGE + winners);
    }

    public void move(Car car) {
        String name;
        int position;

        movementCheck(car);

        name = car.getName();
        position = car.getPositon();

        String movement = "";
        for (int p=0; p<position; p++) {
            movement = movement.concat(MOVEMENT);
        }
        System.out.println(name + " : " + movement);
    }

    public void movementCheck(Car car) {
        if (car.moveForward()) {
            car.setPosition();
        }
    }

    public void findMaximum() {
        for (Car car : cars) {
            int position = car.getPositon();
            if (position > maxScore) {
                maxScore = position;
            }
        }
    }

    public void getWinner() {
        for (Car car : cars) {
            int position = car.getPositon();
            String name = car.getName();
            if (position == maxScore) {
                winner.add(name);
            }
        }
    }
}
