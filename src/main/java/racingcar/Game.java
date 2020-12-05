package racingcar;

import exception.InvalidCarNameException;
import exception.InvalidInputException;

import java.util.*;

public class Game {

    private Scanner scanner;

    private Car[] cars;
    private int round;

    private List<Car> winners = new ArrayList<>();
    private int maxCarPosition = Integer.MIN_VALUE;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() throws InputMismatchException, InvalidInputException {
        initParams();
        playRounds();
        checkWinners();
        awardWinners();
    }


    private void initParams() throws InputMismatchException, InvalidInputException {
        initCars();
        initRound();
    }

    private void initCars() throws InvalidCarNameException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = scanner.nextLine();
        String[] names = parseCarNames(line);
        validateCarNames(names);
        createCars(names);
    }

    private String[] parseCarNames(String line) throws InvalidInputException {
        StringTokenizer tk = new StringTokenizer(line, ",");
        String[] names = new String[tk.countTokens()];
        int i = 0;
        while (tk.hasMoreTokens())
            names[i++] = tk.nextToken();
        return names;
    }

    private void validateCarNames(String[] names) throws InvalidInputException {
        for (String name : names)
            validateNameLength(name);
    }

    private void validateNameLength(String name) throws InvalidInputException {
        if (name.length() > 5)
            throw new InvalidCarNameException();
    }

    private void createCars(String[] names) {
        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    private void initRound() throws InvalidInputException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        round = scanner.nextInt();
    }


    private void playRounds() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            playOneRound();
            System.out.println();
        }
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }


    private void checkWinners() {
        for (Car car : cars) {
            checkIfAdditionalWinner(car);
            checkIfNewWinner(car);
        }
    }

    private void checkIfAdditionalWinner(Car car) {
        if (car.getPosition() == maxCarPosition)
            winners.add(car);
    }

    private void checkIfNewWinner(Car car) {
        if (car.getPosition() > maxCarPosition) {
            maxCarPosition = car.getPosition();
            winners.clear();
            winners.add(car);
        }
    }


    private void awardWinners() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자: ");
        for (Car car : winners)
            sb.append(car.getName()).append(", ");
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb.toString());
    }
}
