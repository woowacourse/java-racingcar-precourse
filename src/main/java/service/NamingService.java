package service;

import java.util.Scanner;

/**
 * 경주에 참여할 자동차들의 이름을 입력 받거나 이름이 적합한지를 확인
 *
 * @version 1.0(2019.04.01)
 * @author  김종윤
 */
public class NamingService {
    /*
     * 구현 기능
     * 1.자동차들의 이름 입력받기
     * 2.이름 나누기(,를 기준으로)
     * 3.각 자동차들의 이름이 기준에 적합한지 검사
     * 4.자동차 이름 재입력 받을지 확인
     */

    /**자동차의 이름 최대 길이*/
    private final static int MAX_CAR_NAME_LENGTH = 5;
    static Scanner sc = new Scanner(System.in);

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = sc.nextLine();
        return carNames;
    }

    public String[] splitNames(String carName){
        String[] splitedName = carName.split(",");
        return splitedName;
    }

    private boolean checkCarNameLength(String carName){
        if(carName.length() > MAX_CAR_NAME_LENGTH)
            return false;
        return true;
    }

    /**
     * 자동차의 이름이 적합한지 확인 후에
     * 적합하지 않다면 이름을 다시 입력 받도록 한다.
     *
     * @param carName 자동차 이름
     * @return String 변경되거나 혹은 기존의 자동차 이름
     */
    public String checkReNamingCar(String carName){
        if(!checkCarNameLength(carName)){
            System.out.println(carName + "이란 이름은 너무 깁니다!");
            System.out.println("다시 입력해주세요.");
            carName = sc.nextLine();
        }
        return carName;
    }
}
