package domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int LOWER_CASE_ALPHABET_ASCII_CODE_A = 65;
    private static final int LOWER_CASE_ALPHABET_ASCII_CODE_Z = 90;
    private static final int BIGGER_CASE_ALPHABET_ASCII_CODE_A = 97;
    private static final int BIGGER_CASE_ALPHABET_ASCII_CODE_Z = 122;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int NEXT_CAR = 1;
    private static final int FIRST_CAR_NAME_INDEX = 0;
    private static final int FIRST_LAB_INDEX = 0;
    private static final int FIRST_CAR_INDEX = 0;
    private static final int FUEL_MAX_RANGE = 9;
    private static final int GO = 4;
    private static final String EMPTY_CAR_NAME = "";

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.startRacingCarGame();
    }

    private void startRacingCarGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> racingCars = getRacingCarName();
        System.out.println("시도 할 횟수는 몇번 인가요?");

        int racingLab = getRacingLab();

        racingGameCourse(racingCars, racingLab);
    }

    private void racingGameCourse(List<Car> racingCars, int racingLab) {
        for(int race = FIRST_LAB_INDEX; race < racingLab; race++) {
            getEachLabCarState(racingCars);
        }

        int maxMove = getMaxMoveCar(racingCars);
        System.out.println(getWinnerCar(racingCars, maxMove) + "가 최종 우승했습니다.");
    }

    private int getMaxMoveCar(List<Car> racingCars) {
        int maxMove = 0;

        for(Car car : racingCars) {
            maxMove = Math.max(maxMove,car.getPosition());
        }

        return  maxMove;
    }

    private String getWinnerCar(List<Car> racingCars, int maxMove) {
        List<String> winnerCarNames = racingCars.stream().filter(racingCar -> racingCar.getPosition() == maxMove)
                                        .map(Car::getName).collect(Collectors.toList());

        return String.join(",",winnerCarNames);
    }

    private void getEachLabCarState(List<Car> racingCars) {
        Random getCarState = new Random();

        for(int car = FIRST_CAR_INDEX; car < racingCars.size(); car++) {
            if(getCarState.nextInt(FUEL_MAX_RANGE) >= GO) {
                racingCars.get(car).moveForward();
            }
            racingCars.get(car).displayCarPosition();
        }

        System.out.println();
    }

    private List<Car> getRacingCarName() {
        List<String> racingCarNames = getRacingCarNames();
        List<Car> racingCars = new ArrayList<>();

        for(String racingCar : racingCarNames) {
            racingCars.add(new Car(racingCar));
        }

        return racingCars;
    }

    public int getRacingLab() {
        int racingLab;

        while(true) {
            try{
                Scanner scanRacingLab = new Scanner(System.in);
                racingLab = scanRacingLab.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주시기 바랍니다.");
            }
        }

        return racingLab;
    }
    public List<String> getRacingCarNames() {
        List<String> racingCarNames;

        while(true) {
            try {
                Scanner scanInputCarName = new Scanner(System.in);
                racingCarNames = Arrays.asList(scanInputCarName.nextLine().split(","));
                checkInputRacingCarName(racingCarNames);
                break;
            } catch(Exception e) {
                System.out.println("이름은 5자 초과, 중복및 특수문자, 숫자, 공백, 쉼표 사이에 아무것도 입력안한 것" +
                        " 을 허용하지 않습니다.");
            }
        }
        return racingCarNames;
    }
    public void checkInputRacingCarName(List<String> inputCarName) throws Exception{
        for(int carNameIndex = FIRST_CAR_NAME_INDEX; carNameIndex < inputCarName.size(); carNameIndex++) {
            String carName = inputCarName.get(carNameIndex);

            checkRacingCarNameSpecialWord(carName);
            checkSameRacingCarName(inputCarName, carNameIndex);
        }
    }

    private void checkRacingCarNameSpecialWord(String s) throws Exception {
        for(char carName : s.toCharArray()) {
            if(isAlphabet(carName, LOWER_CASE_ALPHABET_ASCII_CODE_A, LOWER_CASE_ALPHABET_ASCII_CODE_Z)
                    && isAlphabet(carName, BIGGER_CASE_ALPHABET_ASCII_CODE_A, BIGGER_CASE_ALPHABET_ASCII_CODE_Z)){

                throw new Exception();
            }

            if(s.length() > MAX_CAR_NAME_LENGTH || s.equals(EMPTY_CAR_NAME)) {
                throw new Exception();
            }
        }
    }

    private boolean isAlphabet(char carName, int startAlphabetValue, int endAlphabetValue) {
        return carName < startAlphabetValue || carName > endAlphabetValue;
    }

    private void checkSameRacingCarName(List<String> inputCarName, int carNameIndex) throws Exception {
        for(int nextCarNameIndex = carNameIndex + NEXT_CAR; nextCarNameIndex < inputCarName.size(); nextCarNameIndex++) {
            if(inputCarName.get(carNameIndex).equals(inputCarName.get(nextCarNameIndex))) {
                throw new Exception();
            }

            if(inputCarName.get(carNameIndex).toUpperCase().equals(inputCarName.get(nextCarNameIndex).toUpperCase())) {
                throw new Exception();
            }
        }
    }
}
