package racingcar;

import racingcar.exception.ParticipantNameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stadium {

    private Race race;
    private ScoreBoard scoreBoard;
    private ReceptionDesk receptionDesk;

    public Stadium() {
        receptionDesk = new ReceptionDesk();
        scoreBoard = new ScoreBoard();
    }

    public void readyRace(Scanner scanner) throws ParticipantNameException, InputMismatchException {
        Cars participants = receptionDesk.applyCars(scanner);
        RaceSetting raceSetting = new RaceSetting();
        raceSetting.init();
        raceSetting.setRound(scanner);
        race = new Race(participants, raceSetting, new WinnerCondition(), raceStatusListener);
    }

    public void startRace() {
        race.startRace();
    }


    private Race.RaceStatusListener raceStatusListener = new Race.RaceStatusListener() {
        @Override
        public void finishRound(Cars participants) {
            scoreBoard.printCurrentRacingStatus(participants);
        }

        @Override
        public void finishGame(Cars winner) {
            scoreBoard.printWinner(winner);
        }
    };
}
