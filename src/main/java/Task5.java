
public class Task5 {

   public int numberOfColumn;
   public int numberOfRow;
   public int numberOfChanges;
   public int beginningNumberOfCountries;

    public static void main(String[] args) {

        int [][] A = {
                {5,4,3,2,3,1,4},
                {4,3,2,2,3,4,1},
                {4,4,4,2,4,4,1},
                {4,4,4,2,4,4,1}
        };

       Task5 task5 = new Task5();
       System.out.println(task5.solution(A));

    }

    public int solution (int[][] A) {
        numberOfChanges = 0;
        numberOfColumn = A.length;
        numberOfRow = A[0].length;
        int[] newA = new int[numberOfColumn * numberOfRow];
        beginningNumberOfCountries = newA.length;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                newA[toOndDimension(i, j, A[0].length)] = A[i][j];
            }
        }

        for (int i = 0; i < newA.length; i++) {
            System.out.println("i: " + i);
            if (newA[i] != -1) {

                int indexRight = i;
                int indexDown = i;
                int indexUp = i;

                while (isTheSameRight(newA, indexRight, numberOfRow) || isTheSameDown(newA, indexDown, numberOfRow)) {
                    if (isTheSameRight(newA, indexRight, numberOfRow)) {

                        int tempRight = 0;
                        int tempUp = 0;
                        int tempDown = 0;

                        indexUp = indexUp + numberOfRow;
                        indexDown = indexDown + numberOfRow;
                        indexRight = indexRight + numberOfRow;
//
//                        System.out.println("indexRight changes " + indexRight);
//                        numberOfChanges++;

                        while (isTheSameRight(newA, indexRight, numberOfRow) || isTheSameUp(newA, indexUp) || isTheSameDown(newA, indexDown, numberOfRow)) {

                            System.out.println("indexRight is: " + indexRight);

                            if (isTheSameRight(newA, indexRight, numberOfRow)) {

                                tempRight = indexRight;
                                indexRight = indexRight + numberOfRow;
                                System.out.println("indexRight changes " + indexRight);
                                numberOfChanges++;

                            }
                            System.out.println("indexUp is: " + indexUp);

                            if (isTheSameUp(newA, indexUp)) {
                                tempUp = indexUp;
                                indexUp = indexUp - 1;
                                System.out.println("indexUp changes " + indexUp);
                                numberOfChanges++;

                            }

                            System.out.println("indexDown is " + indexDown);

                            if (isTheSameDown(newA, indexDown, numberOfRow)) {
                                tempDown = indexDown;
                                indexDown = indexDown + 1;
                                System.out.println("indexDown changes " + indexDown);
                                numberOfChanges++;

                            }

                            newA[tempRight] = -1;
                            newA[tempUp] = -1;
                            newA[tempDown] = -1;

                        }


                    }


                }


            }



        }
        return beginningNumberOfCountries-numberOfChanges;
    }


    private int toOndDimension(int row, int col, int numberOfColumns) {
        return (row)*numberOfColumns+col;
    }

    public boolean isTheSameRight (int [] table, int thisIndex, int numberOfRows){

        if ((thisIndex < (table.length - numberOfRows)) && table[thisIndex] != -1){
            return table[thisIndex] == table[thisIndex + numberOfRows];
        }else {
            return false;
            }
        }


    public boolean isTheSameDown (int [] table, int thisIndex, int numberOfRows){

        if (thisIndex < table.length -1 && (thisIndex %(numberOfRows - 1)) != 0 && table[thisIndex] != -1) {
            return table[thisIndex] == table[thisIndex + 1];
        }else{
            return false;
        }
    }

    public boolean isTheSameUp (int [] table, int thisIndex){

        if (thisIndex >= 0 && table[thisIndex] != -1) {
            return table[thisIndex] == table[thisIndex - 1];
        }else{
            return false;
        }
    }

}
