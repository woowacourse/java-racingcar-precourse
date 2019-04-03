import java.util.Scanner;
import java.util.Vector;

public class InputHandler {
    private static final String FIRST_WORD = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SEPARATOR = ",";
    private static final int MAX = 5;

    static String getInput() {
        Scanner s = new Scanner(System.in);
        System.out.println(FIRST_WORD);
        return s.nextLine();
    }

    static Vector<String> parse(String input, String Separator) {
        Vector<String> names = new Vector<>();
        String[] stringArray;

        stringArray = input.split(Separator);
        for (String string : stringArray
             ) {
            string = string.trim();
            if(string.equals("")==false) {
                names.add(string);
            }
        }

        return names;
    }



    static int countName(String specificName, Vector<String> names) {
        int count = 0;

        for (String name : names
             ) {
            if(name.equals(specificName)) {
                count++;
            }
        }

        return count;
    }


}
