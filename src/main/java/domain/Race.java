package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Race {
    ArrayList<Car> cars = new ArrayList<>();
    int playTime;

    public void setCarNames() {
        String userInputString;
        ArrayList<String> carNames = new ArrayList<>();

        while (carNames.isEmpty()) {
            userInputString = getInputCarNames();
            carNames = validateUserInput(userInputString);
        }

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void setPlayTime() {
        Scanner scan = new Scanner(System.in);

        System.out.println("시도할 횟수는 몇회인가요?");
        playTime = scan.nextInt();
    }

    public void showRaceResult() {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < playTime; i++) {
            showSingleResult();
            System.out.println();
        }
    }

    private String getInputCarNames() {
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scan.next();
    }

    private ArrayList<String> validateUserInput(String inputString) {
        ArrayList<String> parsedNames = parseInputString(inputString);

        for (String names : parsedNames) {
            if (names.length() > 5) {
                return new ArrayList<>();
            }
        }

        return parsedNames;
    }

    private ArrayList<String> parseInputString(String inputString) {
        return new ArrayList<> (Arrays.asList(inputString.split(",")));
    }

    private void showSingleResult() {
        for (Car car : cars) {
            car.play();
            car.showPosition();
        }
    }

    private ArrayList<String> determineWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        List<Integer> positions = cars.stream().map(car -> car.getPosition()).collect(Collectors.toList());
        int winnerPosition = Collections.max(positions);

        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
