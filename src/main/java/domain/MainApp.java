package domain;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
    }

    /**
     * 사용자로부터 자동차의 이름들을 입력받아 반환하는 메소드입니다.
     * @return 자동차의 이름을 각 원소로 하는 문자열 배열
     */
    public static String[] getCarNames() {
        String arrCarNames[];

        try {
            Scanner rd = new Scanner(System.in);
            String strCarNames = rd.nextLine();
            arrCarNames = strCarNames.split(",");
        } catch (Exception e) {
            return null;
        }
        return arrCarNames;
    }

}
