package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private final static List<Car> cars=new ArrayList();
    private static int trialNumber;

    public static void play(){
        setGame();
        System.out.println("실행 결과");
        for(int i=1; i<=trialNumber; i++){
            startRound();
        }
    }
    private static void startRound(){
        for(Car car : cars){
            tryMove(car);
        }
    }
    private static void tryMove(Car car){
        if(canMove()){
            car.goForward();
        }
    }
    private static boolean canMove(){
        //TODO: 랜덤 기능 추가
        return true;
    }
    private static void setGame(){
        setCars();
        setTrialNumber();
    }
    private static void setCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input=Console.readLine();
        parseStringToList(input);
    }
    private static void parseStringToList(String input){
        String[] carNames=input.split(",");
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
    }
    private static void setTrialNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        trialNumber=Integer.parseInt(Console.readLine());
    }
}
