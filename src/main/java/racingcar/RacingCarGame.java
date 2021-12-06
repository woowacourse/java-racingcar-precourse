package racingcar;
import java.util.*;

import camp.nextstep.edu.missionutils.Console;
public class RacingCarGame  implements Game {
    ArrayList<Car> racingCars;
    int numberOfTrial;

    final int MAXIMUM_LENGTH = 5;
    final String DELIMITER = ",";

    @Override
    public void play() {

        List<String> temporaryRacingCars;
        boolean correctInput = true;
        String trial;

        /*
         *  사용자에게 출전시킬 자동차 이름을 입력받는다.
         *  적잘한 포멧이 아닌 경우, 반복해서 다시 입력받는다.
         *  완전히 다 올바른 값을 입력받을떄까지 개체를 생성하지 않는다.
         */
        do {
            String carNames = getRacingCarsNameFromUser();
            StringTokenizer splitString = splitByMark(carNames);

            temporaryRacingCars = isValidCarNameList(splitString);

        } while (temporaryRacingCars == null);

        // 입력받은 Car의 이름으로 개체 생성 및 리스트에 추가
        for (String carName: temporaryRacingCars) {
            Car car = createRacingCarEntity(carName);
            addRacingCarEntity(car);
        }

        // 사용자로부터 시도 횟수 입력 받기
        do {
            trial = getNumberOfTrialFromUser();
        } while(!checkValidTrialNumber(trial));

        setNumberOfTrial(Integer.parseInt(trial));

        // 레이싱 카 전진 후, 전진한 위치 출력
        while (numberOfTrial-- > 0) {
            for (Car car : racingCars) {
                if(car.isPossibleMoveForward(car.generateRandomValue())) car.updatePosition();
                System.out.println(car);
            }

            System.out.println();
        }

        // 최종 우승자 선별
        Collections.sort(racingCars);
        int maxValue = racingCars.get(0).getPosition();

        StringBuilder stringBuilder = new StringBuilder("최종 우승자 : ");
        for(Car racingCar: racingCars) {
            if(racingCar.getPosition() == maxValue) {
                stringBuilder.append(racingCar.getName());
                stringBuilder.append(",");
            }
        }

        stringBuilder.setLength(stringBuilder.length()-1);
        System.out.println(stringBuilder);

    }
    private ArrayList<String> isValidCarNameList(StringTokenizer splitString) {
        ArrayList<String> temporaryRacingCars = new ArrayList<>();
        while(splitString.hasMoreTokens()) {

            String carName = splitString.nextToken();
            if (!checkMoreThanMaximumLength(carName)) {
                // TODO: 예외 발생
                return null;
            }
            temporaryRacingCars.add(carName);
        }
        return temporaryRacingCars;
    }

    private String getRacingCarsNameFromUser() {
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

    private void addRacingCarEntity(Car car) {
        racingCars.add(car);
    }

    private String getNumberOfTrialFromUser() {
        return Console.readLine();
    }

    private boolean checkValidTrialNumber(String trial) {
        for (int index = 0; index < trial.length(); index++) {
            if (!Character.isDigit(trial.charAt(index))) {
                // TODO: 예러 발생
                return false;
            }
        }
        return true;
    }

    private void setNumberOfTrial(int trial) {
        numberOfTrial = trial;
    }


}
