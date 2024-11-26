package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    private final List<MapChangeListener> observers = new ArrayList<>();


    @Override
    public boolean place(Animal animal) throws IncorrectPositionException {
        if (canMoveTo(animal.getLocation())) {
            animals.put(animal.getLocation(), animal);
            mapChanged("animal placed at " + animal.getLocation());
            return true;
        }
        else{
            throw new IncorrectPositionException(animal.getLocation());
        }

    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getLocation();
        animal.move(direction, this);
        animals.remove(oldPosition);
        animals.put(animal.getLocation(), animal);
        mapChanged("animal moved from " + oldPosition +" to " + animal.getLocation());
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

    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        MapVisualizer map=new MapVisualizer(this);
        return map.draw(bounds.lowerLeft(), bounds.upperRight());
    }
    public abstract Boundary getCurrentBounds();

    public void addObserver(MapChangeListener observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    public void mapChanged(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }

}
