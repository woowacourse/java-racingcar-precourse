/**
 * User.class        1.0 2019/03/30
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */
package domain;

import java.util.Scanner;

/**
 * Racing을 플레이하는 User 역할을 하는 클래스
 *
 * @version         1.0
 * @author          이남준
 */
public class User {

    Scanner sc = new Scanner(System.in);

    /**
     * 사용자로부터 자동차들의 이름을 입력 받는 메소드
     * @return 사용자로부터 입력받은 이름
     */
    public String enterNames() {
        String names = sc.nextLine();
        return names;
    }
}
