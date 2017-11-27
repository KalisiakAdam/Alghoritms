
public class Collinear {

    public static void main(String[] args) {

        Point2D first = new Point2D(0,0);
        Point2D second = new Point2D(1,1);
        Point2D thirst = new Point2D(2,2);
        Point2D fourth = new Point2D(3,3);
        Point2D fifth = new Point2D(3,2);
        Point2D sixth = new Point2D(4,2);
        Point2D seventh = new Point2D(5,1);

        Point2D [] array = new Point2D[7];

        array[0] = first;
        array[1] = second;
        array[2] = thirst;
        array[3] = fourth;
        array[4] = fifth;
        array[5] = sixth;
        array[6] = seventh;

        Collinear collinear = new Collinear();
        System.out.println(collinear.solution(array));



    }
    static class Point2D {
        public int x;
        public int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution (Point2D [] A) {

        int numberOfTriples = 0;
                for (int i = 0; i < A.length; i++) {
                    for (int j = i+1; j<A.length; j++){
                        for (int k = j+1; k<A.length; k++){

                            if(numberOfTriples < 100000 && isCollinear(A[i].x, A[i].y, A[j].x, A[j].y, A[k].x, A[k].y)){

                                System.out.println("A" + i +".x" + A[i].x + "  A" + i +".y" + A[i].y);
                                System.out.println("A" + j +".x" + A[j].x + "  A" + j +".y" + A[j].y);
                                System.out.println("A" + k +".x" + A[k].x + "  A" + k +".y" + A[k].y);
                                System.out.println("   ");
                                numberOfTriples++;

                            } else if (numberOfTriples >= 100000){
                                return -1;
                            }

                        }
                    }

                }

                return numberOfTriples;
    }

    public boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3){

        int firstPartSarrus = x1*y2*1 + y1*1*x3 + 1*x2*y3;
        int secondPartSarrus = 1*y2*x3 +x1*1*y3 + y1*x2*1;

        if(firstPartSarrus-secondPartSarrus == 0) {return true;}

        return false;
    }
}
