package ui;

import domain.Track;

/**
 * @author delf
 */
public interface RaceIOInterface {
    /**
     * @return 입력 받은 이름들을 가공한 문자열 배열
     */
    String[] inputRacersName();

    /**
     * @return 입력 받은 시도 횟수
     */
    int inputTryCount();

    /**
     * Track 인스턴스를 받아 현재 상태를 출력
     */
    void showTrack(Track track);

    /**
     * Track 인스턴스를 받아 최종 승자들을 출력
     */
    void showWinner(Track track);

    /**
     * 간단한 문자열 출력
     * @param s
     */
    static void showPlaneText(String s) {
        System.out.println(s);
    }
}
