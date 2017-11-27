package codilitylessons;


public class TapeEquilibrium {

    public static void main(String[] args) {
        int [] A = {3,1,2,4,3};

        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        System.out.println("result: " + tapeEquilibrium.solution(A));
    }

    public int solution(int[] A){

        int mid = 0;
        int shortest = 1000000;
        int currentShort;

        int tempFirst = 0;
        int tempSecond = 0;

        while (mid < A.length-1) {

            if(mid == 0){
                tempFirst = A[0];
            }else {

                for (int i = 0; i <= mid; i++) {

                    tempFirst += A[i];
                }
            }

            for (int j = mid+1; j < A.length; j++) {
                 tempSecond+= A[j];

            }
            currentShort = Math.abs(tempFirst-tempSecond);
            System.out.println(currentShort);

            if(currentShort<shortest){
                shortest = currentShort;
            }
            mid+= 1;
            tempFirst = 0;
            tempSecond = 0;

        }



        return shortest;
    }
}
