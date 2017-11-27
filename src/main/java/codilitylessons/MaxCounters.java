package codilitylessons;


import java.util.ArrayDeque;
import java.util.Deque;


public class MaxCounters {

    public static void main(String[] args) {


        MaxCounters max = new MaxCounters();

        int[]A = max.createArray(100000);
        for (Integer i :max.solution(100000,A) ){
            System.out.println(i);
        }


    }

    public int[] solution(int N, int[] A) {
        int [] tempA = new int [N];
        Deque<Integer> set = new ArrayDeque<>();
        set.addFirst(0);

        int start = 0;

        while (start < A.length){
            if( A[start] > N){
                int lastnumber = set.getFirst();
                for (int i = 0; i < N; i++){
                    tempA[i]= lastnumber;
                }
                start+=1;
            }
            else if (A[start] <= N)  {

                int thisTemp = A[start]-1;

                int tempAvalue = tempA[thisTemp];

                tempA[thisTemp] = tempAvalue + 1;


                if (!set.isEmpty() && tempA[thisTemp] > set.getFirst()){
                    set.addFirst(tempA[thisTemp]);
                }

                start+=1;
            }


        }


        return tempA;
    }

    public int[] createArray (int n){

        int[] randomArray = new int[n];

        for (int i = 0; i < n; i++){

            randomArray[i] = 1 + (int)(Math.random() * 100001);
            System.out.println(randomArray[i]);
        }
        return randomArray;
    }
}
