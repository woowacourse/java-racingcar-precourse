package racingcar;

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

    private int trial;
    private List<Car> cars;

    public Game(Scanner scanner) {
        this.startGame(scanner);
    }

    public void startGame(Scanner scanner) {
        setPlayer(scanner);
        setTrial(scanner);
        play();
    }

    public void setPlayer(Scanner scanner) {
        System.out.println(START_MESSAGE);
        String temp = scanner.nextLine();
        this.cars = Arrays.stream(temp.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }

    public void setTrial(Scanner scanner) {
        System.out.println(TRIAL_MESSAGE);
        trial = scanner.nextInt();
        System.out.println(trial);
    }

    public void play() {
        System.out.println(RESULT_MESSAGE);
//        for (int i=0; i<trial; i++) {
//
//        }
    }

    public void move(Car car) {
        String name = car.getName();
        int position = car.getPositon();
        String movement = "";
        for (int p=0; p<position; p++) {
            movement = movement.concat(MOVEMENT);
        }
        System.out.println(name + " : " + movement);
    }

}
