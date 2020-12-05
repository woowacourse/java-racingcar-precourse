package racingcar;

import exception.InvalidInputException;
import parser.NameParser;
import parser.RoundParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;

    private Car[] cars;
    private int round;

    private List<Car> winners = new ArrayList<>();
    private int maxCarPosition = Integer.MIN_VALUE;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }


    public void start() throws InvalidInputException {
        initParams();
        playRounds();
        checkWinners();
        awardWinners();
    }


    private void initParams() throws InvalidInputException {
        initCars();
        initRound();
    }

    private void initCars() throws InvalidInputException {
        String line = getNamesInput();
        NameParser nameParser = new NameParser(line);
        String[] names = nameParser.parseCarNames();
        createCars(names);
    }

    private String getNamesInput() {
        System.out.println(Information.NAME_INPUT);
        return scanner.nextLine();
    }

    private void createCars(String[] names) {
        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    private void initRound() throws InvalidInputException {
        String line = getRoundInput();
        RoundParser roundParser = new RoundParser(line);
        round = roundParser.parseRound();
    }

    private String getRoundInput() {
        System.out.println(Information.ROUND_INPUT);
        return scanner.nextLine();
    }


    private void playRounds() {
        System.out.println(Information.RESULT);
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
        sb.append(Information.WINNERS);
        for (Car car : winners)
            sb.append(car.getName()).append(", ");
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb.toString());
    }
}
