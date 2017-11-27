
import java.util.HashSet;

import java.util.Set;


public class ElevatorGood {

    public static void main(String[] args) {
        ElevatorGood elevatorGood = new ElevatorGood();
        int[] weightOfPerson = {60, 80, 120, 60};
        int[] targetFloor = {2, 5, 6, 7};
        int maxCapacity = 3;
        int floors = 6;
        int weightLimit = 140;

        /// <param name="A">weight of people</param>
        /// <param name="B">floors they need to get down</param>
        /// <param name="M">total floors in the building</param>
        /// <param name="X">Max people to carry at a time</param>
        /// <param name="Y">max weight to carry at a time</param>

        System.out.println(elevatorGood.solution(weightOfPerson,targetFloor,floors,maxCapacity,weightLimit));
    }

    public int solution(int[] A, int[] B, int M, int X, int Y)
    {

        int totalStops = 0;
        long totalWeightPerRound = 0;
        int maxPersonsCount = 0;
        Set<Integer> numberOfStops = new HashSet<>();

        int NumberOfPersons = 0;
        boolean startLift = false;
        while (NumberOfPersons < A.length)
        {

            if ((totalWeightPerRound + A[NumberOfPersons]) <= Y && (maxPersonsCount+1) <= X)
            {
                totalWeightPerRound += A[NumberOfPersons];
                maxPersonsCount++;
                numberOfStops.add(B[NumberOfPersons]);

                if (NumberOfPersons == A.length - 1)
                    startLift = true;

                NumberOfPersons++;
            }
            else
            {
                startLift = true;
            }

            if (startLift)
            {
                totalStops += numberOfStops.size() + 1;

                numberOfStops.clear();
                maxPersonsCount = 0;
                totalWeightPerRound = 0;
                startLift = false;
            }
        }

        return totalStops;
    }

}
