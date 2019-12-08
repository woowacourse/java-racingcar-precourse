/*
 * class: racing
 *
 * version: 3.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */

import domain.TryGame;

/**
 * racing prograing 실행을 위한 racing클래스이다.
 * main 매소드로 구성되며 start객체를 만들어 실행한.
 *
 * @author joseph415
 * @version 3.0 2019.12.08
 */
public class racing {

    /**
     * main 게임을 실행하기 위해 tryinput객체 생성
     * @param args no input args
     */
    public static void main(String[] args) {
        TryGame start = new TryGame();
        start.start();
    }
}