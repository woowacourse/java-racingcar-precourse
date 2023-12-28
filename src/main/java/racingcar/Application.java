package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        // 자동차 이름 입력 -> 유효성 검사
        List<String> carNames = getCarNames();
        // 자동차 목록 생성
        List<Car> cars = createCars(carNames);
        // 시도 횟수 입력
        int tryCount = getTryCount();
        // 레이싱 게임 실행 -> 한 라운드 결과 출력
        runRacingGame(cars, tryCount);
        // 우승자 목록 찾기 -> 우승자 목록 출력
        printWinners(findWinners(cars));
    }

    // 자동차 이름 입력
    private static List<String> getCarNames() {
//        Scanner scanner = new Scanner(System.in);
        List<String> carNames;
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            carNames = Arrays.stream(input.split("," , -1));
            try { // 예외가 발생한다면? -> catch
                validateCarNames(carNames); // 유효성 검사
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("올바른 형식의 자동차 이름을 입력하세요.");
            }
        }
        return carNames;
    }

    // 자동차 이름 유효성 검사
    private static void validateCarNames(List<String> carNames) {
        for (String str : carNames) {
            if (str.isEmpty() || str.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        Set<String> uniqueNames = new HashSet<>(carNames); // 중복을 허용하지 않는 자료구조
        if (uniqueNames.size() < carNames.size()) { // 작다면 중복된 이름이 있다는 것을 의미함
            throw new IllegalArgumentException();
        }
    }

    // 시도 횟수 입력
    private static int getTryCount() {
        int tryCount;
        while (true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String input = Console.readLine();
            try {
                tryCount = Integer.parseInt(input); // 문자열을 정수로 변환하는 문법
                if (tryCount <= 0) {
                    throw new IllegalArgumentException();
                }
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("올바른 형식의 숫자를 입력하세요.");
            }
        }
        return tryCount;
    }

    // 자동차 목록 생성.
    private static List<Car> createCars(List<String> carNames) {

    }

}
