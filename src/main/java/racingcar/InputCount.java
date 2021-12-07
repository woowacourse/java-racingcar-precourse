package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputCount {

    // 입력받는 메소드
    private String inputForm() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();
        return count;
    }

    // 숫자가 아닌 다른 문자 포함 시 예외 발생
    private void checkException(String count) {
        final String REGEX = "[0-9]+";
        if(!count.matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

    // 예외를 고려해서 조건에 맞는 문자열 반환 함수
    private String inputCount() {
        String count = inputForm();
        try {
            checkException(count);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            count = inputCount();
        }
        return count;
    }

    // 문자열로 입력받은 실행 횟수 정수롤 변환하는 함수
    public int stringToInteger() {
        return Integer.parseInt(inputCount());
    }
}
