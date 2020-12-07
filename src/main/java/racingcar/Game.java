package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";

    private int trial;
    private String[] names;

    public Game(Scanner scanner) {
        this.startGame(scanner);
    }

    public void startGame(Scanner scanner) {
        setPlayer(scanner);
        setTrial(scanner);
        play();

        System.out.println(Arrays.toString(names));
        System.out.println(trial);
    }

    public void setPlayer(Scanner scanner) {
        System.out.println(START_MESSAGE);
        String temp = scanner.nextLine();
        names = temp.split(",");
    }

    public void setTrial(Scanner scanner) {
        System.out.println(TRIAL_MESSAGE);
        trial = scanner.nextInt();
    }

    public void play() {
//        for (int i=0; i<trial; i++) {
//
//        }
    }


}
