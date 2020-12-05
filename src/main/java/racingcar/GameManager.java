package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
    private HashMap<String, Car> carNameAndCarObjects = new HashMap<String, Car>(); // 참가자 이름 = 참가자 Car 객체
    private Board board; // 전광판
    private AwardGiver awardGiver; // 시상자
    private InputCar inputCar; // 자동차(참가자) 입력 및 검사자
    private InputRound inputRound; // 라운드(이동 횟수) 입력 및 검사자

    public GameManager() {
        board = new Board();
        awardGiver = new AwardGiver();
        inputCar = new InputCar();
        inputRound = new InputRound();
    }

    public void startGame(Scanner scanner) {
        String[] stringArrayCarNames = inputCar.input(scanner);
        int numberRoundsTotal = inputRound.input(scanner);

        registerCar(stringArrayCarNames);
        startAllRounds(numberRoundsTotal);

        ArrayList<HashMap<String, Integer>> allRoundsResults = Round.getRoundsInformation();

        board.printAccumulatedRoundsResult(allRoundsResults, numberRoundsTotal);
        awardGiver.printAwardReceiver(carNameAndCarObjects, allRoundsResults, numberRoundsTotal);
    }

    private void registerCar(String[] stringArrayCarNames) {
        for (int i = 0; i < stringArrayCarNames.length; i++) {
            String carName = stringArrayCarNames[i];
            carNameAndCarObjects.put(carName, new Car(carName));
        }
    }

    private void startAllRounds(int numberRoundsTotal) {
        for (int roundNumber = 0; roundNumber < numberRoundsTotal; roundNumber++) {
            Round round = new Round();
            round.start(carNameAndCarObjects, round, roundNumber);
        }
    }
}
