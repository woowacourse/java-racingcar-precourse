package domain;

import java.util.Scanner;

public class RacingGame {
    Scanner scanner = new Scanner(System.in);

    RacingGame(){
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        String userInput = scanner.nextLine();
        String[] carNames = inputCarName(userInput);
    }

    public String[] inputCarName(String carNames){
        if(carNames == null){
            return new String[]{};
        }
        String result[] = carNames.split(",");
        return result;
    }
}
