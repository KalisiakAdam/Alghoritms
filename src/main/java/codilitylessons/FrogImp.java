package codilitylessons;

/**
 * Created by kalisiaczki on 06.11.2017.
 */
public class FrogImp {

    public static void main(String[] args) {
        FrogImp frogImp = new FrogImp();
        System.out.println(frogImp.solution(10, 110, 30));
    }

    public int solution(int X, int Y, int D) {

        int distance = Y-X;
        if (distance % D != 0) {
            return distance / D+1 ;
        } else {
            return distance / D;
        }
    }
}
