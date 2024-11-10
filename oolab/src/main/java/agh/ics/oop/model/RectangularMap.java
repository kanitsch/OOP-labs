package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap{
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    public  RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public Map<Vector2d,Animal> getAnimals() {
        return animals;
    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(new Vector2d(0,0), new Vector2d(width,height));
    }

    public boolean canMoveTo(Object position1) {
        Vector2d position=(Vector2d) position1;
        if(position.getX()>width || position.getY()>height
                || position.getX()<0 || position.getY()<0)
        {
            return false;
        }
        return !isOccupied(position);
    }

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
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.getX()>=width || position.getY()>=height
                || position.getX()<0 || position.getY()<0)
        {
            return false;
        }
        return !isOccupied(position);
    }
}
