package domain;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Admin class - 프로그램 진행에 필요한 메소드를 모아둔 클래스
 *
 * @author 김범준(ddaaac)
 * @version 1.00 2019-12-04
 */
public class Admin {
    /**
     * 전진여부 결정 시 나올 수 있는 최대 정수
     */
    protected static final int maxRandomNumber = 10;

    /**
     * 전진여부 결정 시 전진할 수 있는 최소 정수
     */
    protected static final int minMovingNumber = 4;

    /**
     * 입력받은 값이 valid하지 않은 값이라는 것을 확인할 때 사용하는 class 변수
     */
    public static final Boolean IS_NOT_VALID = false;

    /**
     * 값을 입력받기 위한 Scanner class
     * 한번만 초기화하면 되기 때문에 class 변수로 선언
     */
    private static final Scanner scan = new Scanner(System.in);

    /**
     * 입력받은 차 이름을 저장하기 위한 String Array
     */
    private String[] carNames;

    /**
     * Car 객체를 저장하기 위한 Car array
     */
    private Car[] cars;

    /**
     * 전진을 시도할 횟수를 저장하는 변수
     */
    private int maxNumOfMoving;

    /**
     * 쉼표로 구분된 차 이름을 입력받아 carNames 변수에 저장하는 메소드
     *
     * @return Boolean 쉼표로 구분된 각 이름이 모두 유효한지 여부
     */
    public Boolean getCarName() {
        String input;
        String carNameValidPattern = "(^[a-zA-Z0-9]{1,5})";         // 유효한 패턴은 1~5 글자의 영문 알파벳, 숫자를 의미

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = scan.nextLine();
        carNames = input.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (!ifStringHasValidPattern(carNames[i], carNameValidPattern)) {
                carNames = null;
                return false;
            }
        }
        return true;
    }

    /**
     * Car 객체를 생성하여 반환하는 메소드
     *
     * @return Car[] 입력받은 이름으로 초기화된 Car Array
     */
    public void makeCars() {
        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    /**
     * 자동차를 최대 몇 번 이동시킬지 사용자에게 물어보고 maxNumOFMoving 변수에 저장하는 메소드
     *
     * @return Boolean 입력받은 문자열이 숫자인지 여부
     */
    public Boolean getNumberOfMoving() {
        String input;
        String numberValidPattern = "(^[0-9]+)";         // 한자리 이상의 숫자를 의미

        System.out.println("시도할 횟수는 몇회인가요?");
        input = scan.nextLine();
        if (!ifStringHasValidPattern(input, numberValidPattern)) {
            return false;
        }
        maxNumOfMoving = Integer.parseInt(input);
        return true;
    }

    /**
     * 자동차를 전진시키고 전진과정을 출력하는 메소드
     */
    public void moveCars() {
        /* position 변수를 사용하지 않기 위해 각 Car 객체에서 입력받은 횟수만큼 전진했는지 여부를 담은 배열을 반환
         * 그 배열을 확인해서 하나씩 출력하는 식으로 구현
         * */

        Boolean[][] actualMoving = new Boolean[cars.length][maxNumOfMoving];
        for (int i = 0; i < cars.length; i++) {
            actualMoving[i] = cars[i].moveCar(maxNumOfMoving);
        }
        for (int i = 0; i < maxNumOfMoving; i++) {
            for (int j = 0; j < cars.length; j++) {
                printMoving(actualMoving, j, i);
            }
            System.out.println();
        }
    }

    /**
     * 문자열이 유효한 패턴을 갖고 있는지 체크하는 함수
     *
     * @param string       체크할 문자열
     * @param validPattern 찾고 싶은 유효한 패턴
     * @return Boolean 문자열이 유효한 패턴을 갖고 있는지 여부
     */
    private Boolean ifStringHasValidPattern(String string, String validPattern) {
        Pattern namePattern = Pattern.compile(validPattern);
        Matcher nameMatcher = namePattern.matcher(string);
        return nameMatcher.find();
    }

    /**
     * 자동차의 전진과정을 실제로 출력하는 메소드
     *
     * @param actualMoving 자동차가 전진했는지 여부가 담겨있는 2차원 배열
     * @param carNumber    출력할 자동차의 번호
     * @param episode      현재까지 진행된 에피소드
     */
    private void printMoving(Boolean[][] actualMoving, int carNumber, int episode) {
        System.out.print(cars[carNumber].getName() + ": ");
        for (int i = 0; i <= episode; i++) {
            if (actualMoving[carNumber][i]) {
                System.out.print('-');
            }
        }
        System.out.println();
    }
}
