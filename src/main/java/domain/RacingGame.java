package domain;

import java.util.Scanner;

public class RacingGame {
    Scanner scanner = new Scanner(System.in);

    public RacingGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
        String userInput = scanner.nextLine();
        String[] carNames = inputCarName(userInput);
        while(!isCorrectInput(carNames)){
            System.out.println("잘못된 입력을 하셧습니다. 각 자동차의 이름은 5자이하여야 합니다.");
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
            userInput = scanner.nextLine();
            carNames = inputCarName(userInput);
        }
    }

    public String[] inputCarName(String carNames){
        if(carNames == null){
            return new String[]{};
        }
        String result[] = carNames.split(",");
        return result;
    }
    public boolean isCorrectInput(String[] carNames){
        for(int i = 0; i < carNames.length ; i++){
            if(carNames[i].length() > 5 || carNames[i].length() == 0){
                return false;
            }
        }
        return true;
    }
}
