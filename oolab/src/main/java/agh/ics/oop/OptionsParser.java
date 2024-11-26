package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> dirs(String[] args) throws IllegalArgumentException {
        List<MoveDirection> items = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> items.add(MoveDirection.FORWARD);
                case "b" -> items.add(MoveDirection.BACKWARD);
                case "l" -> items.add(MoveDirection.LEFT);
                case "r" -> items.add(MoveDirection.RIGHT);
                default ->  throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }

        return items;
        }
}




