package agh.ics.oop.model;

import java.util.Objects;

public class Animal {
    private MapDirection orient=MapDirection.NORTH;
    private Vector2d location;

    public Animal(){
        this.location=new Vector2d(2,2);
    }

    public Animal(Vector2d location) {
        this.location = location;
    }

    public String toString(){
        return location.toString() + orient.toString();
    }
    public MapDirection getOrient() {
        return orient;
    }

    public boolean isAt(Vector2d position){
        return location.equals(position);
    }

    public void move(MoveDirection direction){
    orient = switch (direction){
        case RIGHT -> orient.next();
        case LEFT -> orient.previous();
        case FORWARD, BACKWARD -> orient;
        };
    Vector2d newLocation = location;
    newLocation = switch (direction){
        case LEFT, RIGHT -> location;
        case FORWARD -> switch (orient){
            case NORTH -> location.add(new Vector2d(0,1));
            case SOUTH -> location.add(new Vector2d(0,-1));
            case WEST -> location.add(new Vector2d(-1,0));
            case EAST -> location.add(new Vector2d(1,0));
        };
        case BACKWARD -> switch (orient){ //nie sprawdza czy nie wychodzi poza zakres
            case NORTH -> location.add(new Vector2d(0,-1));
            case SOUTH -> location.add(new Vector2d(0,1));
            case WEST -> location.add(new Vector2d(-1,0));
            case EAST -> location.add(new Vector2d(1,0));
        };
    };
    if (newLocation.getX() >= 0 && newLocation.getX() <= 4 && newLocation.getY() >= 0 && newLocation.getY() <= 4)
            location = newLocation;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return orient == animal.orient && Objects.equals(location, animal.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orient, location);
    }

}
