package ui;

import domain.Car;
import domain.Track;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author delf
 */
public class ConsoleIOInterface implements RaceIOInterface {
    private Scanner scanner = new Scanner(System.in);
    private final static String DELIM = "'";
    private final static int MAX_RACER = 5;
    private final static int MIN_RACER = 1;
    private final static int MAX_TRY_COUNT = 1000;
    private final static int MIN_TRY_COUNT = 1;

    @Override
    public String[] inputRacersName() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

            String input = scanner.nextLine();
            String[] racersNames;

            try {
                racersNames = checkInputRacersName(input.split(DELIM));
                return racersNames;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] checkInputRacersName(String[] result) throws IllegalArgumentException {
        // TODO: 5자 이하 이름 제한하기
        if (result.length > MAX_RACER || result.length < MIN_RACER) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    @Override
    public int inputTryNumber() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                return checkInputTryNumber(scanner.nextInt());

            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int checkInputTryNumber(int n) {
        if (n > MAX_TRY_COUNT || n < MIN_TRY_COUNT) {
            throw new IllegalArgumentException();
        }
        return n;
    }

    @Override
    public void showTrack(Track track) {
        System.out.println(track + "\n");
    }

    @Override
    public void showWinner(Track track) {
        List<Car> winners = track.getWinners();

        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            sb.append(winner.getName()).append(" ,");
        }
        sb.deleteCharAt(sb.length() - 1).append("가 최종 우승했습니다.");

        System.out.println(sb.toString());
    }
}
