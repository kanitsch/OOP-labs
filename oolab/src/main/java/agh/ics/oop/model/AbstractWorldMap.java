package agh.ics.oop.model;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d,Animal> animals = new HashMap<>();


    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getLocation())) {
            animals.put(animal.getLocation(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getLocation();
        animal.move(direction, this);
        animals.remove(oldPosition);
        animals.put(animal.getLocation(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return  !(objectAt(position) instanceof Animal);
    }

    @Override
    public List<WorldElement> getElements(){
        List<WorldElement> elements = new ArrayList<>(animals.values());
        return elements;

    }


}
