package inOut;
import java.util.ArrayList;
import domain.Car;

/**
 * TotalOutput
 */
public class TotalOutput {
    ArrayList<String> maximumCandidate;
    ArrayList<Car> carlist;
    
    public TotalOutput(ArrayList<Car>cars){
        carlist=cars;
        System.out.println(findWinner());
    }

    public String findWinner(){
        int max = -1;
        for (Car each: carlist){
            if (each.getPosition()>max){
                maximumCandidate = new ArrayList<String>();
                maximumCandidate.add(each.getName());
                max = each.getPosition();
                System.out.println(max);
            }
            else if (each.getPosition()==max){
                maximumCandidate.add(each.getName());
                System.out.println("====");
            }
        }
        return winners();
    }

    public String winners(){
        String result = "";
        for (String name : maximumCandidate){
            result = result + name + ", ";
        }
        result = result.substring(0, result.length()-2);
        result = result + "가 최종 우승했습니다.";
        return result;
    }


}