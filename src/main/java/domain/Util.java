package domain;

public class Util {
    static String carNameArray[];

    //쉼표를 기쥰
    static void splitCarName(String rawCarName) {
        carNameArray = rawCarName.split(",");
    }
}
