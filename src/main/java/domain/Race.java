package domain;

import domain.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Race {

    private static final class carNameLengthException extends RuntimeException {};
    private static final class carNumberException extends RuntimeException {};
    private static final String COMMA = ",";
    private Scanner SCANNER = new Scanner(System.in);
    private Random RANDOM = new Random();

    private ArrayList<Car> Cars;
    private int Round;

    public Race(){
        init();
        // 사용자 입력받고 초기화.
        //      자동차 이름 입력받아서 인스턴스 생성
        //      라운드 입력받기
    }

    private void init(){
        try{
            ArrayList<String> carNames = getCarNames();
            Round = getRound();
        }
        catch( RuntimeException e ){
            System.out.println(e);
        }
    }

    private ArrayList<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = SCANNER.nextLine();
        ArrayList<String> carNames = parseCarNamesInput(carNamesInput);
        validateCarNames(carNames);
        return carNames;
    }

    private ArrayList<String> parseCarNamesInput(String userInput){
        ArrayList<String> carNames = new ArrayList<String>(Arrays.asList(userInput.split(COMMA)));
        return carNames;
    }

    private void validateCarNames(ArrayList<String> carNames){
        carNumberValidation(carNames);
        for(String name : carNames){
            LengthValidation(name);
        }
    }

    private void LengthValidation(String name){
        if(name.length() > 6){
            throw new carNameLengthException();
        }
    }

    private void carNumberValidation(ArrayList<String> carNames){
        if(carNames.size() < 2) {
            throw new carNumberException();
        }
    }

    private int getRound(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String roundInput = SCANNER.nextLine();
        int round = Integer.parseInt(roundInput);
        return round;
    }

    public void start() {
        // 경주 시작
    }

    private void printBoard(){
        // 현재 상황 출력
    }

}
