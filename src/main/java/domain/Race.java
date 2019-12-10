package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Race {

    private static final class carNameLengthException extends RuntimeException {
    }

    ;

    private static final class carNumberException extends RuntimeException {
    }

    ;
    private static final String COMMA = ",";
    private static final String SKID = "-";
    private Scanner SCANNER = new Scanner(System.in);

    private ArrayList<Car> Cars;
    private int Round;

    public Race() {
        init();
    }

    private void init() {
        try {
            ArrayList<String> carNames = getCarNames();
            Cars = createCars(carNames);
            Round = getRound();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    private ArrayList<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = SCANNER.nextLine();
        ArrayList<String> carNames = parseCarNamesInput(carNamesInput);
        validateCarNames(carNames);
        return carNames;
    }

    private ArrayList<String> parseCarNamesInput(String userInput) {
        ArrayList<String> carNames = new ArrayList<String>(Arrays.asList(userInput.split(COMMA)));
        return carNames;
    }

    private void validateCarNames(ArrayList<String> carNames) {
        carNumberValidation(carNames);
        for (String name : carNames) {
            LengthValidation(name);
        }
    }

    private void LengthValidation(String name) {
        if (name.length() > 6) {
            throw new carNameLengthException();
        }
    }

    private void carNumberValidation(ArrayList<String> carNames) {
        if (carNames.size() < 2) {
            throw new carNumberException();
        }
    }

    private int getRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String roundInput = SCANNER.nextLine();
        int round = Integer.parseInt(roundInput);
        return round;
    }

    private ArrayList<Car> createCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void start() {
        System.out.println("실행결과");
        for (int i = 0; i < Round; i++) {
            doRound();
        }
        printResult();
    }

    private void doRound() {
        proceedCars();
        printBoard();
    }

    private void proceedCars() {
        for (Car car : Cars) {
            car.proceed();
        }
    }

    private void printBoard() {
        for (Car car : Cars) {
            printRow(car);
        }
    }

    private String repeat(String str, int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer += str;
        }
        return answer;
    }

    private void printRow(Car car) {
        System.out.println(String.format("%s: %s\n", car.getName(), repeat(SKID, car.getPosition()+1)));
    }

    private void printResult(){
        ArrayList<String> winners = findWinnerNames();
        System.out.println(String.format("%s가 최종 우승했습니다.",Arrays.toString(winners.toArray())));
    }

    private ArrayList<String> findWinnerNames(){
        Car firstWinner = findFirstWinner();
        ArrayList<String> winnerNames = findAllWineers(firstWinner);
        return winnerNames;
    }

    private Car findFirstWinner(){
        Car winner = Cars.get(0);
        int best = winner.getPosition();

        for(Car car:Cars){
            if(car.getPosition() > best){
                winner = car;
                best = car.getPosition();
            }
        }

        return winner;
    }

    private ArrayList<String> findAllWineers(Car winner){
        ArrayList<String> winners = new ArrayList<String>();
        int best = winner.getPosition();

        for(Car car: Cars){
            if(best==car.getPosition()){
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
