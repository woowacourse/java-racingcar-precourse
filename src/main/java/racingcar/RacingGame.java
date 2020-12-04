package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import constant.SystemMessage;

public class RacingGame {
    private Player[] players;
    private int turn;
    private Scanner scanner;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void playGame() {
        getCarName();
        getTurn();

        System.out.println("\n" + SystemMessage.RUN_RESULT + "\n");
        for (int i = 0; i < turn; i++) {
            startRacing();
            printProgress();
        }

        printChampion();
    }

    private void startRacing() {
        for (int i = 0; i < players.length; i++) {
            players[i].racing();
        }
    }

    private void printProgress() {
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getCarName() + " " + SystemMessage.SEPARATOR_COLON + " ");

            int position = players[i].getCarPosition();
            for (int j = 0; j < position; j++) {
                System.out.print(SystemMessage.DISTANCE);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printChampion() {
        System.out.print(SystemMessage.CHAMPION + " ");
        List<Integer> championList = getChampionList();
        System.out.println(players[championList.get(0)].getCarName());
        for (int i = 1; i < championList.size(); i++) {
            System.out.print(SystemMessage.SEPARATOR_COMMA + " " + players[championList.get(i)].getCarName());
        }
    }

    private List<Integer> getChampionList() {
        int position = players[0].getCarPosition();
        for (int i = 1; i < players.length; i++) {
            position = Math.max(position, players[i].getCarPosition());
        }

        List<Integer> championList = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getCarPosition() == position) {
                championList.add(i);
            }
        }
        return championList;
    }

    private void getCarName() {
        System.out.println(SystemMessage.INPUT_CAR_NAME_MESSAGE);
        String[] input = scanner.next().split(",");
        players = new Player[input.length];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(input[i]);
        }
    }

    private void getTurn() {
        System.out.println(SystemMessage.INPUT_TURN_MESSAGE);
        turn = scanner.nextInt();
    }

}
