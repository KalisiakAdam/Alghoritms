
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

            if (newA[i] != -1) {

                int indexRight = i;
                int indexDown = i;
                int indexUp = i;
                int indexLeft = i;

                if(!isTheSameRight(newA, indexRight, numberOfRow) && !isTheSameDown(newA, indexDown, numberOfRow) &&  !isTheSameLeft(newA, indexLeft, numberOfRow) && !isTheSameUp(newA, indexUp)) {

                    newA[i] = -1;



                } else {

                    while (isTheSameRight(newA, indexRight, numberOfRow) || isTheSameDown(newA, indexDown, numberOfRow) || isTheSameUp(newA, indexUp)) {
//right
                        System.out.println("i: " + i);

                        if (isTheSameRight(newA, indexRight, numberOfRow)) {

                            int tempRight = 0;
                            int tempUp = 0;
                            int tempDown = 0;

                            while (isTheSameRight(newA, indexRight, numberOfRow) || isTheSameUp(newA, indexUp) || isTheSameDown(newA, indexDown, numberOfRow) || isTheSameLeft(newA, indexLeft, numberOfRow)) {

                                if (isTheSameRight(newA, indexRight, numberOfRow)) {
                                    System.out.println("indexRight is: " + indexRight);
                                    tempRight = indexRight;
                                    indexRight = indexRight + numberOfRow;
                                    System.out.println("indexRight changes " + indexRight);


                                    if (isTheSameUp(newA, indexRight)) {
                                        System.out.println("indexUp is: " + indexUp);
                                        tempUp = indexUp;
                                        indexUp = indexRight - 1;
                                        System.out.println("indexUp changes " + indexUp);


                                        if(isTheSameUp(newA,indexUp)){
                                            System.out.println("indexUp is: " + indexUp);
                                            tempUp = indexUp;
                                            indexUp = indexUp - 1;
                                            System.out.println("indexUp changes " + indexUp);

                                        }

                                    }
                                    if (isTheSameDown(newA, indexRight, numberOfRow)) {
                                        System.out.println("indexDown is: " + indexDown);
                                        tempDown = indexDown;
                                        indexDown = indexRight + 1;
                                        System.out.println("indexDown changes " + indexDown);

                                        if(isTheSameDown(newA,indexDown,numberOfRow)){
                                            System.out.println("indexDown is: " + indexDown);
                                            tempDown = indexDown;
                                            indexDown = indexDown +1;
                                            System.out.println("indexDown changes " + indexDown);

                                        }


                                    }

                                }

                            }
                            newA[tempRight] = -1;
                            newA[tempUp] = -1;
                            newA[tempDown] = -1;
                        }
                          else if (isTheSameDown(newA, indexDown, numberOfRow)){

                            int tempRight = 0;
                            int tempDown = 0;
                            int tempLeft = 0;

                            while(isTheSameRight(newA, indexRight, numberOfRow) || isTheSameDown(newA, indexDown, numberOfRow) || isTheSameLeft(newA, indexLeft, numberOfRow)){

                                if (isTheSameDown(newA, indexDown, numberOfRow)) {
                                    System.out.println("indexDown is: " + indexDown);
                                    tempDown = indexDown;
                                    indexDown = indexDown + 1;
                                    System.out.println("indexDown changes " + indexDown);



                                    if (isTheSameLeft(newA, indexDown, numberOfRow)) {

                                        tempLeft = indexLeft;
                                        indexLeft = indexDown - numberOfRow;
                                        System.out.println("indexLeft changes " + indexLeft);


                                        if(isTheSameLeft(newA,indexLeft,numberOfRow)){
                                            tempLeft = indexLeft;
                                            indexLeft = indexLeft - numberOfRow;
                                            System.out.println("indexLeft changes " + indexLeft);

                                        }

                                    }

                                    if (isTheSameRight(newA, indexDown, numberOfRow)) {

                                        tempRight = indexRight;
                                        indexRight = indexDown + numberOfRow;
                                        System.out.println("indexRight changes " + indexRight);


                                        if(isTheSameRight(newA, indexRight, numberOfRow)) {
                                            tempRight = indexRight;
                                            indexRight = indexRight +numberOfRow;
                                            System.out.println("indexLeft changes " + indexLeft);


                                        }

                                    }
                                }

                                newA[tempRight] = -1;
                                newA[tempDown] = -1;
                                newA[tempLeft] = -1;

                            }



                        }


                    }

                }
            }



        }
        return beginningNumberOfCountries ;
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

        if (thisIndex > 0 && table[thisIndex] != -1) {
            return table[thisIndex] == table[thisIndex - 1];
        }else{
            return false;
        }
    }

    public boolean isTheSameLeft (int [] table, int thisIndex, int numberOfRows){

        if ((thisIndex > numberOfRow) && table[thisIndex] != -1){
            return table[thisIndex] == table[thisIndex - numberOfRows];
        }else {
            return false;
        }
    }

}
