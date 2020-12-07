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
        checkParticipantsLength(participantsArray);
        this.gameSet = initiateGameSet(participantsArray);
    }
    
    private void checkParticipantsLength(String[] participantsArray) {
        for (String parcipant : participantsArray) {
            checkParicipantLength(parcipant);
        }
    }

    private void checkParicipantLength(String participant){
        if (participant.length() > 5) {
            InputViewer.lengthInputError();
        }
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
        OutputViewer.initiateResult();
        for (int i = 0; i < turnNumber; i++) {
            this.gameSet.oneTurn();
        }
    }

    private void endGame() {
        ArrayList<String> winnerList = gameSet.getWinners();
        showWinners(winnerList);
    }

    private void showWinners(ArrayList<String> winnerList) {
        String winners = String.join(", ",winnerList);
        OutputViewer.finalWinner(winners);
    }
}
