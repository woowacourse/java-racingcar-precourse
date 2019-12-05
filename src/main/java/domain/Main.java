/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package domain;

/**
 * 클래스 이름 : Main.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.5 목요일
 */
public class Main {
    /*
     * Main 클래스에서는 playRacing 클래스로부터 인스턴스를 받아서 이를 실행한다.
     */

    public static void main(final String[] args) {
        PlayRacing play = new PlayRacing();
        play.playRacing();

    }
}
