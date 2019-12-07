package ui;

import domain.Car;
import domain.RacingCar;
import domain.RacingGameConfig;
import domain.errors.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements UserInterface {

    private Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<RacingCar> extractRacingCars() {
        //todo: check dependency
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        String[] names = parseNames(input);
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(new Car(name));
        }

        return racingCars;
    }

    private String[] parseNames(String input) {
        return input.split(RacingGameConfig.STANDARD_TO_PARSE);
    }

    @Override
    public int getCycles() {
        System.out.println("시도할 회수는 몇회인가요?");
        int cycles = scanner.nextInt();
        //todo: 제대로 된 입력값을 받을 때까지 계속 물어보기.
        if (cycles < RacingGameConfig.MIN_CYCLES) {
            throw new InvalidInputException(String.format("입력값이 잘못됐습니다. %d 이상의 숫자를 입력해주세요.", RacingGameConfig.MIN_CYCLES));
        }
        return cycles;
    }
}
