import java.util.Vector;

public class Solution {

    public static void main(String[] args) {

        String s;
        String[] sarray;
        Boolean bool;
        Vector<String> vector;
        int count;

        s = InputHandler.getInput();
        vector = InputHandler.parse(s, ",");

        System.out.print("size: ");
        System.out.println(vector.size());
        for(int i = 0; i < vector.size(); i++) {
            s = vector.get(i);
            System.out.println(s);
        }

        count = InputHandler.countName("car",vector);
        System.out.println(count);
    }

}
