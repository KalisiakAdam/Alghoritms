import java.util.ArrayList;
import java.util.List;


public class ArthmeticWorse {

    public static void main(String[] args) {

        ArthmeticWorse app2 = new ArthmeticWorse();
        int [] arr = {-1,1,3,3,3,2,1,0};
        System.out.println(app2.solution(arr));

    }


    public int solution(int[] A) {
        int first = 0;
        int full = 0;
        int result = 0;

        List list;
        for (int last = 0; last < A.length && first < A.length; ) {
            list = new ArrayList();
            first = last + 2;
            full = A[first - 1] - A[last];
            list.add(last);
            list.add(first - 1);
            int i = 0;
            boolean isItOk = false;
            while (first < A.length && A[first] - A[first - 1] == full) {
                isItOk = true;
                i++;
                list.add(first);
                last = first;
                first++;
                result += i;
                if (result > 1000000000)
                    return -1;
            }
            if (!isItOk)
                last++;
        }
        return result;
    }
}
