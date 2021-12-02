package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class Player {
    private static final int CAR_NAME_LENGTH = 6;
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INSERT_COIN_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ERROR = "[ERROR]";
    private static int gameCoin;
    private static String carNames;
    private static String[] carNamesArray;

    public String[] startGame() {
        while (true) {
            this.inputCarNames();
            try {
                this.validateCarNamesLength();
                this.validateCarNamesDuplicate();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR + exception.getMessage());
            }
        }
        while (true) {
            String coin = this.insertCoin();
            try{
                this.validateOnlyInteger(coin);
                this.validateMoreThanOne();
                break;
            }catch (IllegalArgumentException exception){
                System.out.println(ERROR + exception.getMessage());
            }
        }
        return carNamesArray;
    }

    public boolean remainCoin() {
        return gameCoin-- != 0;
    }

    private void inputCarNames() {
        System.out.println(INPUT_CAR_MESSAGE);
        carNames = Console.readLine();
        carNamesArray = carNames.split(",");
    }

    private String insertCoin() {
        System.out.println(INSERT_COIN_MESSAGE);
        String coin = Console.readLine();
        return coin;
    }

    private void validateCarNamesDuplicate() {
        HashSet<String> carNameSet = new HashSet<>();
        for (String carName : carNamesArray) {
            carNameSet.add(carName);
        }
        if (carNameSet.size() != carNamesArray.length) {
            throw new IllegalArgumentException(" 중복된 자동차 이름을 입력하였습니다.");
        }
    }

    private void validateCarNamesLength() {
        for (String carName : carNamesArray) {
            if (carName.length() >= CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(" 자동차 이름은 최대 5자까지 입력 가능합니다.");
            }
        }
    }

    private void validateMoreThanOne(){
        if(gameCoin <= 0){
            throw new IllegalArgumentException(" 1 이상의 정수만 입력 가능합니다.");
        }
    }

    private void validateOnlyInteger(String coin){
        for(String digit : coin.split("")){
            if(digit.charAt(0) < '0' || digit.charAt(0)  > '9'){
                throw new IllegalArgumentException(" 숫자만 입력이 가능합니다.");
            }
        }
        gameCoin = Integer.parseInt(coin);
    }
}
