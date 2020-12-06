package utils;

public class GameUtils {
    public GameUtils() {
    }
    public boolean isRightCarName(String userCarsName){
        if(userCarsName.length() <=5) return true;
        return false;
    }

}
