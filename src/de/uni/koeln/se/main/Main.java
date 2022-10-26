package de.uni.koeln.se.main;

import java.util.Scanner;

import de.uni.koeln.se.state.Elevator;

public class Main {
    private static Scanner in;
    private static Elevator elevator;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        elevator = new  Elevator();

        int dstFloor = getFloorInput();
        in.close();

        System.out.println("--------------------------------------------");

        elevator.setDestinationFloor(dstFloor);
    }

    public static int getFloorInput() {
        int floor = -1;

        while (floor == -1) {
            elevator.printInfo();
            System.out.printf("Enter destination Floor: (%d to %d):%n", Elevator.MIN_FLOOR, Elevator.MAX_FLOOR);
            try {
                floor = in.nextInt();
            } catch (java.util.InputMismatchException e) {
                in.next();
            }

            if(floor > Elevator.MAX_FLOOR || floor < Elevator.MIN_FLOOR) {
                floor = -1;
                System.out.println("Invalid Input");
            }
        }

        return floor;
    }

}
