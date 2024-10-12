package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] dirs(String[] args) {
        MoveDirection[] items = new MoveDirection[args.length];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> items[i] = MoveDirection.FORWARD;
                case "b" -> items[i] = MoveDirection.BACKWARD;
                case "l" -> items[i] = MoveDirection.LEFT;
                case "r" -> items[i] = MoveDirection.RIGHT;
                default -> items[i]=null;
            }
            i++;
            if (items[i-1]==null){
                i--;
            }
        }

        return Arrays.copyOfRange(items, 0, i);
        }
}




