package racingcar;

import utils.GameUtils;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class RacingGame {
    private Scanner scanner;
    private ArrayList<Car> Cars;
    private GameUtils gameUtils;
    private int numberOfGames;

    public RacingGame(Scanner scanner){
        this.scanner = scanner;
        this.gameUtils = new GameUtils();
        this.Cars = new ArrayList<Car>();
    }
    public void playGame() {
        try {
            inputCars();
            inputNumberOfGames();
            System.out.println(this.numberOfGames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputCars(){
        final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        final String ERROR_MESSAGE = "[ERROR] 자동차의 이름은 5자 이하여야 한다";
        System.out.println(INPUT_MESSAGE);
        String userCarsName = scanner.nextLine();
        String[] nameList = userCarsName.split(",");
        for(int i=0; i<nameList.length; i++){
            if(gameUtils.isRightCarName(nameList[i])) {
                registerCars(nameList[i]);
                continue;
            }
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void registerCars(String carName){
        Car car = new Car(carName);
        this.Cars.add(car);
    }

    public void inputNumberOfGames(){
        final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
        final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다";
        System.out.println(INPUT_MESSAGE);
        String userNumber = scanner.nextLine();
        if(!gameUtils.isNumber(userNumber))
            throw new IllegalArgumentException(ERROR_MESSAGE);
        this.numberOfGames = Integer.parseInt(userNumber);
    }

    public void getCarinfo(){

    }
    public void printResult(){

    }
    public void printWinner(){

    }

}
