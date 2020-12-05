package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputViewer;
import racingcar.view.OutputViewer;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {
    private int turnNumber;
    private Cars gameSet;

    /* 게임을 1회 진행하기 위한 메서드입니다.*/
    public void play() {
        this.intiateGame();
        processGame(turnNumber);
        endGame();
    }

    private void intiateGame() {
        Scanner scanner = new Scanner(System.in);
        askParticipant(scanner);
        askGameTurns(scanner);
    }

    private void askParticipant(Scanner scanner) {
        InputViewer.carsInput();
        String[] participantsArray = scanner.nextLine().split(",");
        this.gameSet = initiateGameSet(participantsArray);
    }

    private Cars initiateGameSet(String[] parcipantArray) {
        return new Cars(parcipantArray);
    }

    private void askGameTurns(Scanner scanner) {
        InputViewer.numberInput();
        try {
            this.turnNumber = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            InputViewer.numberInputError();
        }
    }

    private void processGame(int turnNumber) {
        for (int i = 0; i < turnNumber; i++) {
            this.gameSet.oneTurn();
        }
        OutputViewer.spaceBetweenGames();
    }

    private void endGame() {
        OutputViewer.initiateResult();
        ArrayList<String> winnerList = gameSet.getWinners();
        showWinners(winnerList);
    }

    private void showWinners(ArrayList<String> winnerList) {
        if (winnerList.size() == 1) {
            soloWinner(winnerList);
        }
        multiWinners(winnerList);
    }

    private void soloWinner(ArrayList<String> winnerList) {
        String winner = winnerList.get(0);
        OutputViewer.singleFinalWinner(winner);
    }

    private void multiWinners(ArrayList<String> winnerList) {
        OutputViewer.multipleFinalWinner(winnerList);
    }
}
