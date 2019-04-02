/*
 * 이 클래스는 자동차 경주 게임을 실행하기 위한 클래스로 게임 진행을 위한 메소드와 인스턴스가 있습니다
 *
 *
 * 클래스 이름    Racing
 *
 * 버전 정보     1.0
 *
 * 날짜    2019/04/01
 *
 * 저작권   권유상
 */

package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class Racing {

    private ArrayList<Car> carList;
    private int numberOfTimes;

    private String inputCarName() {
        Scanner scan = new Scanner(System.in);
        String carName;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carName = scan.nextLine();
        }
        while(!isCorrectCarName(carName));
        return carName;
    }

    private boolean isCorrectCarName(String str){
        int charCount= 0;
        for(int i = 0; i<str.length(); i++) {
            charCount++;
            if(str.charAt(i) == ',') {
                charCount = 0;
            }
            if(str.charAt(i) == ' ' || charCount > 5) {
                System.out.println("올바르지 않은 입력입니다.");
                return false;
            }
        }
        return true;
    }

    private int inputMovingNumber(){
        Scanner scan = new Scanner(System.in);
        int number;
        do {
            System.out.print("시도할 횟수를 입력해주세요: ");
            while(!scan.hasNextInt()) {
                System.out.println("자연수를 입력해주세요");
                scan.next();
            }
            number = scan.nextInt();
        }
        while(number < 1);
        return number;
    }

    private void createCar(String str) {
        String[] names = str.split(",");
        for (String name : names) {
            Car car = new Car(name);
            this.carList.add(car);
        }
    }
}
