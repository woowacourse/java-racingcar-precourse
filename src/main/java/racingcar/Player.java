package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class Player {
    private static final int CAR_NAME_LENGTH = 6;
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INSERT_COIN_MESSAGE = "시도할 회수는 몇회인가요?";
    private static int gameCoin;
    private static String carNames;
    private static String[] carNamesArray;

    public String[] startGame() {
        while (!this.inputCarNames()) {
        }
        this.insertCoin();
        return carNamesArray;
    }

    public boolean remainCoin(){
        return gameCoin-- != 0;
    }

    private boolean inputCarNames() {
        System.out.println(INPUT_CAR_MESSAGE);
        carNames = Console.readLine();
        carNamesArray = carNames.split(",");
        return validateCarNamesLength();
    }

    private void insertCoin() {
        System.out.println(INSERT_COIN_MESSAGE);
        String coin = Console.readLine();
        gameCoin = Integer.parseInt(coin);
    }

    private boolean validateCarNamesDuplicate() {
        HashSet<String> carNameSet = new HashSet<>();
        for (String carName : carNamesArray) {
            carNameSet.add(carName);
        }
        return carNameSet.size() == carNamesArray.length;
    }

    private boolean validateCarNamesLength() {
        for (String carName : carNamesArray) {
            if (carName.length() >= CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

}
