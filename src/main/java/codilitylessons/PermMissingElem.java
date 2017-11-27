package codilitylessons;



public class PermMissingElem {

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();

        int [] A = {2,3,1,5};

        System.out.println(permMissingElem.solution(A));

    }

   public int solution(int[] A) {
        int totalArrSize = A.length + 1;
        int shouldBeNumber = (totalArrSize * (1+ totalArrSize))/2;
        int actualNumber = 0;
        for (int aA : A) actualNumber += aA;
        return shouldBeNumber - actualNumber;
    }


}
