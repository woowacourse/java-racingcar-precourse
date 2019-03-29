package domain;

import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);

    private static final int MIN_LENGTH = 0;
    private static final int MAX_LENGTH = 5;

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return sc.nextLine().split(",");
    }

    public boolean checkValidationCarNames(String[] carNames){
        int length;

        for(String carName : carNames){
            length = carName.length();
            if((length < MIN_LENGTH) || (length > MAX_LENGTH)){
                return false;
            }
        }

        return true;
    }

    public int inputCnt(){
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
}
