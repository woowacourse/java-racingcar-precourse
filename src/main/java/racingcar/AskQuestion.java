package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// 구조체처럼 사용하기
class IndexNameSet {
    private int index;
    private String name;

    public IndexNameSet(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}

// 예외 처리 & 입력 검증 부분은 따로 Verify 클래스를 만드는게 나을까?
public class AskQuestion {

    // 여기도 private 또는 final이 붙어야 할까?
    Scanner scanner;
    GameManager gameManager;

    public AskQuestion(Scanner scanner) {
        this.scanner = scanner;
        startQuestions();
    }
    
    public void startQuestions() {
        carNameQuestion();
        String[] carNames = carNameInput();
        numberOfTryQuestion();
        int numberOfTry = numberOfTryInput();
        gameManager = new GameManager(carNames, numberOfTry);
    }

    public GameManager readyToGame() {
        return gameManager;
    }

    public void carNameQuestion() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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
            splitNames = rawNames.split(",");
            if (hasDuplicateElement(splitNames)) {
                errorDuplicate();
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

    public void errorDuplicate() {
        System.out.println("[ERROR] 중복되는 이름이 존재합니다. 다시 입력해주세요.");
    }

    public void checkLength(String[] carNames) {
        ArrayList<IndexNameSet> tooLongName = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
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
        System.out.print("[ERROR] ");
        for (int i = 0; i < tooLongName.size(); i++) {
            System.out.print(tooLongName.get(i).getName());
            if (i < tooLongName.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("은(는) 길이가 너무 깁니다. 5자 이하로 수정해주세요.\n");
    }

    public void modifyTooLongNames(ArrayList<IndexNameSet> tooLongName, String[] carNames) {
        for (int i = 0; i < tooLongName.size(); i++) {
            IndexNameSet elem = tooLongName.get(i);
            System.out.print("[MODIFY] " + elem.getName() + " -> ");
            String newName = scanner.nextLine();
            System.out.print("[MESSAGE] ");
            if (newName.length() > 5) {
                System.out.println(newName + "은(는) 길이가 너무 깁니다. 5자 이하로 수정해주세요.");
                i--;
            } else {
                carNames[elem.getIndex()] = newName;
                System.out.println(elem.getName() + "은(는) " + newName + "(으)로 성공적으로 수정되었습니다.");
            }
        }
    }

    public void numberOfTryQuestion() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public int numberOfTryInput() {
        boolean isNumber = false;
        int numberOfTry = 0;
        while (!isNumber) {
            try {
                numberOfTry = scanner.nextInt();
                scanner.nextLine(); // buffer flush
                isNumber = true;
            } catch (Exception e) {
                errorNumberOfTryNotInt();
                scanner.nextLine(); // buffer flush
            }
        }
        return numberOfTry;
    }

    public void errorNumberOfTryNotInt() {
        System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다. 다시 입력해주세요.");
    }

}
