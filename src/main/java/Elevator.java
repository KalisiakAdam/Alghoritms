import java.util.*;


public class Elevator {



    public static int solution(int[] weightOfPerson, int[] targetFloor, int maxCapacity, int floors, int weightLimit) {

        int numberOfStops = 0;
        int beginningNumberOfPeople = weightOfPerson.length;
        int numberOfPeopleWaiting = weightOfPerson.length;

        Set <Integer> elevator = new LinkedHashSet <>();


        while (numberOfPeopleWaiting > 0) {





                int totalWeightInElevator = 0;
                for (int i = 0; i < beginningNumberOfPeople; i++) {


                    if (totalWeightInElevator <= weightLimit && elevator.size() <= maxCapacity) {

                        System.out.println(totalWeightInElevator);
                        System.out.println(elevator.size() + "<- elevator size");
                        System.out.println(numberOfPeopleWaiting + "<- number of people waiting");

                        elevator.add(targetFloor[i]);
                        totalWeightInElevator += weightOfPerson[i];
                        numberOfPeopleWaiting--;

                    }

                }

            numberOfStops += elevator.size();

        }

        return numberOfStops;

    }


    public static void main(String[] args) {
        int[] weightOfPerson = {60, 80, 120, 60};
        int[] targetFloor = {2, 5, 6, 7};
        int maxCapacity = 3;
        int floors = 6;
        int weightLimit = 140;

        System.out.println(Elevator.solution(weightOfPerson, targetFloor, maxCapacity, floors, weightLimit));


    }
}
