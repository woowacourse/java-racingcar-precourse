package racingcar.domain;

import racingcar.view.ErrorViewer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

public class Cars {
    private static final int LIMIT_PARTICIPANT_NAME = 5;
    private static final String VOID = "";
    private static final String VOID_SPACE = " ";

    private ArrayList<Car> carList;

    public Cars(String[] carNames) {
        ArrayList<Car> carEnrollment = new ArrayList<Car>();
        checkOverlap(carNames);
        insertElements(carEnrollment, carNames);
        this.carList = carEnrollment;
    }

    private void insertElements(ArrayList<Car> carEnrollment,String[] carNames) {
        for (String carName : carNames) {
            checkParticipantCondition(carName);
            Car tempCar = new Car(carName);
            carEnrollment.add(tempCar);
        }
    }

    private void checkParticipantCondition(String participant) {
        checkSingleParticipantLength(participant);
        checkSingleParticipantVoid(participant);
        checkSingleParticipantIncludeVoid(participant);
    }

    private void checkSingleParticipantLength(String participant) {
        if (participant.length() > LIMIT_PARTICIPANT_NAME) {
            ErrorViewer.showLengthInputError();
        }
    }

    private void checkSingleParticipantVoid(String participant) {
        if (participant.equals(VOID)) {
            ErrorViewer.showVoidCarError();
        }
    }

    private void checkSingleParticipantIncludeVoid(String participant) {
        if (participant.contains(VOID_SPACE)) {
            ErrorViewer.showVoidSpaceCarError();
        }
    }

    private void checkOverlap(String[] carNames) {
        HashSet<String> checkOverlapSet = new HashSet<>(Arrays.asList(carNames));
        if (checkOverlapSet.size() != carNames.length) {
            ErrorViewer.showCarsInputError();
        }
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    /*게임 한턴을 진행시켜주는 메서드 */
    public void processOneTurn() {
        carList.forEach(Car::playOneTurn);
    }
}
