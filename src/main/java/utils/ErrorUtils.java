package utils;

public class ErrorUtils {

    private static String errorMsg="";

    private static void print(String msg, Object... args){
        System.out.println(String.format(msg, args));
    }

    public static void printNameError(){
        errorMsg = "자동차의 이름은 5자를 넘을 수 없습니다.";
        print("[ERROR] %s", errorMsg);
    }




}
