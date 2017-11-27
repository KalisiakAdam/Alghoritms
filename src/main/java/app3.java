import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kalisiaczki on 01.11.2017.
 */
public class app3 {

    public static void main(String[] args) {

        app3 app = new app3();

        int [] array = {-1,4,5,99,-12,34,54,11,100,2000,3,1,1,1,1,1};

        System.out.println(app.solution(array));


    }

    public String solution(int[] T) {
        int arrayLength = T.length;
        int numberOfDays = arrayLength/4;

        int [] resultArray = new int[4];

//        Map<String,Integer> mapOf4 = new HashMap<>();
//
//        for(int i = 0; i < 4; i++){
//
//
//
//        }

        int [] array1 = new int [numberOfDays];
        int [] array2 = new int [numberOfDays];
        int [] array3 = new int [numberOfDays];
        int [] array4 = new int [numberOfDays];

        for (int i = 0; i < numberOfDays; i ++){

            array1[i] = T[i];
        }
        for (int i = numberOfDays; i < 2*numberOfDays; i ++){

            array2[i-numberOfDays] = T[i];
        }
        for (int i = 2*numberOfDays; i < 3*numberOfDays; i ++){

            array3[i-2*numberOfDays] = T[i];
        }
        for (int i = 3*numberOfDays; i < 4*numberOfDays; i ++) {

            array4[i-3*numberOfDays] = T[i];
        }

        resultArray[0] = applitude(array1);
        resultArray[1] = applitude(array2);
        resultArray[2] = applitude(array3);
        resultArray[3] = applitude(array4);



        int maxIndex = 0;
        for (int i = 1; i < resultArray.length; i++) {
            int newnumber = resultArray[i];
            if ((newnumber > resultArray[maxIndex])) {
                maxIndex = i;
            }
        }



        switch (maxIndex+1){
            case 1: return  "WINTER";

            case 2: return "SPRING";

            case 3: return "SUMMER";

            case 4: return "AUTUMN";

            default: return "ERROR";

        }

        }

        private int applitude (int [] array){
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();

        return max-min;

    }







    }



