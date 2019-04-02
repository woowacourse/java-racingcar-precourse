package View;

import domain.Car;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 레이싱 게임의 진행하는데 필요한 기능 모음
 *
 * @version         1.00 2019년 04월 02일
 * @author          윤희현
 */
public class RacingGame {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Car> carList = new ArrayList<>();
    private int count; /*시행할 게임 횟수*/

    public void inputCarName() throws Exception {
        final String delimiter = ",";
        final String exceptionMessage = "자동차의 이름은 5자 이하만 가능합니다.";

        String userInput = sc.nextLine();
        String[] carNames = userInput.split(delimiter);

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new Exception(exceptionMessage);
            }
            carList.add(new Car(carNames[i]));
        }
    }

    /**
     * 시행할 게임 횟수를 입력받는 함수
     *
     * @throws Exception mismatchException: 숫자가 아닌 다른것을 입력한 경우
     *                   boundException: 음수가 입력된 경우
     */
    public void inputNum() throws Exception {
        final String mismatchException = "숫자를 입력해주세요";
        final String boundException = "양수를 입력해주세요";

        try {
            count = sc.nextInt();
            if (count < 1) {
                throw new Exception(boundException);
            }
        } catch (InputMismatchException e) {
            throw new Exception(mismatchException);
        }

    }

    /**
     * 사용자가 입력한 횟수만큼 게임을 진행하는 함수
     */
    public void play() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).goOrStop();
            }
            displayCarPosition();
            System.out.println();
        }
    }

    public void displayCarPosition() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.print(car.getName() + ":");
            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    /**
     * 게임의 최종 우승자를 리스트로 반환하는 함수
     * @return 최종 우승자 리스트
     */
    public List<Car> getResult() {
        List<Car> result = new ArrayList<>();

        result.add(carList.get(0));
        for (int i = 1; i < carList.size(); i++) {

            if (result.get(0).getPosition() < carList.get(i).getPosition()) {
                result = new ArrayList<>();
                result.add(carList.get(i));
                continue;
            }
            if (result.get(0).getPosition() == carList.get(i).getPosition()) {
                result.add(carList.get(i));
            }
        }
        return result;
    }

    public void displayResult() {
        List<Car> carList = getResult();
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName());
            if (i != carList.size() - 1) {
                System.out.print(", ");
            }

        }
        System.out.println("가 최종 우승했습니다.");
    }


}
