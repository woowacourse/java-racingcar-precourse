package util;

import java.util.Scanner;

public class NameInput {
    static Scanner scan = new Scanner(System.in);
    private static final String INPUT_CAR_TEXT = "경주할 자동차 이름을 쉼표(,)로 구분해 입력해 주세요.";
    private static final String NAME_INPUT_ERROR = "5자 이하의 이름을 입력해주세요";

    /**
     * 이름 입력 함수.
     */
    public static String [] getCarName(){
        boolean isValidNameInput = false;
        String[] carNames;

        // 유효한 값이 입력 되었는지 확인 및 재입력
        do{
            carNames = nameInput();
            isValidNameInput = validateNameInput(carNames);
        }while(isValidNameInput == false);

        return carNames;
    }

    /**
     * 입력한 이름들을 배열로 반환
     */
    private static String [] nameInput(){
        System.out.println(INPUT_CAR_TEXT);
        String inputString = scan.nextLine().trim();
        String[] nameArray = inputString.split(",\\s*");
        return nameArray;
    }

    /**
     * 유효한 이름 입력값인지 확인.
     * @param name string array
     */
    private static boolean validateNameInput(String [] inputArray){
        for(String inputString: inputArray) {
            if (inputString.length() > Constants.MAX_NAME_LENGTH) {
                System.out.println(NAME_INPUT_ERROR);
                return false;
            }
        }
        return true;
    }
}
