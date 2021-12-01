package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static List<Car> carList = new ArrayList<>();
    static int tryTimes;

    public static void main(String[] args) {
        CreateCars();
        SetTryTimes();
        PlayGames();
    }

    static void CreateCars() {
        PrintGameMessage(GAME_CREATE_CARS);
        String[] carNames = GetCarNames();
        AddCarsToCarList(carNames);
    }

    static void AddCarsToCarList(String[] carNames) {
        for (String s : carNames) {
            Car c = new Car(s);
            carList.add(c);
        }
    }

    static String[] GetCarNames() {
        String carNamesInput = readLine();
        String[] carNames;

        while (true) {
            try {
                carNames = ParseCarNamesInput(carNamesInput);
                return carNames;
            } catch (IllegalArgumentException e) {
                PrintErrorMessage(NAME_INPUT_ERROR);
            }
        }
    }

    final static String parser = "/";

    static String[] ParseCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(parser);

        for (String s : carNames) {
            if (s.length() > 5) {
                PrintErrorMessage(NAME_INPUT_ERROR);
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    static void SetTryTimes() {
        PrintGameMessage(GAME_SET_TRY_TIMES);
        tryTimes = GetTryTimes();
    }

    static int GetTryTimes() {
        String tryTimesInput = readLine();
        int tryTimesInt;

        while (true) {
            try {
                tryTimesInt = InputStringToInt(tryTimesInput);
                return tryTimesInt;
            } catch (IllegalArgumentException e) {
                PrintErrorMessage(TIME_INPUT_ERROR);
            }
        }
    }

    static int InputStringToInt(String inputString) {
        int inputInt;

        try {
            inputInt = Integer.parseInt(inputString);
            return inputInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void PlayGames() {
        PrintGameMessage(GAME_PLAY_START);

        for(int i=0;i<tryTimes;++i){
            PlayOneTurn();
        }
    }

    static void PlayOneTurn(){
        for(Car c:carList){
            c.PlayMovingThisCar();
        }
        System.out.println("\n");
    }

    static int GAME_CREATE_CARS = 1;
    static int GAME_SET_TRY_TIMES = 2;
    static int GAME_PLAY_START=3;

    static void PrintGameMessage(int gameType) {
        if (gameType == GAME_CREATE_CARS) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            return;
        }
        if (gameType == GAME_SET_TRY_TIMES) {
            System.out.println("시도할 회수는 몇회인가요?");
            return;
        }
        if(gameType == GAME_PLAY_START){
            System.out.println("\n실행 결과");
        }
    }

    static int NAME_INPUT_ERROR = 1;
    static int TIME_INPUT_ERROR = 2;

    static void PrintErrorMessage(int errorType) {
        if (errorType == NAME_INPUT_ERROR) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            return;
        }
        if (errorType == TIME_INPUT_ERROR) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
