import domain.Admin;

/**
 * Main class
 *
 * @version         1.01 2019-12-05
 * @author          김범준(ddaaac)
 */
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();

        admin.makeCars();
        while (admin.getNumberOfMoving() == false){
            System.out.println("다시 입력해주세요.");
        }
        admin.moveCars();
        admin.printWinner();
    }
}
