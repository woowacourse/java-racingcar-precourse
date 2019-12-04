package domain;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import domain.Car;

/**
 * Admin class - 프로그램 진행에 필요한 메소드를 모아둔 클래스
 *
 * @author 김범준(ddaaac)
 * @version 1.00 2019-12-04
 */
public class Admin {
    /* Admin은 게임 전체 진행에 필요한 메소드를 포함 */

    /** 입력받은 값이 valid하지 않은 값이라는 것을 확인할 때 사용하는 class 변수 */
    public static final Boolean IS_NOT_VALID = false;

    /**
     * 값을 입력받기 위한 Scanner class
     * 한번만 초기화하면 되기 때문에 class 변수로 선언언     */
    private static final Scanner scan = new Scanner(System.in);

    /** 입력받은 차 이름을 저장하기 위한 String Array */
    private String[] carNames;

    /** Car 객체를 저장하기 위한 Car array */
    private Car[] cars;

    /**
     * 쉼표로 구분된 차 이름을 입력받아 carNames 변수에 저장하는 메소드
     * 이름 중에 하나라도 유효하지 않은 이름이 있으면 false를 return함
     * 이름이 유효하다는 것은 1~5 글자의 영문 알파벳, 숫자로 이뤄졌다는 것을 의미
     * @return Boolean 쉼표로 구분된 각 이름이 모두 유효한지 여부
     */
    public Boolean getCarName() {
        String input;
        Boolean ifValidInput;
        String carNameValidPattern = "(^[a-zA-Z0-9]{1,5})";         // 1~5 글자의 영문 알파벳, 숫자를 의미

        System.out.println("이름 입력");
        input = scan.nextLine();
        carNames = input.split(",");
        for (int i = 0; i < carNames.length; i++) {
            ifValidInput = ifStringHasValidPattern(carNames[i], carNameValidPattern);
            if (!ifValidInput) {
                carNames = null;
                return false;
            }
        }
        return true;
    }

    /**
     * Car 객체를 생성하여 반환하는 함수
     * @return Car[] 입력받은 이름으로 초기화된 Car Array
     */
    public void makeCars() {
        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    /**
     * 문자열이 유효한 패턴을 갖고 있는지 체크하는 함수
     * @param string 체크할 문자열
     * @param validPattern 찾고 싶은 유효한 패턴
     * @return Boolean 문자열이 유효한 패턴을 갖고 있는지 여부
     */
    private Boolean ifStringHasValidPattern(String string, String validPattern) {
        Pattern namePattern = Pattern.compile(validPattern);
        Matcher nameMatcher = namePattern.matcher(string);
        return nameMatcher.find();
    }
}
