package domain;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Validator {
    private static final int SMALL_LOWEST_CHAR_VALUE = 65;
    private static final int SMALL_BIGGEST_CHAR_VALUE = 90;
    private static final int BIG_LOWEST_CHAR_VALUE = 97;
    private static final int BIG_BIGGEST_CHAR_VALUE = 122;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String EMPTY_CAR_NAME = "";
    private static final int NEXT_CAR = 1;
    private static final int FIRST_CAR_NAME_INDEX = 0;

    public List<String> getRacingCarNames() {
        List<String> racingCarNames;
        while(true) {
            try {
                Scanner scanInputCarName = new Scanner(System.in);
                racingCarNames = Arrays.asList(scanInputCarName.nextLine().split(","));
                checkInputRacingCarName(racingCarNames);
                break;
            } catch(Exception e) {
                System.out.println("이름은 5자 초과, 중복및 특수문자, 숫자, 공백, 쉼표 사이에 아무것도 입력안한 것" +
                        " 을 허용하지 않습니다.");
            }
        }
        return racingCarNames;
    }

    private void checkInputRacingCarName(List<String> inputCarName) throws Exception{
        for(int carNameIndex = FIRST_CAR_NAME_INDEX; carNameIndex < inputCarName.size(); carNameIndex++) {
            checkValidRacingCarName(inputCarName, carNameIndex);
        }
    }

    private void checkValidRacingCarName(List<String> inputCarName, int racingCarNameIndex) throws Exception {
        checkRacingCarNameSpecialWord(inputCarName.get(racingCarNameIndex));
        checkRacingCarNameLength(inputCarName, racingCarNameIndex);
        checkSameRacingCarName(inputCarName, racingCarNameIndex);
    }

    private void checkRacingCarNameSpecialWord(String s) throws Exception {
        for(char carName : s.toCharArray()) {
            if(carName < SMALL_LOWEST_CHAR_VALUE || (carName > SMALL_BIGGEST_CHAR_VALUE
                    && carName < BIG_LOWEST_CHAR_VALUE) || carName > BIG_BIGGEST_CHAR_VALUE){
                throw new Exception();
            }
        }
    }

    private void checkRacingCarNameLength(List<String> inputCarName, int racingCarNameIndex) throws Exception {
        if(inputCarName.get(racingCarNameIndex).length() > MAX_CAR_NAME_LENGTH
                || inputCarName.get(racingCarNameIndex).equals(EMPTY_CAR_NAME)) {
            throw new Exception();
        }
    }

    private void checkSameRacingCarName(List<String> inputCarName, int carNameIndex) throws Exception {
        for(int nextCarNameIndex = carNameIndex + NEXT_CAR; nextCarNameIndex < inputCarName.size(); nextCarNameIndex++) {
            if(inputCarName.get(carNameIndex).equals(inputCarName.get(nextCarNameIndex))) {
                throw new Exception();
            }

            if(inputCarName.get(carNameIndex).toUpperCase().equals(inputCarName.get(nextCarNameIndex).toUpperCase())) {
                throw new Exception();
            }
        }
    }

    public int getRacingLab() {
        int racingLab;

        while(true) {
            try{
                Scanner scanRacingLab = new Scanner(System.in);
                racingLab = scanRacingLab.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주시기 바랍니다.");
            }
        }
        return racingLab;
    }
}
