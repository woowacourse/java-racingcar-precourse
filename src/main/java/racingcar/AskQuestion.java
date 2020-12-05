package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// 예외 처리 & 입력 검증 부분은 따로 Verify 클래스를 만드는게 나을까?
public class AskQuestion {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int PREVIOUS_INDEX = -1;

    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String NUMBER_OF_TRY_QUESTION = "시도할 회수는 몇회인가요?";
    private static final String POSTPOSITION = "은(는) ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_DUPLICATE = "중복되는 이름이 존재합니다. 다시 입력해주세요.";
    private static final String ERROR_TOO_LONG = "길이가 너무 깁니다. " + MAX_NAME_LENGTH + "자 이하로 수정해주세요.";
    private static final String ERROR_NOT_POSITIVE_INTEGER = "시도 횟수는 양의 정수여야 합니다. 다시 입력해주세요.";
    private static final String MODIFY_PREFIX = "[MODIFY] ";
    private static final String MODIFY_ARROW = " -> ";
    private static final String MODIFY_SUCCESS = "(으)로 성공적으로 수정되었습니다.";
    private static final String MESSAGE_PREFIX = "[MESSAGE] ";

    private final Scanner scanner;
    private GameManager gameManager;

    public AskQuestion(Scanner scanner) {
        this.scanner = scanner;
        startQuestions();
    }
    
    public void startQuestions() {
        System.out.println(CAR_NAME_QUESTION);
        String[] carNames = carNameInput();
        System.out.println(NUMBER_OF_TRY_QUESTION);
        int numberOfTry = numberOfTryInput();
        gameManager = new GameManager(carNames, numberOfTry);
    }

    public GameManager readyToGame() {
        return gameManager;
    }

    public String[] carNameInput() {
        String[] carNames = checkDuplicate();
        checkLength(carNames);
        return carNames;
    }

    // 입력부와 중복 예외 처리부 분할하는게 나을지도
    public String[] checkDuplicate() {
        String rawNames;
        String[] splitNames;
        while (true) {
            rawNames = scanner.nextLine();
            splitNames = rawNames.split(CAR_NAME_DELIMITER);
            if (hasDuplicateElement(splitNames)) {
                System.out.println(ERROR_PREFIX + ERROR_DUPLICATE);
                continue;
            }
            break;
        }
        return splitNames;
    }

    public boolean hasDuplicateElement(String[] splitNames) {
        HashSet<String> verifyUnique = new HashSet<>();
        for (String name : splitNames) {
            if (verifyUnique.contains(name)) {
                return true;
            }
            verifyUnique.add(name);
        }
        return false;
    }

    public void checkLength(String[] carNames) {
        ArrayList<IndexNameSet> tooLongName = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > MAX_NAME_LENGTH) {
                tooLongName.add(new IndexNameSet(i, carNames[i]));
            }
        }
        if (tooLongName.isEmpty()) {
            return;
        }
        errorTooLongNames(tooLongName);
        modifyTooLongNames(tooLongName, carNames);
    }

    public void errorTooLongNames(ArrayList<IndexNameSet> tooLongName) {
        System.out.print(ERROR_PREFIX);
        for (int i = 0; i < tooLongName.size(); i++) {
            System.out.print(tooLongName.get(i).getName());
            if (i < tooLongName.size() + PREVIOUS_INDEX) {
                System.out.print(GameManager.NAMES_CONNECTOR);
            }
        }
        System.out.println(POSTPOSITION + ERROR_TOO_LONG);
    }

    public void modifyTooLongNames(ArrayList<IndexNameSet> tooLongName, String[] carNames) {
        for (int i = 0; i < tooLongName.size(); i++) {
            IndexNameSet tooLongSet = tooLongName.get(i);
            System.out.print(MODIFY_PREFIX + tooLongSet.getName() + MODIFY_ARROW);
            String newName = scanner.nextLine();
            System.out.print(MESSAGE_PREFIX);
            if (newName.length() > MAX_NAME_LENGTH) {
                System.out.println(newName + POSTPOSITION + ERROR_TOO_LONG);
                i = i + PREVIOUS_INDEX; // re-try
                continue;
            }
            carNames[tooLongSet.getIndex()] = newName;
            System.out.println(tooLongSet.getName() + POSTPOSITION + newName + MODIFY_SUCCESS);
        }
    }

    public int numberOfTryInput() {
        boolean isNumber = GameManager.INITIALIZATION_BOOLEAN;
        int numberOfTry = GameManager.INITIALIZATION_INTEGER;
        while (!isNumber) {
            try {
                numberOfTry = scanner.nextInt();
                isPositiveNumber(numberOfTry);
                isNumber = true;
            } catch (Exception e) {
                System.out.println(ERROR_PREFIX + ERROR_NOT_POSITIVE_INTEGER);
            }
            scanner.nextLine(); // buffer flush
        }
        return numberOfTry;
    }

    public void isPositiveNumber(int input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
    }

}
