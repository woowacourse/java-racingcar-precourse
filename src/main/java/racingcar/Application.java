package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    static int NUMBER_OF_CAR = 0;
    public static void main(String[] args) {
        // TODO 구현 진행
        String[] nameOfCars;
        int numOfTry;
        ArrayList<Car> car = new ArrayList<>();

        while(true){
            try {
                System.out.print("경주할 자동차 이름을 입력하세요.");
                System.out.println("(이름은 쉼표(,) 기준으로 구분)");
                nameOfCars = carNameValidation(Console.readLine());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR] 차 이름은 5글자 이하여야 한다.");
            }
        }

        while(true){
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                numOfTry = numOfTryValidation(Console.readLine());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
        }

        // 입력받은 자동차의 수 만큼 car 객체 생성하고 car.name (생성자) 초기화
        for(String s: nameOfCars){
            car.set(NUMBER_OF_CAR, new Car(s));
            NUMBER_OF_CAR++;
        }


    }

    public static String[] carNameValidation(String inputValue) throws IllegalArgumentException{

        String[] nameOfCarArray = inputValue.split(",");

        for(String s: nameOfCarArray){
            if(s.length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return nameOfCarArray;
    }

    public static int numOfTryValidation(String inputValue) throws IllegalArgumentException{
        int result;
        try {
            result = Integer.parseInt(inputValue);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
