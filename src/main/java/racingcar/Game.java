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
        boolean checking = true;
        try {
            Exception e = new Exception();
            rightInput();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            checking = false;
        }
        return checking;
    }

    private void rightInput() throws IllegalArgumentException{
        carNames = input.split(",");
        if (carNames.length == 1) {
            return;
        }
        for (int i=0;i<carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return;
    }
    


}
