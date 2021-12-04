package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * @apiNote
 * inputNameOfCars 메서드는 NameOfCars 변수를 입력받고 Validation 클래스에 검수를 요청한 후, 성공했다면 입력받은 값을 리턴.
 * inputNumberOfTry 메서드는 NumOfTry 변수를 입력받고 Validation 클래스에 검수를 요청한 후, 성공했다면 입력받은 값을 리턴.
 *
 * @author 장준영
 */

public class Input {
    public String[] inputNameOfCars(Validation validation){
        String[] nameOfCars;
        while(true){
            try {
                System.out.print("경주할 자동차 이름을 입력하세요.");
                System.out.println("(이름은 쉼표(,) 기준으로 구분)");
                nameOfCars = validation.carNameValidation(Console.readLine());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR] 차 이름은 5글자 이하여야 한다.");
            }
        }
        return nameOfCars;
    }

    public int inputNumberOfTry(Validation validation){
        int numOfTry;
        while(true){
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                numOfTry = validation.numOfTryValidation(Console.readLine());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
        }
        return numOfTry;
    }
}
