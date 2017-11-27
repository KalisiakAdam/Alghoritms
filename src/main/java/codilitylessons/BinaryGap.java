package codilitylessons;

public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();

        System.out.println(binaryGap.solution(1041));
    }

    public int solution(int N){

        int longestBinaryGap = 0;
        int number = 0;
        boolean reset = false;
        int calculationN = N;
        while(calculationN > 0 ) {

            if(number >longestBinaryGap && reset ){
                longestBinaryGap = number;
            }
            if(calculationN%2==0){
                number+=1;
                calculationN = calculationN/2;

            }else if (calculationN%2!=0){
                number = 0;
                reset = true;
                calculationN = calculationN/2;
            }

        }
        return longestBinaryGap;
    }
}
