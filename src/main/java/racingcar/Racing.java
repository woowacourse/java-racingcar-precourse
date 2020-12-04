package racingcar;

import java.util.*;

public class Racing {

    static final String TRIAL_RESULT = "실행 결과";
    static final String PRINT_WINNERS = "최종 우승자 : ";

    Input input = new Input();
    Error error = new Error();

    public List<Car> makeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public void oneTrialGame(List<Car> carList) {
        for (Car car : carList) {
            car.tryMove();
            System.out.print(car.getName() + " : ");
            printMove(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public void printMove(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
    }

    public int winnerPosition(List<Car> carList) {
        List<Integer> carPosition = new ArrayList<>();
        for (Car car : carList) {
            carPosition.add(car.getPosition());
        }
        return Collections.max(carPosition);
    }

    public List<String> getWinnersList(List<Car> carList, int winnerPosition) {
        List<String> winners = new ArrayList<>();
        for(Car car : carList) {
            if(car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinnersName(List<String> winners) {
        Iterator<String> iterator = winners.iterator();
        System.out.print(PRINT_WINNERS);
        if (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        while (iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }
    }

    public void printRacingGameResult(List<Car> carList, int trial) {
        System.out.println(TRIAL_RESULT);
        for (int i = 0; i < trial; i++) {
            oneTrialGame(carList);
        }
        List<String> winnersList = getWinnersList(carList, winnerPosition(carList));
        printWinnersName(winnersList);
    }

    public void playRacingGame(Scanner scanner) {
        try {
            List<String> carNameList = input.getCarNameList(input.getCarNameArray(scanner));
            error.checkSameCarName(carNameList);
            error.checkCarNameLength(carNameList);
            String trial = input.getTrial(scanner);
            error.checkTrialIsInteger(trial);
            int trialNumber = Integer.parseInt(trial);
            error.checkTrialLessThanOne(trialNumber);
            List<Car> carList = makeCars(carNameList);
            printRacingGameResult(carList, trialNumber);
        }  catch (IllegalArgumentException illegalArgumentException) {
        }
    }











}
