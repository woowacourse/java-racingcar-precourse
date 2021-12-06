package racingcar;
import java.util.*;

import camp.nextstep.edu.missionutils.Console;
public class RacingCarGame  implements Game {
    CarList racingCars;
    int numberOfTrial;

    final int MAXIMUM_LENGTH = 5;
    final String DELIMITER = ",";

    @Override
    public void play() {

        racingCars = new CarList();
        List<String> temporaryRacingCars;
        String trial;

        /*
         *  사용자에게 출전시킬 자동차 이름을 입력받는다.
         *  적잘한 포멧이 아닌 경우, 반복해서 다시 입력받는다.
         *  완전히 다 올바른 값을 입력받을떄까지 개체를 생성하지 않는다.
         */
        do {
            String carNames = getRacingCarsNameFromUser();
            StringTokenizer splitString = splitByMark(carNames);

            try{
                temporaryRacingCars = isValidCarNameList(splitString);
            } catch (IllegalArgumentException e) {
                temporaryRacingCars = null;
            }

        } while (temporaryRacingCars == null);

        // 입력받은 Car의 이름으로 개체 생성 및 리스트에 추가
        for (String carName: temporaryRacingCars) {
            Car car = createRacingCarEntity(carName);
            racingCars.addRacingCarEntity(car);
        }

        // 사용자로부터 시도 횟수 입력 받기
        boolean checkNumber;
        do {
            trial = getNumberOfTrialFromUser();
            try {
                checkNumber = checkValidTrialNumber(trial);
            } catch (IllegalArgumentException e) {
                checkNumber = false;
            }
        } while(!checkNumber);

        setNumberOfTrial(Integer.parseInt(trial));

        // 레이싱 카 전진 후, 전진한 위치 출력
        while (numberOfTrial-- > 0) {
            racingCars.printCarPosition();
        }

        // 최종 우승자 선별

        StringBuilder stringBuilder = new StringBuilder("최종 우승자 : ");
        List<Car> results = racingCars.determineWinner();

        for(Car result: results) {
            stringBuilder.append(result.getName());
            stringBuilder.append(",");
        }

        stringBuilder.setLength(stringBuilder.length()-1);
        System.out.println(stringBuilder);

    }
    private ArrayList<String> isValidCarNameList(StringTokenizer splitString) {
        ArrayList<String> temporaryRacingCars = new ArrayList<>();
        while(splitString.hasMoreTokens()) {

            String carName = splitString.nextToken();
            if (!checkMoreThanMaximumLength(carName)) throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값: " + carName);

            temporaryRacingCars.add(carName);
        }
        return temporaryRacingCars;
    }

    private String getRacingCarsNameFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private StringTokenizer splitByMark(String neededToSplit) {
        return new StringTokenizer(neededToSplit, DELIMITER);
    }

    private boolean checkMoreThanMaximumLength(String neededToCheck) {
        return neededToCheck.length() <= MAXIMUM_LENGTH;
    }

    private Car createRacingCarEntity(String carName) {
        return new Car(carName);
    }

    private String getNumberOfTrialFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    private boolean checkValidTrialNumber(String trial) {
        for (int index = 0; index < trial.length(); index++) {
            if (!Character.isDigit(trial.charAt(index))) throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값: " +trial);
        }
        return true;
    }

    private void setNumberOfTrial(int trial) {
        numberOfTrial = trial;
    }


}
