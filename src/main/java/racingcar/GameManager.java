package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
    private HashMap<String, Car> participants = new HashMap<String, Car>(); // 참가자 이름 = 참가자 Car 객체
    private Board board; // 전광판
    private AwardGiver awardGiver; // 시상자
    private ReceptionForCars receptionForCars; // 자동차(참가자) 입력 및 검사자
    private ReceptionForRound receptionForRound; // 라운드(이동 횟수) 입력 및 검사자

    public GameManager() {
        board = new Board();
        awardGiver = new AwardGiver();
        receptionForCars = new ReceptionForCars();
        receptionForRound = new ReceptionForRound();
    }

    public void startGame(Scanner scanner) {
        String[] arrayParticipants = receptionForCars.input(scanner);
        int numberRoundsTotal = receptionForRound.input(scanner);

        registerCar(arrayParticipants);
        startAllRounds(numberRoundsTotal);

        ArrayList<HashMap<String, Integer>> allRoundsResults = Round.getRoundsInformation();

        board.printAccumulatedRoundsResult(allRoundsResults, numberRoundsTotal);
        awardGiver.printAwardReceiver(participants, allRoundsResults, numberRoundsTotal);
    }

    private void registerCar(String[] arrayParticipants) {
        for (int i = 0; i < arrayParticipants.length; i++) {
            String carOwner = arrayParticipants[i];
            participants.put(carOwner, new Car(carOwner));
        }
    }

    private void startAllRounds(int numberRoundsTotal) {
        for (int roundNumber = 0; roundNumber < numberRoundsTotal; roundNumber++) {
            Round round = new Round();
            round.start(participants, round, roundNumber);
        }
    }
}
