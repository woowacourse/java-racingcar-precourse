package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class RacingStadium {
    private final Car[] raceCars;
    private final int moveCount;

    public RacingStadium(String[] participants, int moveCount) {
        this.raceCars = getReady(participants);
        this.moveCount = moveCount;
    }

    private Car[] getReady(String[] participants) {
        Car[] startLine = new Car[participants.length];

        for (int i = 0; i < participants.length; i++) {
            startLine[i] = new Car(participants[i]);
        }
        return startLine;
    }

    public void startRace() {
        System.out.println("\n실행결과");
        for (int i = 0; i < moveCount; i++) {
            playRace();
            System.out.println("\n");
        }
    }

    private void playRace() {
        Random random = new Random();

        for (Car raceCar : raceCars) {
            int randomNumber = random.nextInt(9);
            raceCar.tryToGoForward(randomNumber);
            raceCar.printCurrentStatus();
        }
    }

    public void announceWinners() {
        ArrayList<String> winnerList = new ArrayList<String>();
        winnerList = update(winnerList);

        System.out.printf("%s가 최종 우승했습니다.", extractName(winnerList));
    }

    private ArrayList<String> update(ArrayList<String> winnerList) {
        int maxPosition = 0;
        for (Car raceCar : raceCars) {
            int position = raceCar.getPosition();
            if (position < maxPosition) {
                continue;
            }
            if (position > maxPosition) {
                winnerList = new ArrayList<String>();
                maxPosition = position;
            }
            winnerList.add(raceCar.getName());
        }
        return winnerList;
    }

    private String extractName(ArrayList<String> winnerList) {
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (String winner : winnerList) {
            stringJoiner.add(winner);
        }
        return stringJoiner.toString();
    }
}
