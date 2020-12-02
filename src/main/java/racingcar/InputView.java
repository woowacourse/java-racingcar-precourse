package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Integer INPUT_NAME_LENGTH=5;
    private static final Integer INPUT_NONE_CAR=0;
    private static final char ZERO='0';
    private static final char NINE='9';
    private static final String INPUT_SPLIT_REGEX=",";
    private static final String TRY_COUNT_NUMBER_ERROR="[ERROR] 시도 횟수는 숫자(양수)여야 한다.";
    private static final String NAME_LENGTH_ERROR="[ERROR] 자동차 이름은 5자이하만 가능합니다.";
    private static final String INPUT_CAR_NAMES="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT="시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner){
        this.scanner=scanner;
    }

    public List<String> getCarNames(){
        System.out.println(INPUT_CAR_NAMES);
        List<String> carNames=Arrays.asList(scanner.nextLine().split(INPUT_SPLIT_REGEX));
        if(carNames.stream().anyMatch(this::isValidNameLength)){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        return carNames;
    }

    public Integer getTryCount(){
        System.out.println(INPUT_TRY_COUNT);
        String tryCount=scanner.next();
        if(!tryCount.chars().allMatch(this::isDigit)){
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_ERROR);
        }
        return Integer.parseInt(tryCount);
    }

    private boolean isValidNameLength(String name){
        return name.length()>INPUT_NAME_LENGTH;
    }

    private boolean isDigit(int ch){
        return ZERO<=ch&&ch<=NINE;
    }
}
