package com.harry.LiftSimulator;

enum Direction { UP, DOWN, IDLE }

public class Elevator {
    private static final int MAX_CAPACITY = 10;
    private static final int MIN_FLOOR = 0;
    private static final int MAX_FLOOR = 20;

    private int currentFloor = 0;
    private int currentCapacity = 0;
    private Direction direction = Direction.IDLE;

    public synchronized String request(int floor, int people) {
        System.out.println("current_direction: " + direction);
        if (floor < MIN_FLOOR || floor > MAX_FLOOR)
            throw new IllegalArgumentException("Invalid floor: " + floor);
        if (people <= 0)
            throw new IllegalArgumentException("People must be > 0");
        if (currentCapacity + people > MAX_CAPACITY)
            return "Request denied — elevator full";

        currentCapacity += people;

        if (floor == currentFloor) {
            currentCapacity -= people;
            return "Already at floor " + floor + " — passengers left";
        }

        direction = (floor > currentFloor) ? Direction.UP : Direction.DOWN;
        System.out.printf("Moving %s: %d -> %d with %d people%n",
                direction, currentFloor, floor, people);

        currentFloor = floor;
        currentCapacity -= people;
        if (currentCapacity < 0) currentCapacity = 0;

        direction = Direction.IDLE;
        return String.format("Arrived at %d. load=%d", currentFloor, currentCapacity);
    }

    public static void main(String[] args) {
        Elevator e = new Elevator();
        System.out.println(e.request(5, 3));
        System.out.println(e.request(2, 2));
        System.out.println(e.request(2, 11));
    }
}
