package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {

    private final Scanner scanner;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        int tryCount;
        List<Car> cars;

        cars = getCars(getInput());
        tryCount = getTryCount();

        GameResult gameResult = Race.startRace();

        // todo 우승자 안내 문구
        // 단독
        // 최종 우승자: pobi
        // 공동
        // 최종 우승자: pobi, jun
    }

    private int getTryCount() {
        // todo 시도할 회수 입력
        int tryCount = 0;

        while (tryCount <= 0) {
            try {
                tryCount = Integer.parseInt(getInput());
            } catch (Exception e) {
                System.out.println("다시입력");
            }
        }
        return tryCount;
    }

    private List<Car> getCars(String input) {
        // todo 경주 할 자동차 이름 입력(이름은 쉼표(,) 기준으로 구분)
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String getInput() {
        return scanner.nextLine();
    }

}
