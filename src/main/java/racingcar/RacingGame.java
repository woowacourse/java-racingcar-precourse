package racingcar;

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
