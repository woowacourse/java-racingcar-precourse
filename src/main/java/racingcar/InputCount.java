package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputCount {

    // 입력받는 메소드
    private String inputForm() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();
        return count;
    }

    // 예외 발생 유무 확인
    // 예외가 발생하면 true, 발생하지 않았다면 false
    private boolean checkException(String count) {
        final String REGEX = "[0-9]+";
        if(!count.matches(REGEX)) {
            return true;
        }
        return false;
    }

    // 예외를 고려해서 조건에 맞는 문자열 반환 함수
    private String inputCount() {
        String count = inputForm();
        try {
            if(checkException(count)) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
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
