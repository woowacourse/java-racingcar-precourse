package controller;

import racingcar.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/** 레이싱게임의 로직을 담당하는 클래스*/
public class GameController {
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_COUNT = 1;

    private static int status;
    private static int count;
    private static int maxDistance = 0;
    private static List<Car> cars = new ArrayList<>();

    public static void start(Scanner scanner) {
        setCarNames(scanner);
    }

    /**
     * 자동차의 이름을 등록하는 메소드
     * @param scanner
     */
    public static void setCarNames(Scanner scanner) {
        List<String> names;
        do {
            status = SUCCESS;
            System.out.println("경주할 자동차 이름을  입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = Arrays.stream(scanner.nextLine().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            status = validateName(names);
        } while (status == FAIL);
        names.forEach(name -> cars.add(new Car(name)));

    }

    /**
     * 입력받은 값이 정상인지 검증하는 메소드
     * @param names
     */
    public static int validateName(List<String> names) {
        if (names.isEmpty()) {
            System.out.println("자동차 이름으로 콤마를 입력했습니다. 다시 입력하세요.");
            return FAIL;
        }
        for (String name : names) {
            if (name.isBlank()) {
                System.out.println(name + "자동차 이름으로 빈 문자열을 사용할 수 없습니다.");
                return FAIL;
            } else if (name.length() > MAX_NAME_LENGTH) {
                System.out.println("자동차 이름은 다섯 글자 이하만 가능합니다.");
                return FAIL;
            }
        }
        return SUCCESS;
    }
}
