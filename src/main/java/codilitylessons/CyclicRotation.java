package codilitylessons;

/**
 * Created by kalisiaczki on 02.11.2017.
 */
public class CyclicRotation {

    public static void main(String[] args)
    {

        CyclicRotation cyclicRotation = new CyclicRotation();
        int [] array = {3,8,9,7,6};
        int K = 8;

        for(Integer i : cyclicRotation.solution(array,K)){
            System.out.print(i + ",");

        }
    }

    public int[] solution(int[] A, int K){

        int [] newArray = new int[A.length];
        int tableSize = A.length;
        int tempK = 0 ;

        if (K == 0){
            tempK =0;
        }else {
            try {
                tempK = (K % tableSize);
            } catch (ArithmeticException e){
                e.printStackTrace();
            }
        }
        for (int aA : A) {

            if (tempK == A.length) {
                tempK = 0;
            }
            newArray[(A.length - (A.length - tempK))] = aA;
            tempK += 1;
        }
        return newArray;
    }
}
