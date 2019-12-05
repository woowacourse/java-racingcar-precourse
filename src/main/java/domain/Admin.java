package domain;

import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

/**
 * Admin class - 프로그램 진행에 필요한 메소드를 모아둔 클래스
 *
 * @author 김범준(ddaaac)
 * @version 1.01 2019-12-05
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
     * 값을 입력받기 위한 Scanner class
     * 한번만 초기화하면 되기 때문에 class 변수로 선언
     */
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Car 객체를 저장하기 위한 Car array
     */
    private Car[] cars;

    /**
     * 전진을 시도할 횟수를 저장하는 변수
     */
    private int maxNumOfMoving;

    /**
     * 자동차의 전진여부를 저장하는 배열
     */
    private Boolean[][] actualMoving;

    /**
     * 이름을 입력받고 Car 객체를 생성하는 메소드
     */
    public void makeCars() {
        /* input이 유효할 때까지 이름을 입력받고, 입력받은 String을 기준으로 Car 객체 생성 */
        String[] carNames = getCarNamesUntilValid();

        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = makeCar(carNames[i]);
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

        actualMoving = new Boolean[cars.length][maxNumOfMoving];
        for (int i = 0; i < cars.length; i++) {
            actualMoving[i] = cars[i].moveCar(maxNumOfMoving);
        }
        for (int episode = 0; episode < maxNumOfMoving; episode++) {
            for (int carNumber = 0; carNumber < cars.length; carNumber++) {
                printMoving(carNumber, episode);
            }
            System.out.println();
        }
    }

    /**
     * 우승자를 출력하는 메소드
     */
    public void printWinner() {
        /* 가장 많이 움직인 자동차들의 이름들을 actualMoving 변수를 통해 구하고, 그 문자열을 join해서 출력 */
        ArrayList<String> winnerList = getWinnerList();
        System.out.println(String.join(", ", winnerList) + "가 최종 우승했습니다.");
    }

    /**
     * 입력한 이름이 유효할때까지 입력을 받는 메소드
     *
     * @return Car 객체 각각 이름이 담긴 String Array
     */
    private String[] getCarNamesUntilValid() {
        String[] carNames;

        while (true) {
            carNames = getCarNames();
            if (carNames == null) {
                System.out.println("다시 입력해주세요.");
                continue;
            }
            return carNames;
        }
    }

    /**
     * 쉼표로 구분된 차 이름을 입력받아 반환하는 메소드
     *
     * @return 유효한 이름이라면 이름들이 담긴 String Array, 유효하지 않다면 null
     */
    private String[] getCarNames() {
        String input;
        String[] carNames;
        String carNameValidPattern = "(^[a-zA-Z0-9]{1,5})";         // 유효한 패턴은 1~5 글자의 영문 알파벳, 숫자를 의미

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = scan.nextLine();
        carNames = input.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (!ifStringHasValidPattern(carNames[i], carNameValidPattern)) {
                return null;
            }
        }
        return carNames;
    }

    /**
     * Car 객체를 생성하여 반환하는 메소드
     *
     * @param name Car 객체의 이름
     * @return 입력받은 이름으로 생성된 Car 객체
     */
    private Car makeCar(String name) {
        return new Car(name);
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
     * @param carNumber 출력할 자동차의 번호
     * @param episode   현재까지 진행된 에피소드
     */
    private void printMoving(int carNumber, int episode) {
        System.out.print(cars[carNumber].getName() + ": ");
        for (int i = 0; i <= episode; i++) {
            if (actualMoving[carNumber][i]) {
                System.out.print('-');
            }
        }
        System.out.println();
    }

    /**
     * 가장 많이 전진한 자동차들의 이름을 구하는 함수
     *
     * @return ArrayList<String> 자동차들의 이름
     */
    private ArrayList<String> getWinnerList() {
        ArrayList<Integer> countMoving = new ArrayList<>();         // 각 자동차별로 전진한 횟수를 저장하는 ArrayList
        ArrayList<String> winnerList = new ArrayList<>();
        int maxMoving;

        for (int i = 0; i < cars.length; i++) {
            countMoving.add(countTrue(actualMoving[i]));
        }
        maxMoving = Collections.max(countMoving);
        for (int i = 0; i < countMoving.size(); i++) {
            if (countMoving.get(i) == maxMoving) {
                winnerList.add(cars[i].getName());
            }
        }
        return winnerList;
    }

    /**
     * 배열에서 true인 원소의 갯수를 반환하는 메소드
     *
     * @param targetArr 갯수를 셀 Boolean 배열
     * @return int true인 원소의 갯수
     */
    private int countTrue(Boolean[] targetArr) {
        int counter = 0;
        for (int i = 0; i < targetArr.length; i++) {
            if (targetArr[i]) {
                counter++;
            }
        }
        return counter;
    }
}
