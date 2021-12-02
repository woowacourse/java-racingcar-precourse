package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class RacingGame {
    private Result result;
    private int moves;
    ArrayList<Car> carList = new ArrayList<>();
    LinkedHashSet<String> carNameLinkedHashSet = new LinkedHashSet<>();

    public void run() {
        initGame();
        startGame();
        printWinner();
    }

    private void printWinner() {
        System.out.println("최종 우승자 : " + checkWinner());
    }

    private String checkWinner() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : carList) {
            appendIfWinner(stringBuilder, car);
        }

        return stringBuilder.toString();
    }

    private void appendIfWinner(StringBuilder stringBuilder, Car car) {
        if(isWinner(car)) {
            appendIfNotFirst(stringBuilder);
            stringBuilder.append(car.getName());
        }
    }

    private void appendIfNotFirst(StringBuilder stringBuilder) {
        if(stringBuilder.length() != 0) {
            stringBuilder.append(", ");
        }
    }

    private boolean isWinner(Car car) {
        return car.getPosition() == result.getMax();
    }

    private void initGame() {
        printMessageForCarNames();
        processCarName();
        createResult();
        printMessageForNumberOfMoves();
        inputMoves();
    }

    private void printMessageForNumberOfMoves() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void printMessageForCarNames() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    private void createResult() {
        result = new Result(carList);
    }

    private void startGame() {
        for(int i = 0; i < moves; i++) {
            moveAllCar();
            printResult();
        }
    }

    private void printResult() {
        System.out.println(result.toString());
    }

    private void moveAllCar() {
        for(Car car : carList) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if(canCarMove()) {
            car.moveCarForward();
        }
    }

    private boolean canCarMove() {
        return RandomNumberGenerator.getRandomNumber() >= 4;
    }

    private String inputCarNames() {
        while(true) {
            try {
                String input = Console.readLine();
                isValidInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidInput(String input) {
        if(!input.matches("^[a-zA-Z]+(,[a-zA-Z]+)+$")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 이름,이름,이름 형식으로 다시 입력해주세요.");
        }
    }

    private void inputMoves() {
        boolean flag = false;

        do {
            try {
                validateNumber(Console.readLine());
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(!flag);
    }

    private void validateNumber(String input) {
        if(!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자로만 제한됩니다. 다시 입력해주세요.");
        }

        moves = Integer.parseInt(input);
    }

    private void processCarName() {
        boolean isValid = false;

        do {
            try {
                StringTokenizer st = new StringTokenizer(inputCarNames(), ",");
                validateCarName(st);
                isValid = true;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                carNameLinkedHashSet.clear();
            }
        } while(!isValid);

        createCars();
    }

    private void createCars() {
        for(String carName : carNameLinkedHashSet) {
            carList.add(new Car(carName));
        }
    }

    private void validateCarName(StringTokenizer stringTokenizer) throws IllegalArgumentException {
        while(stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            validateNameLength(nextToken);
            validateDuplicateName(nextToken);
            carNameLinkedHashSet.add(nextToken);
        }
    }

    private void validateDuplicateName(String nextToken) {
        if (carNameLinkedHashSet.contains(nextToken)) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 있습니다. 다시 입력해주세요.");
        }
    }

    private void validateNameLength(String carName) {
        if(isValidLength(carName)) {
            throw new IllegalArgumentException("[ERROR] 각 자동차 이름은 5 글자 이하로 제한됩니다. 다시 입력해주세요.");
        }
    }

    private boolean isValidLength(String carName) {
        return carName.length() > 5;
    }
}
