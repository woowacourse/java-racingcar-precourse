import java.util.Scanner;
import java.util.Vector;

public class InputHandler {
    static final String FIRST_WORD = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String SEPARATOR = ",";

    static String getInput() {
        Scanner s = new Scanner(System.in);
        System.out.println(FIRST_WORD);
        return s.nextLine();
    }

    static Vector<String> parse(String input, String Separator) {
        Vector<String> vector = new Vector<>();
        String[] stringArray;

        stringArray = input.split(Separator);
        for (String string:stringArray
             ) {
            if(string.equals("")==false) {
                vector.add(string.trim());
            }
        }

        return vector;
    }


}
