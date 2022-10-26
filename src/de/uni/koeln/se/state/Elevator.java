package de.uni.koeln.se.state;

public class Elevator{
    private int curFloor, dstFloor;
    private ElevatorState state;

    public static final int MAX_FLOOR = 10;
    public static final int MIN_FLOOR = 0;

    public Elevator(int floor) {
        this.state = ElevatorState.IDLE;
        this.curFloor = this.dstFloor = floor;
    }

    public Elevator() {
        this(5);
    }

    @SuppressWarnings("unused")
    public int getDestinationFloor() {
        return dstFloor;
    }

    public void printInfo() {
        System.out.printf("*** Current floor is: %d; State is: %s%n", curFloor, state.toString());
    }

    public void setDestinationFloor(int dstFloor) {
        this.dstFloor = dstFloor;
        System.out.println("*** Destination floor is: "+ dstFloor);

        while(dstFloor != curFloor) { // arrive_to_floor
            this.state = dstFloor > curFloor ? ElevatorState.MOVING_UP : ElevatorState.MOVING_DOWN;
            printInfo();
            switch (state) {
                case MOVING_UP:
                    curFloor++; // go_up
                    break;
                case MOVING_DOWN:
                    curFloor--; // go_down
                    break;
                default:
                    System.out.println("Warning: Should not be here");
                    printInfo();
                    break;
            }
        }
        this.state = ElevatorState.IDLE;
        printInfo();
    }

    @SuppressWarnings("unused")
    public int getCurrentFloor() {
        return curFloor;
    }

    @SuppressWarnings("unused")
    public void setCurrentFloor(int curFloor) {
        this.curFloor = curFloor;
    }
}
