/**
 * Created by kalisiaczki on 12.05.2017.
 */
public class ShortestSequence {

    public static void main(String[] args) {

        ShortestSequence app = new ShortestSequence();
        int number = app.solution(18);
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

