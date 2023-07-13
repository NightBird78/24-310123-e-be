package GreedyElevator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class GreedyElevator {

    public static void main(String[] args) {
        Elevator elevator1 = new Elevator("elevator1", 8);
        Elevator elevator2 = new Elevator("elevator2", 0);

        LivingBlock livingBlock = new LivingBlock(19);

        livingBlock.addElevator(elevator1, elevator2);

        System.out.println(livingBlock);
        System.out.println();

        livingBlock.call(10, 3);

        System.out.println(livingBlock);

    }
}

@Getter
@Setter
@AllArgsConstructor
class Elevator {
    private String name;
    private int currentFloor;

    @Override
    public String toString() {

        return "\nElevator{" +
                "\nname:  " + name +
                "\nfloor: " + currentFloor + " }"
                ;
    }

}

@Getter
@ToString
class LivingBlock {
    int floor;
    Set<Elevator> elevators;

    public LivingBlock(int floor) {
        this.floor = floor;
        elevators = new HashSet<>();
    }


    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public void addElevator(Elevator... elevators) {
        Collections.addAll(this.elevators, elevators);
    }

    public void call(int fromFloor, int toFloor) {
        Elevator elevator =
                elevators.stream().
                        sorted(Comparator.comparing(el -> Math.abs(el.getCurrentFloor() - fromFloor)))
                        .toList()
                        .get(0);

        System.out.println("LivingBlock: " + elevator.getName() + " called to " + fromFloor);
        System.out.printf("%d -> %d -> %d\n", elevator.getCurrentFloor(), fromFloor, toFloor);

        elevator.setCurrentFloor(toFloor);
    }
}
