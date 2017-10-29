import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kalisiaczki on 12.05.2017.
 */
public class App {

    public static void main(String[] args) {

        App app = new App();
        int number = app.solution(5);
        System.out.println(number);

    }

    int counter = 1;
    public int solution(int N) {
    if (N % 2 == 0) {
        int temp1 = N / 2;
        if(temp1>0) {
            solution(temp1);
            counter++;
        }
    } else if(N % 2 != 0) {
        int temp = N - 1;
        counter++;
        solution(temp);

    }


       return counter-1;
    }




    }

