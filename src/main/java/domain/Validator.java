package domain;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Validator {
    public List<String> getRacingCarNames() {
        List<String> racingCarNames;
        while (true) {
            try {
                Scanner scanInputCarName = new Scanner(System.in);
                racingCarNames = Arrays.asList(scanInputCarName.nextLine().split(","));
                checkInputRacingCarName(racingCarNames);
                break;
            } catch (Exception e) {
                System.out.println("자동차 2대 이상, 이름은 5자 초과, 중복및 특수문자, 숫자, 공을 허용하지 않습니다.");
            }
        }
        return racingCarNames;
    }

    private void checkInputRacingCarName(List<String> inputCarName) throws Exception {
        if (inputCarName.size() == 1) {
            throw new Exception();
        }
        for (int racingCarNameIndex = 0; racingCarNameIndex < inputCarName.size(); racingCarNameIndex++) {
            checkRacingCarNameSpecialWord(inputCarName.get(racingCarNameIndex));
            checkRacingCarNameLength(inputCarName, racingCarNameIndex);
            checkSameRacingCarName(inputCarName, racingCarNameIndex);
        }
    }

    private void checkRacingCarNameSpecialWord(String s) throws Exception {
        for (char carName : s.toCharArray()) {
            if (carName < 65 || (carName > 90 && carName < 97) || carName > 122) {
                throw new Exception();
            }

        }
    }

    private void checkRacingCarNameLength(List<String> inputCarName, int racingCarNameIndex) throws Exception {
        if (inputCarName.get(racingCarNameIndex).length() > 5) {
            throw new Exception();
        }
    }

    private void checkSameRacingCarName(List<String> inputCarName, int racingCarNameIndex) throws Exception {
        for (int j = racingCarNameIndex + 1; j < inputCarName.size(); j++) {
            if (inputCarName.get(racingCarNameIndex).equals(inputCarName.get(j))) {
                throw new Exception();
            }

            if (inputCarName.get(racingCarNameIndex).toUpperCase().equals(inputCarName.get(j).toUpperCase())) {
                throw new Exception();
            }
        }
    }
}
