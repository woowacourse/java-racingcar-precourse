/*
 * @Process.java   1.0 2019/04/02
 */

package domain;

/**
 * 경주 진행 클래스
 *
 * @author 최훈하
 * @version 1.00 2019년 4월 2일
 */

public class Process {
    static void game_Process() {
        Input.enter_Car_Name();
        Input.car_Object_Create();
        Forward_Util.try_Number();
        Forward_Util.count_Repeat();
        Forward_Util.winner_Print();
    }
}
