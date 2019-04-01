package domain;

import java.util.*;

public class Manager {
    // 게임 진행 관리. 실제 게임 플레이 관련 내용은 여기에 다 있다.
    
    /** 0에서 9 사이의 임의의 정수 하나를 생성하여 반환 */
    public static int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void main(String[] args) {
        // 메소드 테스트용 공간.
        // todo
        // System.out.println(getRandomInt());
    }
}
