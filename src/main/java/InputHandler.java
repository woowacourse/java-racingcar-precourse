import java.util.Scanner;
import java.util.Vector;

public class InputHandler {

    static String getInput(String word) {
        Scanner s = new Scanner(System.in);
        System.out.println(word);
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
