package racingcar;

import view.ConsoleView;

import java.util.*;

public class Application {
    private static final String REQUEST_INPUT_RACING_CAR_MSG = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA = ",";
    private List<Car> cars;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application();
        app.start(scanner);
    }

    private void start(Scanner scanner) {
        ConsoleView view = new ConsoleView(scanner);
        view.println(REQUEST_INPUT_RACING_CAR_MSG);
        String userInput = view.inputNextLine();

        cars = makeCarList(userInput);
    }

    private List<Car> makeCarList(String userInput) {
        String[] carNames = userInput.split(COMMA);

        validateCarNamesSize(carNames);
        validateDuplicateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarNameFormat(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void validateCarNameFormat(String carName) {
        if(carName.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 공백 이름은 사용할 수 없습니다.");
        }
        if(carName.length() > 5){
            throw new IllegalArgumentException("[ERROR] 사용자의 아이디는 5글자 이하여야 합니다.");
        }
    }

    private void validateDuplicateCarNames(String[] carNames) {
        Set<String> duplicateCheckSet = new HashSet<>(Arrays.asList(carNames));
        if (duplicateCheckSet.size() != carNames.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 사용자 이름입니다.");
        }
    }

    private void validateCarNamesSize(String[] carNames) {
        if (carNames.length > 5) {
            throw new IllegalArgumentException("[ERROR] 인원숫자를 확인해주십시오. ( 5명 이하)");
        }
    }
}
