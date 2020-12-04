package racingcar;

import utils.ErrorUtils;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//cars 리스트 각각의 car에 대해 한번씩 랜덤 메소드 실행 및 결과값 position에 저장
//그 후 결과값 출력까지가 한 라운드로 설정
public class RacingGame {
    private int tryNum;
    private List<Car> cars;

    public RacingGame() {
        cars = new ArrayList<Car>();
    }

    public int getTryNum(){
        return this.tryNum;
    }

    public void startGame(Scanner scanner){
        InputUtils.inputNames(scanner, cars);
        tryNum = InputUtils.inputTryNumber(scanner);
        if(tryNum < 1){
            ErrorUtils.printNumError(tryNum);
            tryNum = InputUtils.inputTryNumber(scanner);
        }
    }

    public void playOneRound(){
        for(Car car : cars) {
            car.tryToMoveForward();
            Result.printCarName(car.getName());
            Result.printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    public void endGame(){
        Result.printFinalWinner();
    }
}
