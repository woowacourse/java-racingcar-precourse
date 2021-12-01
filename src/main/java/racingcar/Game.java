package racingcar;
import camp.nextstep.edu.missionutils.Console;


public class Game {

    public Game() {

    }

    private String CarsInput() {
        String input;
        input = Console.readLine();
        return input;
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

    


}
