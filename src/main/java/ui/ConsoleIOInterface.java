package ui;

import domain.Car;
import domain.Track;
import exeption.IncorrectRacerNameException;
import exeption.IncorrectTryCountException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author delf
 */
public class ConsoleIOInterface implements RaceIOInterface {
    private Scanner scanner = new Scanner(System.in);
    private final static String DELIM = ",";

    @Override
    public String[] inputRacersName() {
        while (true) {
            RaceIOInterface.showPlaneText("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

            String input = scanner.nextLine();
            try {
                return checkRacersName(input.split(DELIM));

            } catch (IllegalArgumentException e) {
                RaceIOInterface.showPlaneText(e.getMessage());
            }
        }
    }

    private String[] checkRacersName(String[] result) throws IllegalArgumentException {
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].trim();
            if (result[i].length() > Car.MAX_LENGTH_RACER_NAME) {
                throw new IncorrectRacerNameException();
            }
        }
        return result;
    }

    @Override
    public int inputTryCount() {
        while (true) {
            RaceIOInterface.showPlaneText("시도할 회수는 몇회인가요?");
            try {
                return checkTryCount(scanner.nextInt());

            } catch (IncorrectTryCountException | InputMismatchException e) {
                RaceIOInterface.showPlaneText(e.getMessage());

            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private int checkTryCount(int n) throws IllegalArgumentException {
        if (n > Track.MAX_TRY_COUNT || n < Track.MIN_TRY_COUNT) {
            throw new IncorrectTryCountException();
        }
        return n;
    }

    @Override
    public void showTrack(Track track) {
        RaceIOInterface.showPlaneText(track.toString());
    }

    @Override
    public void showWinner(Track track) {
        List<String> winners = track.getWinners();

        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("이(가) 최종 우승했습니다.");

        RaceIOInterface.showPlaneText(sb.toString());
    }
}
