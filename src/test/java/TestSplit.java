public class TestSplit {

    public static void main(String[] args) {
        String names = "pobi,woni,jun";
        String[] splitName = names.split(",");

        for (String name : splitName) {
            System.out.println(name);
        }

        names = "a, ,   ,,,pobi";
        splitName = names.split(",");

        System.out.println("size: " + splitName.length);
        for (String name : splitName) {
            System.out.print("len: " + name.length() + " -> ");
            System.out.println(name);
        }
    }
}
