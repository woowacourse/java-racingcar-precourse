/*
 * class: ParsingCarString
 *
 * version: 3.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */

package domain;

import java.util.Scanner;

/**
 * 사용자가 입력한 이름 구분자로 파싱 해주는 기능
 *
 * @author joseph415
 * @version 3.0 2019.12.08
 */
public class ParsingCarString {
    public String carString = "";
    Scanner sc = new Scanner(System.in);

    /**
     * 사용자가 입력한 이름 구분자로 파싱 해주는 매소
     *
     * @return 파싱하고 각 이름을 배열에 넣어 return
     */
    public String[] parseCarString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carString = sc.nextLine();

        /*(,)구분자로 문자열 파싱*/
        String[] carList = carString.split(",");

        return carList;
    }
}
