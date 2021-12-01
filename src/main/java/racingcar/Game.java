package racingcar;
import camp.nextstep.edu.missionutils.Console;


public class Game {
    private String input;
    public String[] carNames;

    public Game() {

    }

    private void CarsInput() {
        input = Console.readLine();
    }

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        boolean checking = false;
        while (!checking) {
            CarsInput();
            checking = checkCars();
        }

    }

    private boolean checkCars() {
        try {
            boolean checking = true;

        } catch (IllegalArgumentException) {

        }

        return checking;
    }

    private boolean rightInput() {
        carNames = input.split(",");
        if (carNames.length == 1) {
            return true;
        }
        for (int i=0;i<carNames.length; i++) {
            if (carNames[i].length() > 5) {
                return false;
            }
        }
        return true;
    }
    


}
