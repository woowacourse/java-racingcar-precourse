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

public class Racing {

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
}
