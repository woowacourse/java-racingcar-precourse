package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputCarName {

    private Car[] cars;

    // 문자열로 입력 받기
    private String inputForm() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        return carsInput;
    }

    // 입력받은 문자열 배열로 변경하기
    private String[] carNameToArray() {
        String carNameString = inputForm();
        String[] carArray = carNameString.split(",");
        return carArray;
    }

    // 5글자가 넘어가면 예외 발생
    private void checkException(String[] carArray) {
        for(String name : carArray) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 한다.");
            }
        }
    }

    // 예외를 고려해서 올바른 문자열 배열 생성하기
    public String[] inputCar() {
        String[] carName = carNameToArray();
        try{
            checkException(carName);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5글자 이하여야 한다.");
            carName = inputCar();
        }
        return carName;
    }

}
