package codilitylessons;

import java.util.Arrays;


public class OddOccurencesianArray {

    public static void main(String[] args) {

        OddOccurencesianArray oddOccurencesianArray = new OddOccurencesianArray();
        int[] array = {1,3,3,7,5,1,7,11,13,11,5,13,19,19,4};

        System.out.println(oddOccurencesianArray.solution(array));
    }

    public int solution(int[] A){

        Arrays.sort(A);
        int i = 0;
        while (i < A.length) {
            if (i < A.length-1 && A[i] == A[i + 1]) {
                i += 2;
            } else {
                return A[i];
            }
        }

      return -1;
    }
}
