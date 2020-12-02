package racingcar;

import java.util.Scanner;

/**
 * 입력값을 처리하는 클래스
 */
public class InputGuide {

    public static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    public static final String MOVES_INPUT_MESSAGE = "시도할 횟수는 몇회인가요? : ";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String CAR_NAME_INPUT_EXCEPTION_MESSAGE = "자동차 이름은 5자 이내여야 합니다.";
    private static final String CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE = "자동차 갯수는 2개 이상이어야 합니다.";
    private static final String MOVES_INPUT_EXCEPTION_MESSAGE = "자연수를 입력해야 합니다.";
    private static final String REST = ",";
    private static final int FIVE = 5;
    private static final int TWO = 2;
    private final Scanner scanner;
    private Car[] cars;

    InputGuide(Scanner scanner){
        this.scanner = scanner;
    }

    public Car[] inputCars() {
        System.out.println(CAR_INPUT_MESSAGE);
        String[] cars = splitCarsName(scanner.nextLine());
        if(isMoreThanOne(cars)){
            return makeCar(cars);
        }
        return inputCars();
    }

    private String[] splitCarsName(String input){
        return input.split(REST);
    }

    private boolean isMoreThanOne(String[] input){
        if(input.length >= TWO){
            cars = new Car[input.length];
            return checkCarName(cars);
        }
        showIllegalArgumentException(CAR_NUMBERS_INPUT_EXCEPTION_MESSAGE);
        return false;
    }

    private boolean checkCarName(Car[] cars){
        boolean lessThanFive = true;
        int index = cars.length;
        while(lessThanFive && index>0){
            lessThanFive = countCharacters(cars[index]);
        }
        if(!lessThanFive){
            showIllegalArgumentException(CAR_NAME_INPUT_EXCEPTION_MESSAGE);
        }
        return lessThanFive;
    }

    private boolean countCharacters(Car car){
        return car.getName().length() >= FIVE;
    }

    private Car[] makeCar(String[] names){
        for(int i = 0, length = names.length; i<length; i++){
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public int countMove(){
        System.out.println(MOVES_INPUT_MESSAGE);
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException exception){
            showIllegalArgumentException(MOVES_INPUT_EXCEPTION_MESSAGE);
            return countMove();
        }
    }

    private void showIllegalArgumentException(String message){
        throw new IllegalArgumentException(ERROR_MESSAGE+message);
    }


}
