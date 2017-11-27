/**
 * Created by kalisiaczki on 31.10.2017.
 */
public class Arthmetic {


    public int solution(int [] A) {

        int numberOfArth = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if (((A[i+1] - A[i]) == A[i + 2] - A[i+1])) {

                int space = A[i+1] - A[i];

                int current = i + 2;
                int currentNext = i + 3;

                numberOfArth++;

                    while((currentNext < A.length && (A[currentNext] - A[current] == space))) {
                        numberOfArth++;
                            current += 1;
                            currentNext += 1;
                    }
            }
        }

        return numberOfArth;
    }

    public static void main(String[] args) {
        int [] A = {-1,1,3,3,3,2,1,0};

        Arthmetic arthmetic = new Arthmetic();
        System.out.println(arthmetic.solution(A));

    }

}
