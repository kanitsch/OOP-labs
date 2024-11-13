package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;


public class TextMap implements WorldNumberPositionMap<String,Integer> {
    private final List<String> strings;

    public TextMap() {
        this.strings = new ArrayList<>();
    }

    @Override
    public boolean place(String animal) {
        return strings.add(animal);
    }

    @Override
    public void move(String animal, MoveDirection direction) {
        int index = strings.indexOf(animal);
        if (index == -1) {
            return;
        }
        switch (direction) {
            case RIGHT:
            case FORWARD:

                if (index < strings.size() - 1) {
                    String temp = strings.get(index);
                    strings.set(index, strings.get(index+1));
                    strings.set(index+1, temp);
                }
                break;
            case LEFT:
            case BACKWARD:

                if (index > 0) {
                    String temp = strings.get(index);
                    strings.set(index, strings.get(index - 1));
                    strings.set(index - 1, temp);
                }
                break;
        }
    }


    @Override
    public boolean isOccupied(Integer position) {
        if (position != null) {
            return (Integer) position >= 0 && (Integer) position<strings.size();
        }
        return false;
    }

    @Override
    public String objectAt(Integer position) {
        if (position != null && (Integer) position < strings.size() && (Integer) position >= 0) {
            return strings.get((Integer) position);
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return position != null && (Integer) position < strings.size() && (Integer) position >= 0;
    }

    public String toString() {
        return strings.toString();
    }

}
