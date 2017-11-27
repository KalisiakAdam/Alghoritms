package codilitylessons;

/**
 * Created by kalisiaczki on 26.11.2017.
 */
public class SummNumbers {

    public int sumIt(int[] numberArray){

        int totalNumber = 0;

        for(int i = 0 ; i <numberArray.length ; i++ ){

            int number = numberArray[i];


            if(number < 10) {

                totalNumber =+ number;

            }
            else{
                while(number > 0) {

                    totalNumber += number % 10;;
                    number = number / 10;
                }
            }
        }

        return totalNumber;
    }
    public static void main(String[] args) {
        int arry[]={9, 21, 3155, 2456};
        SummNumbers sumNumber = new SummNumbers();
        System.out.println(sumNumber.sumIt(arry));

    }
}
